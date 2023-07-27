package org.sid.tripservice;

import org.sid.tripservice.entities.Trip;
import org.sid.tripservice.model.Destination;
import org.sid.tripservice.repositories.TripRepository;
import org.sid.tripservice.services.DestinationRestCient;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@EnableFeignClients
public class TripServiceApplication {

	public static void main(String[] args) {

		SpringApplication.run(TripServiceApplication.class, args);


	}

	@Bean
	public CommandLineRunner start(TripRepository tripRepository,
								  DestinationRestCient destinationRestCient,
								   RepositoryRestConfiguration repositoryRestConfiguration){

		List<LocalDate> dates = new ArrayList<>();
		dates.add(LocalDate.of(2023, 7, 31));
		dates.add(LocalDate.of(2023, 8, 5));
		dates.add(LocalDate.of(2023, 8, 12));

		return args -> {
			repositoryRestConfiguration.exposeIdsFor(Trip.class);
			Trip trip = new Trip();
			Long destinationId = 1L ;
			Destination destination = destinationRestCient.findDestinationById(destinationId);
			if(destination==null) throw new RuntimeException("destination not found");
			System.out.println(destination);
			trip.setDestinationId(destination.getId());
			trip.setDestination(destination);
			trip.setPrice(2500);
			trip.setDates(dates);
			trip.setDuration(7);

			tripRepository.save(trip);

		};

	}
}
