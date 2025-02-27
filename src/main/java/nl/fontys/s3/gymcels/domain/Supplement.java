package nl.fontys.s3.gymcels.domain;

import jakarta.persistence.*;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter @Setter
public class Supplement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String brand;
    private String name;
    private String description;
    private String supplementFacts;
    private int quantity;
    private double price;
    @Lob
    private byte[] picture;
}
