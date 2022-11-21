package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class TeacherMenuController {

	
	
	
	 private Stage stage;
	 private Scene scene;
	 private Parent root;
	 
	
	 
	
	
	 public void Home(ActionEvent event) throws IOException {
		 root = FXMLLoader.load(getClass().getResource("UI/TeacherMenu.fxml"));
		  stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		  scene = new Scene(root);
		  stage.setScene(scene);
		  stage.show();
		 }
	
	 public void  Attendence(ActionEvent event) throws IOException {
		 root = FXMLLoader.load(getClass().getResource("UI/UploadAttendence.fxml"));
		  stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		  scene = new Scene(root);
		  stage.setScene(scene);
		  stage.show();
			 }
	
	 public void Marks(ActionEvent event) throws IOException {
		 root = FXMLLoader.load(getClass().getResource("UI/UploadMarks.fxml"));
		  stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		  scene = new Scene(root);
		  stage.setScene(scene);
		  stage.show();
			 }
	 
	 public void Announcement1(ActionEvent event) throws IOException {
		 root = FXMLLoader.load(getClass().getResource("UI/ViewAnnouncementTeacher.fxml"));
		 stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		 scene = new Scene(root);
		 stage.setScene(scene);
		 stage.show();
		 }
	
	
	 public void ViewQuerry(ActionEvent event) throws IOException {
		 root = FXMLLoader.load(getClass().getResource("UI/ViewQuerry1.fxml"));
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
	public void Queries(ActionEvent event) throws IOException {
		 root = FXMLLoader.load(getClass().getResource("UI/ViewQuerry1.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
}
