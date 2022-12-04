package application;

import java.io.IOException;

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
import BusinessLogic.TTC;

public class ControllerAdmin {

	@FXML
	private TextField Name;
	@FXML
	private TextField Passward;
	@FXML
    private TextField AdminId;
	@FXML
	private TextField Salary;
	@FXML
	private TextField PhoneNumber;

	
	
	 private Stage stage;
	 private Scene scene;
	 private Parent root;
	 
	
	 
	 public void MakeAccount(ActionEvent event) throws IOException {
		
		 

		 if(Name.getText().isEmpty() || Passward.getText().isEmpty()  || AdminId.getText().isEmpty() || Salary.getText().isEmpty() ||  PhoneNumber.getText().isEmpty()){
			 Alert alert1= new Alert(AlertType.WARNING);
			   alert1.setTitle("Warning");
			   alert1.setHeaderText("Fill all the Textfield first");
			   alert1.showAndWait(); 
		}
		else	{
			
			int check2=	TTC.getInstance().SearchStudent(AdminId.getText());
		 
		 if(check2==-1) {
	int check1=	  TTC.getInstance().addAdmin(AdminId.getText(),Name.getText(), Passward.getText(),Salary.getText(),PhoneNumber.getText());
	
	if(check1==-1) {
		 Alert alert1= new Alert(AlertType.WARNING);
		   alert1.setTitle("Warning");
		   alert1.setHeaderText("Failed to add Administration member");
		   alert1.showAndWait();
		
	}else {
		
		 Alert alert1= new Alert(AlertType.WARNING);
		   alert1.setTitle("Warning");
		   alert1.setHeaderText("Administration member added Successfully");
		   alert1.showAndWait();
	}
	 }
		 else {
			 
			 Alert alert1= new Alert(AlertType.WARNING);
			   alert1.setTitle("Warning");
			   alert1.setHeaderText("A Administration member with this Admin id  already exist");
			   alert1.showAndWait(); 
			 
		 }
		 
		 
	 }	 
		 
		 
		 }
	
	 public void Reset(ActionEvent event) throws IOException {
		if(Name.getText().isBlank() || AdminId.getText().isBlank() || PhoneNumber.getText().isBlank() || Passward.getText().isBlank() || Salary.getText().isBlank()){
			Alert alert1= new Alert(AlertType.WARNING);
			alert1.setTitle("Warning");
			alert1.setHeaderText("Fill all the textfield first");
			alert1.showAndWait();
		}else{
			Name.clear();
			AdminId.clear();
			PhoneNumber.clear();
			Passward.clear();
			Salary.clear();		
		 }}
	
	 public void Back(ActionEvent event) throws IOException {
		 root = FXMLLoader.load(getClass().getResource("UI/AdminMenu.fxml"));
		  stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		  scene = new Scene(root);
		  stage.setScene(scene);
		  stage.show();
		 }
	
	
	 
	
	
	
	
	
	
}
