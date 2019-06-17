package com.movierental;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CustomerTest {

    @Before
    public void before() {
    }

    @After
    public void after() {
    }

    @Test
    public void testCreateWithoutName() {
        Customer cust = DataUtil.createCustomer(null);
        assertNotNull(cust);
        assertNull(cust.getName());
        assertEquals("Rental Record for null\n" +
                "Amount owed is 0.0\n" +
                "You earned 0 frequent renter points", cust.statement());
    }

    @Test
    public void testCreateWithName() {
        Customer cust = DataUtil.createCustomer("pawan");
        assertNotNull(cust);
        assertNotNull(cust.getName());
        assertEquals("pawan", cust.getName());
        assertEquals("Rental Record for pawan\n" +
                "Amount owed is 0.0\n" +
                "You earned 0 frequent renter points", cust.statement());
    }

    //@Test
    public void testWithNullMovieRental() {
        Customer cust = DataUtil.createCustomer("pawan");
        assertNotNull(cust);
        Rental rental = DataUtil.createRental(null, 10);
        cust.addRental(rental);
        assertNotNull(cust.getName());
        assertEquals("pawan", cust.getName());
        assertEquals("Rental Record for pawan\n" +
                "\tCOD\t0.0\n" +
                "Amount owed is 0.0\n" +
                "You earned 1 frequent renter points", cust.statement());
    }

    //@Test
    public void testNullRental() {
        Customer cust = DataUtil.createCustomer("pawan");
        assertNotNull(cust);
        cust.addRental(null);
        assertNotNull(cust.getName());
        assertEquals("pawan", cust.getName());
        assertEquals("Rental Record for pawan\n" +
                "\tCOD\t0.0\n" +
                "Amount owed is 0.0\n" +
                "You earned 1 frequent renter points", cust.statement());
    }


    @Test
    public void testOneMovieRental() {
        Customer cust = DataUtil.createCustomer("pawan");
        assertNotNull(cust);
        Movie movie = DataUtil.createMovie("COD", 3);
        Rental rental = DataUtil.createRental(movie, 10);
        cust.addRental(rental);
        assertNotNull(cust.getName());
        assertEquals("pawan", cust.getName());
        assertEquals("Rental Record for pawan\n" +
                "\tCOD\t0.0\n" +
                "Amount owed is 0.0\n" +
                "You earned 1 frequent renter points", cust.statement());
    }

    @Test
    public void testMultiMovieRental() {
        Customer cust = DataUtil.createCustomer("pawan");
        assertNotNull(cust);
        Movie movie = DataUtil.createMovie("COD", 3);
        Rental rental = DataUtil.createRental(movie, 10);
        cust.addRental(rental);
        cust.addRental(rental);
        movie = DataUtil.createMovie("MOHAA", 3);
        rental = DataUtil.createRental(movie, 10);
        cust.addRental(rental);
        assertNotNull(cust.getName());
        assertEquals("pawan", cust.getName());
        assertEquals("Rental Record for pawan\n" +
                "\tCOD\t0.0\n" +
                "\tCOD\t0.0\n" +
                "\tMOHAA\t0.0\n" +
                "Amount owed is 0.0\n" +
                "You earned 3 frequent renter points", cust.statement());
    }


    @Test
    public void testHtmlMultiMovieRental() {
        Customer cust = DataUtil.createCustomer("pawan");
        assertNotNull(cust);
        Movie movie = DataUtil.createMovie("COD", 3);
        Rental rental = DataUtil.createRental(movie, 10);
        cust.addRental(rental);
        cust.addRental(rental);
        movie = DataUtil.createMovie("MOHAA", 83);
        rental = DataUtil.createRental(movie, 10);
        cust.addRental(rental);
        assertNotNull(cust.getName());
        assertEquals("pawan", cust.getName());
        assertEquals("<h1>Rental Record for <b>pawan</b></h1><br/> COD <b>0.0</b><br/> COD <b>0.0</b><br/> MOHAA " +
                "<b>0.0</b><br/>Amount owed is <b>0.0</b><br/>You earned <b>3</b> frequent renter points",
                new HtmlStatement().generate(cust.getName(), cust.getRentals()));
    }

}
