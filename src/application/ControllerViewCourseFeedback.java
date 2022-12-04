package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class ControllerViewCourseFeedback {

	@FXML
	private TextField CustomerId;

	@FXML
	private TextField Orderitem;
	@FXML
	private TextField Status;
	
	
	
	
	
	
	
	
	
	
	
	
	 private Stage stage;
	 private Scene scene;
	 private Parent root;
	 
	
	 
	
	
	 
	
	 public void Reset(ActionEvent event) throws IOException {
		
		CustomerId.clear();
		Orderitem.clear();
		Status.clear();
		

		 }
	
	 public void Back(ActionEvent event) throws IOException {
		 root = FXMLLoader.load(getClass().getResource("UI/Login.fxml"));
		  stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		  scene = new Scene(root);
		  stage.setScene(scene);
		  stage.show();
		 }
	
	 public void Remove(ActionEvent event) throws IOException {
		 System.out.println("Removed");
	 }
	
	
public void Updatestatus(ActionEvent event) throws IOException {
	System.out.println("Updating");
	 }
	
public void Acceptorder(ActionEvent event) throws IOException {
	System.out.println("Accepted");
}


public void Transfer(ActionEvent event) throws IOException {
	 System.out.println("Transfering");
}




}
