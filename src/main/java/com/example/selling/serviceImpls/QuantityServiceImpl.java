package com.example.selling.serviceImpls;

import com.example.selling.dtos.QuantityDTO;
import com.example.selling.models.Product;
import com.example.selling.models.Quantity;
import com.example.selling.repositories.IProductsRepository;
import com.example.selling.repositories.IQuantityRepository;
import com.example.selling.services.IQuantityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class QuantityServiceImpl implements IQuantityService {

    private final IQuantityRepository quantityRepository;
    private final IProductsRepository productRepository;

    @Autowired
    public QuantityServiceImpl(IQuantityRepository quantityRepository, IProductsRepository productRepository) {
        this.quantityRepository = quantityRepository;
        this.productRepository = productRepository;
    }

    @Override
    public QuantityDTO registerQuantity(QuantityDTO quantityDTO) {
        Quantity quantity = new Quantity();
        quantity.setQuantity(quantityDTO.getQuantity());
        quantity.setOperation(quantityDTO.getOperation());
        quantity.setDate(quantityDTO.getDate());

        // Retrieve the Product entity based on productCode
        Product product = productRepository.findByCode(quantityDTO.getProductCode())
                .orElseThrow(() -> new IllegalArgumentException("Invalid product code"));

        // Set the Product entity in the Quantity entity
        quantity.setProduct(product);

        Quantity savedQuantity = quantityRepository.save(quantity);
        return mapQuantityToDTO(savedQuantity);
    }

    private QuantityDTO mapQuantityToDTO(Quantity quantity) {
        QuantityDTO quantityDTO = new QuantityDTO();
        quantityDTO.setId(quantity.getId());
        quantityDTO.setProductCode(quantity.getProduct().getCode());
        quantityDTO.setQuantity(quantity.getQuantity());
        quantityDTO.setOperation(quantity.getOperation());
        quantityDTO.setDate(quantity.getDate());

        return quantityDTO;
    }
}

