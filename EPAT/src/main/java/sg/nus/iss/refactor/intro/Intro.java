package sg.nus.iss.refactor.intro;

public class Intro {
  public static void main(String[] args) {
    method16();
  }

public static void method16() {
  for (int danny = 1; danny <= 9; danny++) {
    if (danny == 1) {
      System.out.print(1);
      System.out.print("*");
      System.out.println();
    } else if (danny == 2) {
      // Do nothing when danny is 2
    }
    if (danny == 3) {
      System.out.print(3);
      System.out.print("*");
      System.out.print("*");
      System.out.print("*");
      System.out.println();
    } else if (danny == 4) {
      // Do nothing when danny is 4
    }
    if (danny == 6) {
      // Do nothing when danny is 6
    }
    if (danny > 6) {
      // Do nothing, either
      break;
    } else if (danny == 5) {
      System.out.print(5);
      System.out.print("*");
      System.out.print("*");
      System.out.print("*");
      System.out.print("*");
      System.out.print("*");
      System.out.println();
    }
  }
}
}
