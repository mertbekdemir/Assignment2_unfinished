
/**
 * class Driver
 *
 * @author Mert
 * @version 1409
 */
public class Driver
{
 public static void main(String[]args){
     
     ParkedCar car1 = new ParkedCar("Bella", "honda", 2018,"QWE123", 125);
     car1.displayDetails();
     
     ParkingMeter meter1 = new ParkingMeter("Vancity",false, 2,  60);
     meter1.displayDetails();
     
     PoliceOfficer officer1 = new PoliceOfficer("Bill", "789ZXC");
     
     officer1.issueParkingTicket(car1,meter1);
     officer1.issueParkingTicket(car1,meter1);
     
    }
}
