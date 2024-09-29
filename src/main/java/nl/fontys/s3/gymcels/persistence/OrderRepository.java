package nl.fontys.s3.gymcels.persistence;

import nl.fontys.s3.gymcels.domain.OrderItem;
import nl.fontys.s3.gymcels.dto.OrderItemDTO;

public interface OrderRepository {
    boolean createOrderRepo(OrderItem order);
    boolean cancelOrderRepo(int orderId);
    OrderItem getOrderByIDRepo(int orderId);
}
