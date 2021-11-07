package sg.nus.iss.tdd.fake;

public class ForexCalculator {
  private IExchangeRateProvider erp;

  public ForexCalculator(IExchangeRateProvider erp) {
    this.erp = erp;
  }

  public double calc(String source, double amount, String dest) {
    double rate = erp.getRate(source, dest);
    return rate * amount;
  }
}
