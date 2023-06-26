package com.example.selling.serviceImpls;

import com.example.selling.dtos.ProductsDTO;
import com.example.selling.models.Product;
import com.example.selling.repositories.IProductsRepository;
import com.example.selling.services.IProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductsServiceImpl  implements IProductsService {
    private final IProductsRepository productRepository;

    @Autowired
    public ProductsServiceImpl(IProductsRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Product registerProduct(ProductsDTO productDTO) {
        Product product = new Product();
        product.setCode(productDTO.getCode());
        product.setName(productDTO.getName());
        product.setProductType(productDTO.getProductType());
        product.setPrice(productDTO.getPrice());
        product.setInDate(productDTO.getInDate());
        product.setImage(productDTO.getImage());

        Product savedProduct = productRepository.save(product);
        return savedProduct;
    }

    @Override
    public List<Product> getAllProducts() {
        List<Product> products = productRepository.findAll();
        return products;
    }
}
