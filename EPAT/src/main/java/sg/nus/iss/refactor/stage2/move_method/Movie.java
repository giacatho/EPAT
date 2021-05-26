package sg.nus.iss.refactor.stage2.move_method;

public class Movie {
  public static final int REGULAR = 0;
  public static final int CHILDRENS = 1;
  public static final int NEW_RELEASE = 2;

  private String _title;
  private int _categoryCode;

  public Movie(String title, int categoryCode) {
    _title = title;
    _categoryCode = categoryCode;
  }

  public int getCategory() {
    return _categoryCode;
  }

  public void setCategory(int ctg) {
    _categoryCode = ctg;
  }

  public String getTitle() {
    return _title;
  }
}
