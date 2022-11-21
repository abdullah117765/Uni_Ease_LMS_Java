package application;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import BusinessLogic.Announcement;
import BusinessLogic.Courseoffer;
import BusinessLogic.Marks;
import BusinessLogic.TTC;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

public class ControllerViewAnnouncement_teacher {


	
	 private Stage stage;
	 private Scene scene;
	 private Parent root;
	 
	 @FXML
		private TableColumn< Announcement, String>   Announcementcolumn;
	 @FXML
		private TableView<Announcement> AnnouncementTable;
	 
	 public void initialize() {
			
		ArrayList<Announcement> announce= TTC.getInstance().DisplayallAnnouncementforstudent();
			
		if(announce==null || announce.isEmpty()) {
			 Alert alert1= new Alert(AlertType.WARNING);
			   alert1.setTitle("Warning");
			   alert1.setHeaderText("NO Announcement Yet");
			   alert1.showAndWait(); 
		}
		
		else {
		 Announcementcolumn.setCellValueFactory(new PropertyValueFactory <Announcement  , String>("announcement"));
				
			for(int i=0;i<announce.size();i++) {
				AnnouncementTable.getItems().add(announce.get(i));
			}
				
	 }
		}

	public void Back(ActionEvent event) throws IOException {
		root = FXMLLoader.load(getClass().getResource("UI/TeacherMenu.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	
	
	
	
	
	
}
