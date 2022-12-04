package application;

import java.io.IOException;
import java.util.ArrayList;

import BusinessLogic.Student;
import BusinessLogic.TTC;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.stage.Stage;

public class ControllerViewDetails {



	
	 private Stage stage;
	 private Scene scene;
	 private Parent root;

	@FXML
	private TableView<Student> StudentTable;
	@FXML
	private TableColumn<Student, String> StudentName;
	@FXML
	private TableColumn<Student, String> StudentSection;
	@FXML
	private TableColumn<Student, String> StudRollNumber;
	@FXML
	private TableColumn<Student, String> StudentDepartment;
	@FXML
	private TableColumn<Student, String> StudentPhoneNumber;


	public void DisplayStudent(ArrayList<Student> studentlist) {

		StudentPhoneNumber.setCellValueFactory(new PropertyValueFactory<Student , String>("phoneNo"));
		StudentPhoneNumber.setCellFactory(TextFieldTableCell.forTableColumn());
		StudentPhoneNumber.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<Student, String>>() {
			@Override
			public void handle(TableColumn.CellEditEvent<Student, String> event) {
				Student s = event.getRowValue();
				s.setPhoneNo(event.getNewValue());
				int check2=	TTC.getInstance().updateStudent(s ,1);
			}
		});
		StudentName.setCellValueFactory(new PropertyValueFactory <Student , String>("Name"));
		StudRollNumber.setCellValueFactory(new PropertyValueFactory <Student , String>("RollNo"));
		StudRollNumber.setVisible(true);
		StudentDepartment.setCellValueFactory(new PropertyValueFactory <Student , String>("Department"));
		StudentSection.setCellValueFactory(new PropertyValueFactory <Student , String>("Section"));
		StudentSection.setCellFactory(TextFieldTableCell.forTableColumn());
		StudentSection.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<Student, String>>() {
			@Override
			public void handle(TableColumn.CellEditEvent<Student, String> event) {
				Student s = event.getRowValue();
				s.setSection(event.getNewValue());
				int check2=	TTC.getInstance().updateStudent(s ,2);
			}
		});


		for(int i=0; i<studentlist.size();i++) {
			StudentTable.getItems().add(studentlist.get(i));
		}
	}
	public void initialize() {
		ArrayList<Student>  ss=TTC.getInstance().DisplayStudents2();
		DisplayStudent(ss);
	}


	public void Back(ActionEvent event) throws IOException {
		 root = FXMLLoader.load(getClass().getResource("UI/StudentHomePage.fxml"));
		  stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		  scene = new Scene(root);
		  stage.setScene(scene);
		  stage.show();
		 }
	
	
	



}
