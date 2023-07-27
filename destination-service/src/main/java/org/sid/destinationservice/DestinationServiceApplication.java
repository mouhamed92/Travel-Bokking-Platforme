package org.sid.destinationservice;

import org.sid.destinationservice.entities.Destination;
import org.sid.destinationservice.repositories.DestinationRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

import java.util.List;

@SpringBootApplication
public class DestinationServiceApplication {

	public static void main(String[] args) {

		SpringApplication.run(DestinationServiceApplication.class, args);
	}

	@Bean
	public CommandLineRunner start(DestinationRepository destinationRepository,
								   RepositoryRestConfiguration repositoryRestConfiguration){

		return args -> {
			repositoryRestConfiguration.exposeIdsFor(Destination.class);
			destinationRepository.saveAll(
					List.of(
							Destination.builder().country("Espain").city("Malaga").build(),
							Destination.builder().country("Grece").city("Santorini").build(),
							Destination.builder().country("Italia").city("Roma").build()
					)
			);

			destinationRepository.findAll().forEach(destination -> {
				System.out.println(destination);
			});
		};
	}
}
