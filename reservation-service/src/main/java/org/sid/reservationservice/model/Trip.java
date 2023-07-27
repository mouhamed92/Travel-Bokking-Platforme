package org.sid.reservationservice.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Data
public class Trip {

    private Long id ;
    private Destination destination ;
    private Long destinationId ;
    private int duration ;
    private List<LocalDate> dates ;
    private double price ;
}
