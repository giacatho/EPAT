package sg.nus.iss.refactor.stage1.extract_method;

import java.util.ArrayList;
import java.util.List;

public class CustomerRental {
  private String _name;
  private List<Rental> _rentals = new ArrayList<Rental>();

  public CustomerRental(String name) {
    _name = name;
  }

  public void addRental(Rental rental) {
    _rentals.add(rental);
  }

  public int totalRented() {
    return _rentals.size();
  }

  public String getName() {
    return _name;
  }

  public String statement() {
    double totalAmount = 0;
    int frequentRenterPoints = 0;
    String result = "Rental Record for " + getName() + "\n";
    
    for (Rental each : _rentals) {
      double thisAmount = getPrice(each);
       // add frequent renter points
      frequentRenterPoints++;

      // add bonus for a two day new release rental
      if ((each.getMovie().getCategory() == Movie.NEW_RELEASE) && each.getDaysRented() > 1)
        frequentRenterPoints++;
      // show figures for this rental
      result += each.getMovie().getTitle() + "\t" + thisAmount + "\n";
      totalAmount += thisAmount;
    } // end of while loop

    // add footer lines
    result += "Amount owed is " + totalAmount + "\n";
    result += "You earned " + frequentRenterPoints + " frequent renter points";
    return result;
  }// end of statement method

  private double getPrice(Rental aRental) {
    double thisAmount = 0;
    
    //determine amounts for each line
    switch (aRental.getMovie().getCategory()) {
    case Movie.REGULAR:
      thisAmount += 2;
      if (aRental.getDaysRented() > 2)
        thisAmount += (aRental.getDaysRented() - 2) * 1.5;
      break;

    case Movie.NEW_RELEASE:
      thisAmount += aRental.getDaysRented() * 3;
      break;
      
    case Movie.CHILDRENS:
      thisAmount += 1.5;
      if (aRental.getDaysRented() > 3)
        thisAmount += (aRental.getDaysRented() - 3) * 1.5;
      break;
    }// end-switch
    return thisAmount;
  }
} // end of CustomerRental class
