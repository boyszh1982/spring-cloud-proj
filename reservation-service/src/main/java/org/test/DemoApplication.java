package org.test;

import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.test.dao.ReservationRepository;
import org.test.vo.Reservation;

@SpringBootApplication
public class DemoApplication {

	@Bean
	CommandLineRunner runner(ReservationRepository rr) {
		return args -> {
			Arrays.asList("Dr. Rod, Dr. Syer,Juergen,ALL THE COMMUNITY,Josh".split(","))
				.forEach( x -> rr.save(new Reservation(x)) );
			rr.findAll().forEach(System.out::println);
		} ;
		/*	
		 * branch master is all of spring-cloud
		 * next step branch spring-cloud-step1-simple
		 * next step branch spring-cloud-step2-security-config
		 * next step branch spring-cloud-step3-eureka
		 */
	}
	
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
}

