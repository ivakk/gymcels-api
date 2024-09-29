package nl.fontys.s3.gymcels.business.impl;

import nl.fontys.s3.gymcels.business.OrderService;
import nl.fontys.s3.gymcels.domain.OrderItem;
import nl.fontys.s3.gymcels.dto.OrderItemDTO;
import nl.fontys.s3.gymcels.persistence.OrderRepository;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;

    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }
    @Override
    public boolean createOrder(OrderItemDTO order) {
        if (order == null){
            throw new IllegalArgumentException("order is null");
        }
        else{
            return orderRepository.createOrderRepo(convertDTOToOrderItem(order));
        }
    }

    @Override
    public boolean acceptOrder(int orderId, int fulfillerID) {
        return false;
    }

    @Override
    public boolean approveOrder(int orderId, int fulfillerID) {
        return false;
    }

    @Override
    public boolean completeOrder(int orderId, int fulfillerID) {
        return false;
    }

    @Override
    public boolean cancelOrder(int orderId) {
        if (orderId <= 0){
            throw new IllegalArgumentException("orderId must be a positive integer");
        }
        else{
            return orderRepository.cancelOrderRepo(orderId);
        }
    }

    @Override
    public boolean rejectOrder(int orderId, int rejectorID) {
        return false;
    }

    @Override
    public OrderItem getOrderByID(int orderId) {
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
