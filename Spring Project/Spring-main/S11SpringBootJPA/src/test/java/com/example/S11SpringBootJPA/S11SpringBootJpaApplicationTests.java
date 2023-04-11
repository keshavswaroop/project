package com.example.S11SpringBootJPA;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import com.example.S11SpringBootJPA.entity.Product;
import com.example.S11SpringBootJPA.entity.ProductRepository;

@SpringBootTest
class S11SpringBootJpaApplicationTests {
	
	@Autowired
	ApplicationContext context;

	@Test
	void contextLoads() {
	}
	
	@Test
	void createProduct() {
		ProductRepository pr=context.getBean(ProductRepository.class);
		Product product = new Product("Laptop","3GB","23433");
		pr.save(product);
	}
	
	@Test
	void updateProduct() {
		ProductRepository pr=context.getBean(ProductRepository.class);
		Optional<Product> optionalProduct=pr.findById(1);
		if(optionalProduct.isPresent()) {
			Product product= optionalProduct.get();
			System.out.println(product);
			product.setPrice("32444");
			pr.save(product);
		}
		else {
			System.out.println("Product not present");
		}
		
	}
	
	@Test
	void readAllProduct() {
		ProductRepository pr=context.getBean(ProductRepository.class);
		List<Product> product= (List<Product>) pr.findAll();
		System.out.println(product);
	}
	
	@Test
	void findProductByName() {
		ProductRepository pr=context.getBean(ProductRepository.class);
		List<Product> product=pr.findByName("Laptop");
		System.out.println("Finding by name"+product);
	}

}
