package nl.fontys.s3.gymcels.domain;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Entity
@NoArgsConstructor
@Getter @Setter
@SuperBuilder
public class Trainer extends Member{
    private String bsn;
    private Workout[] workouts;
}
