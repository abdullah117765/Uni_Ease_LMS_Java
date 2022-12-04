package BusinessLogic;

public class CourseRegister {

	
	private String Semid;
	private String BatchId;
	private String Department;
	private String CourseId;
	private String StudentId;
	
	
	
	
	public CourseRegister(String semid, String batchId, String department, String courseId, String studentId) {
		super();
		Semid = semid;
		BatchId = batchId;
		Department = department;
		CourseId = courseId;
		StudentId = studentId;
	}
	
	
	
	public String getSemid() {
		return Semid;
	}
	public void setSemid(String semid) {
		Semid = semid;
	}
	public String getBatchId() {
		return BatchId;
	}
	public void setBatchId(String batchId) {
		BatchId = batchId;
	}
	public String getDepartment() {
		return Department;
	}
	public void setDepartment(String department) {
		Department = department;
	}
	public String getCourseId() {
		return CourseId;
	}
	public void setCourseId(String courseId) {
		CourseId = courseId;
	}
	public String getStudentId() {
		return StudentId;
	}
	public void setStudentId(String studentId) {
		StudentId = studentId;
	}
	
	
	
	
	
	
}
