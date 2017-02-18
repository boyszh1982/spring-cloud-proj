package org.test;

import java.util.Arrays;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@SpringBootApplication
public class DemoApplication {

	@Bean
	CommandLineRunner runner(ReservationRepository rr) {
		return args -> {
			Arrays.asList("Dr. Rod, Dr. Syer,Juergen,ALL THE COMMUNITY,Josh".split(","))
				.forEach( x -> rr.save(new Reservation(x)) );
			rr.findAll().forEach(System.out::println);
		} ;
		
	}
	
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
}

@RefreshScope
@RestController
class MessageRestController {
	
	@Value("${message}")
	private String message ;
	
	@RequestMapping("/message")
	String message(){
		return this.message;
	}
	
}

@RepositoryRestResource
interface ReservationRepository extends JpaRepository<Reservation, Long> {
	@RestResource(path="by-name")
	Collection<Reservation> findByReservationName(@Param("rn") String rn);
}

@Entity
class Reservation {
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getReservationName() {
		return reservationName;
	}
	public void setReservationName(String reservationName) {
		this.reservationName = reservationName;
	}
	@Id
	@GeneratedValue
	private Long id;
	private String reservationName ;
	
	public Reservation() {
		// TODO Auto-generated constructor stub
	}
	
	public Reservation(String reservationName) {
		this.reservationName = reservationName;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}
}