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

public class ControllerStudents {

	@FXML
	private TextField Name;
	@FXML
	private TextField Passward;
	@FXML
    private TextField RollNumber;
	@FXML
	private TextField Salary;
	@FXML
	private TextField PhoneNumber;
	@FXML
	private TextField Department;
	@FXML
	private TextField Section;
	
	
	
	 private Stage stage;
	 private Scene scene;
	 private Parent root;
	 
	
	
	 public void MakeAccount(ActionEvent event) throws IOException {
		
		if(Name.getText().isEmpty() && Passward.getText().isEmpty()  && RollNumber.getText().isEmpty() && Section.getText().isEmpty() && Department.getText().isEmpty() && PhoneNumber.getText().isEmpty()){
			 Alert alert1= new Alert(AlertType.WARNING);
			   alert1.setTitle("Warning");
			   alert1.setHeaderText("Fill all the Textfield first");
			   alert1.showAndWait(); 
		}
		else	{
			
			int check2=	TTC.getInstance().SearchStudent(RollNumber.getText());
		 
		 if(check2==-1) {
	int check1=	 TTC.getInstance().addStudent(Name.getText(), Passward.getText(),RollNumber.getText(),Section.getText(), Department.getText(),PhoneNumber.getText());
	
	if(check1==-1) {
		 Alert alert1= new Alert(AlertType.WARNING);
		   alert1.setTitle("Warning");
		   alert1.setHeaderText("Failed to add student");
		   alert1.showAndWait();
		
	}else {
		
		 Alert alert1= new Alert(AlertType.WARNING);
		   alert1.setTitle("Warning");
		   alert1.setHeaderText("Student added Successfully");
		   alert1.showAndWait();
	}
	 }
		 else {
			 
			 Alert alert1= new Alert(AlertType.WARNING);
			   alert1.setTitle("Warning");
			   alert1.setHeaderText("A Student with this student id  already exist");
			   alert1.showAndWait(); 
			 
		 }
		 
		 
	 }	 
		 
	 }



	public void Reset(ActionEvent event) throws IOException {
		if (Name.getText().isBlank() || Passward.getText().isBlank() || RollNumber.getText().isBlank()  || PhoneNumber.getText().isBlank() || Department.getText().isBlank() || Section.getText().isBlank()) {
			Alert alert1 = new Alert(AlertType.WARNING);
			alert1.setTitle("Warning");
			alert1.setHeaderText("Fill all the Textfield first");
			alert1.showAndWait();
		} else {
			Name.clear();
			RollNumber.clear();
			PhoneNumber.clear();
			Passward.clear();
			Department.clear();
			Section.clear();
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
