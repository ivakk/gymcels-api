package nl.fontys.s3.gymcels.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ShoppingCartDTO {
    private List<OrderItemDTO> items;
}
