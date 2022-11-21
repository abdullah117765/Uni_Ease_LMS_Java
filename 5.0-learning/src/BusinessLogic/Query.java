package BusinessLogic;

public class Query {

	  private String Semid;
	  private String BatchId;
	  private String Department;
	  private String CourseId;
	  private String StudentId;
	  private String statement;
	private String Reply;
private String Queryid;
private static int count=0;
	public Query(String semid, String batchId, String department, String courseId, String studentId, String statement) {
		Semid = semid;
		BatchId = batchId;
		Department = department;
		CourseId = courseId;
		StudentId = studentId;
		this.statement = statement;
		Reply = " ";
		count++;
		Queryid="Q"+count;
	}

	public Query(String semid, String batchId, String department, String courseId, String studentId, String statement, String reply, String queryid) {
		Semid = semid;
		BatchId = batchId;
		Department = department;
		CourseId = courseId;
		StudentId = studentId;
		this.statement = statement;
		Reply = reply;
		Queryid = queryid;
	}

	public String getQueryid() {
		return Queryid;
	}
	public String getSemid() {
		return Semid;
	}

	public String getBatchId() {
		return BatchId;
	}

	public String getDepartment() {
		return Department;
	}

	public String getCourseId() {
		return CourseId;
	}

	public String getStudentId() {
		return StudentId;
	}

	public String getStatement() {
		return statement;
	}

	public String getReply() {
		return Reply;
	}

	public void setSemid(String semid) {
		Semid = semid;
	}

	public void setBatchId(String batchId) {
		BatchId = batchId;
	}

	public void setDepartment(String department) {
		Department = department;
	}

	public void setCourseId(String courseId) {
		CourseId = courseId;
	}

	public void setStudentId(String studentId) {
		StudentId = studentId;
	}

	public void setStatement(String statement) {
		this.statement = statement;
	}

	public void setReply(String reply) {
		Reply = reply;
	}

	public void setQueryid(String queryid) {
		Queryid = queryid;
	}
}
