package nl.fontys.s3.gymcels.domain;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
public class Workout {
    private int id;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
}
