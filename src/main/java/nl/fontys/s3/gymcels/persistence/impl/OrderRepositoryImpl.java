package nl.fontys.s3.gymcels.persistence.impl;

import nl.fontys.s3.gymcels.domain.Order;
import nl.fontys.s3.gymcels.domain.OrderItem;
import nl.fontys.s3.gymcels.dto.OrderItemDTO;
import nl.fontys.s3.gymcels.persistence.OrderRepository;
import org.springframework.stereotype.Repository;

@Repository
public class OrderRepositoryImpl implements OrderRepository {
    @Override
    public boolean createOrderRepo(Order order) {
        return false;
    }

    @Override
    public boolean updateOrderRepo(Order order) {
        return false;
    }

    @Override
    public boolean cancelOrderRepo(int orderId) {
        return false;
    }

    @Override
    public Order getOrderByIDRepo(int orderId) {
        return null;
    }
}
