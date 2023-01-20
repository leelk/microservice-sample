package me.leel.inventoryservice.service;

import lombok.RequiredArgsConstructor;
import me.leel.inventoryservice.repository.InventoryRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class InventoryService {

    private final InventoryRepository inventoryRepository;

    @Transactional(readOnly = true)
    public boolean isinStock(String skuCode) {
        return inventoryRepository.findBySkuCode(skuCode).isPresent();
    }

}
