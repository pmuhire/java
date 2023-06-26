package com.example.selling.serviceImpls;

import com.example.selling.dtos.QuantityDTO;
import com.example.selling.models.Quantity;
import com.example.selling.repositories.IQuantityRepository;
import com.example.selling.services.IQuantityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class QuantityServiceImpl implements IQuantityService {

    private final IQuantityRepository quantityRepository;

    @Autowired
    public QuantityServiceImpl(IQuantityRepository quantityRepository) {
        this.quantityRepository = quantityRepository;
    }

    @Override
    public QuantityDTO registerQuantity(QuantityDTO quantityDTO) {
        Quantity quantity = new Quantity();
        quantity.setProductCode(quantityDTO.getProductCode());
        quantity.setQuantity(quantityDTO.getQuantity());
        quantity.setOperation(quantityDTO.getOperation());
        quantity.setDate(quantityDTO.getDate());

        Quantity savedQuantity = quantityRepository.save(quantity);
        return mapQuantityToDTO(savedQuantity);
    }

    @Override
    public List<QuantityDTO> getAllQuantities() {
        List<Quantity> quantities = quantityRepository.findAll();
        return quantities.stream()
                .map(this::mapQuantityToDTO)
                .collect(Collectors.toList());
    }

    private QuantityDTO mapQuantityToDTO(Quantity quantity) {
        QuantityDTO quantityDTO = new QuantityDTO();
        quantityDTO.setId(quantity.getId());
        quantityDTO.setProductCode(quantity.getProductCode());
        quantityDTO.setQuantity(quantity.getQuantity());
        quantityDTO.setOperation(quantity.getOperation());
        quantityDTO.setDate(quantity.getDate());

        return quantityDTO;
    }
}

