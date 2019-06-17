package com.movierental;

public class DataUtil {

    public static Customer createCustomer(String name) {
        return  new Customer(name);
    }

    public static Movie createMovie(String title, int priceCode) {
        return new Movie(title, priceCode);
    }

    public static Rental createRental(Movie movie, int daysRented) {
        return new Rental(movie, daysRented);
    }
}
