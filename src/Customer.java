
import java.lang.*;
import java.util.*;

class Customer {
    private String name;
    private Vector rentals = new Vector();
    public Customer (String newname){
        name = newname;
    };
    private double amountFor(double daysRented) {
        return daysRented;
    }
    public void addRental(Rental arg) {
        rentals.addElement(arg);
    };
    public String getName (){
        return name;
    };
    public String statement() {
        int frequentRenterPoints = 0;
        Enumeration rentals = this.rentals.elements();
        String result = "Rental Record for " + getName() + "\n";
        result += "\t" + "Title" + "\t" + "\t" + "Days" + "\t" + "Amount" + "\n";

        while (rentals.hasMoreElements()) {
            Rental each = (Rental) rentals.nextElement();
            frequentRenterPoints += each.getFrequentRenterPoints();
            //show figures for this rental
            result += "\t" + each.getMovie().getTitle()+ "\t" + "\t" + each.getDaysRented() + "\t" + String.valueOf(each.getCharge()) + "\n";
        }
        //add footer lines
        result += "Amount owed is " + String.valueOf(getTotalCharge()) + "\n";
        result += "You earned " + String.valueOf(getTotalFrequentRenterPoints()) + " frequent renter points";
        return result;
    }


    private double getTotalCharge(){
        double result = 0;
        Enumeration rentals = this.rentals.elements();
        while (rentals.hasMoreElements()) {
            Rental each = (Rental) rentals.nextElement();
            result += each.getCharge();
        }
        return result;
    }
    private int getTotalFrequentRenterPoints(){
        int result = 0;
        Enumeration rentals = this.rentals.elements();
        while(rentals.hasMoreElements()) {
            Rental each = (Rental) rentals.nextElement();
            result += each.getFrequentRenterPoints();
        }
        return result;

        }
    public String htmlStatement(){
        Enumeration rentals = this.rentals.elements();
        String result = "<H1>Rentals for <EM<>" + getName () + "</EM></H1><P>/n";
        while (rentals.hasMoreElements()) {
            Rental each = (Rental) rentals.nextElement();
            result += each.getMovie().getTitle()+ ": " + String.valueOf(each.getCharge()) + "<BR>\n";
        }
                result +=  "<P>You owe <EM>" + String.valueOf(getTotalCharge()) + "</EM><P>\n";
                result += "On this rental you earned <EM>" + String.valueOf(getTotalFrequentRenterPoints()) + "</EM> frequent renter points<P>";
                        return result;
             }

    }

    