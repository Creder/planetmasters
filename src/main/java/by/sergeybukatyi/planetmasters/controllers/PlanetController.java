package by.sergeybukatyi.planetmasters.controllers;

import by.sergeybukatyi.planetmasters.entities.Planet;
import by.sergeybukatyi.planetmasters.services.PlanetService;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/planets")
public class PlanetController {
    final PlanetService planetService;

    public PlanetController(PlanetService planetService) {
        this.planetService = planetService;
    }

    @PostMapping("/save")
    public String savePlanet(@RequestParam("name") String name) {

        return planetService.savePlanet(name);
    }

    @GetMapping("/getall")
    public List<Planet> getAllPlanets(){
        return planetService.getAll();
    }

    @PostMapping("/setMaster")
    public String setMaster(@RequestParam(value = "mastername", defaultValue = "") String masterName, @RequestParam(value = "planetname", defaultValue = "") String planetname){
        return planetService.setMasterToPlanet(masterName, planetname);
    }

    @GetMapping("/destroy/{planetname}")
    public void destroyPlanet(@PathVariable("planetname") String planetName, HttpServletResponse response) throws IOException {
        planetService.destroyPlanet(planetName);
        response.sendRedirect("/");
    }



}
