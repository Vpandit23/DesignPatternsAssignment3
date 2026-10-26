package assignment03;

import java.time.LocalTime;

public class CS528 extends CourseDecorator {
	public CS528(AbstractStudent stu) {
		super(stu, "CS", "528", "Computer Networks", 3, "01",
				LocalTime.of(10, 30), LocalTime.of(11, 45));
	}
}
