package pl.bartoszkaczmarczyk.plantnurserymanagement;

import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import pl.bartoszkaczmarczyk.plantnurserymanagement.entity.Plant;
import pl.bartoszkaczmarczyk.plantnurserymanagement.entity.Supplier;
import pl.bartoszkaczmarczyk.plantnurserymanagement.repository.PlantRepository;
import pl.bartoszkaczmarczyk.plantnurserymanagement.repository.SupplierRepository;

import java.time.LocalDate;

@SpringBootApplication
@AllArgsConstructor
public class PlantNurseryManagementApplication implements CommandLineRunner {

	PlantRepository plantRepository;
	SupplierRepository supplierRepository;

	public static void main(String[] args) {

		SpringApplication.run(PlantNurseryManagementApplication.class, args);
		}

	@Override
	public void run(String... args) throws Exception {
		Plant[] plants = new Plant[] {
				new Plant("Sosna", "150-200", 890.00),
				new Plant("Brzoza", "200+", 150.00),
				new Plant("Lipa", "200+", 150.00)
		};

		for (Plant plant :
				plants) {
			plantRepository.save(plant);
		}

		Supplier[] suppliers = new Supplier[] {
				new Supplier("Plant nursury 1"),
				new Supplier("Plant nursury 2"),
				new Supplier("Plant nursury 3")
		};

		for (Supplier supplier :
				suppliers) {
			supplierRepository.save(supplier);
		}
	}
}
