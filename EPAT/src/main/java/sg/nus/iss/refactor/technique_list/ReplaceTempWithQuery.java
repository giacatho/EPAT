package sg.nus.iss.refactor.technique_list;

public class ReplaceTempWithQuery {
  int quantity;
  double itemPrice;
  
double calculateTotal() {
  double basePrice = quantity * itemPrice;
  if (basePrice > 1000) {
    return basePrice * 0.95;
  }
  else {
    return basePrice * 0.98;
  }
}
  
double calculateTotal2() {
  if (getBasePrice() > 1000) {
    return getBasePrice() * 0.95;
  }
  else {
    return getBasePrice() * 0.98;
  }
}

double getBasePrice() {
  return quantity * itemPrice;
}
  
  
}
