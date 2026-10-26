package assignment03;

import java.time.LocalTime;

public class CS542 extends CourseDecorator {
	public CS542(AbstractStudent stu) {
		super(stu, "CS", "542", "Design Patterns", 3, "01", 
				LocalTime.of(13,30), LocalTime.of(14,30));
	}
}
