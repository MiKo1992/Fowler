/**
 * Created by mikok on 02.05.2016.
 */
public class RegularPrice extends Price {
    int getPriceCode(){
        return Movie.REGULAR;
    }

    public double getCharge(int daysRented) {
        double result = 2;
        if (daysRented > 2)
            result += (daysRented - 2) * 1.5;
        return result;

    }
}
