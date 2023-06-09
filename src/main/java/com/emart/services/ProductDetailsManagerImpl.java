package com.emart.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emart.entities.Category;
import com.emart.entities.ProductDetails;
import com.emart.repository.ProductDetailsRepository;

@Service
public class ProductDetailsManagerImpl implements ProductDetailsManager {

	@Autowired
	ProductDetailsRepository repository;
	
	/**
	 * @author  Madhavi
	 * @version 3.9.10
	 * @since   24-05-2023
	 * Add product details.
	 *
	 * @param c The product details to be added.
	 */
	@Override
	public void addProductDetails(ProductDetails c) {
		repository.save(c);
	}
	
	/**
	 * Get all product details.
	 *
	 * @return The list of product details.
	 */
	@Override
	public List<ProductDetails> getProductDetails() {
		return repository.findAll();
	}
	
	/**
	 * Delete product details by ID.
	 *
	 * @param id The ID of the product details to be deleted.
	 */
	@Override
	public void delete(int id) {
		repository.deleteById(id);
	}
	
	/**
	 * Get product details by ID.
	 *
	 * @param id The ID of the product details.
	 * @return An optional containing the product details, or an empty optional if not found.
	 */
	@Override
	public Optional<ProductDetails> getProductDetail(int id) {
		return repository.findById(id);
	}
	
	/**
	 * Get product details by product ID.
	 *
	 * @param p_Id The product ID.
	 * @return The list of product details.
	 */
	@Override
	public List<ProductDetails> getDetails(int p_Id) {
		return repository.getDetails(p_Id);
	}
	
	/**
	 * Check if product details exist for a given category ID.
	 *
	 * @param cid The category ID.
	 * @return true if product details exist, false otherwise.
	 */
	@Override
	public boolean exists(int cid) {
		return false;
	}
}
