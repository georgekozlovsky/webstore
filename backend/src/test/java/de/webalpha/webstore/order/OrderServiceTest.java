package de.webalpha.webstore.order;

import de.webalpha.webstore.order.core.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class OrderServiceTest {

  @Mock
  private OrderRepository orderRepository;

  @Captor
  private ArgumentCaptor<Order> orderCaptor;

  @InjectMocks
  private OrderService testee;

  @Test
  public void findOrder() {
    UUID orderId = UUID.randomUUID();
    Order order = createOrder(orderId);
    when(orderRepository.findOne(orderId)).thenReturn(order);

    Order testeeOrder = testee.findOrder(orderId);

    assertThat(testeeOrder.getId()).isEqualTo(orderId);
  }

  private Order createOrder(UUID orderId) {
    return new Order(orderId, new ArrayList<Item>(), "promotionCode", "buyerId", mock(Address.class), mock(Address.class), mock(PaymentMethod.class));
  }

  @Test
  public void placeNewOrder() {
    Address shippingAdress = new Address("street", "zip", "place", "country");
    Order order = new Order(UUID.randomUUID(), new ArrayList<Item>(), "promotionCode", "buyerId", shippingAdress, shippingAdress, new Sepa("iban", "bic"));
    when(orderRepository.save(order)).thenReturn(order);

    testee.placeNewOrder(order);
    verify(orderRepository).save(order);
  }

  @Test
  public void cancelOrder() {
    UUID orderId = UUID.randomUUID();
    Order order = createOrder(orderId);
    when(orderRepository.findOne(orderId)).thenReturn(order);
    testee.cancelOrder(orderId);

    verify(orderRepository).save(orderCaptor.capture());
    Order captorValue = orderCaptor.getValue();
    assertThat(captorValue.getId()).isEqualTo(orderId);
    assertThat(captorValue.getOrderStatus()).isEqualTo(OrderStatus.CANCELED);
  }
}