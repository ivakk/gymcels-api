package nl.fontys.s3.gymcels.domain;

import jakarta.persistence.Entity;
import lombok.*;

import java.util.ArrayList;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
public class Member{
    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String address;
    private ArrayList<Byte> profilePicture;
}
