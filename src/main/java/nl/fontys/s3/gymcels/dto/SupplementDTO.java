package nl.fontys.s3.gymcels.dto;

import jakarta.persistence.*;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SupplementDTO {
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
