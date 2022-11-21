package BusinessLogic;

public class Marks {
	
	  private String Semid;
	  private String BatchId;
	  private String Department;
	  private String CourseId;
	  private String StudentId;
	  private String Type;   // type 1 means assignment mark, 2 means Project, type 3 means Quizes, type 4 means Sessional 1 , type means finals
	private String TMarks;
	private String OMarks;
	  
	  
	 
	
	
	public Marks(String semid, String batchId, String department, String courseId, String studentId, String type,
			String tMarks, String oMarks) {
		super();
		Semid = semid;
		BatchId = batchId;
		Department = department;
		CourseId = courseId;
		StudentId = studentId;
		Type = type;
		TMarks = tMarks;
		OMarks = oMarks;
	}
	
	
	
	public String getTMarks() {
		return TMarks;
	}


	public void setTMarks(String tMarks) {
		TMarks = tMarks;
	}



	public String getOMarks() {
		return OMarks;
	}



	public void setOMarks(String oMarks) {
		OMarks = oMarks;
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
	public String getType() {
		return Type;
	}
	public void setType(String type) {
		Type = type;
	}
	
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
}
