package sg.nus.iss.refactor.stage4.replace_with_strategy;

public class Rental {
  private Movie _movie;
  private int _daysRented;
  
  public Rental(Movie movie, int daysRented) {
    _movie = movie;
    _daysRented = daysRented;
  }

  public int getDaysRented() {
    return _daysRented;
  }

  public Movie getMovie() {
    return _movie;
  }
  
  public double getPrice() {
    // Refactored: keep a reference of IRentalPriceComputer,
    // asking it to compute the price instead of
    // computing the price in the complex switch-case statements
    IRentalPriceComputer rentalPriceComputer = null;
    
    switch (getMovie().getCategory()) {
    case Movie.REGULAR:
      rentalPriceComputer = new RegularRentalPriceComputer();
      break;

    case Movie.NEW_RELEASE:
      rentalPriceComputer = new NewRentalPriceComputer();
      break;
      
    case Movie.CHILDRENS:
      rentalPriceComputer = new ChildrenRentalPriceComputer();
      break;
    
      default:
        throw new IllegalArgumentException("Invalid movie category");
    }
      
    return rentalPriceComputer.computePrice(_daysRented);
  }
}
