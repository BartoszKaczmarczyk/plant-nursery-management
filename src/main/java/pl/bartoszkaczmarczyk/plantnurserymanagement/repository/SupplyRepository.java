package pl.bartoszkaczmarczyk.plantnurserymanagement.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.bartoszkaczmarczyk.plantnurserymanagement.entity.Supply;

@Repository
public interface SupplyRepository extends CrudRepository<Supply, Long> {
    Supply findByPlantIdAndSupplierId(Long plantId, Long supplierId);
}
