package com.movierental;

import java.util.List;

public class TextStatement {
    public String generate(String name, Rentals rentals) {
        String result = "Rental Record for " + name + "\n";
        for (Rental each : rentals) {
            // add frequent renter points
            //show figures for this rental
            result += "\t" + each.getMovie().getTitle() + "\t" +
                    each.amountFor() + "\n";
        }

        //add footer lines result
        result += "Amount owed is " + rentals.totalRentalAmount() + "\n";
        result += "You earned " + rentals.frequentRenterPoints()
                + " frequent renter points";
        return result;
    }
}
