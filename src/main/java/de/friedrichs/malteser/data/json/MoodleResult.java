package de.friedrichs.malteser.data.json;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 *
 * @author AFR
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MoodleResult implements Serializable {

    private static final long serialVersionUID = -8716975059272569713L;

    @JsonProperty("event")
    private Event event;
    @JsonProperty("validationerror")
    private Boolean validationerror;
    @JsonProperty("exception")
    private String exception;
    @JsonProperty("errorcode")
    private String errorcode;
    @JsonProperty("message")
    private String message;
    @JsonProperty("debuginfo")
    private String debuginfo;

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public Boolean getValidationerror() {
        return validationerror;
    }

    public void setValidationerror(Boolean validationerror) {
        this.validationerror = validationerror;
    }
    
    
    public Map<String, Object> getAdditionalProperties() {
        return additionalProperties;
    }
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<>();

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + Objects.hashCode(this.event);
        hash = 29 * hash + Objects.hashCode(this.validationerror);
        hash = 29 * hash + Objects.hashCode(this.exception);
        hash = 29 * hash + Objects.hashCode(this.errorcode);
        hash = 29 * hash + Objects.hashCode(this.message);
        hash = 29 * hash + Objects.hashCode(this.debuginfo);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final MoodleResult other = (MoodleResult) obj;
        if (!Objects.equals(this.exception, other.exception)) {
            return false;
        }
        if (!Objects.equals(this.errorcode, other.errorcode)) {
            return false;
        }
        if (!Objects.equals(this.message, other.message)) {
            return false;
        }
        if (!Objects.equals(this.debuginfo, other.debuginfo)) {
            return false;
        }
        if (!Objects.equals(this.event, other.event)) {
            return false;
        }
        return Objects.equals(this.validationerror, other.validationerror);
    }

    @Override
    public String toString() {
        return "MoodleResult{" + "event=" + event + ", validationerror=" + validationerror + ", exception=" + exception + ", errorcode=" + errorcode + ", message=" + message + ", debuginfo=" + debuginfo + '}';
    }

    

    
}
