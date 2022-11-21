package application;

import java.io.IOException;
import java.util.ArrayList;

import BusinessLogic.Admin;
import BusinessLogic.Student;
import BusinessLogic.TTC;
import BusinessLogic.Teacher;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;


public class ControllerManageUsers {

	@FXML
	private TextField Search;
	private Stage stage;
	private Scene scene;
	private Parent root;
	@FXML
	private TableColumn<Admin,String> AdminSalary;
	@FXML
	private TableColumn<Admin,String> AdmonId;
	@FXML
	private TableColumn<Teacher, String> TeacherPhoneNumber;	
	@FXML
	private TableColumn<Admin,String> AdminName;
	@FXML
	private TableColumn<Admin,String> AdminPhoneNumber;
	@FXML
	private Tab TeacherPortion;	
	@FXML
	private TableColumn<Teacher, String> TeacherSalary;	
	@FXML
	private Tab AdminPortion;
	@FXML
	private Tab StudentPortion;
	@FXML
	private TableColumn<Teacher, String> TeachId;
	@FXML
	private TableColumn<Teacher, String> TeacherName;
	@FXML
	private TableView<Admin> AdminTable;
	@FXML
	private TableView<Teacher> TeacherTable;
	@FXML
	private TableView<Student> StudentTable;
	@FXML
	private TableColumn<Student, String> StudentName;
	@FXML
	private TableColumn<Student, String> StudentSection;
	@FXML
	private TableColumn<Student, String> RollNumber;
	@FXML
	private TableColumn<Student, String> StudentDepartment;
	@FXML
	private TableColumn<Student, String> StudentPhoneNumber;

	
	public void DisplayStudent(ArrayList<Student> studentlist) {
		
		StudentPhoneNumber.setCellValueFactory(new PropertyValueFactory <Student , String>("phoneNo"));
		StudentPhoneNumber.setCellFactory(TextFieldTableCell.forTableColumn());		
		StudentPhoneNumber.setOnEditCommit(new EventHandler<CellEditEvent<Student, String>>() {
			@Override
			public void handle(CellEditEvent<Student, String> event) {
				Student s = event.getRowValue();
				s.setPhoneNo(event.getNewValue());
				int check2=	TTC.getInstance().updateStudent(s ,1);
			}
		});
		StudentName.setCellValueFactory(new PropertyValueFactory <Student , String>("Name"));
		RollNumber.setCellValueFactory(new PropertyValueFactory <Student , String>("RollNo"));
		StudentDepartment.setCellValueFactory(new PropertyValueFactory <Student , String>("Department"));
		StudentSection.setCellValueFactory(new PropertyValueFactory <Student , String>("Section"));
		StudentSection.setCellFactory(TextFieldTableCell.forTableColumn());		
		StudentSection.setOnEditCommit(new EventHandler<CellEditEvent<Student, String>>() {
			@Override
			public void handle(CellEditEvent<Student, String> event) {
				Student s = event.getRowValue();
				s.setSection(event.getNewValue());
				int check2=	TTC.getInstance().updateStudent(s ,2);
			}
		});
		

   for(int i=0; i<studentlist.size();i++) {
		StudentTable.getItems().add(studentlist.get(i));
}
	}

	public void DisplayTeacher(ArrayList<Teacher> teacherlist ) {
		//TeacherTable.clear()

		TeacherName.setCellValueFactory(new PropertyValueFactory <Teacher , String>("Name"));
		TeachId.setCellValueFactory(new PropertyValueFactory <Teacher , String>("TeacherId"));
		TeacherPhoneNumber.setCellValueFactory(new PropertyValueFactory <Teacher , String>("phoneNo"));
		TeacherPhoneNumber.setCellFactory(TextFieldTableCell.forTableColumn());
		TeacherPhoneNumber.setEditable(true);
		TeacherPhoneNumber.setOnEditCommit(new EventHandler<CellEditEvent<Teacher, String>>() {
			@Override
			public void handle(CellEditEvent<Teacher, String> event) {
				Teacher s = event.getRowValue();
				s.setPhoneNo(event.getNewValue());
				int check2=	TTC.getInstance().updateTeacher(s ,1);
			}
		});
		TeacherSalary.setCellValueFactory(new PropertyValueFactory <Teacher , String>("Salary"));
		TeacherSalary.setCellFactory(TextFieldTableCell.forTableColumn());		
		TeacherSalary.setOnEditCommit(new EventHandler<CellEditEvent<Teacher, String>>() {
			@Override
			public void handle(CellEditEvent<Teacher, String> event) {
				Teacher s = event.getRowValue();
				s.setPhoneNo(event.getNewValue());
				int check2=	TTC.getInstance().updateTeacher(s ,2);
			}
		});
		
		
// Adding object of teacher which will acess it attributes and add it to the screen
		for(int i=0;i<teacherlist.size();i++) {
		TeacherTable.getItems().add(teacherlist.get(i));
		}
	}



	public void DisplayAdmin(ArrayList<Admin> adminlist) {

		AdminName.setCellValueFactory(new PropertyValueFactory <Admin , String>("Name"));
		AdmonId.setCellValueFactory(new PropertyValueFactory <Admin , String>("AdminId"));
		AdminPhoneNumber.setCellValueFactory(new PropertyValueFactory <Admin , String>("PhoneNumber"));
		AdminPhoneNumber.setCellFactory(TextFieldTableCell.forTableColumn());		
		AdminPhoneNumber.setOnEditCommit(new EventHandler<CellEditEvent<Admin, String>>() {
			@Override
			public void handle(CellEditEvent<Admin, String> event) {
				Admin s = event.getRowValue();
				s.setPhoneNumber(event.getNewValue());
				int check2=	TTC.getInstance().updateAdmin(s ,1);
			}
		});
		AdminSalary.setCellValueFactory(new PropertyValueFactory <Admin , String>("Salary"));
		AdminSalary.setCellFactory(TextFieldTableCell.forTableColumn());		
		AdminSalary.setOnEditCommit(new EventHandler<CellEditEvent<Admin, String>>() {
			@Override
			public void handle(CellEditEvent<Admin, String> event) {
				Admin s = event.getRowValue();
				s.setPhoneNumber(event.getNewValue());
				int check2=	TTC.getInstance().updateAdmin(s ,2);
			}
		});
		
		
		
		for(int i=0;i<adminlist.size();i++) {
			AdminTable.getItems().add(adminlist.get(i));
			}
	}



	public void Back(ActionEvent event) throws IOException {
		root = FXMLLoader.load(getClass().getResource("UI/AdminMenu.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}

	public void Delete(ActionEvent event) throws IOException {
		if(Search.getText().isEmpty()) {
			Alert alert1= new Alert(AlertType.WARNING);
			alert1.setTitle("Warning");
			alert1.setHeaderText("Enter some id first in search box");
			alert1.showAndWait();
		}
		else {

		if(AdminPortion.isSelected()) {
int check5=	TTC.getInstance().SearchAdmin(Search.getText());
			
			if(check5==-1) {
				 Alert alert1= new Alert(AlertType.WARNING);
			   alert1.setTitle("Warning");
			   alert1.setHeaderText("There is no Admin with this Id");
			   alert1.showAndWait();
			}
			else {
				int check6=	TTC.getInstance().deleteAdmin(Search.getText());
				if(check6==-1) {
					 Alert alert1= new Alert(AlertType.WARNING);
				   alert1.setTitle("Warning");
				   alert1.setHeaderText("Failed to delete the Admin");
				   alert1.showAndWait();
				}else {
					Alert alert1= new Alert(AlertType.WARNING);
					   alert1.setTitle("Warning");
					   alert1.setHeaderText(" Admin Deleted Successfully");
					   alert1.showAndWait();
				}
						
			}
		}

		if(TeacherPortion.isSelected()) {
int check4=	TTC.getInstance().SearchTeacher(Search.getText());
			
			if(check4==-1) {
				 Alert alert1= new Alert(AlertType.WARNING);
			   alert1.setTitle("Warning");
			   alert1.setHeaderText("There is no Teacher with this Id");
			   alert1.showAndWait();
			}
			else {
				int check3=	TTC.getInstance().deleteTeacher(Search.getText());
				if(check3==-1) {
					 Alert alert1= new Alert(AlertType.WARNING);
				   alert1.setTitle("Warning");
				   alert1.setHeaderText("Failed to delete the Teacher");
				   alert1.showAndWait();
				}else {
					Alert alert1= new Alert(AlertType.WARNING);
					   alert1.setTitle("Warning");
					   alert1.setHeaderText(" Teacher Deleted Successfully");
					   alert1.showAndWait();
				}
						
			}
		}

		if(StudentPortion.isSelected()) {
		int check=	TTC.getInstance().SearchStudent(Search.getText());
			
			if(check==-1) {
				 Alert alert1= new Alert(AlertType.WARNING);
			   alert1.setTitle("Warning");
			   alert1.setHeaderText("There is no student with this Roll number");
			   alert1.showAndWait();
			}
			else {
				int check2=	TTC.getInstance().deleteStudent(Search.getText());
				if(check2==-1) {
					 Alert alert1= new Alert(AlertType.WARNING);
				   alert1.setTitle("Warning");
				   alert1.setHeaderText("Failed to delete the Student");
				   alert1.showAndWait();
				}else {
					Alert alert1= new Alert(AlertType.WARNING);
					   alert1.setTitle("Warning");
					   alert1.setHeaderText(" Student Deleted Successfully");
					   alert1.showAndWait();
				}
						
			}
		}
	}
		TeacherTable.getItems().clear();
		AdminTable.getItems().clear();
		StudentTable.getItems().clear();
	}
		



// search function
	public void Search(ActionEvent event) throws IOException {

		TeacherTable.getItems().clear();
		AdminTable.getItems().clear();
		StudentTable.getItems().clear();

		if (Search.getText().isEmpty()) {
			Alert alert1 = new Alert(AlertType.WARNING);
			alert1.setTitle("Warning");
			alert1.setHeaderText("Enter some id first in search box");
			alert1.showAndWait();
		} else {


			if (AdminPortion.isSelected()) {


				ArrayList<Admin> adminlist = TTC.getInstance().DisplayAdmins(Search.getText());

				if (adminlist == null) {
					Alert alert1 = new Alert(AlertType.WARNING);
					alert1.setTitle("Warning");
					alert1.setHeaderText("There is no admin with this id");
					alert1.showAndWait();
				} else
					DisplayAdmin(adminlist);
			}

			if (TeacherPortion.isSelected()) {
				ArrayList<Teacher> teacherlist = TTC.getInstance().DisplayTeachers(Search.getText());

				if (teacherlist.isEmpty()) {
					Alert alert1 = new Alert(AlertType.WARNING);
					alert1.setTitle("Warning");
					alert1.setHeaderText("There is no teacher with this id");
					alert1.showAndWait();
				} else
					DisplayTeacher(teacherlist);
			}

			if (StudentPortion.isSelected()) {
				ArrayList<Student> studentlist = TTC.getInstance().DisplayStudents(Search.getText());

				if (studentlist.isEmpty()) {
					Alert alert1 = new Alert(AlertType.WARNING);
					alert1.setTitle("Warning");
					alert1.setHeaderText("There is no student with this Roll number");
					alert1.showAndWait();
				} else
					DisplayStudent(studentlist);
			}


		}
	}

	
	
	


}
