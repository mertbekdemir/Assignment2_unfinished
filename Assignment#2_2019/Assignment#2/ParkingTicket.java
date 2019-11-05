
/**
 * class ParkingTicket
 *
 * @author Mert
 * @version 1409
 */
public class ParkingTicket
{
    //Fields
    private String officerName;
    private String officerBadgeNumber;
    private String ticketNumber;
    private String carLicensePlateNumber;
    private double fineAmountInCAD;

    // Symbolic constant
    public static final String TICKET_PREFIX = "VAN";

    //Static variable
    public static int counter = 1000;

    /**
     * Constructor
     */
    public ParkingTicket(String inputOfficerName, String inputOfficerBadgeNumber, String carLicenseNumber,double fine){
        setOfficerName(inputOfficerName);
        setOfficerBadgeNumber(inputOfficerBadgeNumber);
        setCarLicensePlateNumber(carLicenseNumber);
        setFineAmountInCAD(fine);
        generateTicketNumber();

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

    /**
     * method getTicketNumber
     * return ticketNumber
     */
    public String getTicketNumber(){
        return ticketNumber;
    }

    /**
     * method getCarLicensePlateNumber
     * return carLicensePlateNumber
     */
    public String getCarLicensePlateNumber(){
        return carLicensePlateNumber;
    }

    /**
     * method getFineAmountInCAD
     * return fineAmountInCAD
     */
    public double getFineAmountInCAD(){
        return fineAmountInCAD;
    }

    //Mutator methods

    /**
     * method setOfficerName
     * @param newOfficerName
     */
    public void setOfficerName(String newOfficerName){
        if(newOfficerName == null ){
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

    /**
     * method setCarLicensePlateNumber
     * @param newCarLicensePlateNumber
     */
    public void setCarLicensePlateNumber(String newCarLicensePlateNumber){
        if(newCarLicensePlateNumber == null){
            throw new IllegalArgumentException("car license plate number must not be null");   
        }
        else if(newCarLicensePlateNumber.equals("")){
            throw new IllegalArgumentException("car license plate number must not be empty String");
        }else{
            carLicensePlateNumber = newCarLicensePlateNumber;
        }
    }

    /**
     * method setFineAmountInCAD
     * @param newFineAmountInCAD
     */
    public void setFineAmountInCAD(double newFineAmountInCAD){
        if(newFineAmountInCAD == 0){
            throw new IllegalArgumentException("fine amount must not be 0");
        }
        else if(newFineAmountInCAD < 0){
            throw new IllegalArgumentException("fine amount must not be negative");
        }else{
            fineAmountInCAD = newFineAmountInCAD;
        }
    }

    private String generateTicketNumber(){
        ticketNumber = TICKET_PREFIX + ++counter ;
        return ticketNumber;
    }
    
    /**
     * method displayDetails
     */
    public void displayDetails(){
        System.out.println("Ticket Number: " + getTicketNumber());
        System.out.println("Officer Name: " + getOfficerName());
        System.out.println("Officer Badge number: " + getOfficerBadgeNumber());
        System.out.println("Car License Plate Number: " + getCarLicensePlateNumber());
        System.out.println("Fine amount: " + getFineAmountInCAD());
    }
    
    public static int resetCounter(){
        counter = 1000;
        return counter;
    }
}

