package busReser;
import java.util.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
public class Booking {
	String passengerName;
	int busNo;
	Date date;
	
	Booking(){
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter your name of passenger : ");
		passengerName = scanner.next();
		System.out.println("Enter bus No : ");
		busNo = scanner.nextInt();
		System.out.println("Enter the date dd-mm-yyyy: ");
		String dateInput = scanner.next();
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		try {
			date = dateFormat.parse(dateInput);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public boolean isAvailable(ArrayList<Booking> bookings, ArrayList<Bus> busses) {
		int capacity = 0;
		for(Bus bus:busses) {
			if(bus.getBusNo()== busNo) {
				capacity = bus.getCapacity();
			}
		}
		int booked = 0;
		
		for(Booking b:bookings) {
			if(b.busNo == busNo && b.date.equals(date)) {
				booked++;
			}
		}
		
		return booked<capacity?true:false;
	}
}
