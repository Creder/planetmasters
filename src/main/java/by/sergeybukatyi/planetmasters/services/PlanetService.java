package by.sergeybukatyi.planetmasters.services;

import by.sergeybukatyi.planetmasters.entities.Master;
import by.sergeybukatyi.planetmasters.entities.Planet;
import by.sergeybukatyi.planetmasters.repositories.PlanetRepository;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class PlanetService {

    private final PlanetRepository planetRepository;
    private final MasterService masterService;

    public PlanetService(PlanetRepository planetRepository, MasterService masterService) {
        this.planetRepository = planetRepository;
        this.masterService = masterService;
    }

    public String savePlanet(String name) {
        if(!name.equals("")){
            Planet planet = new Planet(name);
            try {
                planetRepository.save(planet);
                return planet.getName() + " created!";
            }
            catch (DataIntegrityViolationException e){
                return planet.getName() + " already exists!";
            }
        }
        else
            return "Planet name cannot be empty!";

    }

    public List<Planet> getAll() {
        return (List<Planet>) planetRepository.findAll();
    }

    public Planet getPlanetByName(String name) {
        return planetRepository.findByName(name);
    }

    @Transactional(readOnly = true)
    public String getMasterName(String planetName){
        Planet planet = planetRepository.findByName(planetName);
        return planet.getMaster().getName();
    }
    public String setMasterToPlanet(String masterName, String planetName){
        Master master = masterService.getMasterByName(masterName);
        Planet planet = getPlanetByName(planetName);
        if(master != null){
            try {
                    planet.setMaster(master);
                    planetRepository.save(planet);
                    return masterName+" set to "+ planetName;
            }catch (NullPointerException e){
                return planetName + " does not exists!";
            }
        }
        else{
            return "Master " + masterName + " does not exists!";
        }


    }

    public void destroyPlanet(String planetName){
        Planet planet = getPlanetByName(planetName);
        planetRepository.delete(planet);
    }
}
