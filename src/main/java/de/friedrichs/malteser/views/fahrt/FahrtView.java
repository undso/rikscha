package de.friedrichs.malteser.views.fahrt;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.datetimepicker.DateTimePicker;
import com.vaadin.flow.component.select.Select;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.grid.GridVariant;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.splitlayout.SplitLayout;
import com.vaadin.flow.component.textfield.NumberField;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.data.binder.ValidationException;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import de.friedrichs.malteser.data.entity.Fahrgast;
import de.friedrichs.malteser.data.entity.Fahrt;
import de.friedrichs.malteser.data.entity.Pilot;
import de.friedrichs.malteser.data.generator.DataGenerator;
import de.friedrichs.malteser.data.service.FahrgastRepository;
import de.friedrichs.malteser.data.service.FahrtRepository;
import de.friedrichs.malteser.data.service.PilotRepository;
import de.friedrichs.malteser.moodle.EventHandler;
import de.friedrichs.malteser.views.main.MainView;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;

@Route(value = "fahrt", layout = MainView.class)
@PageTitle("Bevorstehende Fahrten")
@CssImport("styles/views/fahrt/fahrt-view.css")
public class FahrtView extends Div {

    private static final long serialVersionUID = -1210816100195664035L;

    private static final DateTimeFormatter DATEONLY = DateTimeFormatter.ofPattern("dd.MM.yy");
    private static final Logger LOG = LoggerFactory.getLogger(FahrtView.class);

    private final FahrtRepository fahrtRepository;
    private final FahrgastRepository fahrgastRepository;
    private final PilotRepository pilotRepository;

    private Grid<Fahrt> grid;

    private final Select<Fahrgast> fahrgast = new Select<>();
    private final Select<String> telefon = new Select<>();
    private final Select<Pilot> pilot = new Select<>();
    private final DateTimePicker timestart = new DateTimePicker(LocalDateTime.now().plusDays(1).withHour(10).withMinute(0).withSecond(0));
    private final NumberField dauerPlan = new NumberField("Geplante Dauer", "(Std.)");
    private final TextField adresse = new TextField("Adresse");
    private final TextField forumsLink = new TextField("Forums Link");
    private final TextArea weitereInfos = new TextArea("Weitere Informationen");

    private final Button cancel = new Button("Cancel");
    private final Button save = new Button("Speichern");
    private final Button createEvent = new Button("Moodle erstellen/anpassen");
    private final TextField eventId = new TextField("Moodle EventId");
    private final Button neu = new Button("Neuer Termin");
    private final Button refresh = new Button("Reload CRM");

    private final Binder<Fahrt> binder;
    
    @Autowired
    private DataGenerator dataGenerator;
    @Autowired
    private EventHandler eventHandler;
    

    public FahrtView(@Autowired FahrtRepository fahrtRepository,
            @Autowired FahrgastRepository fahrgastRepository,
            @Autowired PilotRepository pilotRepository) {

        this.fahrtRepository = fahrtRepository;
        this.fahrgastRepository = fahrgastRepository;
        this.pilotRepository = pilotRepository;

        setId("fahrt-view");
        initGrid();

        // Configure Form
        binder = new Binder<>(Fahrt.class);

        // Bind fields. This where you'd define e.g. validation rules
        binder.bindInstanceFields(this);

        // the grid valueChangeEvent will clear the form too
        cancel.addClickListener(e -> grid.asSingleSelect().clear());
        neu.addClickListener(e -> grid.asSingleSelect().clear());
        
        createEvent.addClickListener(e -> {
            Fahrt value = grid.asSingleSelect().getValue();
            LOG.info("GRID Fahrt: {}", value);
            if (value != null) {
                Long eventId = eventHandler.createOrUpdateMoodleEvent(value);
                value.setEventId(Long.toString(eventId));
                fahrtRepository.save(value);
                Notification.show("Moodle Termin bearbeitet.");
                this.listFahrten();
                grid.select(value);
            }else{
                Notification.show("Bitte erst speichern.");
            }
        });
        
        refresh.addClickListener(e -> {
            int loadFahrgastFromCRM = this.dataGenerator.loadFahrgastFromCRM();
            int loadPilotFromCRM = this.dataGenerator.loadPilotFromCRM();
            Notification.show(String.format("%d Fahrgäste und %d Piloten aus CRM geladen.", loadFahrgastFromCRM, loadPilotFromCRM));
        });

        save.addClickListener(e -> {
            Fahrt value = grid.asSingleSelect().getValue();
            LOG.info("GRID Fahrt: {}", value);
            if (value == null) {
                value = new Fahrt();
            }
            try {
                binder.writeBean(value);
            } catch (ValidationException ve) {
                LOG.error("Validation: {}", ve.getLocalizedMessage());
                Notification.show(ve.getLocalizedMessage());
            }

            LOG.info("Fahrt: {}", value);
            fahrtRepository.save(value);
            this.listFahrten();
            grid.select(value);
            Notification.show(String.format("Fahrt von %s %s gespeichert.",value.getFahrgast().getFirstName(),value.getFahrgast().getLastName()));
        });
        
        dauerPlan.setMin(1);
        dauerPlan.setMax(24);
        dauerPlan.setStep(0.5d);
        dauerPlan.setHasControls(true);
        
        timestart.setLocale(Locale.GERMAN);

        SplitLayout splitLayout = new SplitLayout();
        splitLayout.setSizeFull();

        createGridLayout(splitLayout);
        createEditorLayout(splitLayout);

        add(splitLayout);

        cancel.addThemeVariants(ButtonVariant.LUMO_TERTIARY);
        save.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        neu.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        createEvent.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        refresh.addThemeVariants(ButtonVariant.LUMO_SMALL);
    }
    
    private void listFahrten(){
        grid.setItems(this.fahrtRepository.findByTimestartGreaterThanOrderByTimestartDesc(LocalDateTime.now()));
    }

    private void initGrid() {
        // Configure Grid
        grid = new Grid<>(Fahrt.class);
        
        grid.removeAllColumns();
        grid.addColumn(f -> f.getTimestart().format(DATEONLY)).setSortProperty("timestart").setHeader("Datum").setResizable(true);
        grid.addColumn(f -> f.getFahrgast().getFirstName() + " " + f.getFahrgast().getLastName()).setSortProperty("fahrgast.lastName").setHeader("Fahrgast").setResizable(true);
        grid.addColumn(f -> (f.getPilot() != null) ? f.getPilot().getFirstName() + " " + f.getPilot().getLastName() : "").setSortProperty("pilot.lastName").setHeader("Pilot").setResizable(true);
        grid.getColumns()
                .forEach(column -> column.setAutoWidth(true));
        listFahrten();
        grid.recalculateColumnWidths();

        grid.addThemeVariants(GridVariant.LUMO_NO_BORDER);
        grid.setHeightFull();
        // when a row is selected or deselected, populate form
        grid.asSingleSelect().addValueChangeListener(event -> populateForm(event.getValue()));
        //
    }

    private void initSelects() {
        telefon.setLabel("Telefonkontakt");
        telefon.setEnabled(false);

        fahrgast.setLabel("Fahrgast");
        List<Fahrgast> fahrgaeste = fahrgastRepository.findAll(Sort.by("lastName"));
        fahrgast.setItemLabelGenerator(f -> f.getFirstName() + " " + f.getLastName());
        fahrgast.setItems(fahrgaeste);
        fahrgast.addValueChangeListener(e -> {
            if (fahrgast.getValue() != null) {
                telefon.setItems(fahrgast.getValue().getPhones());
                telefon.setEmptySelectionAllowed(true);
                telefon.setEnabled(true);
                
                adresse.setValue(fahrgast.getValue().getAnschrift());
            }else{
                telefon.clear();
                telefon.setEnabled(false);
            }
        });
        
        eventId.setReadOnly(true);

        pilot.setLabel("Pilot");
        List<Pilot> pilots = pilotRepository.findAll(Sort.by("lastName"));
        pilot.setItemLabelGenerator(f -> f.getFirstName() + " " + f.getLastName());
        pilot.setItems(pilots);
    }

    private void createEditorLayout(SplitLayout splitLayout) {
        Div editorDiv = new Div();
        editorDiv.setId("editor-layout");
        createButtonLayout(editorDiv, refresh, neu);
        initSelects();
        FormLayout formLayout = new FormLayout();
//        formLayout.setResponsiveSteps(
//                new FormLayout.ResponsiveStep("25em", 1),
//                new FormLayout.ResponsiveStep("32em", 2),
//                new FormLayout.ResponsiveStep("40em", 3),
//                new FormLayout.ResponsiveStep("49em", 4));
        formLayout.add(eventId);
        formLayout.add(fahrgast);
        formLayout.add(pilot);
        timestart.setLabel("Datum / Uhrzeit");
        formLayout.add(timestart);
        formLayout.add(dauerPlan);
        formLayout.add(telefon);
        formLayout.add(adresse);
        formLayout.add(weitereInfos);
        formLayout.add(forumsLink);
        editorDiv.add(formLayout);
        createButtonLayout(editorDiv, cancel, save, createEvent);

        splitLayout.addToSecondary(editorDiv);
    }

    private void createButtonLayout(Div editorDiv, Button... buttons) {
        HorizontalLayout buttonLayout = new HorizontalLayout();
        buttonLayout.setId("button-layout");
        buttonLayout.setWidthFull();
        buttonLayout.setSpacing(true);
        buttonLayout.add(buttons);
        editorDiv.add(buttonLayout);
    }

    private void createGridLayout(SplitLayout splitLayout) {
        Div wrapper = new Div();
        wrapper.setId("wrapper");
        wrapper.setWidth("20%");
        splitLayout.addToPrimary(wrapper);
        wrapper.add(grid);
    }

    private void populateForm(Fahrt value) {
        LOG.info("Fahrt - populateForm: {}", value);
        // Value can be null as well, that clears the form
        binder.readBean(value);
    }
}
