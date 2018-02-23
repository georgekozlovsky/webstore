package de.webalpha.webstore.inventory.service;

import de.webalpha.webstore.inventory.persistence.InventoryRepository;
import de.webalpha.webstore.inventory.persistence.Product;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/products")
public class InventoryResource {

  private InventoryRepository repository;

  public InventoryResource(InventoryRepository repository) {
    this.repository = repository;
  }

  @GetMapping
  public List<Product> findAll() {
    return repository.findAll();
  }
}
