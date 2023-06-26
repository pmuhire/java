package com.example.selling.controllers;
import com.example.selling.dtos.ProductsDTO;
import com.example.selling.models.Product;
import com.example.selling.serviceImpls.ProductsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/products")
public class ProductsController {

    private final ProductsServiceImpl productService;

    @Autowired
    public ProductsController(ProductsServiceImpl productService) {
        this.productService = productService;
    }

    @PostMapping
    public ResponseEntity<Product> registerProduct(@RequestBody ProductsDTO productDTO) {
        Product savedProduct = productService.registerProduct(productDTO);
        return new ResponseEntity<>(savedProduct, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts() {
        List<Product> products = productService.getAllProducts();
        return new ResponseEntity<>(products, HttpStatus.OK);
    }
}
