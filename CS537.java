package assignment03;

import java.time.LocalTime;

public class CS537 extends CourseDecorator {
	public CS537(AbstractStudent stu) {
		super(stu, "CS", "537", "Introduction to Deep Learning", 3, "01",
				LocalTime.of(9, 0), LocalTime.of(10, 0));
	}
}
