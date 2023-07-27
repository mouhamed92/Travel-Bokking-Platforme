package org.sid.reservationservice.services;

import org.sid.reservationservice.model.Destination;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "DESTINATION-SERVICE")
public interface RestDestinationClient {

    @GetMapping(path = "/destinations/{id}")
    Destination getDestination(@PathVariable Long id);
}
