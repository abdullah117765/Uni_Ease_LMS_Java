package BusinessLogic;
import java.util.ArrayList;

import BusinessLogic.Student;
import application.DB.*;


public class StudentBacklog  {
	

	
	private StudentBacklog() {
		super();
	}


	private static StudentBacklog obj = new StudentBacklog();


    public static StudentBacklog getInstance(){
    	
        return obj;
    }
	
	
	

    public int addStudent(String name, String password, String rollNo, String section, String department, String phoneNo){
        Student student1=new Student( name,  password,  rollNo,  section,  department,  phoneNo);
     int x1=StudentDbHandler.getInstance().addStudent(student1);
        return x1;
    }
    
    
 public ArrayList<Student> DisplayStudents(String RollNo) {
    	ArrayList<Student> studentlist= StudentDbHandler.getInstance().DisplayStudent(RollNo);
    	return studentlist;
    }
    
 

    
    public int Deletestudent(String Rollnumber) {
    	int x1=StudentDbHandler.getInstance().deleteStudent(Rollnumber);
    	return x1;
    }
    
  public int SearchStudent(String Rollnumber) {
    	int x1= StudentDbHandler.getInstance().SearchStudent(Rollnumber);
    	return x1;
    }
  
    public int updateStudent(Student updateS, int x) {
    	int x1=StudentDbHandler.getInstance().updateStudent(updateS,x);
    	return x1;
    }

    public int verifyStudent(String Rollnumber, String password) {
        int x1=StudentDbHandler.getInstance().verifyStudent(Rollnumber,password);
    	return x1;
    }

    public int  RegisterCourse(String semid, String batchId, String department, String courseId, String studentId){
       CourseRegister reg=new CourseRegister( semid,  batchId,  department,  courseId,  studentId);
       int x1= CourseRegisterDBHandler.getInstance().RegisterCourse(reg);
        return x1;
    }
    
    
    
public ArrayList<CourseRegister> DisplayRegisterCourse(String semid, String batchId, String department, String courseId, String studentId) {
    CourseRegister reg=new CourseRegister( semid,  batchId,  department,  courseId,  studentId);
    	
    	ArrayList<CourseRegister>  courseregisterlist= CourseRegisterDBHandler.getInstance().DisplayRegisterCourse(reg);
    	return courseregisterlist;
    }
    
    
    public int unregisterCourse(String semid, String batchId, String department, String courseId, String studentId) {
        CourseRegister reg=new CourseRegister( semid,  batchId,  department,  courseId,  studentId);
    	int x1=CourseRegisterDBHandler.getInstance().unregisterCourse(reg);
    	return x1;
    }

public int SearchRegisterCourse(String semid, String batchId, String department, String courseId, String studentId) {
    CourseRegister reg=new CourseRegister( semid,  batchId,  department,  courseId,  studentId);
    int x1= CourseRegisterDBHandler.getInstance().SearchRegisterCourse(reg);
    	return x1;
    }
    
    
    
    // related to displaying register course for attendence

public ArrayList<CourseRegister> DisplayallREgcoursesforattendence(String semid, String batchId, String department, String courseId) {
	
	
	ArrayList<CourseRegister>  courseregisterlist= CourseRegisterDBHandler.getInstance().DisplayallREgcoursesforattendence(semid, batchId, department, courseId);
	return courseregisterlist;
}
    
    
public ArrayList<Attendance> Viewattendence( String semid, String batchId, String department,String courseId, String studentId){
	ArrayList<Attendance>  Attendencelist=AttendanceDBHandler.getInstance().ViewAttendance(semid, batchId, department, courseId, studentId);



	return  Attendencelist;
}

    
public ArrayList<CourseRegister> DisplayallCoursesRegisteredByStudent(String StudentId){

    ArrayList<CourseRegister> reg=CourseRegisterDBHandler.getInstance().DisplayallcoursesRegisterbystudent(StudentId);
    return reg;
}


public ArrayList<Marks> DisplayMarks(String semid, String batchId, String department, String courseId, String studentId ){

	ArrayList<Marks>  markslist=MarksDBHandler.getInstance().ViewMarks(semid, batchId, department, courseId, studentId);
	 
	 return markslist;
}

// Querry starts here

    public int ADDQuerry(String semid, String batchId, String department, String courseId, String studentId, String statement){
Query q=new Query(semid,batchId,department,courseId,studentId,statement);
        int x1=QueryDBHandler.getInstance().addQuery(q);
        return x1;
    }

    public  ArrayList<Query>  ViewReply(String semid, String batchId, String department, String courseId, String studentId, String QueryId, String Statement){

        ArrayList<Query> qurries=QueryDBHandler.getInstance().ViewReply(semid,batchId,department,courseId,studentId,QueryId,Statement);
        return qurries;
    }


// Querry ends here




}
