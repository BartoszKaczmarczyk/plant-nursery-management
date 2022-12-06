package pl.bartoszkaczmarczyk.plantnurserymanagement.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.bartoszkaczmarczyk.plantnurserymanagement.entity.Supply;
import pl.bartoszkaczmarczyk.plantnurserymanagement.service.PlantServiceImplementation;
import pl.bartoszkaczmarczyk.plantnurserymanagement.service.SupplyServiceImplementation;

import javax.validation.Valid;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/supply")
public class SupplyController {

    SupplyServiceImplementation supplyServiceImplementation;
    PlantServiceImplementation plantServiceImplementation;

    @GetMapping("/{id}")
    public ResponseEntity<Supply> getSupply(@PathVariable Long id) {
        return new ResponseEntity<>(supplyServiceImplementation.getSupply(id), HttpStatus.OK);
    }

    @PostMapping("/plant/{plantId}/supplier/{supplierId}")
    public ResponseEntity<Supply> saveSupply(@Valid @RequestBody Supply supply, @PathVariable Long plantId, @PathVariable Long supplierId) {
        return new ResponseEntity<>(supplyServiceImplementation.saveSupply(supply, plantId, supplierId), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteSupply(@PathVariable Long id) {
        Supply supply = supplyServiceImplementation.getSupply(id);
        if (supplyServiceImplementation.deleteSupply(supply)) {
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Supply>> getSupplies() {
        return new ResponseEntity<>(supplyServiceImplementation.getAllSupplies(), HttpStatus.OK);
    }




}
