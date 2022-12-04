package application;


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
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

	public class ControllerLogin implements Initializable {

		
		@FXML
		private TextField Passward;
		@FXML
		private TextField Username;
		
		
		
	 private Stage stage;
	 private Scene scene;
	 private Parent root;
	 private String curruser; 
		
		
		@FXML
		private ChoiceBox<String> myChoiceBox;
		
		private String[] Userselect = {"Administration","Student","Teacher"};

	
		@Override
		public void initialize(URL arg0, ResourceBundle arg1) {
			
			myChoiceBox.getItems().addAll(Userselect);
			myChoiceBox.setValue("Select");
			myChoiceBox.setOnAction(this::getuser);
			
		}
		
		public void getuser(ActionEvent event) {
			
		 curruser = myChoiceBox.getValue();
			
		}


		
		
		
		public void loginpressed(ActionEvent event) throws IOException {
			//Username  Passward
			if (myChoiceBox.getValue().equalsIgnoreCase("Select")) {
				Alert alert1 = new Alert(AlertType.ERROR);
				alert1.setTitle("Warning");
				alert1.setHeaderText("Select User first");
				alert1.showAndWait();
			}else{
			if (Username.getText().isEmpty() || Passward.getText().isEmpty()) {
				Alert alert1 = new Alert(AlertType.ERROR);
				alert1.setTitle("Warning");
				alert1.setHeaderText("Please fill the text field ");
				alert1.showAndWait();
			} else {

				if (curruser.equalsIgnoreCase("Administration")) {
					int check = TTC.getInstance().verifyAdmin(Username.getText(), Passward.getText());

					if (check != -1) {
						TTC.getInstance().setCurrentUser(Username.getText(), 1);
						root = FXMLLoader.load(getClass().getResource("UI/AdminMenu.fxml"));
						stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
						scene = new Scene(root);
						stage.setScene(scene);
						stage.show();
					} else {
						Alert alert1 = new Alert(AlertType.ERROR);
						alert1.setTitle("Warning");
						alert1.setHeaderText("Wrong User Id or passward");
						alert1.showAndWait();
					}
				}

				if (curruser.equalsIgnoreCase("Student")) {

					int check2 = TTC.getInstance().verifyStudent(Username.getText(), Passward.getText());

					if (check2 != -1) {
						TTC.getInstance().setCurrentUser(Username.getText(), 3);
						root = FXMLLoader.load(getClass().getResource("UI/StudentHomePage.fxml"));
						stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
						scene = new Scene(root);
						stage.setScene(scene);
						stage.show();
					} else {
						Alert alert1 = new Alert(AlertType.ERROR);
						alert1.setTitle("Warning");
						alert1.setHeaderText("Wrong User Id or passward");
						alert1.showAndWait();
					}
				}


				if (curruser.equalsIgnoreCase("Teacher")) {
					int check2 = TTC.getInstance().verifyTeacher(Username.getText(), Passward.getText());

					if (check2 != -1) {
						TTC.getInstance().setCurrentUser(Username.getText(), 2);
						root = FXMLLoader.load(getClass().getResource("UI/TeacherMenu.fxml"));
						stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
						scene = new Scene(root);
						stage.setScene(scene);
						stage.show();
					} else {
						Alert alert1 = new Alert(AlertType.ERROR);
						alert1.setTitle("Warning");
						alert1.setHeaderText("Wrong User Id or passward");
						alert1.showAndWait();
					}
				}

			}


		}
	 
		}
	 
	}