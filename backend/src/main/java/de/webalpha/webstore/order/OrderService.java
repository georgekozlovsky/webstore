package de.webalpha.webstore.order;

import de.webalpha.webstore.order.core.Order;
import de.webalpha.webstore.order.core.OrderRepository;
import de.webalpha.webstore.order.core.OrderStatus;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.UUID;

@Service
@Validated
public class OrderService {
    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public Order findOrder(UUID orderId) {
        return orderRepository.findOne(orderId);
    }

    public UUID placeNewOrder(Order order) {
        Order savedOrder = orderRepository.save(order);
        return savedOrder.getId();
    }

    public void cancelOrder(UUID orderId) {
        Order order = orderRepository.findOne(orderId);
        order.setOrderStatus(OrderStatus.CANCELED);
        orderRepository.save(order);
    }
}
