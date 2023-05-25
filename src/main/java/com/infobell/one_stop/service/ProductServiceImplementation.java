package com.infobell.one_stop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infobell.one_stop.dao.ProductRepository;
import com.infobell.one_stop.model.Product;

@Service
public class ProductServiceImplementation implements ProductService {

	@Autowired
	private ProductRepository productrepository;
	
	@Override
	public List<Product> getProduct() {
		
		return productrepository.findAll();
	}

	@Override
	public Product addProduct(Product product) {
		productrepository.save(product);
		return product;
	}

	@Override
	public Product getProductById(String id) {
		
		return productrepository.findByProductId(id);
	}

	@Override
	public Product updateProduct(Product product) {
		if(productrepository.existsById(product.getMasterId())) {
			Product updatedProduct = productrepository.save(product);
			return updatedProduct;
		}
		else {
//			return "Product Not Found";
			return null;
		}
	}

	@Override
	public String deleteById(int id) {
		// TODO Auto-generated method stub
		productrepository.deleteById(id);
		return "Deleted.";
	}

	
}

