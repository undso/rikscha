package de.friedrichs.malteser.data.generator;


import com.vaadin.flow.spring.annotation.SpringComponent;
import de.friedrichs.malteser.data.json.MoodleFeedbackResponse;
import java.util.HashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author AFR
 */
@SpringComponent
@ConfigurationProperties(prefix = "moodle.rest")
public class MoodleDataLoader {

    private static final Logger LOG = LoggerFactory.getLogger(MoodleDataLoader.class);
    
    @Autowired(required = true)
    @Qualifier("MoodleRestTemplate")
    private RestTemplate restTemplate;
    
    private String wstoken;
    private String serverurl;
    private String courseid;
    private String feedbackid;
    
    @Scheduled(fixedRate = 300000)
    public void loadFeedback() {
        Map<String, String> uriVariables = new HashMap<>();
        uriVariables.put("wstoken", wstoken);
        uriVariables.put("moodlewsrestformat", "json");
        uriVariables.put("wsfunction", "mod_feedback_get_responses_analysis");
        uriVariables.put("courseid", courseid);
        uriVariables.put("feedbackid", feedbackid);
        uriVariables.put("page", "0");
        uriVariables.put("perpage", "100");
        uriVariables.put("groupid", "0");
        
        LOG.debug("Variables: {}", uriVariables);

        ResponseEntity<MoodleFeedbackResponse> response = restTemplate.getForEntity(
                serverurl
                + "?wstoken={wstoken}&moodlewsrestformat={moodlewsrestformat}&"
                + "wsfunction={wsfunction}&courseid={courseid}&"
                + "feedbackid={feedbackid}&page={page}&"
                + "perpage={perpage}&groupid={groupid}",
                MoodleFeedbackResponse.class, uriVariables);

        LOG.debug("ResponseCode: {}", response.getStatusCodeValue());
        response.getHeaders().entrySet().forEach((e) -> LOG.debug("{}: {}", e.getKey(), e.getValue()));
        LOG.debug("Body: {}", response.getBody());
        
        LOG.info("{} Feedbacks geladen.", response.getBody().getTotalanonattempts());
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

    public String getFeedbackid() {
        return feedbackid;
    }

    public void setFeedbackid(String feedbackid) {
        this.feedbackid = feedbackid;
    }
    
    
}
