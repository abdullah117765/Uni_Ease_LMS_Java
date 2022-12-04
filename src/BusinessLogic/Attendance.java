package BusinessLogic;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Attendance {

	DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
    Calendar cal = Calendar.getInstance();
	
	
    private String Date;
    private String flagAttendance;
    private String Semid;
	private String BatchId;
	private String Department;
	private String CourseId;
	private String StudentId;
	
	
	
	
	public Attendance(String date, String semid, String batchId, String department,String courseId, String studentId) {
		super();
		Date = date;
		this.flagAttendance = "NO";
		Semid = semid;
		BatchId = batchId;
		Department = department;
		CourseId = courseId;
		StudentId = studentId;
	}

	public Attendance(DateFormat dateFormat, Calendar cal, String date, String flagAttendance, String semid, String batchId, String department, String courseId, String studentId) {
		this.dateFormat = dateFormat;
		this.cal = cal;
		Date = date;
		this.flagAttendance = flagAttendance;
		Semid = semid;
		BatchId = batchId;
		Department = department;
		CourseId = courseId;
		StudentId = studentId;
	}

	public Attendance(String date,String flagAttendance, String semid, String batchId, String department,String courseId, String studentId) {

		Date = date;
		this.flagAttendance = flagAttendance;
		Semid = semid;
		BatchId = batchId;
		Department = department;
		CourseId = courseId;
		StudentId = studentId;
	}

	public String getFlagAttendance() {
		return flagAttendance;
	}

	public String getDate() {
		return Date;
	}
	public void setDate(String date) {
		Date = date;
	}
	public String isFlagAttendance() {
		return flagAttendance;
	}
	public void setFlagAttendance(String flagAttendance) {
		this.flagAttendance = flagAttendance;
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
