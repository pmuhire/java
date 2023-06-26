package com.example.selling.services;
import com.example.selling.dtos.ProductsDTO;
import com.example.selling.models.Product;

import java.util.List;

public interface IProductsService {
    Product registerProduct(ProductsDTO product);

    List<Product> getAllProducts();
}
