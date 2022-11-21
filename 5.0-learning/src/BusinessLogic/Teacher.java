package BusinessLogic;

public class Teacher {

    private String Name;
    private String password;
    private String TeacherId;
    private String Salary;
    private String phoneNo;
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
    public String getTeacherId() {
        return TeacherId;
    }
    public void setTeacherId(String teacherId) {
        TeacherId = teacherId;
    }
    public String getSalary() {
        return Salary;
    }
    public void setSalary(String salary) {
        Salary = salary;
    }
    public String getPhoneNo() {
        return phoneNo;
    }
    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }
    public Teacher(String name, String password, String teacherId, String salary, String phoneNo) {
        super();
        Name = name;
        this.password = password;
        TeacherId = teacherId;
        Salary = salary;
        this.phoneNo = phoneNo;
    }

    public void addTeacher(String Name, String password, String TeacherId, String Salary, String phoneNo) {

    }
    public void deleteTeacher(String teacherId) {

    }
}
