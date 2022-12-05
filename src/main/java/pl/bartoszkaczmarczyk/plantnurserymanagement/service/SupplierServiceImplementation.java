package pl.bartoszkaczmarczyk.plantnurserymanagement.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.bartoszkaczmarczyk.plantnurserymanagement.entity.Supplier;
import pl.bartoszkaczmarczyk.plantnurserymanagement.repository.SupplierRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class SupplierServiceImplementation implements SupplierService {

    SupplierRepository supplierRepository;

    @Override
    public Supplier getSupplier(Long id) {
        try {
            return supplierRepository.findById(id).get();
        } catch (Exception e) {
            System.out.println("Supplier not found");
        }
        return null;
    }

    @Override
    public Supplier saveSupplier(Supplier supplier) {
        return supplierRepository.save(supplier);
    }

    @Override
    public void deleteSupplier(Long id) {
        try {
            supplierRepository.deleteById(id);
        } catch (Exception e) {
            System.out.println("Supplier not found");
        }
    }

    @Override
    public List<Supplier> getSuppliers() {
        return (List<Supplier>) supplierRepository.findAll();
    }
}
