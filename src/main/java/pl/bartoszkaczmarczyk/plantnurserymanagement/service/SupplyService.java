package pl.bartoszkaczmarczyk.plantnurserymanagement.service;

import pl.bartoszkaczmarczyk.plantnurserymanagement.entity.Supply;

import java.util.List;

public interface SupplyService {

    Supply getSupply(Long id);
    Supply saveSupply(Supply supply, Long plantId, Long supplierId);
    boolean deleteSupply(Supply supply);
    List<Supply> getAllSupplies();
}
