package org.sid.reservationservice;

import org.sid.reservationservice.entities.Reservation;
import org.sid.reservationservice.repositories.ReservationRepository;
import org.sid.reservationservice.services.RestTripClient;
import org.sid.reservationservice.services.RestUserClient;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

@SpringBootApplication
@EnableFeignClients
public class ReservationServiceApplication {

	public static void main(String[] args) {

		SpringApplication.run(ReservationServiceApplication.class, args);
	}

	@Bean
	public CommandLineRunner start(ReservationRepository reservationRepository,
								   RestUserClient restUserClient,
								   RestTripClient restTripClient,
								   RepositoryRestConfiguration repositoryRestConfiguration){

		Long userId = 1L ;
		Long tripId = 1L ;

		return args -> {
			repositoryRestConfiguration.exposeIdsFor(Reservation.class) ;

			Reservation reservation = new Reservation() ;
			reservation.setUserId(userId);
			reservation.setTripId(tripId);
			reservation.setTrip(restTripClient.getTrip(tripId));
			reservation.setUser(restUserClient.getUser(userId));
			reservation.setParticipant(2);
			reservation.setStartDate(restTripClient.getTrip(tripId).getDates().get(1));
			reservation.setEndDate(reservation.getStartDate().plusDays(restTripClient.getTrip(tripId).getDuration()));
			reservationRepository.save(reservation);



		};
	}
}
