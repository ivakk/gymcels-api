package nl.fontys.s3.gymcels.business;

import nl.fontys.s3.gymcels.domain.Order;
import nl.fontys.s3.gymcels.domain.OrderItem;
import nl.fontys.s3.gymcels.dto.OrderItemDTO;
import nl.fontys.s3.gymcels.dto.ShoppingCartDTO;

public interface OrderService {
    boolean createOrder(ShoppingCartDTO order);
    boolean acceptOrder(int orderId, int fulfillerID);
    boolean approveOrder(int orderId, int fulfillerID);
    boolean completeOrder(int orderId, int fulfillerID);
    boolean cancelOrder(int orderId);
    boolean rejectOrder(int orderId, int rejectorID);
    Order getOrderByID(int orderId);
    OrderItemDTO convertOrderItemToDTO(OrderItem orderItem);
    OrderItem convertDTOToOrderItem(OrderItemDTO orderItem);
}
