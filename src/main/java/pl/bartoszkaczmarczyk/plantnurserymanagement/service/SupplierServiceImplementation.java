package pl.bartoszkaczmarczyk.plantnurserymanagement.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.bartoszkaczmarczyk.plantnurserymanagement.entity.Supplier;
import pl.bartoszkaczmarczyk.plantnurserymanagement.exception.EntityNotFoundException;
import pl.bartoszkaczmarczyk.plantnurserymanagement.repository.SupplierRepository;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class SupplierServiceImplementation implements SupplierService {

    SupplierRepository supplierRepository;

    @Override
    public Supplier getSupplier(Long id) {
        Optional<Supplier> supplier = supplierRepository.findById(id);
        if (supplier.isPresent()) {
            return supplier.get();
        } else {
            throw new EntityNotFoundException(Supplier.class, id);
        }
    }

    @Override
    public Supplier saveSupplier(Supplier supplier) {
        return supplierRepository.save(supplier);
    }

    @Override
    public void deleteSupplier(Long id) {
        Optional<Supplier> supplier = supplierRepository.findById(id);
        if (supplier.isPresent()) {
            supplierRepository.deleteById(id);
        } else {
            throw new EntityNotFoundException(Supplier.class, id);
        }
    }

    @Override
    public List<Supplier> getSuppliers() {
        return (List<Supplier>) supplierRepository.findAll();
    }
}
