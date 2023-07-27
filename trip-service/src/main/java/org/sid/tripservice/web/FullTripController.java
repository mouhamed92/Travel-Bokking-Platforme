package org.sid.tripservice.web;

import org.sid.tripservice.entities.Trip;
import org.sid.tripservice.repositories.TripRepository;
import org.sid.tripservice.services.DestinationRestCient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FullTripController {

    @Autowired
    private TripRepository tripRepository ;
    @Autowired
    private DestinationRestCient destinationRestCient ;

    @GetMapping(path = "/full-trip/{id}")
    Trip getTrip(@PathVariable Long id){
       Trip  trip = tripRepository.findById(id).get() ;
       trip.setDestination(destinationRestCient.findDestinationById(trip.getDestinationId()));
        return trip ;
    }
}
