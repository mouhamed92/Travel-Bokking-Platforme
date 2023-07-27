package org.sid.reservationservice.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.sid.reservationservice.model.Trip;
import org.sid.reservationservice.model.User;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor @Builder
public class Reservation {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;
    private Long userId ;
    @Transient
    private User user ;
    private Long tripId;
    @Transient
    private Trip trip ;
    private LocalDate startDate ;
    private LocalDate endDate ;
    private int participant ;
}
