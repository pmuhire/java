package com.example.selling.services;
import com.example.selling.dtos.PurchasedDTO;
import com.example.selling.models.Purchased;

public interface IPurchasedService {
    PurchasedDTO registerPurchased(PurchasedDTO purchasedDTO);

    Purchased save(Purchased purchased);
    // Other methods for retrieving, updating, and deleting Purchased entities
}

