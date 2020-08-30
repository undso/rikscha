package de.friedrichs.malteser.data.json;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



/**
 *
 * @author AFR
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Anonattempt implements Serializable{

    private static final long serialVersionUID = 1261058754602388258L;
    
    @JsonProperty("id")
    private Integer id;
    @JsonProperty("courseid")
    private Integer courseid;
    @JsonProperty("number")
    private Integer number;
    @JsonProperty("responses")
    private List<Answer> responses;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCourseid() {
        return courseid;
    }

    public void setCourseid(Integer courseid) {
        this.courseid = courseid;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public List<Answer> getResponses() {
        if(responses == null){
            responses = new ArrayList<>();
        }
        return responses;
    }

    public void setResponses(List<Answer> responses) {
        this.responses = responses;
    }

    @Override
    public String toString() {
        return "Anonattempt{" + "id=" + id + ", number=" + number + ", responses=" + responses + '}';
    }
    
    
    public Map<String, Object> getAdditionalProperties() {
        return additionalProperties;
    }
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<>();

}
