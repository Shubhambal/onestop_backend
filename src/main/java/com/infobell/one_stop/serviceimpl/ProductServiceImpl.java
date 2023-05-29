package com.infobell.one_stop.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.infobell.one_stop.exception.ResourceNotFoundException;
import com.infobell.one_stop.repository.ProductRepository;
import com.infobell.one_stop.service.ProductService;
import com.infobell.one_stop.model.Product;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productrepository;

	/**
	 * Retrieves all products.
	 *
	 * @return List of products
	 */
	@Override
	public List<Product> getProduct() {
		return productrepository.findAll();
	}

	/**
	 * Adds a new product.
	 *
	 * @param product Product to be added
	 * @return The added product
	 */
	@Override
	public Product addProduct(Product product) {
		productrepository.save(product);
		return product;
	}

	/**
	 * Retrieves a product by its ID.
	 *
	 * @param id ID of the product
	 * @return The product with the specified ID
	 * @throws ResourceNotFoundException if the product is not found
	 */
	@Override
	public Product getProductById(int id) {
		Product product = productrepository.findByProductId(id);
		if (product == null) {
			throw new ResourceNotFoundException("Product", "id", id);
		}
		return product;
	}

	/**
	 * Updates an existing product.
	 *
	 * @param product Product to be updated
	 * @return The updated product
	 * @throws ResourceNotFoundException if the product is not found
	 */
	@Override
	public Product updateProduct(Product product) {
		if (productrepository.existsById(product.getProductId())) {
			Product updatedProduct = productrepository.save(product);
			return updatedProduct;
		} else {
			throw new ResourceNotFoundException("Product", "id", Integer.toString(product.getProductId()));
		}
	}

	/**
	 * Deletes a product by its ID.
	 *
	 * @param id ID of the product to be deleted
	 * @return A message indicating the deletion status
	 * @throws ResourceNotFoundException if the product is not found
	 */
	@Override
	public String deleteById(int id) {
		if (productrepository.existsById(id)) {
			productrepository.deleteById(id);
			return "Deleted.";
		}
		throw new ResourceNotFoundException("Product", "id", Integer.toString(id));
	}
}
