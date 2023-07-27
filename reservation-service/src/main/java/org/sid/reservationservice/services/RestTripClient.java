package org.sid.reservationservice.services;

import org.sid.reservationservice.model.Trip;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "TRIP-SERVICE")
public interface RestTripClient {

    @GetMapping(path = "/trips/{id}")
    Trip getTrip(@PathVariable Long id);
}
