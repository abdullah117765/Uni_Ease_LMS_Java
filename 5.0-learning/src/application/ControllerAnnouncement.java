package application;

import java.io.IOException;

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
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextArea;
public class ControllerAnnouncement {

	@FXML
	private TextArea Announcement;
	@FXML
	private TextField teacher;

	@FXML
	private TextField student;
	
	 private Stage stage;
	 private Scene scene;
	 private Parent root;
	String x="NO";
	String y="NO";
	
	 public void Announce(ActionEvent event) throws IOException {

		 if(Announcement==null || Announcement.getText().isBlank()) {

			 Alert alert1= new Alert(AlertType.WARNING);
			   alert1.setTitle("Warning");
			   alert1.setHeaderText("Announce something first");
			   alert1.showAndWait();
		 }else {
			 if(teacher.getText().isBlank() && student.getText().isBlank()){
				 TTC.getInstance().MakeAnnouncement(Announcement.getText(), x, y);}
			 else {

				 if (!teacher.getText().isBlank()) {
					 x = "yes";}
				 if (!student.getText().isBlank()) {
					 y = "yes";}
			 }
			 int x1=	 TTC.getInstance().MakeAnnouncement(Announcement.getText(), x, y);
			 if(x1!=-1){
				 Alert alert1= new Alert(AlertType.WARNING);
				 alert1.setTitle("Warning");
				 alert1.setHeaderText("Announce delievered Successfully");
				 alert1.showAndWait();
			 }
		 }


	 }
	// checkBox.setSelected(true);
	
	 public void Reset(ActionEvent event) throws IOException {
		 if(Announcement.getText().isBlank() ){
			 Alert alert1= new Alert(AlertType.WARNING);
			 alert1.setTitle("Warning");
			 alert1.setHeaderText("enter something in the field first");
			 alert1.showAndWait();
		 }else{
		 Announcement.clear();
		 teacher.clear();
		 student.clear();
		 }}
	
	 public void Back(ActionEvent event) throws IOException {
		 root = FXMLLoader.load(getClass().getResource("UI/AdminMenu.fxml"));
		  stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		  scene = new Scene(root);
		  stage.setScene(scene);
		  stage.show();
		 }
	
	
	
	
	
	
}
