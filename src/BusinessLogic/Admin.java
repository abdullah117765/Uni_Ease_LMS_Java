package BusinessLogic;

public class Admin {

    private String Salary;
    private String PhoneNumber;
    private String AdminId;
    private String Name;
    private String Password;


    public Admin(String adminId, String name, String password, String salary, String phoneNumber) {
        AdminId = adminId;
        Name = name;
        Password = password;
        Salary = salary;
        PhoneNumber = phoneNumber;
    }

    public String getSalary() {
        return Salary;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public String getAdminId() {
        return AdminId;
    }

    public String getName() {
        return Name;
    }

    public String getPassword() {
        return Password;
    }



    public void setAdminId(String adminId) {
        AdminId = adminId;
    }

    public void setName(String name) {
        Name = name;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public void setSalary(String salary) {
        Salary = salary;
    }

    public void setPhoneNumber(String phoneNumber) {
        PhoneNumber = phoneNumber;
    }



}
