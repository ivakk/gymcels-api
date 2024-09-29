package nl.fontys.s3.gymcels.domain;

import jakarta.persistence.*;
import lombok.*;
import nl.fontys.s3.gymcels.enums.OrderStatus;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter @ToString
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int customerId;

    private LocalDateTime orderDate;
    private double totalPrice;

    @Enumerated
    private OrderStatus status;

    @ElementCollection
    private List<OrderItem> items;
}
