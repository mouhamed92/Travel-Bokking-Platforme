package org.sid.tripservice.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.sid.tripservice.model.Destination;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor @Builder
public class Trip {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;
    @Transient
    private Destination destination ;
    private Long destinationId ;
    private int duration ;
    @ElementCollection
    @CollectionTable(name = "reservation_dates", joinColumns = @JoinColumn(name = "trip_id"))
    @Column(name = "available_date")
    private List<LocalDate> dates ;
    private double price ;
}
