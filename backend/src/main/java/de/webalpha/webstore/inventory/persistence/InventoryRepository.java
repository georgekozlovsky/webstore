package de.webalpha.webstore.inventory.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

public interface InventoryRepository extends JpaRepository<Product, String> {
}
