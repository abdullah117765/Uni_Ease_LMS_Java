package application;

import BusinessLogic.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;


public class ControllerViewQuerryReply {


	 private Stage stage;
	 private Scene scene;
	 private Parent root;
	 
	 @FXML
		private TableColumn<Query, String>   Statement;
	@FXML
	private TableColumn<Query, String>   reply;

	@FXML
	private TableView<Query> QuerryReplyTable;
	ArrayList<Query> queries= new ArrayList<>();
	private String curruser;

	ArrayList<CourseRegister> cr =new ArrayList<CourseRegister>();
	private int actualindex=0;
	@FXML
	private ChoiceBox<String> myChoiceBox;

	private ArrayList<String> Userselect = new ArrayList<String>();


	public void Display(ArrayList<Query> qeu) {

		reply.setCellValueFactory(new PropertyValueFactory<Query, String>("Reply"));
		Statement.setCellValueFactory(new PropertyValueFactory<Query, String>("statement"));

		for(int i=0;i<qeu.size();i++) {
			QuerryReplyTable.getItems().add(qeu.get(i));
		}
	}




	 public void initialize() {

		 cr = TTC.getInstance().DisplayallCoursesRegisteredByStudent();
		 if (cr == null || cr.isEmpty()) {
			 Alert alert1 = new Alert(Alert.AlertType.WARNING);
			 alert1.setTitle("Warning");
			 alert1.setHeaderText("you have not registered any course yet");
			 alert1.showAndWait();
		 }else{
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
		QuerryReplyTable.getItems().clear();
		String s = myChoiceBox.getValue();

		for (int i = 0; i < cr.size(); i++) {
			if (cr.get(i).getCourseId().equalsIgnoreCase(myChoiceBox.getValue())) ;
			{
				actualindex = i;
				break;
			}
		}
		if (myChoiceBox.getValue().equalsIgnoreCase("Select")) {
			Alert alert1 = new Alert(Alert.AlertType.WARNING);
			alert1.setTitle("Warning");
			alert1.setHeaderText("Select course first");
			alert1.showAndWait();
		} else {
			//	studentId,QueryId,Statement);
			queries = TTC.getInstance().ViewQuerry(cr.get(actualindex).getSemid(), cr.get(actualindex).getBatchId(), cr.get(actualindex).getDepartment(), cr.get(actualindex).getCourseId());

			if (queries== null || queries.isEmpty()) {
				Alert alert1 = new Alert(Alert.AlertType.WARNING);
				alert1.setTitle("Warning");
				alert1.setHeaderText("write some queries first");
				alert1.showAndWait();
			} else {
					Display(queries);
			}
		}
	}
	}
	

