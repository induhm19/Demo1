package com.product.SpringBootProduct.REPOSITORY;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.product.SpringBootProduct.DTO.Product;

public interface ProductRepository extends JpaRepository<Product,Integer>

{
	@Query("select t from Product t where t.quantity>=2")
	public List<Product> findAllProducts();
}