package com.movierental;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

public class CustomerTest {
    @Test
    public void testEmptyStatement(){
    	Customer customer = new Customer("TestEmptyRentals");
    	String result = customer.statement();
    	System.out.println("Result: " + result);
    	assertNotNull(result);
    }
   
    
    @Test
    //Renter Points should be incremented for valid Movie types?
    public void testStatement(){
    	Customer customer = new Customer("TestRentals");
    	Movie movie = new Movie("Movie One", 2);
    	Rental rental1 = new Rental(movie, 2);
    	customer.addRental(rental1);
    	String result = customer.statement();
    	System.out.println("Result: " + result);
    	assertNotNull(result);
    }
    
    
    
    

}  