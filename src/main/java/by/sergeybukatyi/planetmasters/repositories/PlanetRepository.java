package by.sergeybukatyi.planetmasters.repositories;

import by.sergeybukatyi.planetmasters.entities.Planet;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlanetRepository extends CrudRepository<Planet, Long> {
    Planet findByName(String name);
}
