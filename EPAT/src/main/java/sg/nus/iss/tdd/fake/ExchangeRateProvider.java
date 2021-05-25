package sg.nus.iss.tdd.fake;

public interface ExchangeRateProvider {
  double getRate(String src, String dest);
}
