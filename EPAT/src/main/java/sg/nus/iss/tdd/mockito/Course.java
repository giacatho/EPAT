package sg.nus.iss.tdd.mockito;

public class Course {
  private String courseName;
  private INameList attendees;

  public Course(INameList attendeeList) {
    this.attendees = attendeeList;
  }

  public void addAttendee(String name) {
    attendees.addName(name);
  }

  public void clearAttendeesList() {
    attendees.clear();
  }

  public String getAttendee(int i) {
    return attendees.getName(i);
  }

  public String getCourseName() {
    return courseName;
  }

  public void setCourseName(String courseName) {
    this.courseName = courseName;
  }
}
