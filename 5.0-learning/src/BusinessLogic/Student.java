package BusinessLogic;

public class Student {


    private String Name;
    private String password;
    private String RollNo;
    private String Section;
    private String Department;
    private String phoneNo;
    private String Semester;



    public String getSemester() {
	return Semester;
}

public void setSemester(String semester) {
	Semester = semester;
}

	public String getName() {
        return Name;
    }




    public void setName(String name) {
        Name = name;
    }




    public String getPassword() {
        return password;
    }




    public void setPassword(String password) {
        this.password = password;
    }




    public String getRollNo() {
        return RollNo;
    }




    public void setRollNo(String rollNo) {
        RollNo = rollNo;
    }




    public String getSection() {
        return Section;
    }




    public void setSection(String section) {
        Section = section;
    }




    public String getDepartment() {
        return Department;
    }




    public void setDepartment(String department) {
        Department = department;
    }




    public String getPhoneNo() {
        return phoneNo;
    }




    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }




    public Student(String name, String password, String rollNo, String section, String department, String phoneNo) {
        super();
        Name = name;
        this.password = password;
        RollNo = rollNo;
        Section = section;
        Department = department;
        this.phoneNo = phoneNo;
        Semester="1";
    }




}
