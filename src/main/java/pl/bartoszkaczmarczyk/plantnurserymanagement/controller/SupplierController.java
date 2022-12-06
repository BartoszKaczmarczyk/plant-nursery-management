package pl.bartoszkaczmarczyk.plantnurserymanagement.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.bartoszkaczmarczyk.plantnurserymanagement.entity.Supplier;
import pl.bartoszkaczmarczyk.plantnurserymanagement.service.SupplierServiceImplementation;

import javax.validation.Valid;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/supplier")
public class SupplierController {

    SupplierServiceImplementation supplierServiceImplementation;

    @GetMapping("/{id}")
    public ResponseEntity<Supplier> getSupplier(@PathVariable Long id) {
        return new ResponseEntity<>(supplierServiceImplementation.getSupplier(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Supplier> saveSupplier(@Valid @RequestBody Supplier supplier) {
        return new ResponseEntity<>(supplierServiceImplementation.saveSupplier(supplier), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteSupplier(@PathVariable Long id) {
        supplierServiceImplementation.deleteSupplier(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Supplier>> getSuppliers() {
        return new ResponseEntity<>(supplierServiceImplementation.getSuppliers(), HttpStatus.OK);
    }
}
