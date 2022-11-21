package BusinessLogic;

public class AssignTeacher {

	
	private String Semid;
	private String BatchId;
	private String Department;
	private String CourseId;
	private String TeacherId;
	
	
	
	
	public AssignTeacher(String semid, String batchId, String department, String courseId, String teacherId) {
		super();
		Semid = semid;
		BatchId = batchId;
		Department = department;
		CourseId = courseId;
		TeacherId = teacherId;
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
	public String getTeacherId() {
		return TeacherId;
	}
	public void setTeacherId(String teacherId) {
		TeacherId = teacherId;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
