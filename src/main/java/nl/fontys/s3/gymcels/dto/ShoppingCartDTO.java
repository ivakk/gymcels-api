package nl.fontys.s3.gymcels.dto;

import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
public class ShoppingCartDTO {
    private int customerId;
    private List<OrderItemDTO> items;
    private double totalPrice;
}
