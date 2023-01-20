package me.leel.inventoryservice;

import me.leel.inventoryservice.model.Inventory;
import me.leel.inventoryservice.repository.InventoryRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class InventoryServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(InventoryServiceApplication.class, args);
	}


	@Bean
	public CommandLineRunner loadData(InventoryRepository inventoryRepository){

		return args -> {

			Inventory inventory = new Inventory();
			inventory.setSkuCode("iphone_13");
			inventory.setQuantity(0);

			Inventory inventory2 = new Inventory();
			inventory2.setSkuCode("iphone_13_red");
			inventory2.setQuantity(10);

			Inventory inventory3 = new Inventory();
			inventory3.setSkuCode("iphone_13_green");
			inventory3.setQuantity(10);

			inventoryRepository.save(inventory);
			inventoryRepository.save(inventory2);
			inventoryRepository.save(inventory3);
			inventoryRepository.save(inventory3);
			inventoryRepository.save(inventory3);
			inventoryRepository.save(inventory3);
			inventoryRepository.save(inventory3);
			inventoryRepository.save(inventory3);
			inventoryRepository.save(inventory3);
			inventoryRepository.save(inventory3);
			inventoryRepository.save(inventory3);
			inventoryRepository.save(inventory3);


		};
	}

}
