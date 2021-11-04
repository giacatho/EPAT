package sg.nus.iss.refactor.technique_list;

public class MoveMethod {

}

class Shape {
  private Point pivot;
  
  public void printPivot()
  {
    System.out.println("The x position:" + pivot.getX());
    System.out.println("The y position:" + pivot.getY());
  }
}

class Point {
  private int x;
  private int y;
  
  public int getX() {
    return x;
  }
  
  public int getY() {
    return y;
  }
  // ...
}

class Shape2 {
  private Point2 pivot;
  
  public void printPivot()
  {
    pivot.print();
  }
}

class Point2 {
  private int x;
  private int y;
  
  public int getX() {
    return x;
  }
  
  public int getY() {
    return y;
  }
  
  public void print() {
    System.out.println("The x position:" + x);
    System.out.println("The y position:" + y);
  }
  // ...
}

