package application;

import java.io.IOException;
import java.util.ArrayList;

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

public class ControllerCourse {

	@FXML
	private TextField CourseName;
	@FXML
	private TextField CourseId;
	@FXML
    private TextField CreditHour;

	
	 private Stage stage;
	 private Scene scene;
	 private Parent root;


	public void MakeAccount(ActionEvent event) throws IOException {

		if (CourseName.getText().isBlank() || CourseId.getText().isBlank() || CreditHour.getText().isBlank()) {
			Alert alert1 = new Alert(AlertType.WARNING);
			alert1.setTitle("Warning");
			alert1.setHeaderText("Fill all the textfield first");
			alert1.showAndWait();
		}
else{
		ArrayList<Course> course = TTC.getInstance().SearchCourse(CourseId.getText());

		if (course!=null) {
			int check1 = TTC.getInstance().addCourse(CourseName.getText(), CreditHour.getText(),CourseId.getText());

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
			alert1.setHeaderText("A Course with this courseid already exist");
			alert1.showAndWait();

		}
	}
		 
		 }
	
	 public void Reset(ActionEvent event) throws IOException {
		
		 
		CourseName.clear();
		CourseId.clear();
	    CreditHour.clear();

		 }
	
	 public void Back(ActionEvent event) throws IOException {
		 root = FXMLLoader.load(getClass().getResource("UI/AdminMenu.fxml"));
		  stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		  scene = new Scene(root);
		  stage.setScene(scene);
		  stage.show();
		 }
	
	
	 
	
	
	
	
	
	
}
