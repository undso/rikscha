package de.friedrichs.malteser.data.service;

import de.friedrichs.malteser.data.entity.Fahrgast;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author AFR
 */
public interface FahrgastRepository extends JpaRepository<Fahrgast, String>{
    
}
