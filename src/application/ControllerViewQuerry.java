package application;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import BusinessLogic.*;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class ControllerViewQuerry {
	private Stage stage;
	private Scene scene;
	private Parent root;
	@FXML
	private TableColumn<Query, String> studentid;
	@FXML
	private TableColumn<Query, String> Querry;
	@FXML
	private ChoiceBox<String> myChoiceBox;
	@FXML
	private TextField QuerryReply;
	@FXML
	private TableColumn<Query, String> courseid;
	@FXML
	private TableColumn<Query, String> Querryid;

	private ArrayList<String> Userselect =new ArrayList<String>();

	ArrayList<AssignTeacher>  Assignedcourse1 =new ArrayList<AssignTeacher>();
	private int actualindex=0;
	private String curruser;
	@FXML
	private TableView<Query> QuerryTable;
	ArrayList<Query> queries= new ArrayList<>();
	public void Display(ArrayList<Query> qeu) {

		courseid.setCellValueFactory(new PropertyValueFactory<Query, String>("CourseId"));
		Querryid.setCellValueFactory(new PropertyValueFactory<Query, String>("Queryid"));
		studentid.setCellValueFactory(new PropertyValueFactory<Query, String>("StudentId"));
		Querry.setCellValueFactory(new PropertyValueFactory<Query, String>("statement"));

		for(int i=0;i<qeu.size();i++) {
			QuerryTable.getItems().add(qeu.get(i));
		}
	}


	public void initialize() {


		Assignedcourse1 =TTC.getInstance().DisplayallCoursesAssignedtoteacher();
		if(Assignedcourse1==null || Assignedcourse1.isEmpty()){
			Alert alert1= new Alert(Alert.AlertType.WARNING);
			alert1.setTitle("Warning");
			alert1.setHeaderText("you have not assigned any course yet");
			alert1.showAndWait();
		}else{
		for(int i=0;i<Assignedcourse1.size();i++) {
			Userselect.add(Assignedcourse1.get(i).getCourseId());
		}



		myChoiceBox.getItems().addAll(Userselect);
		myChoiceBox.setValue("Select");
		myChoiceBox.setOnAction(this::getuser);

	}}

	public void getuser(ActionEvent event) {

		curruser = myChoiceBox.getValue();

	}
	public void Back(ActionEvent event) throws IOException {
		root = FXMLLoader.load(getClass().getResource("UI/TeacherMenu.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}

	public void Display2(ActionEvent event) throws IOException {
		QuerryTable.getItems().clear();
		queries=TTC.getInstance().ViewQuerry(Assignedcourse1.get(actualindex).getSemid(), Assignedcourse1.get(actualindex).getBatchId(), Assignedcourse1.get(actualindex).getDepartment(), Assignedcourse1.get(actualindex).getCourseId());
Display(queries);

	}
	public void Reset(ActionEvent event) throws IOException {
if(QuerryReply.getText().isBlank()){
	Alert alert1= new Alert(Alert.AlertType.WARNING);
	alert1.setTitle("Warning");
	alert1.setHeaderText("write something in the textfield");
	alert1.showAndWait();
}else{
	QuerryReply.clear();
}

	}
	public void GiveReply(ActionEvent event) throws IOException {

		ObservableList<Query> st;
		st = QuerryTable.getSelectionModel().getSelectedItems();
if(st==null ||st.isEmpty()){
	Alert alert1= new Alert(Alert.AlertType.WARNING);
	alert1.setTitle("Warning");
	alert1.setHeaderText("Please select a row from Querry table");
	alert1.showAndWait();
}else{
		int x1 =TTC.getInstance().ReplytoQuerry(Assignedcourse1.get(actualindex).getSemid(), Assignedcourse1.get(actualindex).getBatchId(), Assignedcourse1.get(actualindex).getDepartment(), Assignedcourse1.get(actualindex).getCourseId(),st.get(0).getStudentId(),st.get(0).getStatement(),QuerryReply.getText(),st.get(0).getQueryid());
if(x1!=-1){
	Alert alert1= new Alert(Alert.AlertType.WARNING);
	alert1.setTitle("Warning");
	alert1.setHeaderText("Reply sent");
	alert1.showAndWait();
}else{
	Alert alert1= new Alert(Alert.AlertType.WARNING);
	alert1.setTitle("Warning");
	alert1.setHeaderText("Reply failed");
	alert1.showAndWait();
}

	}

}}
