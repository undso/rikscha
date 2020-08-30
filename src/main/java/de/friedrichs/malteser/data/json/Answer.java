package de.friedrichs.malteser.data.json;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;


/**
 *
 * @author AFR
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Answer implements Serializable{

    private static final long serialVersionUID = 4029205112774007448L;

    @JsonProperty("id")
    private Integer id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("printval")
    private String printval;
    @JsonProperty("rawval")
    private String rawval;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrintval() {
        return printval;
    }

    public void setPrintval(String printval) {
        this.printval = printval;
    }

    public String getRawval() {
        return rawval;
    }

    public void setRawval(String rawval) {
        this.rawval = rawval;
    }

    @Override
    public String toString() {
        return "Answer{" + "id=" + id + ", name=" + name + ", printval=" + printval + '}';
    }
    
    
    public Map<String, Object> getAdditionalProperties() {
        return additionalProperties;
    }
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<>();
}
