package pl.bartoszkaczmarczyk.plantnurserymanagement.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.bartoszkaczmarczyk.plantnurserymanagement.entity.Supplier;

@Repository
public interface SupplierRepository extends CrudRepository<Supplier, Long> {
}
