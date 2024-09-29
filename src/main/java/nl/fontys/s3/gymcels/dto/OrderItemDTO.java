package nl.fontys.s3.gymcels.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
public class OrderItemDTO {
    private int customerID;
    private int supplementID;
    private int count;
    private double price;
}
