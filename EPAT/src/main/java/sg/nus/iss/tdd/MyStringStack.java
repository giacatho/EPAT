package sg.nus.iss.tdd;

import java.util.ArrayList;
import java.util.List;

public class MyStringStack {
	private List<String> elements = new ArrayList<>();
	
	public boolean isEmpty() {
		return elements.isEmpty();
	}

	public void push(String str) {
		if (str != null) {
			elements.add(str);
		}
	}
	
	public String pop() {
		if (isEmpty()) throw new IndexOutOfBoundsException();
		return elements.remove(elements.size() - 1);
	}
}
