package busReser;
import java.util.Scanner;
import java.util.ArrayList;
public class BusDemo {
	public static void main(String[] args) {
		ArrayList<Bus> busses = new ArrayList<Bus>();
		ArrayList<Booking> bookings = new ArrayList<Booking>();
		
		busses.add(new Bus(1,true,2));
		busses.add(new Bus(2,false,50));
		busses.add(new Bus(3,true,48));
		
		int UserOpt=1;
		Scanner scanner = new Scanner(System.in);
		
		for(Bus b:busses) {
			b.displayBusInfo();
		}
		
		while(UserOpt==1) {		
			System.out.println("Enter 1 to Book and 2 to Exit ");
			UserOpt = scanner.nextInt(); 
			if(UserOpt==1) {
				Booking booking = new Booking();
				if(booking.isAvailable(bookings,busses)) {
					bookings.add(booking);
					System.out.println("Your booking is confirmed ");
					
				}
				else {
					System.out.println("Sorry Bus is full ");
				}
			}
		}
	}
}
