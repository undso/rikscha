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
public class MoodleFeedbackResponse implements Serializable{

    private static final long serialVersionUID = 6495913638517346488L;

    @JsonProperty("totalattempts")
    private Integer totalattempts;
    @JsonProperty("totalanonattempts")
    private Integer totalanonattempts;
    @JsonProperty("anonattempts")
    private List<Anonattempt> anonattempts;

    public Integer getTotalattempts() {
        return totalattempts;
    }

    public void setTotalattempts(Integer totalattempts) {
        this.totalattempts = totalattempts;
    }

    public Integer getTotalanonattempts() {
        return totalanonattempts;
    }

    public void setTotalanonattempts(Integer totalanonattempts) {
        this.totalanonattempts = totalanonattempts;
    }

    public List<Anonattempt> getAnonattempts() {
        if(anonattempts == null){
            anonattempts = new ArrayList<>();
        }
        return anonattempts;
    }

    public void setAnonattempts(List<Anonattempt> anonattempts) {
        this.anonattempts = anonattempts;
    }

    @Override
    public String toString() {
        return "MoodleFeedbackResponse{" + "totalanonattempts=" + totalanonattempts + ", anonattempts=" + anonattempts + '}';
    }
    
    
    public Map<String, Object> getAdditionalProperties() {
        return additionalProperties;
    }
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<>();
    
}
