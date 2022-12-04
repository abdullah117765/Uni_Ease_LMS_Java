package application;

import java.io.IOException;
import java.util.ArrayList;

import BusinessLogic.Course;
import BusinessLogic.CourseRegister;
import BusinessLogic.Courseoffer;
import BusinessLogic.Student;
import BusinessLogic.TTC;
import BusinessLogic.Teacher;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.stage.Stage;

public class ControllerRegisterCourse {

	@FXML
	private TextField CourseId;
	@FXML
    private TextField Semester;
	@FXML
	private TextField Department;
	@FXML
	private TextField Batchid;
	
	 @FXML
		private Tab OCPortion;
		@FXML
		private Tab RCPortion;
	 
	@FXML
	private TableView<CourseRegister> RegisteredCourseTable;
	@FXML
	private TableView<Courseoffer > offerCourseTable;


	 private Stage stage;
	 private Scene scene;
	 private Parent root;
	 
	
	
	@FXML
	private TableColumn<Courseoffer ,String> offerCourseIdColumn;
	@FXML
	private TableColumn<Courseoffer ,String>offersemesterColumn;
	@FXML
	private TableColumn<Courseoffer , String> offersBatchidColumn;
	@FXML
	private TableColumn<Courseoffer , String> offersDepartmentColumn;
	
	@FXML
	private TableColumn<CourseRegister,String> RegCourseIdColumn;
	@FXML
	private TableColumn<CourseRegister,String> RegStudentIdColumn;
	@FXML
	private TableColumn<CourseRegister, String>RegBatchIdColumn;
	@FXML
	private TableColumn<CourseRegister, String> RegSemesterColumn;
	@FXML
	private TableColumn<CourseRegister, String> RegDepartmentColumn;
	
	
	
	 
		public void DisplayRegisteredCourse(ArrayList<CourseRegister> courseregisterlist) {

			RegCourseIdColumn.setCellValueFactory(new PropertyValueFactory <CourseRegister , String>("CourseId"));
			RegBatchIdColumn.setCellValueFactory(new PropertyValueFactory <CourseRegister , String>("BatchId"));
			RegStudentIdColumn.setCellValueFactory(new PropertyValueFactory <CourseRegister , String>("StudentId"));
		    RegDepartmentColumn.setCellValueFactory(new PropertyValueFactory <CourseRegister , String>("Department"));
			RegSemesterColumn.setCellValueFactory(new PropertyValueFactory <CourseRegister , String>("Semid"));

	for(int i=0;i<courseregisterlist.size();i++) {
		RegisteredCourseTable.getItems().add(courseregisterlist.get(i));
	}
		}
	 
			
	 
	public void DisplayofferedCourse(ArrayList<Courseoffer > courseofferlist) {
			
		offerCourseIdColumn.setCellValueFactory(new PropertyValueFactory <Courseoffer  , String>("courseId"));
		offersBatchidColumn.setCellValueFactory(new PropertyValueFactory <Courseoffer  , String>("BatchId"));
		offersDepartmentColumn.setCellValueFactory(new PropertyValueFactory <Courseoffer  , String>("Department"));
		offersemesterColumn.setCellValueFactory(new PropertyValueFactory <Courseoffer  , String>("semId"));

	for(int i=0;i<courseofferlist.size();i++) {
		offerCourseTable.getItems().add(courseofferlist.get(i));
	}
		}
	 
	 
	
		

	
	 public void Display(ActionEvent event) throws IOException {

			if(Semester.getText().isEmpty() && Batchid.getText().isEmpty() && Department.getText().isEmpty() && CourseId.getText().isEmpty() ) {

				 Alert alert1= new Alert(AlertType.WARNING);
				   alert1.setTitle("Warning");
				   alert1.setHeaderText("Fill all the text fields first");
				   alert1.showAndWait();
			}
			else {
				
				if(OCPortion.isSelected()) {
				 ArrayList<Courseoffer > courseofferlist1=TTC.getInstance().DisplayOfferCourse(Semester.getText(),Batchid.getText(), CourseId.getText(),Department.getText());
				
				if(courseofferlist1==null) {
					 Alert alert1= new Alert(AlertType.WARNING);
				   alert1.setTitle("Warning");
				   alert1.setHeaderText("No Courses Offered Yet");
				   alert1.showAndWait();
				}
				else
					DisplayofferedCourse(courseofferlist1);;
			}

			if(RCPortion.isSelected()) {
				 ArrayList<CourseRegister > courseregiseterlist1=TTC.getInstance().DisplayRegisterCourse(Semester.getText(),Batchid.getText(),Department.getText(), CourseId.getText());
					
					if(courseregiseterlist1 == null) {
						 Alert alert1= new Alert(AlertType.WARNING);
					   alert1.setTitle("Warning");
					   alert1.setHeaderText("No Courses Registered Yet");
					   alert1.showAndWait();
					}
					else
						 DisplayRegisteredCourse(courseregiseterlist1);;
			}
			}		
	 }
	
	
	
	 public void Reset(ActionEvent event) throws IOException {
			if(CourseId.getText().isBlank() || Semester.getText().isBlank() || Department.getText().isBlank()){
				Alert alert1= new Alert(AlertType.WARNING);
				alert1.setTitle("Warning");
				alert1.setHeaderText("fill all text field first");
				alert1.showAndWait();
			}else {
				CourseId.clear();
				Semester.clear();
				Department.clear();
			}
		 }
	 
	 public void Back(ActionEvent event) throws IOException {
		 root = FXMLLoader.load(getClass().getResource("UI/StudentHomePage.fxml"));
		  stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		  scene = new Scene(root);
		  stage.setScene(scene);
		  stage.show();
		 }
	
	
	 public void Addcourse(ActionEvent event) throws IOException {
		 
		 if(Semester.getText().isEmpty() || Batchid.getText().isEmpty() || Department.getText().isEmpty() || CourseId.getText().isEmpty() ) {

			 Alert alert1= new Alert(AlertType.WARNING);
			   alert1.setTitle("Warning");
			   alert1.setHeaderText("Fill all the text fields first");
			   alert1.showAndWait();
		}
		else {
			 ArrayList<Course> cc = TTC.getInstance().SearchCourse(CourseId.getText());

			 int check451 = TTC.getInstance().SearchofferCourse(Semester.getText(), Batchid.getText(), CourseId.getText(), Department.getText());
			 if (check451 == -1) {
				 Alert alert1 = new Alert(AlertType.WARNING);
				 alert1.setTitle("Warning");
				 alert1.setHeaderText("This course is not offered yet");
				 alert1.showAndWait();
			 }else{


			if(RCPortion.isSelected()) {
				 int check52=TTC.getInstance().SearchRegisterCourse(Semester.getText(),Batchid.getText(),Department.getText(), CourseId.getText());
				 
				 if(check52==-1) {
			int check11=	TTC.getInstance().RegisterCourse(Semester.getText(),Batchid.getText(),Department.getText(), CourseId.getText());
			
			if(check11==-1) {
				 Alert alert1= new Alert(AlertType.WARNING);
				   alert1.setTitle("Warning");
				   alert1.setHeaderText("Failed to regiseter course");
				   alert1.showAndWait();
				
			}else {
				
				 Alert alert1= new Alert(AlertType.WARNING);
				   alert1.setTitle("Warning");
				   alert1.setHeaderText("Course Registered Successfully");
				   alert1.showAndWait();
			}
			 }
				 else {
					 
					 Alert alert1= new Alert(AlertType.WARNING);
					   alert1.setTitle("Warning");
					   alert1.setHeaderText("A Course with this Credentials is already registered");
					   alert1.showAndWait(); 
					 
				 }
			}else {
				
				 Alert alert1= new Alert(AlertType.WARNING);
				   alert1.setTitle("Warning");
				   alert1.setHeaderText("Select Regester Table first");
				   alert1.showAndWait();
				
			}
			
		}

	 }
		 RegisteredCourseTable.getItems().clear();
		 offerCourseTable.getItems().clear();
		}
	

public void Droppingcourse(ActionEvent event) throws IOException {
	
	
	if(RCPortion.isSelected()) {
		
		 if(Semester.getText().isEmpty() || Batchid.getText().isEmpty() || Department.getText().isEmpty() || CourseId.getText().isEmpty() ) {

			 Alert alert1= new Alert(AlertType.WARNING);
			   alert1.setTitle("Warning");
			   alert1.setHeaderText("Fill all the text fields first");
			   alert1.showAndWait();
		}
		else {
			
			int course=	TTC.getInstance().SearchRegisterCourse(Semester.getText(),Batchid.getText(),Department.getText(), CourseId.getText());
			
			if(course==-1) {
				Alert alert1= new Alert(AlertType.WARNING);
				   alert1.setTitle("Warning");
				   alert1.setHeaderText("NO course with this id");
				   alert1.showAndWait(); 
			}
			else {
			int check=	TTC.getInstance().unregisterCourse(Semester.getText(),Batchid.getText(),Department.getText(), CourseId.getText());
			
			if( check==-1) {
				 Alert alert1= new Alert(AlertType.WARNING);
				   alert1.setTitle("Warning");
				   alert1.setHeaderText("Failed to unregister Course");
				   alert1.showAndWait(); 
				
			}else {
				
				 Alert alert1= new Alert(AlertType.WARNING);
				   alert1.setTitle("Warning");
				   alert1.setHeaderText("Course unRegister Successfully");
				   alert1.showAndWait(); 			
			}
			}		
		}		
	}else {
		 Alert alert1= new Alert(AlertType.WARNING);
		   alert1.setTitle("Warning");
		   alert1.setHeaderText("Select Regester Table first");
		   alert1.showAndWait();	
	}
	RegisteredCourseTable.getItems().clear();
	offerCourseTable.getItems().clear();
	 }
	




}
