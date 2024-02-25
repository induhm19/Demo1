package com.product.SpringBootProduct.CONTROLLER;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.product.SpringBootProduct.DAO.ProductDao;
import com.product.SpringBootProduct.DTO.Product;

@RestController
public class ProductController 
{
	@Autowired
	ProductDao dao;
	
	//API for inserting object
	@PostMapping("/product")
	public Product InsertProduct(@RequestBody Product product)
	{
		return dao.addProduct(product);
	}
	
	//API for fetching all objects
	@GetMapping("/product")
	public List<Product> allProduct()
	{
		return dao.getAllProducts();
	}
	
	//API for fetching one object
	@GetMapping("/getproduct")
	public Product getProduct(@RequestParam int productId)
	{
		return dao.findProduct(productId);
	}
	
	//API for deleting an object
	@DeleteMapping("/product")
	public void deleteProduct(@RequestParam int productId)
	{
		dao.deleteProduct(productId);
	}
	
	//API for updating task object
	@PutMapping("/product")
	public String updateProduct(@RequestParam int product_id,@RequestParam String date_of_delivery,@RequestParam int quantity)
	{
		return dao.updateProduct(date_of_delivery, product_id, quantity);
	}
	
	//to retrieve all completed tasks
		@GetMapping("/get")
		public List<Product> getAll()
		{
			return dao.getAllProduct();
		}
}
