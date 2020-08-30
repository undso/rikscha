/*
 */
package de.friedrichs.malteser.moodle;

import com.vaadin.flow.spring.annotation.SpringComponent;
import de.friedrichs.malteser.data.entity.Fahrt;
import de.friedrichs.malteser.data.json.MoodleResult;
import de.friedrichs.malteser.data.service.FahrgastRepository;
import de.friedrichs.malteser.data.service.PilotRepository;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author AFR
 */
@SpringComponent
@ConfigurationProperties(prefix = "moodle.rest")
public class EventHandler {

    private static final Logger LOG = LoggerFactory.getLogger(EventHandler.class);
    private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("dd.MM.yyyy 'um' hh:mm 'Uhr'");

    @Autowired
    private FahrgastRepository fahrgastRepository;
    @Autowired
    private PilotRepository pilotRepository;
    @Autowired(required = true)
    @Qualifier("MoodleRestTemplate")
    private RestTemplate restTemplate;

    private String wstoken;
    private String serverurl;
    private String courseid;
    private int minutesBeforEvent;
    private int minutesAfterEvent;

    public Long createOrUpdateMoodleEvent(Fahrt f) {
        Map<String, String> uriVariables = new HashMap<>();
        uriVariables.put("wstoken", wstoken);
        uriVariables.put("moodlewsrestformat", "json");
        uriVariables.put("wsfunction", "core_calendar_submit_create_update_form");
        uriVariables.put("formdata", createFormdata(f));

        LOG.debug("FormData: {}", uriVariables.get("formdata"));

        ResponseEntity<MoodleResult> response = restTemplate.getForEntity(
                serverurl
                + "?wstoken={wstoken}&moodlewsrestformat={moodlewsrestformat}&"
                + "wsfunction={wsfunction}&formdata={formdata}",
                MoodleResult.class, uriVariables);

        LOG.info("ResponseCode: {}", response.getStatusCodeValue());
        response.getHeaders().entrySet().forEach((e) -> LOG.info("{}: {}", e.getKey(), e.getValue()));
        LOG.info("Body: {}", response.getBody());

        if (response.getBody() != null && !response.getBody().getValidationerror()) {
            return response.getBody().getEvent().getId();
        } else {
            return null;
        }

    }

    private String createDescription(Fahrt f) {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("<p>Los gehts am %s</p></br>", f.getTimestart().format(DATE_TIME_FORMATTER)));
        sb.append(String.format("<p>Fahrgast: %s %s (Tel.: %s)</p></br>",
                f.getFahrgast().getFirstName(),
                f.getFahrgast().getLastName(),
                f.getTelefon()));
        sb.append(String.format("<p>Pilot: %s %s</p></br>", f.getPilot().getFirstName(), f.getPilot().getLastName()));
        sb.append(String.format("<p>Geplante Dauer: %1$,.1f Std.</p></br>", f.getDauerPlan()));
        if (!StringUtils.isEmpty(f.getForumsLink())) {
            sb.append(String.format("<a href=\"%s\" target=\"_blank\">Zum Forumseintrag</a></br>", f.getForumsLink()));
        }
        if (!StringUtils.isEmpty(f.getWeitereInfos())) {
            sb.append(String.format("</br><p>Weitere Infos: %s</p></br>", f.getWeitereInfos()));
        }
        sb.append("</br>");
        sb.append(String.format("<a href=\"https://www.google.com/maps/place/%s/\" target=\"_blank\">Google Maps</a>",
                f.getAdresse().replaceAll("\\s", "+")));
        return sb.toString();
    }

    private String createFormdata(Fahrt f) {
        Map<String, String> fd = initFormdataMap(f);
        if (!StringUtils.isEmpty(f.getEventId())) {
            fd.put("id", f.getEventId());
            fd.put("_qf__core_calendar_local_event_forms_update", "1");
        } else {
            fd.put("_qf__core_calendar_local_event_forms_create", "1");
        }

        StringBuilder sb = new StringBuilder();
        fd.forEach((k, v) -> sb.append(k).append("=").append(v).append("&"));

        return sb.substring(0, sb.length() - 1);
    }

    private Map<String, String> initFormdataMap(Fahrt f) {
        Map<String, String> fd = new HashMap<>();
        //Defaults
        fd.put("visible", "1");
        fd.put("eventtype", "course");
        fd.put("courseid", courseid);
        fd.put("duration", "2"); //Angabe der Dauer in Minuten
        //Custom
        fd.put("location", f.getAdresse());
        fd.put("name", String.format("Rikschafahrt mit %s %s", f.getFahrgast().getFirstName(), f.getFahrgast().getLastName()));
        LocalDateTime minusMinutes = f.getTimestart().minusMinutes(minutesBeforEvent);
        fd.put("timestart[day]", Integer.toString(minusMinutes.getDayOfMonth()));
        fd.put("timestart[month]", Integer.toString(minusMinutes.getMonthValue()));
        fd.put("timestart[year]", Integer.toString(minusMinutes.getYear()));
        fd.put("timestart[hour]", Integer.toString(minusMinutes.getHour()));
        fd.put("timestart[minute]", Integer.toString(minusMinutes.getMinute()));
        fd.put("timedurationminutes", Double.toString((f.getDauerPlan()) * 60 + minutesBeforEvent + minutesAfterEvent));
        fd.put("description[text]", createDescription(f));
        fd.put("description[format]", "1");
        return fd;
    }

    public String getWstoken() {
        return wstoken;
    }

    public void setWstoken(String wstoken) {
        this.wstoken = wstoken;
    }

    public String getServerurl() {
        return serverurl;
    }

    public void setServerurl(String serverurl) {
        this.serverurl = serverurl;
    }

    public String getCourseid() {
        return courseid;
    }

    public void setCourseid(String courseid) {
        this.courseid = courseid;
    }

    public int getMinutesBeforEvent() {
        return minutesBeforEvent;
    }

    public void setMinutesBeforEvent(int minutesBeforEvent) {
        this.minutesBeforEvent = minutesBeforEvent;
    }

    public int getMinutesAfterEvent() {
        return minutesAfterEvent;
    }

    public void setMinutesAfterEvent(int minutesAfterEvent) {
        this.minutesAfterEvent = minutesAfterEvent;
    }

}
