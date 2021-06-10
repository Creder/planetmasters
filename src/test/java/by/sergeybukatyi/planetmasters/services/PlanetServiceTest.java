package by.sergeybukatyi.planetmasters.services;

import by.sergeybukatyi.planetmasters.entities.Master;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PlanetServiceTest {

    @Autowired
    PlanetService planetService;
    @Autowired
    MasterService masterService;

    @Test
    void savePlanet() {
        String result = planetService.savePlanet("Mars");
        assertEquals("Mars created!", result);
    }

    @Test
    void getAll() {
        planetService.savePlanet("Mercury");
        planetService.savePlanet("Venus");
        planetService.savePlanet("Earth");
        planetService.savePlanet("Mars");
        planetService.savePlanet("Jupiter");
        planetService.savePlanet("Saturn");
        planetService.savePlanet("Uranus");
        planetService.savePlanet("Neptune");
        assertEquals(8, planetService.getAll().size());

    }

    @Test
    void getPlanetByName() {
        planetService.savePlanet("Mercury");
        planetService.savePlanet("Venus");
        planetService.savePlanet("Earth");
        assertEquals("Venus", planetService.getPlanetByName("Venus").getName());
    }

    @Test
    void setMasterToPlanet() {
        planetService.savePlanet("Mercury");
        masterService.saveMaster("Tanos", 100);

        planetService.setMasterToPlanet("Tanos", "Mercury");
        assertEquals("Tanos", planetService.getMasterName("Mercury"));
    }

    @Test
    void destroyPlanet() {
        planetService.savePlanet("Mercury");
        planetService.savePlanet("Venus");
        planetService.savePlanet("Earth");
        planetService.savePlanet("Mars");
        planetService.savePlanet("Jupiter");
        planetService.savePlanet("Saturn");
        planetService.savePlanet("Uranus");
        planetService.savePlanet("Neptune");

        assertEquals(8, planetService.getAll().size());

        planetService.destroyPlanet("Saturn");

        assertEquals(7, planetService.getAll().size());

        assertNull(planetService.getPlanetByName("Saturn"));
    }
}