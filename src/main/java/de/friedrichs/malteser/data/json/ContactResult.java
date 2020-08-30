package de.friedrichs.malteser.data.json;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 *
 * @author AFR
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ContactResult implements Serializable {

    private static final long serialVersionUID = -1786961738300384039L;

    @JsonProperty("is_error")
    private Integer isError;
    @JsonProperty("version")
    private Integer version;
    @JsonProperty("count")
    private Integer count;
    @JsonProperty("id")
    private Integer id;
    @JsonProperty("values")
    private List<Contact> values = null;

    public Map<String, Object> getAdditionalProperties() {
        return additionalProperties;
    }
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<>();

    public Integer getIsError() {
        return isError;
    }

    public void setIsError(Integer isError) {
        this.isError = isError;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<Contact> getValues() {
        return values;
    }

    public void setValues(List<Contact> values) {
        this.values = values;
    }


    @Override
    public String toString() {
        return "ContactResult{" + "isError=" + isError + ", version=" + version + ", count=" + count + ", values=" + values + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 13 * hash + Objects.hashCode(this.isError);
        hash = 13 * hash + Objects.hashCode(this.version);
        hash = 13 * hash + Objects.hashCode(this.count);
        hash = 13 * hash + Objects.hashCode(this.id);
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
        final ContactResult other = (ContactResult) obj;
        if (!Objects.equals(this.isError, other.isError)) {
            return false;
        }
        if (!Objects.equals(this.version, other.version)) {
            return false;
        }
        if (!Objects.equals(this.count, other.count)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
    
    

}
