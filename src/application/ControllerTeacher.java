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
import javafx.stage.Stage;

public class ControllerTeacher {

	@FXML
	private TextField Name;
	@FXML
	private TextField Passward;
	@FXML
    private TextField TeacherId;
	@FXML
	private TextField Salary;
	@FXML
	private TextField PhoneNumber;
	

	
	 private Stage stage;
	 private Scene scene;
	 private Parent root;
	 
	
	 
	 
	
	
	 public void MakeAccount(ActionEvent event) throws IOException {


		 if(Name.getText().isEmpty() || Passward.getText().isEmpty()  || TeacherId.getText().isEmpty() || Salary.getText().isEmpty() || PhoneNumber.getText().isEmpty()){
			 Alert alert1= new Alert(AlertType.WARNING);
			   alert1.setTitle("Warning");
			   alert1.setHeaderText("Fill all the Textfield first");
			   alert1.showAndWait(); 
		}
		else	{
			
			int check2=	TTC.getInstance().SearchTeacher(TeacherId.getText());
		 
		 if(check2==-1) {
	int check1=	 TTC.getInstance().addTeacher(Name.getText(), Passward.getText(),TeacherId.getText(),Salary.getText(),PhoneNumber.getText());
	
	if(check1==-1) {
		 Alert alert1= new Alert(AlertType.WARNING);
		   alert1.setTitle("Warning");
		   alert1.setHeaderText("Failed to add teacher");
		   alert1.showAndWait();
		
	}else {
		
		 Alert alert1= new Alert(AlertType.WARNING);
		   alert1.setTitle("Warning");
		   alert1.setHeaderText("Teacher added Successfully");
		   alert1.showAndWait();
	}
	 }
		 else {
			 
			 Alert alert1= new Alert(AlertType.WARNING);
			   alert1.setTitle("Warning");
			   alert1.setHeaderText("A Teacher with this Teacher id  already exist");
			   alert1.showAndWait(); 
			 
		 }
		 
		 
	 }	 
		 
		 
		 }
	 

	 
	
	 public void Reset(ActionEvent event) throws IOException {
		 if(!Name.getText().isBlank() || !Passward.getText().isBlank() || !TeacherId.getText().isBlank() || !Salary.getText().isBlank() || !PhoneNumber.getText().isBlank() ) {
		 Name.clear();
		 Passward.clear();
		 TeacherId.clear();
		 Salary.clear();
		 PhoneNumber.clear();	
		 }else {
			 Alert alert1= new Alert(AlertType.WARNING);
			   alert1.setTitle("Warning");
			   alert1.setHeaderText("first fill all text fields to Reset");
			   alert1.showAndWait();
		 }
		 
		 }
	
	 public void Back(ActionEvent event) throws IOException {
		 root = FXMLLoader.load(getClass().getResource("UI/AdminMenu.fxml"));
		  stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		  scene = new Scene(root);
		  stage.setScene(scene);
		  stage.show();
		 }
	
	
	
	
	
	
}
