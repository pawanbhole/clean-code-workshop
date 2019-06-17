package com.movierental;

public class HtmlStatement{
    public String generate(String name, Rentals rentals) {
        String result = "<h1>Rental Record for <b>" + name + "</b></h1><br/>";
        for (Rental each : rentals) {
            // add frequent renter points
            //show figures for this rental
            result += " " + each.getMovie().getTitle() + " <b>" +
                    each.amountFor() + "</b><br/>";
        }

        //add footer lines result
        result += "Amount owed is <b>" + rentals.totalRentalAmount() + "</b><br/>";
        result += "You earned <b>" + rentals.frequentRenterPoints()
                + "</b> frequent renter points";
        return result;
    }
}
