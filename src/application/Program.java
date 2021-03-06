package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import services.Reservation;

public class Program {

	public static void main(String[] args) throws ParseException {

		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.print("Room number: ");
		int roomNumber = sc.nextInt();
		System.out.print("Check-in date: ");
		sc.nextLine();
		Date checkIn = sdf.parse(sc.next());
		System.out.print("Check-out date: ");
		sc.nextLine();
		Date checkOut = sdf.parse(sc.next());
		
		if (! checkOut.after(checkIn)) {
			System.out.println("Error in reservation: Check-out date must be after check-in date");
		}
		else {
			Reservation reservation = new Reservation(roomNumber, checkIn, checkOut);
			System.out.println("Reservation: " + reservation);
			
			System.out.println("Enter data to update the reservation:");
			System.out.print("Update check-in: ");
			checkIn = sdf.parse(sc.next());
			System.out.print("Update check-out: ");
			checkOut = sdf.parse(sc.next());
			
			String error = reservation.updateDates(checkOut, checkIn);
			
			if (error != null) {
				System.out.println("Error in reservation: " + error);
			}
			else {
				System.out.println("Reservation: " + reservation);
			}
		}
		sc.close();
	}

}
