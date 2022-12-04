package application;

import java.io.IOException;
import java.util.ArrayList;

import BusinessLogic.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;


public class ControllerViewAnnouncement_student {


	 private Stage stage;
	 private Scene scene;
	 private Parent root;
	 
	 @FXML
		private TableColumn<Announcement, String>   Announcementcolumn;
	@FXML
	private TableView<Announcement> AnnouncementTable22;

	 
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
				AnnouncementTable22.getItems().add(announce.get(i));
			}
				
	 }

		}
	
	 public void Back(ActionEvent event) throws IOException {
		 root = FXMLLoader.load(getClass().getResource("UI/StudentHomePage.fxml"));
		  stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		  scene = new Scene(root);
		  stage.setScene(scene);
		  stage.show();
		 }
	
	
	
	
	
}
