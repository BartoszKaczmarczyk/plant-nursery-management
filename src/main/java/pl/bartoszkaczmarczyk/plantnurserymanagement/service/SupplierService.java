package pl.bartoszkaczmarczyk.plantnurserymanagement.service;

import pl.bartoszkaczmarczyk.plantnurserymanagement.entity.Plant;
import pl.bartoszkaczmarczyk.plantnurserymanagement.entity.Supplier;
import pl.bartoszkaczmarczyk.plantnurserymanagement.entity.Supply;

import java.util.List;
import java.util.Set;

public interface SupplierService {

    Supplier getSupplier(Long id);
    Supplier saveSupplier(Supplier supplier);
    void deleteSupplier(Long id);
    List<Supplier> getSuppliers();

//    Set<Supply> getSupplies(Long id);
//    Plant addPlantToSupplier(Long plantId, Long supplierId);
//    Set<Plant> getSuppliedPlants(Long id);

}
