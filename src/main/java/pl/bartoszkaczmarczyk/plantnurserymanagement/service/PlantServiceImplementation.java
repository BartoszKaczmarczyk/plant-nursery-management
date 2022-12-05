package pl.bartoszkaczmarczyk.plantnurserymanagement.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.bartoszkaczmarczyk.plantnurserymanagement.entity.Plant;
import pl.bartoszkaczmarczyk.plantnurserymanagement.repository.PlantRepository;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class PlantServiceImplementation implements PlantService {

    PlantRepository plantRepository;

    @Override
    public Plant getPlant(Long id) {
        Optional <Plant> plant = plantRepository.findById(id);
        try {
            return plant.get();
        } catch (Exception e) {
            System.out.println("Plant not found");
        }
        return null;
    }

    @Override
    public Plant savePlant(Plant plant) {
        return plantRepository.save(plant);
    }

    @Override
    public void deletePlant(Long id) {
        try {
            plantRepository.deleteById(id);
        } catch (Exception e) {
            System.out.println("Plant not found");
        }
    }

    @Override
    public List<Plant> getPlants() {
        return (List<Plant>) plantRepository.findAll();
    }
}
