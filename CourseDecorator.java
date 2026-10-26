package assignment03;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class CourseDecorator extends AbstractStudent {
	protected AbstractStudent delegate;	
	
	private String courseRubric; // such as "CS", "MATH", "CHEM", "ISE"
	private String courseNumber; // such as "350", "520", "481A", "580E"
	private String courseTitle;  // such as "Design Patterns"
	private int credits;		// such as 3, 4
	private String section;		// such as "01", "90", "A52"
	private LocalTime startTime;
	private LocalTime endTime;
	public CourseDecorator(AbstractStudent s, String courseRubricIn, 
			String courseNumberIn, String courseTitleIn, int creditsIn,
			String sectionIn, LocalTime startTimeIn, LocalTime endTimeIn) {
		super(s.getInnerSelf());
		delegate = s;
		courseRubric = courseRubricIn;
		courseNumber = courseNumberIn;
		courseTitle = courseTitleIn;
		credits = creditsIn;
		section = sectionIn;
		startTime = startTimeIn;
		endTime = endTimeIn;
	}
	public Person getInnerSelf() {
		return delegate.getInnerSelf();
	}
	public String getCourses() {
		return delegate.getCourses() + this.toString() + "\n";
	}
	public List<String> getCourseList() {
		List<String> courses = delegate.getCourseList();
		courses.add(this.toString());
		return courses;
	}
	public boolean betweenStartAndEnd(LocalTime time) {
		LocalTime bufferedStart = startTime.minusMinutes(15);
		LocalTime bufferedEnd = endTime.plusMinutes(15);
		return time.equals(bufferedStart)
				|| (time.isAfter(bufferedStart) && time.isBefore(bufferedEnd));
	}
	public boolean timeConflict(LocalTime time) {
		int meetingStart = time.toSecondOfDay();
		int meetingEnd = meetingStart + 60 * 60;
		int classStart = startTime.toSecondOfDay() - 15 * 60;
		int classEnd = endTime.toSecondOfDay() + 15 * 60;

		// Compare against adjacent-day copies to account for meetings that
		// cross midnight and buffered class times near midnight.
		for (int dayOffset = -24 * 60 * 60; dayOffset <= 24 * 60 * 60;
				dayOffset += 24 * 60 * 60) {
			if (meetingStart + dayOffset < classEnd
					&& meetingEnd + dayOffset > classStart) {
				return true;
			}
		}
		return delegate.timeConflict(time);
	}
	@Override
	public String toString() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("h:mma");
        String fStartTime = startTime.format(formatter).toLowerCase();
        String fEndTime = endTime.format(formatter).toLowerCase();
		return courseRubric + courseNumber + "-" + section + " "
				+ courseTitle + "(" + credits + "cr), meets " + fStartTime + "-" + fEndTime;
	}
	
	@Override
	public String getUniversity() {
		return delegate.getUniversity();
	}
	@Override
	public void setUniversity(String university) {
		delegate.setUniversity(university);
	}
	@Override
	public String getMajor() {
		return delegate.getMajor();
	}
	@Override
	public void setMajor(String major) {
		delegate.setMajor(major);
	}
}
