package sg.nus.iss.refactor.technique_list;

public class ReplaceConditionWithStrategy {

}

class Loan
{
  String expiry;
  String maturity;
  double commitment;
  double duration;
  double riskFactor;
  
double capital() {
  if (expiry==null && maturity!=null) {
    return commitment * duration * riskFactor;
  }
  else if (expiry != null && maturity == null) {
    if (getUnusedPercentage() != 1.0)
      return commitment * getUnusedPercentage() 
        * duration * riskFactor;
    else 
      return outstandingRiskAmount() * 
          duration * riskFactor +
            (getUnusedRiskAmount() * duration * unusedRiskFactor());
  }
  return 0.0;
}

  private double getUnusedRiskAmount() {
    // TODO Auto-generated method stub
    return 0;
  }

  private int unusedRiskFactor() {
    // TODO Auto-generated method stub
    return 0;
  }

  private double outstandingRiskAmount() {
    // TODO Auto-generated method stub
    return 0;
  }

  private double getUnusedPercentage() {
    // TODO Auto-generated method stub
    return 0;
  }
}