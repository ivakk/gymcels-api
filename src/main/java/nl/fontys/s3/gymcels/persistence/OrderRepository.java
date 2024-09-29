package nl.fontys.s3.gymcels.persistence;

import nl.fontys.s3.gymcels.domain.Order;

public interface OrderRepository {
    boolean createOrderRepo(Order order);
    boolean updateOrderRepo(Order order);
    boolean cancelOrderRepo(int orderId);
    Order getOrderByIDRepo(int orderId);
}
