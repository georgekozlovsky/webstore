package de.webalpha.webstore.inventory.service;

import de.webalpha.webstore.inventory.persistence.InventoryRepository;
import de.webalpha.webstore.inventory.persistence.Product;
import org.springframework.stereotype.Service;

/**
 * Service for inventory manipulations.
 */
@Service
public class InventoryService {
    private final InventoryRepository inventory;

    public InventoryService(InventoryRepository inventory) {
        this.inventory = inventory;
    }

    public Product findProduct(String id) {
        return inventory.findOne(id);
    }

    public void addProductToInventory(Product product) {
        inventory.save(product);
    }

    public void removeProductFromInventory(Product product) {
        inventory.delete(product);
    }
}
