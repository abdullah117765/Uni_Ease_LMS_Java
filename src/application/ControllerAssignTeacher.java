package application;

import java.io.IOException;

import BusinessLogic.Course;
import BusinessLogic.TTC;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class ControllerAssignTeacher {

	@FXML
	private TextField CourseId;
	@FXML
	private TextField TeacherId;
	@FXML
    private TextField Semester;
	@FXML
	private TextField Department;
	@FXML
	private TextField Batchid;
	
	
	 private Stage stage;
	 private Scene scene;
	 private Parent root;
	 
	
	 
	
	
	 public void Back(ActionEvent event) throws IOException {
		 root = FXMLLoader.load(getClass().getResource("UI/AdminMenu.fxml"));
		  stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		  scene = new Scene(root);
		  stage.setScene(scene);
		  stage.show();
		 }
	
 public void Assign(ActionEvent event) throws IOException {
	 
	 if(Semester.getText().isEmpty() || Batchid.getText().isEmpty() || Department.getText().isEmpty() || CourseId.getText().isEmpty() ||  TeacherId.getText().isEmpty()) {

		 Alert alert1= new Alert(AlertType.WARNING);
		   alert1.setTitle("Warning");
		   alert1.setHeaderText("Fill all the text fields first");
		   alert1.showAndWait();
	}
	else {
		 int check45 = TTC.getInstance().SearchofferCourse(Semester.getText(), Batchid.getText(), CourseId.getText(), Department.getText());
		 if (check45 == -1) {
			 Alert alert1 = new Alert(AlertType.WARNING);
			 alert1.setTitle("Warning");
			 alert1.setHeaderText("This course is not offered yet");
			 alert1.showAndWait();
		 }else{
			 int check145= TTC.getInstance().SearchTeacher(TeacherId.getText());
			 if(check145==-1){
				 Alert alert1 = new Alert(AlertType.WARNING);
				 alert1.setTitle("Warning");
				 alert1.setHeaderText("There is no teacher with this id in database");
				 alert1.showAndWait();
			 }else{
		 int check52 = TTC.getInstance().SearchAsssignedTeacher(Semester.getText(), Batchid.getText(), Department.getText(), CourseId.getText(), TeacherId.getText());

		 if (check52 == -1) {
			 int check11 = TTC.getInstance().AssignTeachertoCourse(Semester.getText(), Batchid.getText(), Department.getText(), CourseId.getText(), TeacherId.getText());

			 if (check11 == -1) {
				 Alert alert1 = new Alert(AlertType.WARNING);
				 alert1.setTitle("Warning");
				 alert1.setHeaderText("Failed to assigned teacher to course");
				 alert1.showAndWait();

			 } else {

				 Alert alert1 = new Alert(AlertType.WARNING);
				 alert1.setTitle("Warning");
				 alert1.setHeaderText("Course assigned to teacher Successfully");
				 alert1.showAndWait();
			 }
		 } else {

			 Alert alert1 = new Alert(AlertType.WARNING);
			 alert1.setTitle("Warning");
			 alert1.setHeaderText("A Teacher with this Credentials is already assigned to this course");
			 alert1.showAndWait();
		 }
	 }
 }	 }
	 }
	
	

public void Reset(ActionEvent event) throws IOException {
		 if(CourseId.getText().isBlank() || TeacherId.getText().isBlank() || Semester.getText().isBlank() || Department.getText().isBlank() ||Batchid.getText().isBlank()){
			 Alert alert1= new Alert(AlertType.WARNING);
			 alert1.setTitle("Warning");
			 alert1.setHeaderText("Fill all the textfield first");
			 alert1.showAndWait();
		 }else{
	CourseId.clear();
	TeacherId.clear();
	Semester.clear();
 Department.clear();
    Batchid.clear();
}}

public void DEASSIGN(ActionEvent event) throws IOException {
	 if(Semester.getText().isEmpty() || Batchid.getText().isEmpty() || Department.getText().isEmpty() || CourseId.getText().isEmpty() ||  TeacherId.getText().isEmpty()) {

		 Alert alert1= new Alert(AlertType.WARNING);
		   alert1.setTitle("Warning");
		   alert1.setHeaderText("Fill all the text fields first");
		   alert1.showAndWait();
	}
	else {
		
		int course=	TTC.getInstance().SearchAsssignedTeacher(Semester.getText(),Batchid.getText(),Department.getText(), CourseId.getText(), TeacherId.getText());
		
		if(course==-1) {
			Alert alert1= new Alert(AlertType.WARNING);
			   alert1.setTitle("Warning");
			   alert1.setHeaderText("NO course with this id");
			   alert1.showAndWait(); 
		}
		else {
		int check=	TTC.getInstance().unassignteachertoCourse(Semester.getText(),Batchid.getText(),Department.getText(), CourseId.getText(), TeacherId.getText());
		
		if( check==-1) {
			 Alert alert1= new Alert(AlertType.WARNING);
			   alert1.setTitle("Warning");
			   alert1.setHeaderText("Failed to unregister Course");
			   alert1.showAndWait(); 
			
		}else {
			
			 Alert alert1= new Alert(AlertType.WARNING);
			   alert1.setTitle("Warning");
			   alert1.setHeaderText("Course unregistered Successfully");
			   alert1.showAndWait(); 			
		}
		}		
	}
}



}
