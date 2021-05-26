package sg.nus.iss.refactor.stage4.replace_with_strategy;

public class ChildrenRentalPriceComputer 
                implements IRentalPriceComputer {
  @Override
  public double computePrice(int daysRented) {
    double thisAmount = 1.5;
    if (daysRented > 3) {
      thisAmount += (daysRented - 3) * 1.5;
    }
    
    return thisAmount;
  }
}
