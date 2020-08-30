package de.friedrichs.malteser.data.service;

import de.friedrichs.malteser.data.entity.Fahrt;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author AFR
 */
public interface FahrtRepository extends JpaRepository<Fahrt, Integer> {

    //public List<Fahrt> findAllOrderByTimestartDesc();
    public List<Fahrt> findByTimestartGreaterThan(LocalDateTime timestart);
    public List<Fahrt> findByTimestartGreaterThanOrderByTimestartDesc(LocalDateTime timestart);
    
}
