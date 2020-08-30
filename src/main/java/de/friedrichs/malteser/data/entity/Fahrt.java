package de.friedrichs.malteser.data.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author AFR
 */
@Entity
public class Fahrt implements Serializable {

    private static final long serialVersionUID = -5811005274202342392L;
    
    @Id
    @GeneratedValue
    private Long id;
    private String eventId;
    private LocalDateTime timestart;
    private double dauerPlan;
    private double dauerIst;
    @ManyToOne
    private Pilot pilot;
    @ManyToOne
    private Fahrgast fahrgast;
    private String adresse;
    private String telefon;
    private String weitereInfos;
    private double gefahreneKm;
    private String forumsLink;
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created", nullable = false)
    private Date created;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "updated", nullable = false)
    private Date updated;

    @PrePersist
    protected void onCreate() {
        this.updated = this.created = new Date();
    }

    @PreUpdate
    protected void onUpdate() {
        this.updated = new Date();
    }
    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEventId() {
        return eventId;
    }

    public void setEventId(String eventId) {
        this.eventId = eventId;
    }

    public LocalDateTime getTimestart() {
        return timestart;
    }

    public void setTimestart(LocalDateTime timestart) {
        this.timestart = timestart;
    }

    public Pilot getPilot() {
        return pilot;
    }

    public void setPilot(Pilot pilot) {
        this.pilot = pilot;
    }

    public Fahrgast getFahrgast() {
        return fahrgast;
    }

    public void setFahrgast(Fahrgast fahrgast) {
        this.fahrgast = fahrgast;
    }

    public String getWeitereInfos() {
        return weitereInfos;
    }

    public void setWeitereInfos(String weitereInfos) {
        this.weitereInfos = weitereInfos;
    }

    public double getGefahreneKm() {
        return gefahreneKm;
    }

    public void setGefahreneKm(double gefahreneKm) {
        this.gefahreneKm = gefahreneKm;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public double getDauerPlan() {
        return dauerPlan;
    }

    public void setDauerPlan(double dauerPlan) {
        this.dauerPlan = dauerPlan;
    }

    public double getDauerIst() {
        return dauerIst;
    }

    public void setDauerIst(double dauerIst) {
        this.dauerIst = dauerIst;
    }

    public String getForumsLink() {
        return forumsLink;
    }

    public void setForumsLink(String forumsLink) {
        this.forumsLink = forumsLink;
    }
    
    public Date getCreated() {
        return created;
    }

    public Date getUpdated() {
        return updated;
    }
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + Objects.hashCode(this.id);
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
        final Fahrt other = (Fahrt) obj;
        return Objects.equals(this.id, other.id);
    }

    @Override
    public String toString() {
        return "Fahrt{" + "id=" + id + ", eventId=" + eventId + ", timestart=" + timestart + ", dauerPlan=" + dauerPlan + ", pilot=" + pilot + ", fahrgast=" + fahrgast + ", weitereInfos=" + weitereInfos + ", gefahreneKm=" + gefahreneKm + '}';
    }

    
}
