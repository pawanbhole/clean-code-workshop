package com.movierental;

import java.util.ArrayList;
import java.util.List;

public class Customer {
  private String name;
  private Rentals rentals = new Rentals();

  public Customer(String name) {
    this.name = name;
  }

  public void addRental(Rental arg) {
    rentals.add(arg);
  }

  public Rentals getRentals() {
    return rentals;
  }

  public String getName() {
    return name;
  }

  public String statement() {
    return new TextStatement().generate(name, rentals);
  }
}

