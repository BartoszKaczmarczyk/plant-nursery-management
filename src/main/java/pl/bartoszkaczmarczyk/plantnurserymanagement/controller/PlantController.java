package pl.bartoszkaczmarczyk.plantnurserymanagement.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.bartoszkaczmarczyk.plantnurserymanagement.entity.Plant;
import pl.bartoszkaczmarczyk.plantnurserymanagement.service.PlantServiceImplementation;

import javax.validation.Valid;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/plant")
public class PlantController {

    PlantServiceImplementation plantServiceImplementation;

    @GetMapping("/{id}")
        public ResponseEntity<Plant> getPlant(@PathVariable Long id) {
            return new ResponseEntity<>(plantServiceImplementation.getPlant(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Plant> savePlant(@Valid @RequestBody Plant plant) {
        return new ResponseEntity<>(plantServiceImplementation.savePlant(plant), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deletePlant(@PathVariable Long id) {
        plantServiceImplementation.deletePlant(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Plant>> getPlants() {
        return new ResponseEntity<>(plantServiceImplementation.getPlants(), HttpStatus.OK);
    }


}
