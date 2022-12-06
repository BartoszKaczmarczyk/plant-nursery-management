package pl.bartoszkaczmarczyk.plantnurserymanagement.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.bartoszkaczmarczyk.plantnurserymanagement.entity.Plant;
import pl.bartoszkaczmarczyk.plantnurserymanagement.exception.EntityNotFoundException;
import pl.bartoszkaczmarczyk.plantnurserymanagement.repository.PlantRepository;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class PlantServiceImplementation implements PlantService {

    PlantRepository plantRepository;

    @Override
    public Plant getPlant(Long id) {
        Optional<Plant> plant = plantRepository.findById(id);
        if (plant.isPresent()) {
            return plant.get();
        } else {
            throw new EntityNotFoundException(Plant.class, id);
        }
    }

    @Override
    public Plant savePlant(Plant plant) {
        return plantRepository.save(plant);
    }

    @Override
    public void deletePlant(Long id) {
        Optional<Plant> plant = plantRepository.findById(id);
        if (plant.isPresent()) {
            plantRepository.deleteById(id);
        } else {
            throw new EntityNotFoundException(Plant.class, id);
        }
    }

    @Override
    public List<Plant> getPlants() {
        return (List<Plant>) plantRepository.findAll();
    }

    @Override
    public boolean sellPlant(Plant plant, int quantity) {
        if (plant.getStock() >= quantity) {
        adjustStock(plant, -quantity);
        plantRepository.save(plant);
        return true;
        }
        return false;
    }

    public void adjustStock(Plant plant, int quantity) {
            plant.setStock(plant.getStock() + quantity);
    }
}
