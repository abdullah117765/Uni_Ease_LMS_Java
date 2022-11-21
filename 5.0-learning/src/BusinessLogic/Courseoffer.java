package BusinessLogic;

public class Courseoffer {

private String semId;
private String BatchId;
private String courseId;
private String Department;




public Courseoffer(String semId, String batchId, String courseId, String Department) {
	super();
	this.semId = semId;
	BatchId = batchId;
	this.courseId = courseId;
	this.Department=Department;
}


public String getSemId() {
	return semId;
}
public void setSemId(String semId) {
	this.semId = semId;
}
public String getBatchId() {
	return BatchId;
}
public void setBatchId(String batchId) {
	BatchId = batchId;
}
public String getCourseId() {
	return courseId;
}
public void setCourseId(String courseId) {
	this.courseId = courseId;
}


public String getDepartment() {
	return Department;
}


public void setDepartment(String department) {
	Department = department;
}
	

	
	
	
	
	
}
