package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class StudentMenuController {

	
	
	
	 private Stage stage;
	 private Scene scene;
	 private Parent root;
	 
	
	 
	
	
	 public void Home(ActionEvent event) throws IOException {
		 root = FXMLLoader.load(getClass().getResource("UI/StudentHomePage.fxml"));
		  stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		  scene = new Scene(root);
		  stage.setScene(scene);
		  stage.show();
		 }
	
	 public void  ViewAttendence(ActionEvent event) throws IOException {
		 root = FXMLLoader.load(getClass().getResource("UI/view Attendencelearning.fxml"));
		  stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		  scene = new Scene(root);
		  stage.setScene(scene);
		  stage.show();
			 }
	
	 public void ViewMarks(ActionEvent event) throws IOException {
		 root = FXMLLoader.load(getClass().getResource("UI/ViewMarks.fxml"));
		  stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		  scene = new Scene(root);
		  stage.setScene(scene);
		  stage.show();
			 }
	 
	
	
	
	 public void RegisterCourse(ActionEvent event) throws IOException {
		 root = FXMLLoader.load(getClass().getResource("UI/registerCourse.fxml"));
		  stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		  scene = new Scene(root);
		  stage.setScene(scene);
		  stage.show();
		
			 }
	
	 
	 public void ViewDetails(ActionEvent event) throws IOException {
		 root = FXMLLoader.load(getClass().getResource("UI/ViewDetails.fxml"));
		  stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		  scene = new Scene(root);
		  stage.setScene(scene);
		  stage.show();
		
			 }
	 
	 
	 public void ViewAnnouncement(ActionEvent event) throws IOException {
		 root = FXMLLoader.load(getClass().getResource("UI/ViewAnnouncementStudent.fxml"));
		 stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		 scene = new Scene(root);
		 stage.setScene(scene);
		 stage.show();
			 }

	 public void GiveQuerry(ActionEvent event) throws IOException {
		 root = FXMLLoader.load(getClass().getResource("UI/GiveQuerry1.fxml"));
		 stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		 scene = new Scene(root);
		 stage.setScene(scene);
		 stage.show();
			 }
	public void REPLY(ActionEvent event) throws IOException {
		root = FXMLLoader.load(getClass().getResource("UI/ViewQuerryReply.fxml"));
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
