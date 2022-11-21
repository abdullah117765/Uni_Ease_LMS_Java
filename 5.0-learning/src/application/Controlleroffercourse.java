package application;

import java.io.IOException;
import java.sql.SQLOutput;
import java.util.ArrayList;

import BusinessLogic.Admin;
import BusinessLogic.Course;
import BusinessLogic.Student;
import BusinessLogic.TTC;
import BusinessLogic.Teacher;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class Controlleroffercourse {

	@FXML
	private TextField CourseId;
	@FXML
	private TextField Batchid;
	@FXML
    private TextField Semester;
	@FXML
	private TextField SearchCousre;
	@FXML
	private TextField Department;
	
	@FXML
	private TableColumn<Course,String> OfferCourseId;
	@FXML
	private TableColumn<Course,String> OfferCourseName;
	@FXML
	private TableColumn<Course, String> OfferCourseCredithour;
	@FXML
	private TableView<Course> OfferCourseTable;


	
	 private Stage stage;
	 private Scene scene;
	 private Parent root;
	 
		
	
	 public void Display1(ArrayList<Course> courselist) {


		 OfferCourseId.setCellValueFactory(new PropertyValueFactory <Course , String>("CourseId"));
		 OfferCourseName.setCellValueFactory(new PropertyValueFactory <Course , String>("CourseName"));
		 OfferCourseCredithour.setCellValueFactory(new PropertyValueFactory <Course , String>("Credithour"));
		 
		 for(int i=0;i<courselist.size();i++) {
			 OfferCourseTable.getItems().add(courselist.get(i));
		}
		 }

	 public void Reset(ActionEvent event) throws IOException {
		if(CourseId.getText().isBlank() || Batchid.getText().isBlank() || Semester.getText().isBlank() || Department.getText().isBlank()){
			Alert alert1 = new Alert(AlertType.WARNING);
			alert1.setTitle("Warning");
			alert1.setHeaderText("Fill all text field first");
			alert1.showAndWait();
		}else {
			CourseId.clear();
			Batchid.clear();
			Semester.clear();
			Department.clear();
		}
	 }
	
	 public void Back(ActionEvent event) throws IOException {
		 root = FXMLLoader.load(getClass().getResource("UI/AdminMenu.fxml"));
		  stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		  scene = new Scene(root);
		  stage.setScene(scene);
		  stage.show();
		 }
	
	 public void OfferCourse(ActionEvent event) throws IOException {
		 
		 if(Semester.getText().isBlank() ||  Batchid.getText().isBlank()  || CourseId.getText().isBlank() || Department.getText().isBlank()){
			 Alert alert1= new Alert(AlertType.WARNING);
			   alert1.setTitle("Warning");
			   alert1.setHeaderText("Fill all the Textfield first");
			   alert1.showAndWait(); 
		}
		else {
			 ArrayList<Course> cc = TTC.getInstance().SearchCourse(CourseId.getText());

			 if (cc.isEmpty()) {
				 Alert alert1 = new Alert(AlertType.WARNING);
				 alert1.setTitle("Warning");
				 alert1.setHeaderText("This course is not taught here first add it to university teaching list");
				 alert1.showAndWait();
			 } else{
			 int check2 = TTC.getInstance().SearchofferCourse(Semester.getText(), Batchid.getText(), CourseId.getText(), Department.getText());

			 if (check2 == -1) {
				 int check1 = TTC.getInstance().OfferCourse(Semester.getText(), Batchid.getText(), CourseId.getText(), Department.getText());

				 if (check1 == -1) {
					 Alert alert1 = new Alert(AlertType.WARNING);
					 alert1.setTitle("Warning");
					 alert1.setHeaderText("Failed to offer course");
					 alert1.showAndWait();

				 } else {

					 Alert alert1 = new Alert(AlertType.WARNING);
					 alert1.setTitle("Warning");
					 alert1.setHeaderText("Course offered Successfully");
					 alert1.showAndWait();
				 }
			 } else {

				 Alert alert1 = new Alert(AlertType.WARNING);
				 alert1.setTitle("Warning");
				 alert1.setHeaderText("A Course with this courseid  already exist");
				 alert1.showAndWait();

			 }
		 }
	 }

	 }

public void Display(ActionEvent event) throws IOException {
	OfferCourseTable.getItems().clear();
	ArrayList<Course> courselist =	TTC.getInstance().DisplayCourse();
	if(courselist.isEmpty()) {
		 Alert alert1= new Alert(AlertType.WARNING);
	   alert1.setTitle("Warning");
	   alert1.setHeaderText("There are no courses added to portfolio");
	   alert1.showAndWait();
	}
	else
		Display1(courselist);
	}




public void unofferCourse(ActionEvent event) throws IOException {
	
		if(Semester.getText().isEmpty() &&  Batchid.getText().isEmpty()  && CourseId.getText().isEmpty() && Department.getText().isEmpty()){
			 Alert alert1= new Alert(AlertType.WARNING);
			   alert1.setTitle("Warning");
			   alert1.setHeaderText("Fill all the Textfield first");
			   alert1.showAndWait(); 
		}else {

	 int check22=	TTC.getInstance().SearchofferCourse(Semester.getText(), Batchid.getText(), CourseId.getText(), Department.getText());
	 
	 if(check22!=-1) {		 
		int check35= TTC.getInstance().unofferCourse(Semester.getText(), Batchid.getText(), CourseId.getText(), Department.getText());
		
		if(check35==-1) {
			 Alert alert1= new Alert(AlertType.WARNING);
			   alert1.setTitle("Warning");
			   alert1.setHeaderText("failed to delete course");
			   alert1.showAndWait(); 
		}
		else {
			 Alert alert1= new Alert(AlertType.WARNING);
			   alert1.setTitle("Warning");
			   alert1.setHeaderText("delete Successfully");
			   alert1.showAndWait();
		}		
		 		 
	 }	 
else {
			 Alert alert1= new Alert(AlertType.WARNING);
			   alert1.setTitle("Warning");
			   alert1.setHeaderText("There is no course with this id in database");
			   alert1.showAndWait();
		 }
}
	OfferCourseTable.getItems().clear();
}



public void DeleteCourse(ActionEvent event) throws IOException {
	if(!SearchCousre.getText().isEmpty()) {
		ArrayList<Course> course=	TTC.getInstance().SearchCourse(SearchCousre.getText());
			
		if(course.isEmpty()) {
			Alert alert1= new Alert(AlertType.WARNING);
			   alert1.setTitle("Warning");
			   alert1.setHeaderText("NO course with this id");
			   alert1.showAndWait(); 
		}
		else {
		int check=	TTC.getInstance().DeleteCourse(SearchCousre.getText());
		
		if( check==-1) {
			 Alert alert1= new Alert(AlertType.WARNING);
			   alert1.setTitle("Warning");
			   alert1.setHeaderText("Failed to delete Course");
			   alert1.showAndWait(); 
			
		}else {
			
			 Alert alert1= new Alert(AlertType.WARNING);
			   alert1.setTitle("Warning");
			   alert1.setHeaderText("Course Deleted Successfully");
			   alert1.showAndWait(); 
			
		}
		}
		}else {
			 Alert alert1= new Alert(AlertType.WARNING);
			   alert1.setTitle("Warning");
			   alert1.setHeaderText("Enter the courseId in  Textfield first");
			   alert1.showAndWait(); 
		}
	OfferCourseTable.getItems().clear();
}



public void Search(ActionEvent event) throws IOException {
	OfferCourseTable.getItems().clear();
	if(!SearchCousre.getText().isEmpty()) {
	ArrayList<Course> course=TTC.getInstance().SearchCourse(SearchCousre.getText());
		
	if(course.isEmpty()) {
		Alert alert1= new Alert(AlertType.WARNING);
		   alert1.setTitle("Warning");
		   alert1.setHeaderText("NO course with this id");
		   alert1.showAndWait(); 
	}
	else {
		Display1(course);
	}
		
		
	}else {
		 Alert alert1= new Alert(AlertType.WARNING);
		   alert1.setTitle("Warning");
		   alert1.setHeaderText("Enter the courseId in  Textfield first");
		   alert1.showAndWait(); 
	}
}



}
