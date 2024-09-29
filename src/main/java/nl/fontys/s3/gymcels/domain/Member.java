package nl.fontys.s3.gymcels.domain;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter @Setter
@SuperBuilder
public class Member{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String address;
    @Lob
    private byte[] profilePicture;
    private boolean active;
}
