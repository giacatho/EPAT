package sg.nus.iss.refactor.stage4.replace_with_strategy;

public class RegularRentalPriceComputer 
    implements IRentalPriceComputer {
  @Override
  public double computePrice(int daysRented) {
    double thisAmount = 2;
    if (daysRented > 2) {
      thisAmount += (daysRented - 2) * 1.5;
    }
    
    return thisAmount;
  }
}
