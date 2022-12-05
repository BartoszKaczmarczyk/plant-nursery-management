package pl.bartoszkaczmarczyk.plantnurserymanagement.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.bartoszkaczmarczyk.plantnurserymanagement.entity.Plant;

@Repository
public interface PlantRepository extends CrudRepository<Plant, Long> {
}
