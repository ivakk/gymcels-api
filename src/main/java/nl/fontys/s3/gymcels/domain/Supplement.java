package nl.fontys.s3.gymcels.domain;

import jakarta.persistence.Entity;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter @Setter
public class Supplement {
    private int id;
    private String brand;
    private String name;
    private String description;
    private String supplementFacts;
    private int quantity;
    private double price;
}
