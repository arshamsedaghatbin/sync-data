package com.data.rest;

import com.data.domain.Product;
import com.data.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController("/product")
public class AddProduct {

    @Autowired
    private ProductService productService;
    @PostMapping
    public ResponseEntity<Void> createProduct(@RequestBody Product product){
        productService.saveProduct(product);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }
}
