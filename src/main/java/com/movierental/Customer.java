package com.movierental;

import java.util.ArrayList;
import java.util.List;

public class Customer {
	private String name;
	private List<Rental> rentals = new ArrayList<>();

	public Customer(String name) {
		this.name = name;
	}

	public void addRental(Rental arg) {
		rentals.add(arg);
	}

	public String getName() {
		return name;
	}

	public String statement() {
		double totalAmount = 0;
		int frequentRenterPoints = 0;
		String result = "Rental Record for " + getName() + "\n";
		for (Rental eachRrental : rentals) {

			if (eachRrental == null || eachRrental.getMovie() == null) {
				continue;
			}

			double thisAmount = eachRrental.getCalculatedAmount();

			// add frequent renter points, add bonus for a two day new release rental
			frequentRenterPoints = frequentRenterPoints + 1 + eachRrental.getCalculatedBonusRentals();

			// show figures for this rental
			result += "\t" + eachRrental.getMovie().getTitle() + "\t" + String.valueOf(thisAmount) + "\n";
			totalAmount += thisAmount;
		}

		// add footer lines result
		result += "Amount owed is " + String.valueOf(totalAmount) + "\n";
		result += "You earned " + String.valueOf(frequentRenterPoints) + " frequent renter points";
		return result;
	}
}
