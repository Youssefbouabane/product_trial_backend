package com.alt.products;

import com.alt.products.entities.Product;
import com.alt.products.entities.User;
import com.alt.products.enums.InventoryStatus;
import com.alt.products.repositories.ProductRepository;
import com.alt.products.repositories.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class ProductsApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductsApplication.class, args);
	}

	@Bean
	CommandLineRunner run(ProductRepository productRepository, UserRepository userRepository) {
		return args -> {
			productRepository.saveAll(List.of(
					new Product("P001", "Laptop", "High-end gaming laptop", "laptop.jpg", "Electronics", 1200.00, 10, "REF001", 1L, InventoryStatus.INSTOCK, 5),
					new Product("P002", "Smartphone", "Latest smartphone with cutting-edge features", "smartphone.jpg", "Gadgets", 800.00, 5, "REF002", 2L, InventoryStatus.LOWSTOCK, 4),
					new Product("P003", "Vacuum Cleaner", "Powerful and compact vacuum cleaner", "vacuum.jpg", "Home Appliances", 200.00, 20, "REF003", 3L, InventoryStatus.INSTOCK, 3)
			));

			User defaultUser = new User();
			defaultUser.setEmail("test@test.com");
			defaultUser.setPassword("$2a$10$mbeLHgTpEhYK7/9kKMQgIeGNtNnt/tRzfeQE2VvcXD5jS66oLgtZu");

			User userAdmin = new User();
			userAdmin.setEmail("admin@admin.com");
			userAdmin.setPassword("$2a$10$mbeLHgTpEhYK7/9kKMQgIeGNtNnt/tRzfeQE2VvcXD5jS66oLgtZu");

			userRepository.saveAll(List.of(defaultUser,userAdmin));

		};
	}
}
