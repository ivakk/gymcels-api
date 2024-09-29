package nl.fontys.s3.gymcels.business.impl;

import nl.fontys.s3.gymcels.business.OrderService;
import nl.fontys.s3.gymcels.domain.Order;
import nl.fontys.s3.gymcels.domain.OrderItem;
import nl.fontys.s3.gymcels.dto.OrderItemDTO;
import nl.fontys.s3.gymcels.dto.ShoppingCartDTO;
import nl.fontys.s3.gymcels.enums.OrderStatus;
import nl.fontys.s3.gymcels.persistence.OrderRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;

    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }
    @Override
    public boolean createOrder(ShoppingCartDTO cart) {
        if (cart == null){
            throw new IllegalArgumentException("order is null");
        }
        else{
            Order newOrder = new Order();
            newOrder.setCustomerId(cart.getCustomerId());
            newOrder.setOrderDate(LocalDateTime.now());
            newOrder.setStatus(OrderStatus.PENDING);
            List<OrderItem> orderItems = cart.getItems().stream()
                    .map(item -> new OrderItem(
                            item.getCustomerID(),
                            item.getSupplementID(),
                            item.getCount(),
                            item.getPrice()
                    ))
                    .collect(Collectors.toCollection(ArrayList::new));

            newOrder.setItems(orderItems);
            newOrder.setTotalPrice(cart.getItems().stream()
                    .mapToDouble(item -> item.getCount() * item.getPrice())
                    .sum());

            return orderRepository.createOrderRepo(newOrder);
        }
    }

    @Override
    public boolean acceptOrder(int orderId, int fulfillerID) {
        if (orderId <= 0  || fulfillerID <= 0){
            throw new IllegalArgumentException("orderId or fulfillerID is null");
        }
        else {
            Order order = orderRepository.getOrderByIDRepo(orderId);
            order.setStatus(OrderStatus.PROCESSED);

            return orderRepository.updateOrderRepo(order);
        }
    }

    @Override
    public boolean approveOrder(int orderId, int fulfillerID) {
        if (orderId <= 0  || fulfillerID <= 0){
            throw new IllegalArgumentException("orderId or fulfillerID is null");
        }
        else {
            Order order = orderRepository.getOrderByIDRepo(orderId);
            order.setStatus(OrderStatus.APPROVED);

            return orderRepository.updateOrderRepo(order);
        }
    }

    @Override
    public boolean completeOrder(int orderId, int fulfillerID) {
        if (orderId <= 0  || fulfillerID <= 0){
            throw new IllegalArgumentException("orderId or fulfillerID is null");
        }
        else {
            Order order = orderRepository.getOrderByIDRepo(orderId);
            order.setStatus(OrderStatus.COMPLETED);

            return orderRepository.updateOrderRepo(order);
        }
    }

    @Override
    public boolean cancelOrder(int orderId) {
        if (orderId <= 0){
            throw new IllegalArgumentException("orderId must be a positive integer");
        }
        else{
            Order order = orderRepository.getOrderByIDRepo(orderId);
            order.setStatus(OrderStatus.CANCELLED);
            return orderRepository.updateOrderRepo(order);
        }
    }

    @Override
    public boolean rejectOrder(int orderId, int rejectorID) {
        if (orderId <= 0){
            throw new IllegalArgumentException("orderId must be a positive integer");
        }
        else{
            Order order = orderRepository.getOrderByIDRepo(orderId);
            order.setStatus(OrderStatus.REJECTED);
            return orderRepository.updateOrderRepo(order);
        }
    }

    @Override
    public Order getOrderByID(int orderId) {
        return null;
    }

    @Override
    public OrderItemDTO convertOrderItemToDTO(OrderItem orderItem) {
        return new OrderItemDTO(
                orderItem.getCustomerID(),
                orderItem.getSupplementID(),
                orderItem.getCount(),
                orderItem.getPrice()
        );
    }

    @Override
    public OrderItem convertDTOToOrderItem(OrderItemDTO orderItem) {
        return new OrderItem(
                orderItem.getCustomerID(),
                orderItem.getSupplementID(),
                orderItem.getCount(),
                orderItem.getPrice()
        );
    }
}
