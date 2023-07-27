package org.sid.reservationservice.web;

import com.netflix.discovery.converters.Auto;
import org.sid.reservationservice.entities.Reservation;
import org.sid.reservationservice.repositories.ReservationRepository;
import org.sid.reservationservice.services.RestTripClient;
import org.sid.reservationservice.services.RestUserClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ReservationController {

    @Autowired
    RestUserClient restUserClient ;
    @Autowired
    RestTripClient restTripClient ;
    @Autowired
    ReservationRepository reservationRepository ;

    @GetMapping(path = "/full-reservation/{id}")
    Reservation getReservation(@PathVariable Long id){

        Reservation reservation = reservationRepository.findById(id).get();
        reservation.setTrip(restTripClient.getTrip(reservation.getTripId()));
        reservation.setUser(restUserClient.getUser(reservation.getUserId()));

        return reservation ;

    }
}
