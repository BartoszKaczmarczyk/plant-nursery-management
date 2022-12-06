package pl.bartoszkaczmarczyk.plantnurserymanagement.service;

import pl.bartoszkaczmarczyk.plantnurserymanagement.entity.Supplier;

import java.util.List;

public interface SupplierService {

    Supplier getSupplier(Long id);
    Supplier saveSupplier(Supplier supplier);
    void deleteSupplier(Long id);
    List<Supplier> getSuppliers();
}
