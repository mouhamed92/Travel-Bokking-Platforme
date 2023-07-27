package org.sid.reservationservice.services;

import org.sid.reservationservice.model.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "USER-SERVICE")
public interface RestUserClient {

    @GetMapping(path = "/users/{id}")
    User getUser(@PathVariable Long id);
}
