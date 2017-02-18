package org.test.vo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Reservation {
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