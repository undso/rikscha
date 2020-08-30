package de.friedrichs.malteser.data.generator;

import com.vaadin.flow.spring.annotation.SpringComponent;
import de.friedrichs.malteser.data.entity.Fahrgast;

import de.friedrichs.malteser.data.entity.Pilot;
import de.friedrichs.malteser.data.json.Contact;
import de.friedrichs.malteser.data.json.ContactResult;
import de.friedrichs.malteser.data.service.FahrgastRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.client.RestTemplate;
import de.friedrichs.malteser.data.service.PilotRepository;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;

@SpringComponent
@ConfigurationProperties(prefix = "crm.rest")
public class DataGenerator {

    private static final Logger logger = LoggerFactory.getLogger(DataGenerator.class);

    @Autowired
    private FahrgastRepository fahrgastRepository;
    @Autowired
    private PilotRepository pilotRepository;
    @Autowired(required = true)
    @Qualifier("CRMRestTemplate")
    private RestTemplate restTemplate;
    private String apiKey;
    private String key;
    private String serverurl;

    @Scheduled(fixedRate = 300000)
    public int loadFahrgastFromCRM() {
        logger.info("Lade Fahrgaeste");
        String json = "{\"sequential\":1,\"contact_type\":\"Individual\",\"contact_sub_type\":\"Klient\",\"custom_147\":{\"IS NOT NULL\":1},\"options\":{\"limit\":100},\"api.Phone.get\":{}}";

        Map<String, String> uriVariables = new HashMap<>();
        uriVariables.put("apiKey", apiKey);
        uriVariables.put("key", key);
        uriVariables.put("json", json);

        ResponseEntity<ContactResult> response = restTemplate.getForEntity(serverurl
                + "?entity=Contact&action=get&api_key={apiKey}&key={key}&"
                + "json={json}", ContactResult.class, uriVariables);

        logger.debug("ResponseCode: {}", response.getStatusCodeValue());
        response.getHeaders().entrySet().forEach(e -> logger.debug("{}: {}", e.getKey(), e.getValue()));
        logger.debug("Body: {}", response.getBody());

        List<Contact> contacts = response.getBody().getValues();
        contacts.forEach(c -> {
            Fahrgast p = this.fahrgastRepository.findById(
                    c.getContactId()).orElse(new Fahrgast(c.getContactId()));
            p.setContactType(c.getContactType());
            p.setFirstName(c.getFirstName());
            p.setLastName(c.getLastName());
            p.setMiddleName(c.getMiddleName());
            p.setGender(c.getGender());
            p.setImageURL(c.getImageURL());
            p.setStrasse(c.getStreetAddress());
            p.setPlz(c.getPostalCode());
            p.setOrt(c.getCity());
            p.setAdresszusatz(c.getSupplementalAddress1());
            c.getPhonesResult().getValues().forEach(pr -> {
                if(!p.getPhones().contains(pr.getPhone())){
                    p.getPhones().add(pr.getPhone());
                }
            });

            this.fahrgastRepository.save(p);
        });

        logger.info("{} Fahrgaeste geladen und gespeichert.", response.getBody().getCount());
        return response.getBody().getCount();
    }

    @Scheduled(fixedRate = 300000)
    public int loadPilotFromCRM() {

        String json = "{\"sequential\":1,\"contact_type\":\"Individual\",\"contact_sub_type\":\"Ehrenamtlicher\",\"custom_146\":2}";

        Map<String, String> uriVariables = new HashMap<>();
        uriVariables.put("apiKey", apiKey);
        uriVariables.put("key", key);
        uriVariables.put("json", json);

        ResponseEntity<ContactResult> response = restTemplate.getForEntity(serverurl
                + "?entity=Contact&action=get&api_key={apiKey}&key={key}&"
                + "json={json}", ContactResult.class, uriVariables);

        logger.debug("ResponseCode: {}", response.getStatusCodeValue());
        response.getHeaders().entrySet().forEach(e -> logger.debug("{}: {}", e.getKey(), e.getValue()));
        logger.debug("Body: {}", response.getBody());

        List<Contact> contacts = response.getBody().getValues();
        contacts.forEach(c -> {
            Pilot p = this.pilotRepository.findById(c.getContactId()).orElse(new Pilot(c.getContactId()));
            p.setContactType(c.getContactType());
            p.setFirstName(c.getFirstName());
            p.setLastName(c.getLastName());
            p.setMiddleName(c.getMiddleName());
            p.setGender(c.getGender());
            this.pilotRepository.save(p);
        });

        logger.info("{} Piloten geladen und gespeichert.", response.getBody().getCount());
        return response.getBody().getCount();
    }

    public String getApiKey() {
        return apiKey;
    }

    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getServerurl() {
        return serverurl;
    }

    public void setServerurl(String serverurl) {
        this.serverurl = serverurl;
    }
    
}
