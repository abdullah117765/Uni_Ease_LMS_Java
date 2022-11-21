package BusinessLogic;

public class Course {

	private String CourseName;
	private String Credithour;
	private String CourseId;



	public Course(String courseName, String credithour, String courseId) {
		super();
		CourseName = courseName;
		Credithour = credithour;
		CourseId = courseId;

	}
	public String getCourseName() {
		return CourseName;
	}
	public void setCourseName(String courseName) {
		CourseName = courseName;
	}
	public String getCredithour() {
		return Credithour;
	}
	public void setCredithour(String credithour) {
		Credithour = credithour;
	}
	public String getCourseId() {
		return CourseId;
	}
	public void setCourseId(String courseId) {
		CourseId = courseId;
	}




}
