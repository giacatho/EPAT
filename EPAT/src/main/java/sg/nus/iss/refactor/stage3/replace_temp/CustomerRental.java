package sg.nus.iss.refactor.stage3.replace_temp;

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
    // Refactored: Replace temp variables with queries
    // double totalAmount = 0;
    // int frequenRenterPoints = 0;
    String result = "Rental Record for " + getName() + "\n";

    for (Rental each : _rentals) {
      // show figures for this rental
      result += each.getMovie().getTitle() + "\t" + each.getPrice() + "\n";
    } // end of while loop

    // add footer lines
    result += "Amount owed is " + getTotalAmount() + "\n";
    result += "You earned " + getFrequentRenterPoints() + " frequent renter points";
    return result;
  }// end of statement method

// Refactored: replace temp variable 'frequentRenterPoints'
// in statement() with this query
private int getFrequentRenterPoints() {
  int frequentRenterPoints = 0;

  for (Rental each : _rentals) {
    frequentRenterPoints++;

    if ((each.getMovie().getCategory() == Movie.NEW_RELEASE) && each.getDaysRented() > 1)
      frequentRenterPoints++;
  }

  return frequentRenterPoints;
}

// Refactored: Replace temp variable 'totalAmount'
// in statement() with this query
private double getTotalAmount() {
  double totalAmount = 0;

  for (Rental each : _rentals) {
    double thisAmount = each.getPrice();
    totalAmount += thisAmount;
  } // end of while loop

  return totalAmount;
}

} // end of CustomerRental class
