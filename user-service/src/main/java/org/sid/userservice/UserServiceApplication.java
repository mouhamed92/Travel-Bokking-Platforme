package org.sid.userservice;

import org.sid.userservice.entities.User;
import org.sid.userservice.repositories.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

import java.util.List;

@SpringBootApplication
public class UserServiceApplication {

	public static void main(String[] args) {

		SpringApplication.run(UserServiceApplication.class, args);
	}

	@Bean
	public CommandLineRunner start(UserRepository userRepository,
								   RepositoryRestConfiguration repositoryRestConfiguration){

		return args -> {
			repositoryRestConfiguration.exposeIdsFor(User.class);

			userRepository.saveAll(
					List.of(
							User.builder().username("Mohamed").email("mohamed@gmail.com").password("1234").build(),
							User.builder().username("Salah").email("salah@gmail.com").password("7895").build(),
							User.builder().username("Ali").email("Ali@gmail.com").password("1459").build()
					)
			);
			   userRepository.findAll().forEach(user->{
				   System.out.println(user);
			   });
		};
	}

}
