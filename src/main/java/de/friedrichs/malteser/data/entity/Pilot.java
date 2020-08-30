package de.friedrichs.malteser.data.entity;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 *
 * @author AFR
 */
@Entity
public class Pilot extends Person implements Serializable{

    private static final long serialVersionUID = 5455193537547975639L;

    @Id
    private String id;

    public Pilot() {
    }
    
    public Pilot(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 31 * hash + Objects.hashCode(this.id);
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
        final Pilot other = (Pilot) obj;
        return Objects.equals(this.id, other.id);
    }

}
