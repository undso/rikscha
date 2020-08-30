/*
 */
package de.friedrichs.malteser.data.entity;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author AFR
 */
public class FahrgastTest {
    
    public FahrgastTest() {
    }

    @Test
    public void testGetAnschrift() {
        
        System.out.println("getAnschrift");
        Fahrgast f1 = new Fahrgast();
        f1.setAdresszusatz("Zusatz");
        f1.setStrasse("Strasse 13");
        f1.setPlz("12345");
        f1.setOrt("Ort");
        
        Fahrgast f2 = new Fahrgast();
        f2.setStrasse("Strasse 13");
        f2.setPlz("12345");
        f2.setOrt("Ort");
        
        Fahrgast f3 = new Fahrgast();
        f3.setPlz("12345");
        f3.setOrt("Ort");
        
        Fahrgast f4 = new Fahrgast();
        f4.setStrasse("Strasse 13");
        f4.setPlz("12345");
        
        Fahrgast f5 = new Fahrgast();
        f5.setStrasse("Strasse 13");
        f5.setOrt("Ort");
        
        Fahrgast f6 = new Fahrgast();
        f6.setOrt("Ort");
        
        String expF1 = "Zusatz, Strasse 13, 12345 Ort";
        String expF2 = "Strasse 13, 12345 Ort";
        String expF3 = "12345 Ort";
        String expF4 = "Strasse 13, 12345";
        String expF5 = "Strasse 13, Ort";
        String expF6 = "Ort";
        
        assertEquals(expF1, f1.getAnschrift());
        assertEquals(expF2, f2.getAnschrift());
        assertEquals(expF3, f3.getAnschrift());
        assertEquals(expF4, f4.getAnschrift());
        assertEquals(expF5, f5.getAnschrift());
        assertEquals(expF6, f6.getAnschrift());
    }

    
    
}
