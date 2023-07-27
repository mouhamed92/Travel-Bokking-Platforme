package org.sid.tripservice.repositories;

import org.sid.tripservice.entities.Trip;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

@RepositoryRestResource
public interface TripRepository extends JpaRepository<Trip,Long> {
}
