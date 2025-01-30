package org.trave.travel_destination;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Travel Destination API", version = "1.0", description = "Travel Destination Information", 
					contact = @Contact(name = "Harshith N J", email = "Harshith.dev2024@outlook.com")))
public class TravelDestinationApplication {

	public static void main(String[] args) {
		SpringApplication.run(TravelDestinationApplication.class, args);
	}

}
