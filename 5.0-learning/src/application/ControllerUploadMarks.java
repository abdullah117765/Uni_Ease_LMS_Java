package application;

import java.io.IOException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.ResourceBundle;

import BusinessLogic.AssignTeacher;
import BusinessLogic.Attendance;
import BusinessLogic.Marks;
import BusinessLogic.Student;
import BusinessLogic.TTC;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.stage.Stage;

public class ControllerUploadMarks {


	@FXML
	private TextField StudentId;
	@FXML
    private TextField TMarks;
	@FXML
	private TextField OMarks;
	@FXML
	private TextField Type;
	 @FXML
		private TableView<Student> StudentTable;
	
		@FXML
		private TableColumn<Student, String> StudentName;
		@FXML
		private TableColumn<Student, String> StudentSection;
		@FXML
		private TableColumn<Student, String> StudentRollNumber;
		@FXML
		private TableColumn<Student, String> StudentDepartment;
		@FXML
		private TableColumn<Student, String> StudentPhoneNumber;

	 private String curruser2; 
	 ArrayList<AssignTeacher>  Assignedcourse1 = new ArrayList<AssignTeacher>();
	 private Stage stage;
	 private Scene scene;
	 private Parent root;
	 private int actualindex=0;
	 // for Course selection
		@FXML
		private ChoiceBox<String> myChoiceBox2;
		
		private ArrayList<String> Userselect2=new ArrayList<String>();

		ArrayList<Student> studentlist=new ArrayList<Student>();
		
		public void Display() {
				    	        
			 for(int i=0;i<Assignedcourse1.size();i++) {
				  if(Assignedcourse1.get(i).getCourseId().equalsIgnoreCase( myChoiceBox2.getValue()));{
				  actualindex=i; break;}
			  }
		 studentlist=	TTC.getInstance().Displayallstudentsforattendence(Assignedcourse1.get(actualindex).getSemid(),Assignedcourse1.get(actualindex).getBatchId(),Assignedcourse1.get(actualindex).getDepartment(),Assignedcourse1.get(actualindex).getCourseId());
			if(studentlist== null || studentlist.isEmpty()){
				Alert alert1= new Alert(AlertType.WARNING);
				alert1.setTitle("Warning");
				alert1.setHeaderText("No students are registered in this course yet");
				alert1.showAndWait();
			}
		else{
		 StudentPhoneNumber.setCellValueFactory(new PropertyValueFactory <Student , String>("phoneNo"));
		 StudentSection.setCellValueFactory(new PropertyValueFactory <Student , String>("Section"));
		 StudentName.setCellValueFactory(new PropertyValueFactory <Student , String>("Name"));
			StudentRollNumber.setCellValueFactory(new PropertyValueFactory <Student , String>("RollNo"));
			StudentDepartment.setCellValueFactory(new PropertyValueFactory <Student , String>("Department"));
				
			
			 for(int i=0;i<studentlist.size();i++) {
				 StudentTable.getItems().add(studentlist.get(i));
			}
		}}
		
		
		
		
			public void initialize() {
				
				  Assignedcourse1 =TTC.getInstance().DisplayallCoursesAssignedtoteacher();

				if (Assignedcourse1.isEmpty() || Assignedcourse1 == null) {
					Alert alert1 = new Alert(AlertType.WARNING);
					alert1.setTitle("Warning");
					alert1.setHeaderText("NO courses assigned to  you yet");
					alert1.showAndWait();
				} else {


					for(int i=0;i<Assignedcourse1.size();i++) {
						Userselect2.add(Assignedcourse1.get(i).getCourseId());
					}
					myChoiceBox2.getItems().addAll(Userselect2);
					myChoiceBox2.setValue("Select");
					myChoiceBox2.setOnAction(this::getuser2);


				}
			}
			
			public void getuser2(ActionEvent event) {
			 curruser2 = myChoiceBox2.getValue();
				
			}

	 public void Back(ActionEvent event) throws IOException {
		 root = FXMLLoader.load(getClass().getResource("UI/TeacherMenu.fxml"));
		  stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		  scene = new Scene(root);
		  stage.setScene(scene);
		  stage.show();
		 }
	
	 public void UpdateMarks(ActionEvent event) throws IOException {
		 if(  StudentId.getText().isEmpty() || TMarks.getText().isEmpty() || OMarks.getText().isEmpty() || Type.getText().isEmpty()) {
			 Alert alert1= new Alert(AlertType.WARNING);
			   alert1.setTitle("Warning");
			   alert1.setHeaderText("Fill all the Textfield first");
			   alert1.showAndWait(); 
		}
		else {
		int check=TTC.getInstance().UpdateMarks( Assignedcourse1.get(actualindex).getSemid(),Assignedcourse1.get(actualindex).getBatchId(),Assignedcourse1.get(actualindex).getDepartment(),Assignedcourse1.get(actualindex).getCourseId(),StudentId.getText(),Type.getText(),TMarks.getText(), OMarks.getText());
		if(check==-1) {
			 Alert alert1= new Alert(AlertType.WARNING);
			   alert1.setTitle("Warning");
			   alert1.setHeaderText("Failed Update marks");
			   alert1.showAndWait();
		}else {
			 Alert alert1= new Alert(AlertType.WARNING);
			   alert1.setTitle("Warning");
			   alert1.setHeaderText("Marks Updated Successfully");
			   alert1.showAndWait();
		}
		
		} 
	 }
	
	
public void SaveMarks(ActionEvent event) throws IOException {
	if( StudentId.getText().isEmpty() || TMarks.getText().isEmpty() || OMarks.getText().isEmpty() || Type.getText().isEmpty()) {
		 Alert alert1= new Alert(AlertType.WARNING);
		   alert1.setTitle("Warning");
		   alert1.setHeaderText("Fill all the Textfield first");
		   alert1.showAndWait(); 
	}
	else {
		int check91= TTC.getInstance().SearchRegisterCourse1(Assignedcourse1.get(actualindex).getSemid(),Assignedcourse1.get(actualindex).getBatchId(),Assignedcourse1.get(actualindex).getDepartment(),Assignedcourse1.get(actualindex).getCourseId(),StudentId.getText());
if(check91==-1){
	Alert alert1= new Alert(AlertType.WARNING);
	alert1.setTitle("Warning");
	alert1.setHeaderText("This student is not in your class");
	alert1.showAndWait();
}else{
		int check=TTC.getInstance().AddMarks ( Assignedcourse1.get(actualindex).getSemid(),Assignedcourse1.get(actualindex).getBatchId(),Assignedcourse1.get(actualindex).getDepartment(),Assignedcourse1.get(actualindex).getCourseId(),StudentId.getText(),Type.getText(),TMarks.getText(), OMarks.getText());
	if(check==-1) {
		 Alert alert1= new Alert(AlertType.WARNING);
		   alert1.setTitle("Warning");
		   alert1.setHeaderText("Failed Upload marks");
		   alert1.showAndWait();
	}else {
		 Alert alert1= new Alert(AlertType.WARNING);
		   alert1.setTitle("Warning");
		   alert1.setHeaderText("Marks Uploaded Successfully");
		   alert1.showAndWait();
	}
	
	} }
	
	 }
	

public void Reset(ActionEvent event) throws IOException {
	if( StudentId.getText().isBlank() || TMarks.getText().isBlank() || TMarks.getText().isBlank() ||OMarks.getText().isBlank() || Type.getText().isBlank()){
		Alert alert1= new Alert(AlertType.WARNING);
		alert1.setTitle("Warning");
		alert1.setHeaderText("Filll all the text field first");
		alert1.showAndWait();
	}else{
	 StudentId.clear();
     TMarks.clear();
	OMarks.clear();
	  Type.clear();
	  
	 }}


	public void Display2(ActionEvent event) throws IOException {
		StudentTable.getItems().clear();
		Display();  // for showing all students in table

	}






}
