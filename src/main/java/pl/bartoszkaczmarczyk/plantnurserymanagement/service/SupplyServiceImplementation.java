package pl.bartoszkaczmarczyk.plantnurserymanagement.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.bartoszkaczmarczyk.plantnurserymanagement.entity.Plant;
import pl.bartoszkaczmarczyk.plantnurserymanagement.entity.Supplier;
import pl.bartoszkaczmarczyk.plantnurserymanagement.entity.Supply;
import pl.bartoszkaczmarczyk.plantnurserymanagement.exception.EntityNotFoundException;
import pl.bartoszkaczmarczyk.plantnurserymanagement.repository.PlantRepository;
import pl.bartoszkaczmarczyk.plantnurserymanagement.repository.SupplyRepository;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class SupplyServiceImplementation implements SupplyService {

    SupplyRepository supplyRepository;
    PlantRepository plantRepository;
    PlantServiceImplementation plantServiceImplementation;
    SupplierServiceImplementation supplierServiceImplementation;


    @Override
    public Supply getSupply(Long id) {
        Optional<Supply> supply = supplyRepository.findById(id);
        if (supply.isPresent()) {
            return supply.get();
        } else {
            throw new EntityNotFoundException(Supply.class);
        }
    }

    @Override
    public Supply saveSupply(Supply supply, Long plantId, Long supplierId) {
        Plant plant = plantServiceImplementation.getPlant(plantId);
        Supplier supplier = supplierServiceImplementation.getSupplier(supplierId);
        supply.setPlant(plant);
        supply.setSupplier(supplier);
        plantServiceImplementation.adjustStock(plant, supply.getQuantity());
        plantRepository.save(plant);
        return supplyRepository.save(supply);
    }

    @Override
    public boolean deleteSupply(Supply supply) {
        if (supply.getPlant().getStock() >= supply.getQuantity()) {
            plantServiceImplementation.adjustStock(supply.getPlant(), -supply.getQuantity());
            supplyRepository.deleteById(supply.getId());
            return true;
        }
        return false;
    }

    @Override
    public List<Supply> getAllSupplies() {
        return (List<Supply>) supplyRepository.findAll();
    }
}
