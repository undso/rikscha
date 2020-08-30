package de.friedrichs.malteser.data.json;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author AFR
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PhonesResult implements Serializable {

    private static final long serialVersionUID = 4063850887408472532L;

    @JsonProperty("is_error")
    private Integer isError;
    @JsonProperty("version")
    private Integer version;
    @JsonProperty("count")
    private Integer count;
    @JsonProperty("id")
    private Integer id;
    @JsonProperty("values")
    private List<Phone> values = null;

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

    public List<Phone> getValues() {
        return values;
    }

    public void setValues(List<Phone> values) {
        this.values = values;
    }
}
