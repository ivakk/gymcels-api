package nl.fontys.s3.gymcels.business;

import nl.fontys.s3.gymcels.dto.OrderItemDTO;

public interface ShoppingCartService {
    boolean addItem(OrderItemDTO orderItem);
    boolean removeItem(OrderItemDTO orderItem);
    boolean updateItemQuantity(OrderItemDTO orderItem, int quantity);
    double calculateTotalPrice();
}
