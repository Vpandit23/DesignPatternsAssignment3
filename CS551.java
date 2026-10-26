package assignment03;

import java.time.LocalTime;

public class CS551 extends CourseDecorator {
	public CS551(AbstractStudent stu) {
		super(stu, "CS", "551", "Systems Programming", 3, "01",
				LocalTime.of(15, 0), LocalTime.of(16, 0));
	}
}
