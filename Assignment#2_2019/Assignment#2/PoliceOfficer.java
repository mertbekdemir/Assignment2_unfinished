
/**
 * class PoliceOfficer
 *
 * @author Mert
 * @version 1409
 */
public class PoliceOfficer
{
    private String officerName;
    private String officerBadgeNumber;

    public static final double ONE_HOUR_FINE_AMOUNT = 20;
    public static final int MINUTES_IN_HOUR = 60;
    /**
     * Constructor for PoliceOfficer objects
     */
    public PoliceOfficer(String newOfficerName, String newOfficerBadgeNumber){

        setOfficerName(newOfficerName);
        setOfficerBadgeNumber(newOfficerBadgeNumber);

    }

    //Accessor methods

    /**
     * method getOfficerName
     * return officerName
     */
    public String getOfficerName(){
        return officerName;
    }

    /**
     * method getOfficerBadgeNumber
     * return officerBadgeNumber
     */
    public String getOfficerBadgeNumber(){
        return officerBadgeNumber;
    }

    //Mutator methods

    /**
     * method setOfficerName
     * @param newOfficerName
     */
    public void setOfficerName(String newOfficerName){
        if(newOfficerName == null){
            throw new IllegalArgumentException("officer name must not be null");
        }
        else if(newOfficerName.equals("")){
            throw new IllegalArgumentException("officer name must not be an empty String");
        }else{
            officerName = newOfficerName;
        }
    }

    /**
     * method setOfficerBadgeNumber
     * @param newOfficerBadgeNumber
     */
    public void setOfficerBadgeNumber(String newOfficerBadgeNumber){
        if(newOfficerBadgeNumber == null){
            throw new IllegalArgumentException("badge number must not be null");   
        }
        else if(newOfficerBadgeNumber.equals("")){
            throw new IllegalArgumentException("badge number must not be empty String");
        }else{
            officerBadgeNumber = newOfficerBadgeNumber;
        }
    }

    private boolean isParkingTimeExpired(ParkedCar car, ParkingMeter meter){

        if(car.getNumberOfMinutesParked() > meter.getNumberOfPurchasedMinutes()){
            return true;
        }else{
            return false;
        }

    }

    private double calculateFine(ParkedCar car, ParkingMeter meter){
        int minutesOverParked = car.getNumberOfMinutesParked() - meter.getNumberOfPurchasedMinutes();
        double fineAmount = 0;
        if(isParkingTimeExpired(car, meter) == true) { 
            if(minutesOverParked <= MINUTES_IN_HOUR){
                fineAmount = ONE_HOUR_FINE_AMOUNT;
            }else{
                fineAmount = ONE_HOUR_FINE_AMOUNT*((minutesOverParked % MINUTES_IN_HOUR));
            }
            return fineAmount;
        }
        return 0;
    }

    /**
     * method issueParkingTicket
     * @param car
     * @param meter
     */
    public ParkingTicket issueParkingTicket(ParkedCar car, ParkingMeter meter){
        if(isParkingTimeExpired(car, meter) == true) { 
            ParkingTicket ticket = new ParkingTicket(getOfficerName(),getOfficerBadgeNumber(),getCarLicensePlateNumber());
            ticket.displayDetails();
            return ticket;
        }
        return null;
    }
}
