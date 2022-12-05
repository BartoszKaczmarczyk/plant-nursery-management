package pl.bartoszkaczmarczyk.plantnurserymanagement.service;

import pl.bartoszkaczmarczyk.plantnurserymanagement.entity.Supply;

import java.util.List;

public interface SupplyService {

    Supply getSupply(Long plantId, Long supplierId);
    Supply saveSupply(Supply supply, Long plantId, Long supplierId);
    void deleteSupply(Long id);
    List<Supply> getAllSupplies();
//    Supply updateSupply(String quantity, Long plantId, Long supplierId);
//    List<Supply> getPlantSupplies(Long plantId);
//    List<Supply> getSupplierSupplies(Long supplierId);

}
