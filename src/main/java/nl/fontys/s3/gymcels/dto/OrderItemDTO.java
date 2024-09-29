package nl.fontys.s3.gymcels.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class OrderItemDTO {
    private int customerID;
    private int supplementID;
    private int count;
    private double price;
}
