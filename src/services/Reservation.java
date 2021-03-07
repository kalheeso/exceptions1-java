package services;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import exceptions.DomainExceptions;

public class Reservation {

	private Integer roomNumber;
	private Date checkIn;
	private Date checkOut;
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	public Reservation() {
	}

	public Reservation(Integer roomNumber, Date checkIn, Date checkOut) throws DomainExceptions {
		if (checkOut.before(checkIn)) {
			throw new DomainExceptions ("Check-out date must be after check-in date");
		}
		this.roomNumber = roomNumber;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}

	public Integer getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(Integer roomNumber) {
		this.roomNumber = roomNumber;
	}

	public Date getCheckIn() {
		return checkIn;
	}
	
	public Date getCheckOut() {
		return checkOut;
	}

	public long duration() {
		long diff = getCheckOut().getTime() - getCheckIn().getTime();
		return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
	}
	
	public void updateDates(Date checkOut, Date checkIn) throws DomainExceptions {
		Date now = new Date();
		if (checkOut.before(now) || checkIn.before(now)) {
			throw new DomainExceptions ("Reservation dates for update must be future dates");
			// exceção quando os argumentos passados não são válidos.
		}
		if (checkOut.before(checkIn)) {
			throw new DomainExceptions ("Check-out date must be after check-in date");
		}
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}
	
	public String toString() {
		return "Room "
			   + roomNumber
			   + ", check-in: "
			   + sdf.format(checkIn) 
			   + ", check-out: "
			   + sdf.format(checkOut)
			   + ". Duration: "
			   + duration()
			   + " nights.";
	}
}
