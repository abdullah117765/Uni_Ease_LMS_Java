package BusinessLogic;

public class Announcement {

   private String announcement;
   private String teachercheck;
   private String studentcheck;
   
   
public Announcement(String announcement, String teachercheck, String studentcheck) {
	super();
	this.announcement = announcement;
	this.teachercheck = teachercheck;
	this.studentcheck = studentcheck;
}



public String getAnnouncement() {
	return announcement;
}
public void setAnnouncement(String announcement) {
	this.announcement = announcement;
}
public String getTeachercheck() {
	return teachercheck;
}
public void setTeachercheck(String teachercheck) {
	this.teachercheck = teachercheck;
}
public String getStudentcheck() {
	return studentcheck;
}
public void setStudentcheck(String studentcheck) {
	this.studentcheck = studentcheck;
}
   
   
   

}
