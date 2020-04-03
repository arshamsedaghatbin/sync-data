package com.data.service;


import com.data.domain.Product;
import com.data.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    @Autowired
    public ProductRepository productRepository;
    public void saveProduct(Product product) {
        productRepository.save(product);

    }
}
