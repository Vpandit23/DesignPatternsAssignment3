package assignment03;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class ConcreteStudent extends AbstractStudent {
	private String university;
	public ConcreteStudent(Person p) {
		super(p);
	}
	@Override
	public String getUniversity() {
		return university;
	}
	@Override
	public void setUniversity(String university) {
		this.university = university;
	}
	@Override
	public String getCourses() {
		return "";
	}
	@Override
	public List<String> getCourseList() {
		return new ArrayList<>();
	}
	@Override
	public boolean timeConflict(LocalTime time) {
		return false;
	}
}
