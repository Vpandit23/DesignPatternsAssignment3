package assignment03;

import java.time.LocalTime;

public class Driver {
	public static void main(String[] args) {
		Person person = new Person("Alex Student", "2000-01-01");
		AbstractStudent student = new ConcreteStudent(person);
		student.setMajor("Computer Science");
		student.setUniversity("Example University");

		student = new CS537(student);
		student = new CS528(student);
		student = new CS542(student);
		student = new CS551(student);

		System.out.println(student.getInnerSelf().getName());
		System.out.println(student.getMajor() + " at " + student.getUniversity());
		System.out.println(student.getCourses());

		LocalTime meetingTime = LocalTime.of(14, 30);
		System.out.println("Meeting at " + meetingTime
				+ " conflicts: " + student.timeConflict(meetingTime));
	}
}
