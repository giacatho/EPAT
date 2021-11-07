package sg.nus.iss.tdd.fake;

public class FakeRateProvider implements IExchangeRateProvider {
  @Override
  public double getRate(String src, String dest) {
    return 1.4;
  }
}
