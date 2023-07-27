package org.sid.tripservice.services;

import org.sid.tripservice.model.Destination;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@FeignClient(name= "DESTINATION-SERVICE")
public interface DestinationRestCient {

       @GetMapping(path = "/destinations/{id}")
       Destination findDestinationById(@PathVariable Long id);

}
