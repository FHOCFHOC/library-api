package com.corinto.libraryapi;

import com.corinto.libraryapi.service.EmailService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
@EnableScheduling
public class LibraryApiApplication {

/*	@Autowired
	private EmailService emailService;*/

	@Bean
	public ModelMapper modelMapper(){
		return new ModelMapper();
	}

/*	@Bean
	public CommandLineRunner runner(){
		return args -> {
			List<String> emails = Arrays.asList("5b53ae6430-e06610@inbox.mailtrap.io");
			emailService.sendMail("Testando serviço de emails.", emails);
			System.out.println("EMAILS ENVIADOS");
		};
	}*/

	public static void main(String[] args) {
		SpringApplication.run(LibraryApiApplication.class, args);
	}

}
