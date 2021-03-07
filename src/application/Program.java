package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import exceptions.DomainExceptions;
import services.Reservation;

public class Program {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		try {
			System.out.print("Room number: ");
			int roomNumber = sc.nextInt();
			System.out.print("Check-in date: ");
			sc.nextLine();
			Date checkIn = sdf.parse(sc.next());
			System.out.print("Check-out date: ");
			sc.nextLine();
			Date checkOut = sdf.parse(sc.next());
			
			Reservation reservation = new Reservation(roomNumber, checkIn, checkOut);
			System.out.println("Reservation: " + reservation);
			
			System.out.println("Enter data to update the reservation:");
			System.out.print("Update check-in: ");
			checkIn = sdf.parse(sc.next());
			System.out.print("Update check-out: ");
			checkOut = sdf.parse(sc.next());
			
			reservation.updateDates(checkOut, checkIn);
			System.out.println("Reservation: " + reservation);
		}
		catch(ParseException e) {
			System.out.println("Invalid date format!");
		}
		catch(DomainExceptions e) {
			System.out.println("Error in reservation: " + e.getMessage());
		}
		sc.close();
	}

}
