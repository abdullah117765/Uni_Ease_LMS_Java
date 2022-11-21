package BusinessLogic;
import java.util.ArrayList;

import BusinessLogic.Teacher;
import application.DB.*;


public class TeacherBacklog  {
	
	
	
	private TeacherBacklog() {
		super();
	}


	private static TeacherBacklog obj = new TeacherBacklog();


    public static TeacherBacklog getInstance(){
    	
        return obj;
    }
	
	
	

    public int addTeacher(String name, String password, String teacherId, String salary, String phoneNo){
    	Teacher t =new Teacher(name,  password, teacherId,salary,phoneNo);
    int x1=	TeacherDBHandler.getInstance().addTeacher(t);         
        return x1;
    }
    
    
 public ArrayList<Teacher> DisplayTeachers(String Teacherid) {
    	
    	
    	ArrayList<Teacher> teacherlist= TeacherDBHandler.getInstance().displayoneTeacher(Teacherid);
    	
    	return teacherlist;
    }
    
    
    public int Deleteteacher(String teacherid) {
    	
    	int x1=TeacherDBHandler.getInstance().deleteRecord(teacherid);  	
    	return x1;
    }
    
  public int SearchTeacher(String teacherid) {
    	
	  int x1=TeacherDBHandler.getInstance().SearchTeacher(teacherid);
  	return x1;
    }
  
    public int updateTeacher(Teacher upd, int x) {
    	// 1 for updating phone number
    	// 2 for updating Salary

        int x1= TeacherDBHandler.getInstance().updateTeacher(upd,x);
    	return x1;
    }
    
    
    public int verifyTeacher(String teacherId, String password) {
        int x1=TeacherDBHandler.getInstance().verifyTeacher(teacherId,password);
    	return x1;
    }
    
    
    
    
    // Assign teacher to course Starts here
    
    
    
    public int  AssignTeachertoCourse(String semid, String batchId, String department, String courseId, String teacherId){
        AssignTeacher assign=new AssignTeacher( semid,  batchId,  department,  courseId,  teacherId);
        
        int x1= AssignTeacherDBHandler.getInstance().AssignTeachertoCourse(assign);
      //  AdminDBHandler.getInstance().addcourse(admin);
        return x1;
    }

    
    public int unassignteachertoCourse(String semid, String batchId, String department, String courseId, String teacherId) {
        AssignTeacher assign=new AssignTeacher( semid,  batchId,  department,  courseId,  teacherId);
        int x1= AssignTeacherDBHandler.getInstance().unassignteachertoCourse(assign);
    	return x1;
    }
    
    
      public int SearchAsssignedTeacher(String semid, String batchId, String department, String courseId, String teacherId) {

          AssignTeacher assign=new AssignTeacher( semid,  batchId,  department,  courseId,  teacherId);
          int x1= AssignTeacherDBHandler.getInstance().SearchAsssignedTeacher(assign);
          return x1;
    }

      public ArrayList<AssignTeacher> DisplayAsssignedTeacher( String teacherId) {

    	//return all course where teacher id is this
          ArrayList<AssignTeacher> assign=AssignTeacherDBHandler.getInstance().DisplayAsssignedTeacher(teacherId);

    	  return assign;
    }
      
      
    // Assign teacher to course end here
    
// upload attendence starts here


     public int  updateAttendence(String date, String semid, String batchId, String department,String courseId, String studentId, int option) {
                 Attendance at= new Attendance(date, semid, batchId, department, courseId, studentId);
        int x1= AttendanceDBHandler.getInstance().updateAttendance(at,option);
       return x1;
      }


    public ArrayList<Attendance>   SearchAttendance(String date, String semid, String batchId, String department,String courseId, String studentId) {
        ArrayList<Attendance> aot= AttendanceDBHandler.getInstance().SearchAttendance(semid, batchId, department, courseId, studentId,date);
        return aot;
    }
     public int  AddAttendence(String date, String semid, String batchId, String department,String courseId, String studentId) {
         Attendance at= new Attendance(date, semid, batchId, department, courseId, studentId);
         int x1= AttendanceDBHandler.getInstance().AddAttendence(at);
         return x1;
}

//upload attendence ends here


// upload marks start here
     
     
     public int  AddMarks(String semid, String batchId, String department, String courseId, String studentId, String type,
 			String tMarks, String oMarks){
        Marks marks=new Marks(semid, batchId, department, courseId, studentId, type, tMarks, oMarks);
		int x1=MarksDBHandler.getInstance().AddMarks(marks);
    	 
    		return x1;
     }
     
     
 public int UpdateMarks(String semid, String batchId, String department, String courseId, String studentId, String type,
			String tMarks, String oMarks){
		// only marks can be updated
    	 // there is no new attribute for updated marks so their will be already some obtained marks for these credentials overwrite it 
     Marks marks=new Marks(semid, batchId, department, courseId, studentId, type, tMarks, oMarks);
    	 int x1=MarksDBHandler.getInstance().updateMarks(marks);
    	 return x1;
     }
     
     
     // upload marks end here
    
    
    
    // Querry starts here

    public int ReplytoQuerry(String semid, String batchId, String department, String courseId, String studentId, String statement, String Reply, String queryid){
Query q=new Query(semid,batchId,department,courseId,studentId, statement,Reply,queryid);
        int x1=QueryDBHandler.getInstance().ReplytoQuerry(q);
        return x1;
    }
    public ArrayList<Query> ViewQuerry(String semid, String batchId, String department, String courseId, String studentId){

        ArrayList<Query> qurries=QueryDBHandler.getInstance().ViewQuerry(semid, batchId, department, courseId, studentId);
        return qurries;
    }

    // Query ends here
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    

}
