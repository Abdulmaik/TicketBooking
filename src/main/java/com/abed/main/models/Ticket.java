package com.abed.main.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;


@Entity
@Table (name="ticket_info")
public class Ticket {
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.AUTO)
	
	int id ;
	@Size(max = 11)
	@Pattern(regexp = "^[a-zA-Z]+$")
	@Column(name="Passenger_name")
	String passengerName ;
	@Column(name="Source_station")
	String source ; 
	@Column(name="Dest_station")
	String dest;
	@DateTimeFormat(pattern ="dd-MM-yyyy")
	@Column(name="Booking_date")
	Date bookDate;
	public Ticket(int id, String passangerName, String source, String dest, Date bookDate) {
		super();
		this.id = id;
		this.source = source;
		this.dest = dest;
		this.bookDate = bookDate;
	}
	public Ticket() {
		super();
	}
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return the passangerName
	 */
	
	/**
	 * @return the source
	 */
	public String getSource() {
		return source;
	}
	/**
	 * @param source the source to set
	 */
	
	
	/**
	 * @return the passengerName
	 */
	public String getPassengerName() {
		return passengerName;
	}
	/**
	 * @param passengerName the passengerName to set
	 */
	public void setPassengerName(String passengerName) {
		this.passengerName = passengerName;
	}
	
	
	public void setSource(String source) {
		this.source = source;
	}
	/**
	 * @return the dest
	 */
	public String getDest() {
		return dest;
	}
	/**
	 * @param dest the dest to set
	 */
	public void setDest(String dest) {
		this.dest = dest;
	}
	/**
	 * @return the bookDate
	 */
	public Date getBookDate() {
		return bookDate;
	}
	/**
	 * @param bookDate the bookDate to set
	 */
	public void setBookDate(Date bookDate) {
		this.bookDate = bookDate;
	} 

	

}
