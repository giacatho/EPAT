package sg.nus.iss.refactor.stage4.replace_with_strategy;

public class NewRentalPriceComputer implements IRentalPriceComputer {
  @Override
  public double computePrice(int daysRented) {
    return daysRented * 3;
  }
}
