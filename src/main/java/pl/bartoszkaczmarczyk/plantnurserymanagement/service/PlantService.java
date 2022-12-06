package pl.bartoszkaczmarczyk.plantnurserymanagement.service;

import pl.bartoszkaczmarczyk.plantnurserymanagement.entity.Plant;

import java.util.List;

public interface PlantService {

    Plant getPlant(Long id);
    Plant savePlant(Plant plant);
    void deletePlant(Long id);
    List<Plant> getPlants();
    boolean sellPlant(Plant plant, int quantity);
}
