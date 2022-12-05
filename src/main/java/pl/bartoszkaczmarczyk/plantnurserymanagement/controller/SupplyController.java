package pl.bartoszkaczmarczyk.plantnurserymanagement.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.bartoszkaczmarczyk.plantnurserymanagement.entity.Supply;
import pl.bartoszkaczmarczyk.plantnurserymanagement.service.SupplyServiceImplementation;

import javax.validation.Valid;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/supply")
public class SupplyController {

    SupplyServiceImplementation supplyServiceImplementation;

    @GetMapping("/plant/{plantId}/supplier/{supplierId}")
    public ResponseEntity<Supply> getSupply(@PathVariable Long plantId, @PathVariable Long supplierId) {
        return new ResponseEntity<>(supplyServiceImplementation.getSupply(plantId, supplierId), HttpStatus.OK);
    }

    @PostMapping("/plant/{plantId}/supplier/{supplierId}")
    public ResponseEntity<Supply> saveSupply(@Valid @RequestBody Supply supply,@PathVariable Long plantId, @PathVariable Long supplierId) {
        return new ResponseEntity<>(supplyServiceImplementation.saveSupply(supply, plantId, supplierId), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deletePlant(@PathVariable Long id) {
        supplyServiceImplementation.deleteSupply(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Supply>> getPlants() {
        return new ResponseEntity<>(supplyServiceImplementation.getAllSupplies(), HttpStatus.OK);
    }




}
