package de.friedrichs.malteser.data.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import org.apache.commons.lang3.StringUtils;

/**
 *
 * @author AFR
 */
@Entity
public class Fahrgast extends Person implements Serializable {

    private static final long serialVersionUID = 539458764652637988L;

    @Id
    private String id;
    @ElementCollection(fetch = FetchType.EAGER)
    private List<String> phones = new ArrayList<>();
    private String imageURL;
    private String adresszusatz;
    private String strasse;
    private String plz;
    private String ort;

    public Fahrgast() {
    }
    
    public Fahrgast(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<String> getPhones() {
        if (phones == null) {
            phones = new ArrayList<>();
        }
        return phones;
    }

    public void setPhones(List<String> phones) {
        this.phones = phones;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public String getStrasse() {
        return strasse;
    }

    public void setStrasse(String strasse) {
        this.strasse = strasse;
    }

    public String getPlz() {
        return plz;
    }

    public void setPlz(String plz) {
        this.plz = plz;
    }

    public String getOrt() {
        return ort;
    }

    public void setOrt(String ort) {
        this.ort = ort;
    }

    public String getAdresszusatz() {
        return adresszusatz;
    }

    public void setAdresszusatz(String adresszusatz) {
        this.adresszusatz = adresszusatz;
    }

    public String getAnschrift() {
        StringBuilder a = new StringBuilder();
        if (!StringUtils.isEmpty(getAdresszusatz())) {
            a.append(getAdresszusatz()).append(", ");
        }
        if (!StringUtils.isEmpty(getStrasse())) {
            a.append(getStrasse());
        }
        if (a.length() > 0) {
            a.append(", ");
        }
        if (!StringUtils.isEmpty(getPlz())) {
            a.append(getPlz()).append(StringUtils.SPACE);
        }
        if (!StringUtils.isEmpty(getOrt())) {
            a.append(getOrt());
        } else {
            a.deleteCharAt(a.length() - 1);
        }
        return a.toString();
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + Objects.hashCode(this.id);
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
        final Fahrgast other = (Fahrgast) obj;
        return Objects.equals(this.id, other.id);
    }

}
