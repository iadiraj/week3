package com.springboot.week3;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.springboot.week3.entities.ProductEntity;
import com.springboot.week3.repositories.ProductRepository;

@SpringBootTest
class Week3ApplicationTests {
	@Autowired
	ProductRepository productRepository;

	@Test
	void contextLoads() {
	}

	@Test
	void testRepositories() {
		ProductEntity productEntity = ProductEntity.builder().sku("nestle234").title("Nestle Chocolate")
				.price(BigDecimal.valueOf(123.45)).quantity(12).build();
		ProductEntity savedProductEntity = productRepository.save(productEntity);
		System.out.println(savedProductEntity);
	}

	@Test
	void getRepository() {
		// List<ProductEntity> entities =
		// productRepository.findByCreatedAtAfter(LocalDateTime.of(2024, 1, 1, 0, 0,
		// 0));
		// List<ProductEntity> entities = productRepository.findByQuantityAndPrice(4,
		// BigDecimal.valueOf(23.45));
		// List<ProductEntity> entities = productRepository.findByTitleLike("%Choco%");
		List<ProductEntity> entities = productRepository.findByTitleContainingIgnoreCase("choco", null);
		System.out.println(entities);
	}

	@Test
	void getSingleFromRepository() {
		Optional<ProductEntity> entity = productRepository.findByTitleAndPrice("Nestle Chocolate",
				BigDecimal.valueOf(123.45));
		System.out.println(entity);

	}

}
