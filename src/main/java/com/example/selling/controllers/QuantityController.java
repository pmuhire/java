package com.example.selling.controllers;

import com.example.selling.dtos.QuantityDTO;
import com.example.selling.serviceImpls.QuantityServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/quantities")
public class QuantityController {

    private final QuantityServiceImpl quantityService;

    @Autowired
    public QuantityController(QuantityServiceImpl quantityService) {
        this.quantityService = quantityService;
    }

    @PostMapping
    public ResponseEntity<QuantityDTO> registerQuantity(@RequestBody QuantityDTO quantityDTO) {
        QuantityDTO savedQuantity = quantityService.registerQuantity(quantityDTO);
        return new ResponseEntity<>(savedQuantity, HttpStatus.CREATED);
    }
}

