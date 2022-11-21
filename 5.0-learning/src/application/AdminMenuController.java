package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class AdminMenuController {

	 private Stage stage;
	 private Scene scene;
	 private Parent root;
	 
	
	 
	
	 public void Home(ActionEvent event) throws IOException {
		 root = FXMLLoader.load(getClass().getResource("UI/AdminMenu.fxml"));
		  stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		  scene = new Scene(root);
		  stage.setScene(scene);
		  stage.show();
		 }
	
	 public void ManageUsers(ActionEvent event) throws IOException {
		 root = FXMLLoader.load(getClass().getResource("UI/AdminManaging.fxml"));
		  stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		  scene = new Scene(root);
		  stage.setScene(scene);
		  stage.show();
		 }
	 public void AddStudent(ActionEvent event) throws IOException {
		 root = FXMLLoader.load(getClass().getResource("UI/Students.fxml"));
		  stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		  scene = new Scene(root);
		  stage.setScene(scene);
		  stage.show();
		 }
	 
	 public void AddTeacher(ActionEvent event) throws IOException {
		 root = FXMLLoader.load(getClass().getResource("UI/Teacher.fxml"));
		  stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		  scene = new Scene(root);
		  stage.setScene(scene);
		  stage.show();
		 }
	 
	 public void AddAdmin(ActionEvent event) throws IOException {
		 root = FXMLLoader.load(getClass().getResource("UI/Administration.fxml"));
		  stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		  scene = new Scene(root);
		  stage.setScene(scene);
		  stage.show();
		 }
	 
	 public void AssignTeacher(ActionEvent event) throws IOException {
		 root = FXMLLoader.load(getClass().getResource("UI/assignteachertocourse.fxml"));
		 stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		 scene = new Scene(root);
		 stage.setScene(scene);
		 stage.show();
		 }
	 
//	 
	 public void MakeAnnouncement(ActionEvent event) throws IOException {
		 root = FXMLLoader.load(getClass().getResource("UI/Announcement1.fxml"));
		  stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		  scene = new Scene(root);
		  stage.setScene(scene);
		  stage.show();
		 }
	 

	 
	 public void OfferCourse(ActionEvent event) throws IOException {
		 root = FXMLLoader.load(getClass().getResource("UI/Offercourse.fxml"));
		  stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		  scene = new Scene(root);
		  stage.setScene(scene);
		  stage.show();
		 }
	 
	 public void AddCourse(ActionEvent event) throws IOException {
		 root = FXMLLoader.load(getClass().getResource("UI/Course.fxml"));
		  stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		  scene = new Scene(root);
		  stage.setScene(scene);
		  stage.show();
		 }
	  
	 
	 public void Logout(ActionEvent event) throws IOException {
		 root = FXMLLoader.load(getClass().getResource("UI/Login.fxml"));
		  stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		  scene = new Scene(root);
		  stage.setScene(scene);
		  stage.show();
			 }
	
	
}
