package BusinessLogic;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

public class TTC {
	
	
	private String CurrentUser;
	private int type;
	
	
	// 1 for admin 2 for teacher 3 for student
	
    public String getCurrentUser() {
		return CurrentUser;
	}

	public void setCurrentUser(String currentUser,int type) {
		this.CurrentUser = currentUser;
		this.type=type;
	}
	
	

	private TTC() {
	}

	
    
    private static TTC obj = new TTC();


    public static TTC getInstance(){
    	
        return obj;
    }

// student portion starts here
    public int addStudent(String name, String password, String rollNo, String section, String department, String phoneNo) {
    	
    	int x1=	StudentBacklog.getInstance().addStudent(name, password, rollNo, section, department, phoneNo);
    		
    	return x1;
    }

    public int deleteStudent( String rollNo) {
    	int x1=StudentBacklog.getInstance().Deletestudent(rollNo);
    	
    	return x1;
    }
    
public int SearchStudent(String Rollnumber) {
	int x1= 	StudentBacklog.getInstance().SearchStudent(Rollnumber);
    	
    	return x1;
    }
    
    
  public int updateStudent(Student updateS,int x) {
	  int x1= StudentBacklog.getInstance().updateStudent(updateS,x);
    	
    	return x1;
    }
    
    
    public int verifyStudent(String Rollnumber, String password) {
    	
    	int x1=StudentBacklog.getInstance().verifyStudent(Rollnumber, password);
    	
    	return x1;
    }
    
 public ArrayList<Student> DisplayStudents(String RollNo) {
    	
	 ArrayList<Student> studentlist= StudentBacklog.getInstance().DisplayStudents(RollNo);
    	     	
    	return studentlist;
    }
	public ArrayList<Student> DisplayStudents2() {

		ArrayList<Student> studentlist= StudentBacklog.getInstance().DisplayStudents(this.CurrentUser);

		return studentlist;
	}
 // student portion ends here
    
 // Teacher portion starts here
 
 public int addTeacher(String name, String password, String teacherId, String salary, String phoneNo) {
 	
	 int x1=TeacherBacklog.getInstance().addTeacher(name,  password,  teacherId,  salary,  phoneNo);
 		
 	return x1;
 }

 public int deleteTeacher( String teacherId) {
	 int x1=TeacherBacklog.getInstance().Deleteteacher(teacherId);
 	
 	return x1;
 }
 
public int SearchTeacher(String id) {
	int x1= TeacherBacklog.getInstance().SearchTeacher(id);
 	
 	return x1;
 }
 
 
public int updateTeacher(Teacher updateT,int x) {
	int x1=  TeacherBacklog.getInstance().updateTeacher(updateT,x);
 	
 	return x1;
 }
 
 
 public int verifyTeacher(String teacherId, String password) {
 	
	 int x1=TeacherBacklog.getInstance().verifyTeacher(teacherId, password);
 	
 	return x1;
 }
 
public ArrayList<Teacher> DisplayTeachers(String teacherId) {
 	
	 ArrayList<Teacher> teacherlist= TeacherBacklog.getInstance().DisplayTeachers(teacherId);
 	     	
 	return teacherlist;
 }
 
 
 // Teacher portion Ends here
    
//   Admin portion starts here 
    
public int addAdmin(String adminId, String name, String password, String salary, String phoneNumber) {
 	
	int x1=AdminBacklog.getInstance().addAdmin(adminId,name, password,salary,phoneNumber);
 		
 	return x1;
 }

 public int deleteAdmin( String adminId) {

	 int x1=	AdminBacklog.getInstance().Deleteadmin(adminId);
 	
 	return x1;
 }
 
public int SearchAdmin(String adminid) {
 	
	int x1=AdminBacklog.getInstance().SearchAdmin(adminid);
 	return x1;
 }
 
 
public int updateAdmin(Admin updateT,int x) {
	int x1=  AdminBacklog.getInstance().updateAdmin(updateT,x);
 	
 	return x1;
 }
 
 
 public int verifyAdmin(String adminId, String password) {
 	
	 int x1=AdminBacklog.getInstance().verifyAdmin(adminId, password);
 	
 	return x1;
 }
 
public ArrayList<Admin> DisplayAdmins(String adminId) {
 	
	 ArrayList<Admin> adminlist= AdminBacklog.getInstance().DisplayAdmins(adminId);
 	     	
 	return adminlist;
 }
    
//Admin portion ends here 

//Manage Course Starts here

public int addCourse(String courseName, String credithour, String courseId){
	int x1=AdminBacklog.getInstance().addCourse(courseName, credithour, courseId); 

	return x1;
}

public ArrayList<Course> SearchCourse(String courseid) {
	
	ArrayList<Course> course= AdminBacklog.getInstance().SearchCourse(courseid);

    	return course;
    }


public ArrayList<Course> DisplayCourse() {
	
	ArrayList<Course> courselist=AdminBacklog.getInstance().DisplayCourse();
	
	return courselist;
}


public int DeleteCourse(String courseId) {
	
	int x1=AdminBacklog.getInstance().DeleteCourse(courseId);
	return x1;
}


// Manage course ends here

// Offer course Starts here


public int OfferCourse(String semId, String BatchId, String courseId,String  Department){
	int x1=AdminBacklog.getInstance().OfferCourse(semId,BatchId, courseId,Department);
 
	return x1;
}


public ArrayList<Courseoffer> DisplayOfferCourse(String semId,String batchId, String courseId, String Department) {
	
	
	ArrayList<Courseoffer> courseofferlist= AdminBacklog.getInstance().DisplayOfferCourse(semId,batchId, courseId, Department);
	
	return courseofferlist;
}


public int unofferCourse(String semId, String batchId, String courseId, String Department) {
	
	int x1=AdminBacklog.getInstance().unofferCourse(semId, batchId, courseId, Department);
	return x1;
}
public int SearchofferCourse(String semId, String batchId, String courseId, String Department) {
	int x1=AdminBacklog.getInstance().SearchofferCourse(semId, batchId, courseId, Department);
	
	return x1;
}

// offerCourse ends here


//Register Course Starts here


public int RegisterCourse(String semid, String batchId, String department, String courseId){
	int x1=StudentBacklog.getInstance().RegisterCourse( semid,  batchId,  department,  courseId, this.CurrentUser);
	return x1;
}


public ArrayList<CourseRegister> DisplayRegisterCourse(String semid, String batchId, String department, String courseId) {
	
	
	ArrayList<CourseRegister>  courseregisterlist= StudentBacklog.getInstance().DisplayRegisterCourse(semid, batchId, department, courseId, this.CurrentUser );
	
	return courseregisterlist;
}


public int unregisterCourse(String semid, String batchId, String department, String courseId) {
	
	int x1=StudentBacklog.getInstance().unregisterCourse(semid, batchId, department, courseId,  this.CurrentUser);
	
	
	return x1;
}


public int SearchRegisterCourse(String semid, String batchId, String department, String courseId) {
	int x1=StudentBacklog.getInstance().SearchRegisterCourse(semid, batchId, department, courseId,  this.CurrentUser);
	
	return x1;
}

	public int SearchRegisterCourse1(String semid, String batchId, String department, String courseId,String studentid) {
		int x1=StudentBacklog.getInstance().SearchRegisterCourse(semid, batchId, department, courseId,  studentid);

		return x1;
	}

// Register course ends here



// Assign teacher to course starts here


public int  AssignTeachertoCourse(String semid, String batchId, String department, String courseId, String teacherid){
	int x1=TeacherBacklog.getInstance().AssignTeachertoCourse(semid, batchId, department, courseId, teacherid);
  
    return x1;
}






public int unassignteachertoCourse(String semid, String batchId, String department, String courseId,String teacherid) {
	
	int x1=TeacherBacklog.getInstance().unassignteachertoCourse(semid, batchId, department, courseId,teacherid);
	return x1;
}


public int SearchAsssignedTeacher(String semid, String batchId, String department, String courseId,String teacherid) {
	int x1=TeacherBacklog.getInstance().SearchAsssignedTeacher(semid, batchId, department, courseId,teacherid);
	
	return x1;
}

// assign teacher to course ends here




// upload attendence starts here

public int  updateAttendence(String date, String semid, String batchId, String department,String courseId, String studentId, int option) {
	
	int x1=TeacherBacklog.getInstance().updateAttendence(date, semid, batchId, department, courseId, studentId,option);
	return x1;
}

	public ArrayList<Attendance>  searchAttendence(String date, String semid, String batchId, String department,String courseId, String studentId) {

		ArrayList<Attendance> aot =TeacherBacklog.getInstance().SearchAttendance(date, semid, batchId, department, courseId, studentId);
		return aot;
	}
public int  AddAttendence(String date, String semid, String batchId, String department,String courseId, String studentId) {
	
	int x1=TeacherBacklog.getInstance().AddAttendence(date, semid, batchId, department, courseId, studentId);
	
	return x1;
}

//public void Display


public ArrayList<Student> Displayallstudentsforattendence(String semid, String batchId, String department, String courseId){
	ArrayList<CourseRegister>  regcourseforattend=StudentBacklog.getInstance().DisplayallREgcoursesforattendence(semid, batchId, department, courseId);
if(regcourseforattend==null || regcourseforattend.isEmpty())
	return null;

	ArrayList<Student>  studentlist=new ArrayList<Student>();
	
	for(int i=0;i<regcourseforattend.size();i++) {
	String studid=regcourseforattend.get(i).getStudentId();

	ArrayList<Student> ss1=StudentBacklog.getInstance().DisplayStudents(studid);
	if(ss1==null || ss1.isEmpty())
		return null;
	else
	 studentlist.add(ss1.get(0));
	}
	
	return studentlist;
}

public ArrayList<AssignTeacher> DisplayallCoursesAssignedtoteacher(){
	ArrayList<AssignTeacher>  Assignedcourse1=TeacherBacklog.getInstance(). DisplayAsssignedTeacher(this.CurrentUser);
	// using current user here

	return  Assignedcourse1;
}

public ArrayList<CourseRegister> DisplayallCoursesRegisteredByStudent(){
	ArrayList<CourseRegister>  Assignedcourse1=StudentBacklog.getInstance().DisplayallCoursesRegisteredByStudent(this.CurrentUser);    
	// using current user here
	return  Assignedcourse1;
}

public ArrayList<Attendance> Viewattendence( String semid, String batchId, String department,String courseId){
	ArrayList<Attendance>  Assignedcourse1=StudentBacklog.getInstance().Viewattendence( semid, batchId, department, courseId, this.CurrentUser);
	return  Assignedcourse1;
}

//upload/view  attendence ends here


// Marks related start here


public int  AddMarks(String semid, String batchId, String department, String courseId, String studentId, String type,
		String tMarks, String oMarks){
	
	 int x1=TeacherBacklog.getInstance().AddMarks(semid, batchId, department, courseId, studentId, type, tMarks, oMarks);
	return x1;
}


public int UpdateMarks(String semid, String batchId, String department, String courseId, String studentId, String type,
		String tMarks, String oMarks){

 int x1=TeacherBacklog.getInstance().UpdateMarks(semid, batchId, department, courseId, studentId, type, tMarks, oMarks);
 
 return x1;
}



public ArrayList<Marks> DisplayMarks(String semid, String batchId, String department, String courseId ){
	
	
	ArrayList<Marks>  markslist=StudentBacklog.getInstance().DisplayMarks(semid, batchId, department, courseId,this.CurrentUser);
	 
	 return markslist;
}


// marks related ends here



// announcement starts here


public int MakeAnnouncement(String announcement, String teachercheck, String studentcheck) {
	int x1=AdminBacklog.getInstance().MakeAnnouncement(announcement, teachercheck, studentcheck);
	
	return x1;
}

public ArrayList<Announcement> DisplayallAnnouncementforstudent(){
	ArrayList<Announcement> announcement= AdminBacklog.getInstance().DisplayallAnnouncementfor(this.type);
// if int x=0 then return teachers announcement only if int x=1 the student announcement only
	return announcement;
}
// Announcement ends here


// querry starts here
public int ADDQuerry(String semid, String batchId, String department, String courseId, String statement){

	int x1=StudentBacklog.getInstance().ADDQuerry(semid,batchId,department,courseId,this.CurrentUser,statement);
	return x1;
}

	public  ArrayList<Query>  ViewReply(String semid, String batchId, String department, String courseId, String studentId, String QueryId, String Statement){

		ArrayList<Query> qurries=StudentBacklog.getInstance().ViewReply(semid, batchId, department, courseId, studentId,QueryId,Statement);
		return qurries;
	}

	public int ReplytoQuerry(String semid, String batchId, String department, String courseId, String studentId, String statement, String Reply, String queryid){

		int x1=TeacherBacklog.getInstance().ReplytoQuerry(semid, batchId, department, courseId, studentId,statement, Reply,queryid);
		return x1;
	}
	public ArrayList<Query> ViewQuerry(String semid, String batchId, String department, String courseId){

		ArrayList<Query> qurries=TeacherBacklog.getInstance().ViewQuerry(semid, batchId, department, courseId, this.CurrentUser);
		return qurries;
	}
	// querry ends here



  

   

}
