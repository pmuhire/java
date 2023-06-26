package com.example.selling.controllers;
import com.example.selling.serviceImpls.PurchasedServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.selling.dtos.PurchasedDTO;

@RestController
@RequestMapping("/api/purchased")
public class PurchasedController {

    private final PurchasedServiceImpl purchasedService;

    @Autowired
    public PurchasedController(PurchasedServiceImpl purchasedService) {
        this.purchasedService = purchasedService;
    }

    @PostMapping
    public ResponseEntity<PurchasedDTO> registerPurchased(@RequestBody PurchasedDTO purchasedDTO) {
        PurchasedDTO savedPurchased = purchasedService.registerPurchased(purchasedDTO);
        return new ResponseEntity<>(savedPurchased, HttpStatus.CREATED);
    }

    // Implement other methods for retrieving, updating, and deleting Purchased entities
}
