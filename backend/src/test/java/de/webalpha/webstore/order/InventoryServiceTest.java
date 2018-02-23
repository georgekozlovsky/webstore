package de.webalpha.webstore.order;

import de.webalpha.webstore.inventory.persistence.InventoryRepository;
import de.webalpha.webstore.inventory.persistence.Product;
import de.webalpha.webstore.inventory.service.InventoryService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class InventoryServiceTest {

    @Mock
    private InventoryRepository inventoryRepository;

    @InjectMocks
    private InventoryService testee;

    @Test
    public void findProduct() {
        Product productMock = new Product("product-ean", "name", "description", BigDecimal.valueOf(99.99));
        when(inventoryRepository.findOne("product-ean")).thenReturn(productMock);

        Product product = testee.findProduct("product-ean");
        assertThat(product.getId()).isEqualTo("product-ean");
    }

    @Test
    public void addProductToInventory() {
        Product product = mock(Product.class);
        testee.addProductToInventory(product);
        verify(inventoryRepository).save(product);
    }

    @Test
    public void removeProductFromInventory() {
        Product product = mock(Product.class);
        testee.removeProductFromInventory(product);
        verify(inventoryRepository).delete(product);
    }
}
