package com.example.selling.serviceImpls;


import com.example.selling.dtos.PurchasedDTO;
import com.example.selling.models.Product;
import com.example.selling.models.Purchased;
import com.example.selling.repositories.IProductsRepository;
import com.example.selling.repositories.IPurchasedRepository;
import com.example.selling.services.IPurchasedService;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class PurchasedServiceImpl implements IPurchasedService {

    private final IPurchasedRepository purchasedRepository;
    private final IProductsRepository productsRepository;

    @Autowired
    public PurchasedServiceImpl(IPurchasedRepository purchasedRepository, IProductsRepository productsRepository) {
        this.purchasedRepository = purchasedRepository;
        this.productsRepository = productsRepository;
    }

    @Override
    public PurchasedDTO registerPurchased(PurchasedDTO purchasedDTO) {
        Purchased purchased = new Purchased();

        // Retrieve the product based on the productCode from the repository
        Product product = productsRepository.findByCode(purchasedDTO.getProductCode())
                .orElseThrow(() -> new IllegalArgumentException("Invalid product code"));
        purchased.setProduct(product);
        purchased.setQuantity(purchasedDTO.getQuantity());
        purchased.setTotal(purchasedDTO.getTotal());
        purchased.setDate(purchasedDTO.getDate());

        Purchased savedPurchased = purchasedRepository.save(purchased);
        return mapPurchasedToDTO(savedPurchased);
    }

    @Override
    public Purchased save(Purchased purchased) {
        return null;
    }

    // Implement other methods for retrieving, updating, and deleting Purchased entities

    private PurchasedDTO mapPurchasedToDTO(Purchased purchased) {
        PurchasedDTO purchasedDTO = new PurchasedDTO();
        purchasedDTO.setId(purchased.getId());

        // Retrieve the product code from the associated Product entity
        purchasedDTO.setProductCode(purchased.getProduct().getCode());

        purchasedDTO.setQuantity(purchased.getQuantity());
        purchasedDTO.setTotal(purchased.getTotal());
        purchasedDTO.setDate(purchased.getDate());

        return purchasedDTO;
    }

}