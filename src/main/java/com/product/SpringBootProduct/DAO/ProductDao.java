package com.product.SpringBootProduct.DAO;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import com.product.SpringBootProduct.DTO.Product;
import com.product.SpringBootProduct.REPOSITORY.ProductRepository;

@Repository
public class ProductDao 
{
	@Autowired
	ProductRepository repository;
	
	//to add task object to DB(insertion)
	public Product addProduct(Product product) 
	{
		repository.save(product);//uyiyiu
		return product;
	}
	
	//to retrieve all objects from DB
	public List<Product> getAllProducts()
	{
		//findAll--->to fetch all objects
		return repository.findAll();
	}
	
	//
	public Product findProduct(int productId)
	{
		
		Optional<Product> opt= repository.findById(productId);
		if(opt.isPresent())//to check whether object is present or not
		{
			//if present,retrieve object using get()
			return opt.get();	
		}
		return null;
	}
    	
	//to delete an object from db
	public void deleteProduct(int productId)
	{
		//
		Product t=findProduct(productId);
		if(t!=null)
		{
			//to delete a object --->delete(object)
			repository.delete(t);
			//or we can delete using --->deleteById(int id)
		}
	}
	
	//to update status and description of a task
	public String updateProduct(String date_of_delivery,int product_id,int quantity)
	{
		Product t=findProduct(product_id);
		if(t!=null)
		{
			//setting new values to the variables
			t.setQuantity(5);
			t.setDate_of_delivery("01-09-2023");
			
			//saving the updated object to DB
			repository.save(t);
			return "updation successful";//returning string
		}
		return "product not found...cannot update";
	}
	
	//to retrieve all completed tasks
	public List<Product> getAllProduct()
	{
		return repository.findAllProducts();
	}
}
