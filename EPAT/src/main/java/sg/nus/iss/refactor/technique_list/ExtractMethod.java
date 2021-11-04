package sg.nus.iss.refactor.technique_list;

public class ExtractMethod {
  String name;
  double outstanding;

void printOwing() {
  // Print banner
  System.out.print("****************");
  System.out.print("**** Customer Owes ****");
  System.out.print("****************");

  // Print details
  System.out.println("name: " + name);
  System.out.println("amount: " + outstanding);
}

void printOwning() {
  printBanner();
  printDetails();
}

void printBanner() {
  System.out.print("****************");
  System.out.print("**** Customer Owes ****");
  System.out.print("****************");
}

void printDetails() {
  System.out.println("name: " + name);
  System.out.println("amount: " + outstanding);
}

}
