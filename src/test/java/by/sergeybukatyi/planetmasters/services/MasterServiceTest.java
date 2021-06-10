package by.sergeybukatyi.planetmasters.services;

import by.sergeybukatyi.planetmasters.entities.Master;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
class MasterServiceTest {

    @Autowired
    PlanetService planetService;
    @Autowired
    MasterService masterService;
    @Test
    void saveMaster() throws Exception {

        String result = masterService.saveMaster("Tanos", 100);
        assertEquals("Tanos saved!", result);
    }

    @Test
    void getAll() {
        masterService.saveMaster("Tanos", 100);
        masterService.saveMaster("Protos", 2000);
        masterService.saveMaster("Cratos", 5000);
        assertEquals(3, masterService.getAll().size());
    }

    @Test
    void getMasterByName() {
        masterService.saveMaster("Tanos", 100);
        Master master = masterService.getMasterByName("Tanos");
        assertEquals(100, master.getAge());
    }

    @Test
    void getMastersWithoutPlanets() {
        masterService.saveMaster("Tanos", 100);
        masterService.saveMaster("Protos", 2000);
        masterService.saveMaster("Cratos", 5000);

        planetService.savePlanet("Mars");

        planetService.setMasterToPlanet("Tanos", "Mars");
        assertEquals(2, masterService.getMastersWithoutPlanets().size());

    }

    @Test
    void getTenYoungestMasters() {
        masterService.saveMaster("Tanos", 100);
        masterService.saveMaster("Protos", 2000);
        masterService.saveMaster("Cratos", 5000);
        masterService.saveMaster("Opus", 147);
        masterService.saveMaster("Anubis", 6000);
        masterService.saveMaster("Rebos", 74);
        masterService.saveMaster("Elgos", 677);
        masterService.saveMaster("Fargus", 144);
        masterService.saveMaster("Nebulae", 600);
        masterService.saveMaster("Tron", 156);
        masterService.saveMaster("Marcus", 70000);

        List<Master> masterList = masterService.getTenYoungestMasters();
        assertEquals(10, masterList.size());
        assertEquals(74, masterList.get(0).getAge());
        assertEquals(6000, masterList.get(9).getAge());

    }
}