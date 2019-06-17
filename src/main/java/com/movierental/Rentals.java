package com.movierental;

import java.util.ArrayList;

public class Rentals extends ArrayList<Rental> {

    public double totalRentalAmount() {
        double totalAmount = 0;
        for (Rental each : this) {
            totalAmount += each.amountFor();;
        }
        return totalAmount;
    }

    public int frequentRenterPoints() {
        int frequentRenterPoints = 0;
        for (Rental each : this) {
            frequentRenterPoints += each.rentalPointsFor();;
        }
        return frequentRenterPoints;
    }

}
