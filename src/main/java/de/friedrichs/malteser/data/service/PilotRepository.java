package de.friedrichs.malteser.data.service;

import de.friedrichs.malteser.data.entity.Pilot;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author AFR
 */
public interface PilotRepository extends JpaRepository<Pilot, String>{
    
}
