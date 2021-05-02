package sg.nus.iss.tdd.mockito;

public class Course {
	private INameList names;
	
	public Course(INameList names) {
		this.names = names;
	}

	public void addAttendee(String string) {
		names.addName(string);
	}

	public void clearAttendeesList() {
		names.clear();
	}

	public String getAttendee(int i) {
		return names.getName(i);
	}
	
	
}
