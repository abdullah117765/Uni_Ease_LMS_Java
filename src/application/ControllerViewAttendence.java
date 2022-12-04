package application;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import BusinessLogic.Attendance;
import BusinessLogic.CourseRegister;
import BusinessLogic.Student;
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

public class ControllerViewAttendence {

	@FXML
	private TextArea TGiveQuerry;
private int actualindex=0;
	
	
	 private Stage stage;
	 private Scene scene;
	 private Parent root;
	 private String curruser; 
	
	 @FXML
		private TableColumn< Attendance, String>  Attendence;
	 @FXML
		private TableColumn< Attendance, String>  Date;
	 @FXML
		private TableView<Attendance> ViewAttendence;
	 ArrayList<CourseRegister> cr;

		@FXML
		private ChoiceBox<String> myChoiceBox;
		
		private ArrayList<String> Userselect= new ArrayList<String>() ;
	ArrayList<Attendance> attend =new ArrayList<Attendance>();


	public void initialize() {
			
		cr=TTC.getInstance().DisplayallCoursesRegisteredByStudent();
			if (cr == null || cr.isEmpty()) {
				Alert alert1 = new Alert(Alert.AlertType.WARNING);
				alert1.setTitle("Warning");
				alert1.setHeaderText("NO courses registered  by  you yet");
				alert1.showAndWait();
			} else {


				for (int i = 0; i < cr.size(); i++) {
					Userselect.add(cr.get(i).getCourseId());
				}


				myChoiceBox.getItems().addAll(Userselect);
				myChoiceBox.setValue("Select");
				myChoiceBox.setOnAction(this::getuser);
			}
	
}
		
		public void getuser(ActionEvent event) {
			
		 curruser = myChoiceBox.getValue();
			
		}
	 
	
	
	
	
	 public void Back(ActionEvent event) throws IOException {
		 root = FXMLLoader.load(getClass().getResource("UI/StudentHomePage.fxml"));
		  stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		  scene = new Scene(root);
		  stage.setScene(scene);
		  stage.show();
		 }
	public void Display2(ActionEvent event) throws IOException {
		ViewAttendence.getItems().clear();
		String s=myChoiceBox.getValue();
		if(myChoiceBox.getValue().equalsIgnoreCase("Select")){
			Alert alert1= new Alert(Alert.AlertType.WARNING);
			alert1.setTitle("Warning");
			alert1.setHeaderText("selcet Course first");
			alert1.showAndWait();
		}else{

			for(int i=0;i<cr.size();i++) {
				if(cr.get(i).getCourseId().equalsIgnoreCase( myChoiceBox.getValue()));{
					actualindex=i; break;}
			}

			for(int i=0;i<cr.size();i++) {
				attend=	TTC.getInstance().Viewattendence(cr.get(actualindex).getSemid(), cr.get(actualindex).getBatchId(), cr.get(actualindex).getDepartment(), cr.get(actualindex).getCourseId());
			}
			if(attend==null || attend.isEmpty()){
				Alert alert1= new Alert(Alert.AlertType.WARNING);
				alert1.setTitle("Warning");
				alert1.setHeaderText("no attendence yet ");
				alert1.showAndWait();
			}
			else{
				Attendence.setCellValueFactory(new PropertyValueFactory <Attendance , String>("flagAttendance"));
				Date.setCellValueFactory(new PropertyValueFactory <Attendance , String>("Date"));

				for(int i=0;i<attend.size();i++) {
					ViewAttendence.getItems().add(attend.get(i));
				}

			}}

	}



}
