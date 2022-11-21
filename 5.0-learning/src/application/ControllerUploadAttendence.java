package application;


	import java.io.IOException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.ResourceBundle;
	import javafx.event.EventHandler;
	import javafx.scene.control.cell.TextFieldTableCell;
	import javafx.scene.control.TableColumn.CellEditEvent;
	import javafx.scene.control.TableColumn.CellEditEvent;
import BusinessLogic.Admin;
import BusinessLogic.AssignTeacher;
import BusinessLogic.Attendance;
import BusinessLogic.Student;
import BusinessLogic.TTC;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
	import javafx.scene.Parent;
	import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
	import java.io.IOException;
	import java.net.URL;
	import java.util.ResourceBundle;
	import BusinessLogic.TTC;
	import javafx.event.ActionEvent;
	import javafx.fxml.FXML;
	import javafx.fxml.FXMLLoader;
	import javafx.fxml.Initializable;
	import javafx.scene.Node;
	import javafx.scene.Parent;
	import javafx.scene.Scene;


public  class ControllerUploadAttendence {


	private String curruser;

	private Stage stage;
	private Scene scene;
	private Parent root;
	private int actualindex = 0;

	@FXML
	private TableColumn<Attendance, String> StudentRollNumber;
	@FXML
	private TableColumn<Attendance, String> flagAttendance1;
	@FXML
	private TableView<Attendance> AttendenceTable;
	int option = 2;
	@FXML
	private ChoiceBox<String> myChoiceBox;
	ArrayList<Student> studentlist = new ArrayList<Student>();
	private ArrayList<String> Userselect = new ArrayList<String>();
	ArrayList<AssignTeacher> Assignedcourse1 = new ArrayList<AssignTeacher>();
	DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
	Calendar cal = Calendar.getInstance();
	Date date = cal.getTime();
	String todaysdate = dateFormat.format(date);
	ArrayList<Attendance> wp = new ArrayList<Attendance>();
	ArrayList<Attendance> att1 = new ArrayList<Attendance>();
int rr=0;
	public void Display() {


		for (int i = 0; i < Assignedcourse1.size(); i++) {
			if (Assignedcourse1.get(i).getCourseId().equalsIgnoreCase(myChoiceBox.getValue())) ;
			{
				actualindex = i;
				break;
			}
		}

		studentlist = TTC.getInstance().Displayallstudentsforattendence(Assignedcourse1.get(actualindex).getSemid(), Assignedcourse1.get(actualindex).getBatchId(), Assignedcourse1.get(actualindex).getDepartment(), Assignedcourse1.get(actualindex).getCourseId());
		if (studentlist == null || studentlist.isEmpty()) {
			Alert alert1 = new Alert(AlertType.WARNING);
			alert1.setTitle("Warning");
			alert1.setHeaderText("NO students are registered to the course yet");
			alert1.showAndWait();
		} else {

			// adding attendence for all studetns

			for (int i = 0; i < studentlist.size(); i++) {
				ArrayList<Attendance> at3 = TTC.getInstance().searchAttendence(todaysdate, Assignedcourse1.get(actualindex).getSemid(), Assignedcourse1.get(actualindex).getBatchId(), Assignedcourse1.get(actualindex).getDepartment(), Assignedcourse1.get(actualindex).getCourseId(), studentlist.get(i).getRollNo());
				if (!at3.isEmpty() ) {
					Alert alert1 = new Alert(AlertType.WARNING);
					alert1.setTitle("Warning");
					alert1.setHeaderText("Attendence of this class for today has happened");
					alert1.showAndWait();
				}else {
					TTC.getInstance().AddAttendence(todaysdate, Assignedcourse1.get(actualindex).getSemid(), Assignedcourse1.get(actualindex).getBatchId(), Assignedcourse1.get(actualindex).getDepartment(), Assignedcourse1.get(actualindex).getCourseId(), studentlist.get(i).getRollNo());
				}
				att1 = TTC.getInstance().searchAttendence(todaysdate, Assignedcourse1.get(actualindex).getSemid(), Assignedcourse1.get(actualindex).getBatchId(), Assignedcourse1.get(actualindex).getDepartment(), Assignedcourse1.get(actualindex).getCourseId(), studentlist.get(i).getRollNo());

			}


		}

	}


	public void initialize() {

		Assignedcourse1 = TTC.getInstance().DisplayallCoursesAssignedtoteacher();
		if (Assignedcourse1 == null || Assignedcourse1.isEmpty() ) {
			Alert alert1 = new Alert(AlertType.WARNING);
			alert1.setTitle("Warning");
			alert1.setHeaderText("NO courses assigned to  you yet");
			alert1.showAndWait();
		} else {
			for (int i = 0; i < Assignedcourse1.size(); i++) {
				Userselect.add(Assignedcourse1.get(i).getCourseId());
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
		root = FXMLLoader.load(getClass().getResource("UI/TeacherMenu.fxml"));
		stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}


	public void Display2(ActionEvent event) throws IOException {
		AttendenceTable.getItems().clear();
		if (myChoiceBox.getValue().equalsIgnoreCase("Select")) {
			Alert alert1 = new Alert(AlertType.WARNING);
			alert1.setTitle("Warning");
			alert1.setHeaderText("select a course first");
			alert1.showAndWait();
		} else {
			Display();

			StudentRollNumber.setCellValueFactory(new PropertyValueFactory<Attendance, String>("studentId"));
			flagAttendance1.setCellValueFactory(new PropertyValueFactory<Attendance, String>("flagAttendance"));
			flagAttendance1.setCellFactory(TextFieldTableCell.forTableColumn());
			flagAttendance1.setOnEditCommit(new EventHandler<CellEditEvent<Attendance, String>>() {
				@Override
				public void handle(CellEditEvent<Attendance, String> event) {
					Attendance s = event.getRowValue();
					s.setFlagAttendance(event.getNewValue());


					if (s.getFlagAttendance().equalsIgnoreCase("yes")) {
						option = 1;
						TTC.getInstance().updateAttendence(todaysdate, Assignedcourse1.get(actualindex).getSemid(), Assignedcourse1.get(actualindex).getBatchId(), Assignedcourse1.get(actualindex).getDepartment(), Assignedcourse1.get(actualindex).getCourseId(), s.getStudentId(),option);

					} else if (s.getFlagAttendance().equalsIgnoreCase("NO")) {
						option = 2;
						TTC.getInstance().updateAttendence(todaysdate, Assignedcourse1.get(actualindex).getSemid(), Assignedcourse1.get(actualindex).getBatchId(), Assignedcourse1.get(actualindex).getDepartment(), Assignedcourse1.get(actualindex).getCourseId(), s.getStudentId(),option);

					} else {
						Alert alert1 = new Alert(AlertType.WARNING);
						alert1.setTitle("Warning");
						alert1.setHeaderText("value cannot be other than Yes or no");
						alert1.showAndWait();

					}
				}
			});


			for (int i = 0; i < studentlist.size(); i++) {
				AttendenceTable.getItems().add(att1.get(i));
			}
		}

	}


}
