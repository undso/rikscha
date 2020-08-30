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
public class Event implements Serializable{

    private static final long serialVersionUID = 6389737142243622586L;

    @JsonProperty("id")
    private Long id;
    @JsonProperty("name")
    private String name;
    
    
    public Map<String, Object> getAdditionalProperties() {
        return additionalProperties;
    }
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 67 * hash + Objects.hashCode(this.id);
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
        final Event other = (Event) obj;
        return Objects.equals(this.id, other.id);
    }

    @Override
    public String toString() {
        return "Event{" + "id=" + id + ", name=" + name + '}';
    }
    
}
