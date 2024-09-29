package nl.fontys.s3.gymcels.domain;

import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter @ToString
public class OrderItem {
    private int customerID;
    private int supplementID;
    private int count;
    private double price;
}
