package org.sid.destinationservice.repositories;

import org.sid.destinationservice.entities.Destination;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

@RepositoryRestResource
public interface DestinationRepository extends JpaRepository<Destination,Long> {
}
