package sg.nus.iss.tdd.fake;

public interface IExchangeRateProvider {
  double getRate(String src, String dest);
}
