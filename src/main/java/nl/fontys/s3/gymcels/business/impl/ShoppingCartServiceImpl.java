package nl.fontys.s3.gymcels.business.impl;

import nl.fontys.s3.gymcels.business.ShoppingCartService;
import nl.fontys.s3.gymcels.dto.OrderItemDTO;
import nl.fontys.s3.gymcels.dto.ShoppingCartDTO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ShoppingCartServiceImpl implements ShoppingCartService {
    private ShoppingCartDTO shoppingCart = new ShoppingCartDTO();

    @Override
    public boolean addItem(OrderItemDTO orderItem) {
        if (orderItem == null) {
            throw new NullPointerException("orderItem is null");
        }
        else{
            // Initialize the list if it is null
            if (shoppingCart.getItems() == null) {
                shoppingCart.setItems(new ArrayList<>());
            }

            // Add the item to the list
            shoppingCart.getItems().add(orderItem);
            return true;
        }
    }

    @Override
    public boolean removeItem(OrderItemDTO orderItem) {
        if (shoppingCart.getItems() != null && shoppingCart.getItems().contains(orderItem)) {
            shoppingCart.getItems().remove(orderItem);
            return true;
        }
        return false;
    }

    @Override
    public boolean updateItemQuantity(OrderItemDTO orderItem, int quantity) {
        if (shoppingCart.getItems() != null) {
            for (OrderItemDTO item : shoppingCart.getItems()) {
                if (item.equals(orderItem)) {
                    item.setCount(quantity);
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public double calculateTotalPrice() {
        double totalPrice = 0;
        if (shoppingCart.getItems() != null) {
            for (OrderItemDTO item : shoppingCart.getItems()) {
                totalPrice += item.getCount() * item.getPrice();
            }
        }
        return totalPrice;
    }

    @Override
    public void clearCart() {
        shoppingCart.getItems().clear();
    }
}
