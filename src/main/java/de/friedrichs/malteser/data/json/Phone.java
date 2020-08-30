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
public class Phone implements Serializable {

    private static final long serialVersionUID = 6446772121443171856L;

    @JsonProperty("phone")
    private String phone;
    
    @JsonIgnore
    private final Map<String, Object> additionalProperties = new HashMap<>();

    
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    
}
