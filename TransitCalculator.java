import java.util.Scanner;
package transitcalculator;

public class TransitCalculator {
    
    int numberOfDays;
    int numberOfRides;
    double[] taxes = {2.75, 33.00, 127.00};
    String[] packages = {"Pay-per-ride", "7-day Unlimited Rides", "30-day Unlimited Rides"};
    
    public TransitCalculator(int days, int rides){
    if (days > 30)
            System.out.println("The number of days exceds the limit!");
    numberOfDays = days;
    numberOfRides = rides;
    }
    
    
    //The method should return the overall price per ride of using the 7-day Unlimited option.
    public double unlimited7Price(){
        double temp = (double)numberOfDays / 7;
        if(temp <= 1)
            return taxes[1] / numberOfRides;
        else if(temp > 1 && temp <= 2)
            return (taxes[1] * 2) / numberOfRides;
        else if (temp > 2 && temp <= 3)
            return (taxes[1] * 3) / numberOfRides;
        else
            return (taxes[1] * 4) / numberOfRides;
    }
    
    //The method should return an array of the price per ride for the three fare options.
    public double[] getRidePrices(){
        double[] fare = new double[3];
        fare[0] = taxes[0];
        fare[1] = unlimited7Price();
        fare[2] = taxes[2] / numberOfRides;
        return fare;
    }
   
    public String getBestFare(){
            
        double lowest = 1000;
        double[] temp = getRidePrices();
        String print = null;
        
        for (int i=0;i<3;i++){
            if (temp[i] < lowest){
                lowest = temp[i];
                print = packages[i];
            }
        }
        
        return "You should get the "+print+" option at $"+Math.round(lowest*100)/100.0+" per ride!";
    }
   
    public static void main(String[] args) {
       
	Scanner scanner = new Scanner();



        TransitCalculator test = new TransitCalculator(scanner.nextLine(), scanner.nextLine());
        double[] a = test.getRidePrices();
        System.out.println(test.getBestFare());
      
    }
    
}
/*
Nice work! If you’d like to see the solution, move to the next task. If you’d like to extend your project on your own, you could consider the following:

The NYC transit system also offers reduced fare options for people with disabilities and people who are at least 65 years old.
Refactor the TransitCalculator class so that it checks if the rider qualifies for reduced fare and calculates the best reduced fare option if they do.
Pay-per-ride (single ride): $1.35
7-day Unlimited Rides: $16.50
30-day Unlimited Rides: $63.50
NYC isn’t the only city where there are several fare options available! Extend your TransitCalculator to work for a different city. Pick your own, or choose from these below:
Vancouver   https://www.translink.ca/Fares-and-Passes/Fare-Pricing.aspx
Mexico City https://mexicometro.org/about/fares/
Delhi       http://www.delhimetrorail.com/recharge_Info.aspx
Berlin      https://www.visitberlin.de/en/public-transport-berlin
Paris       https://www.ratp.fr/en/titres-et-tarifs
Seoul       http://www.seoulmetro.co.kr/en/page.do?menuIdx=348
*/
