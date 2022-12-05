package pl.bartoszkaczmarczyk.plantnurserymanagement.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.bartoszkaczmarczyk.plantnurserymanagement.entity.Plant;
import pl.bartoszkaczmarczyk.plantnurserymanagement.entity.Supplier;
import pl.bartoszkaczmarczyk.plantnurserymanagement.entity.Supply;
import pl.bartoszkaczmarczyk.plantnurserymanagement.repository.PlantRepository;
import pl.bartoszkaczmarczyk.plantnurserymanagement.repository.SupplierRepository;
import pl.bartoszkaczmarczyk.plantnurserymanagement.repository.SupplyRepository;

import java.util.List;

@AllArgsConstructor
@Service
public class SupplyServiceImplementation implements SupplyService {

    SupplyRepository supplyRepository;
    PlantRepository plantRepository;
    SupplierRepository supplierRepository;

    @Override
    public Supply getSupply(Long plantId, Long supplierId) {
        try {
           supplyRepository.findByPlantIdAndSupplierId(plantId, supplierId);
        } catch (Exception e){
            System.out.println("Supply not found");
        }
        return null;
    }

    @Override
    public Supply saveSupply(Supply supply, Long plantId, Long supplierId) {
        try {
            Plant plant = plantRepository.findById(plantId).get();
            supply.setPlant(plant);
            Supplier supplier = supplierRepository.findById(supplierId).get();
            supply.setSupplier(supplier);
            supplyRepository.save(supply);
        } catch (Exception e) {
            System.out.println("Supply not found");
        }
        return null;
    }

    @Override
    public void deleteSupply(Long id) {
        try {
            supplyRepository.deleteById(id);
        } catch (Exception e) {
            System.out.println("Supply not found");
        }
    }

    @Override
    public List<Supply> getAllSupplies() {
        return (List<Supply>) supplyRepository.findAll();
    }
}
