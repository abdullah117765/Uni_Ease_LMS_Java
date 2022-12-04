package application;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import BusinessLogic.Attendance;
import BusinessLogic.CourseRegister;
import BusinessLogic.Marks;
import BusinessLogic.TTC;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class ControllerViewMarks {

	 @FXML
		private TableColumn< Marks, String>  Type;
	 @FXML
		private TableColumn< Marks, String>  Obtained;
	 @FXML
		private TableColumn< Marks, String>  Total;
	 @FXML
		private TableView<Marks> MarksTable;
	ArrayList<Marks> marks =new ArrayList<Marks>();
	 ArrayList<CourseRegister> cr =new ArrayList<CourseRegister>();
	 private int actualindex=0;
	 private String curruser1; 
	 private Stage stage;
	 private Scene scene;
	 private Parent root;
	 
	
	 
	// for Type Selection
			@FXML
			private ChoiceBox<String> myChoiceBox1;
			
			private ArrayList<String> Userselect1 = new ArrayList<String>();

			public void initialize() {

				cr = TTC.getInstance().DisplayallCoursesRegisteredByStudent();
				if (cr == null || cr.isEmpty()) {
					Alert alert1 = new Alert(Alert.AlertType.WARNING);
					alert1.setTitle("Warning");
					alert1.setHeaderText("you have not registered any course yet");
					alert1.showAndWait();
				}else{
					for (int i = 0; i < cr.size(); i++) {
						Userselect1.add(cr.get(i).getCourseId());
					}
				myChoiceBox1.getItems().addAll(Userselect1);
				myChoiceBox1.setValue("Select");
				myChoiceBox1.setOnAction(this::getuser1);

			}
				
			}
			
			public void getuser1(ActionEvent event) {
				
			 curruser1 = myChoiceBox1.getValue();
				
			}
	
	
	 
	 public void Back(ActionEvent event) throws IOException {
		 root = FXMLLoader.load(getClass().getResource("UI/StudentHomePage.fxml"));
		  stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		  scene = new Scene(root);
		  stage.setScene(scene);
		  stage.show();
		 }

	public void Display2(ActionEvent event) throws IOException {
		MarksTable.getItems().clear();
		String s = myChoiceBox1.getValue();

		for (int i = 0; i < cr.size(); i++) {
			if (cr.get(i).getCourseId().equalsIgnoreCase(myChoiceBox1.getValue())) ;
			{
				actualindex = i;
				break;
			}
		}
		if (myChoiceBox1.getValue().equalsIgnoreCase("Select")) {
			Alert alert1 = new Alert(Alert.AlertType.WARNING);
			alert1.setTitle("Warning");
			alert1.setHeaderText("Select course first");
			alert1.showAndWait();
		} else {
			//for(int i=0;i<cr.size();i++) {
			marks = TTC.getInstance().DisplayMarks(cr.get(actualindex).getSemid(), cr.get(actualindex).getBatchId(), cr.get(actualindex).getDepartment(), myChoiceBox1.getValue());
			//}
			if (marks == null || marks.isEmpty()) {
				Alert alert1 = new Alert(Alert.AlertType.WARNING);
				alert1.setTitle("Warning");
				alert1.setHeaderText("NO marsk have been uploaded yet");
				alert1.showAndWait();
			} else {

				Type.setCellValueFactory(new PropertyValueFactory<Marks, String>("Type"));
				Obtained.setCellValueFactory(new PropertyValueFactory<Marks, String>("OMarks"));
				Total.setCellValueFactory(new PropertyValueFactory<Marks, String>("TMarks"));

				for (int i = 0; i < marks.size(); i++) {
					MarksTable.getItems().add(marks.get(i));
				}
			}
		}

	}
}
