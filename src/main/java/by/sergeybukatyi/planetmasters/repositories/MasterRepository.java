package by.sergeybukatyi.planetmasters.repositories;

import by.sergeybukatyi.planetmasters.entities.Master;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public interface MasterRepository extends CrudRepository<Master, Long> {

    Master findByName(String name);
    @Query("Select m from Master m left join fetch m.planets where m.planets is empty ")
    List<Master> get();
    @Query("Select m from Master m left join fetch m.planets order by m.age asc")
    List<Master> findTop10ByOrderByAgeAsc(Pageable pageagble);
}
