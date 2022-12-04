package application;

import BusinessLogic.Attendance;
import BusinessLogic.CourseRegister;
import BusinessLogic.TTC;
import BusinessLogic.TeacherBacklog;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.awt.event.ActionEvent;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class ControllergiveQuerry {

	@FXML
	private TextField Querry;

	@FXML
	private ChoiceBox<String> myChoiceBox;

	private Stage stage;
	private Scene scene;
	private Parent root;
	ArrayList<CourseRegister> cr =new ArrayList<CourseRegister>();
	private String curruser;
	private int actualindex=0;

	private ArrayList<String> Userselect= new ArrayList<String>() ;



	public void initialize() {

		cr=TTC.getInstance().DisplayallCoursesRegisteredByStudent();
if(cr==null || cr.isEmpty()){
	Alert alert1= new Alert(Alert.AlertType.WARNING);
	alert1.setTitle("Warning");
	alert1.setHeaderText("you have not registered any course yet");
	alert1.showAndWait();
}else{
		for(int i=0;i<cr.size();i++) {
			Userselect.add(cr.get(i).getCourseId());
		}



		myChoiceBox.getItems().addAll(Userselect);
		myChoiceBox.setValue("Select");
		myChoiceBox.setOnAction(this::getuser);

	}}

	public void getuser(javafx.event.ActionEvent event) {

		curruser = myChoiceBox.getValue();

	}


	public void Back(javafx.event.ActionEvent event) throws IOException {
		root = FXMLLoader.load(getClass().getResource("UI/StudentHomePage.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}


	public void Givequerrytoteacher(javafx.event.ActionEvent event) throws IOException {
if(Querry.getText().isBlank()){
	Alert alert1= new Alert(Alert.AlertType.WARNING);
	alert1.setTitle("Warning");
	alert1.setHeaderText("Enter something in the text field first");
	alert1.showAndWait();
}else {
	if (myChoiceBox.getValue().equalsIgnoreCase("Select")) {
		Alert alert1= new Alert(Alert.AlertType.WARNING);
		alert1.setTitle("Warning");
		alert1.setHeaderText("Select a course first to give querry");
		alert1.showAndWait();
	}else{
	String s = myChoiceBox.getValue();


	for (int i = 0; i < cr.size(); i++) {
		if (cr.get(i).getCourseId().equalsIgnoreCase(myChoiceBox.getValue())) ;
		{
			actualindex = i;
			break;
		}
	}

	int check = TTC.getInstance().ADDQuerry(cr.get(actualindex).getSemid(), cr.get(actualindex).getBatchId(), cr.get(actualindex).getDepartment(), cr.get(actualindex).getCourseId(), Querry.getText());
	if (check != -1) {
		Alert alert1 = new Alert(Alert.AlertType.WARNING);
		alert1.setTitle("Warning");
		alert1.setHeaderText("Query Delievered");
		alert1.showAndWait();
	} else {
		Alert alert1 = new Alert(Alert.AlertType.WARNING);
		alert1.setTitle("Warning");
		alert1.setHeaderText("Failed to Deleiverd your Query");
		alert1.showAndWait();
	}
}
}
	}






}
