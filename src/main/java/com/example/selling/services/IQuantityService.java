package com.example.selling.services;
import com.example.selling.dtos.QuantityDTO;

import java.util.List;


public interface IQuantityService {
    QuantityDTO registerQuantity(QuantityDTO quantity);

    List<QuantityDTO> getAllQuantities();
}
