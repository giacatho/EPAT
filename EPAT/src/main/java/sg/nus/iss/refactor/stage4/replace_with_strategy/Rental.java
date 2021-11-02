package sg.nus.iss.refactor.stage4.replace_with_strategy;

public class Rental {
  private Movie _movie;
  private int _daysRented;
  // Refactored: keep a reference of IRentalPriceComputer,
  // which will compute the price instead of complex switch-case statements
  private IRentalPriceComputer _rentalPriceComputer;

  public Rental(Movie movie, int daysRented) {
    _movie = movie;
    _daysRented = daysRented;
    // Refactored: set the right IRentalPriceComputer
    setRentalPriceComputer(_movie.getCategory());
  }

  public int getDaysRented() {
    return _daysRented;
  }

  public Movie getMovie() {
    return _movie;
  }

// Refactored: set the right IRentalPriceComputer
// based on the category
private void setRentalPriceComputer(int category) {
  switch (category) {
  case Movie.REGULAR:
    _rentalPriceComputer = new RegularRentalPriceComputer();
    break;

  case Movie.NEW_RELEASE:
    _rentalPriceComputer = new NewRentalPriceComputer();
    break;

  case Movie.CHILDRENS:
    _rentalPriceComputer = new ChildrenRentalPriceComputer();
    break;
  }
}

public double getPrice() {
  // Refactored: replace the complex switch-case
  // statements based on the type code with a hierarchy
  // of classes
  return _rentalPriceComputer.computePrice(_daysRented);
}
}
