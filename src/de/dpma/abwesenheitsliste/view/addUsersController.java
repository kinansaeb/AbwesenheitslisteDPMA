package de.dpma.abwesenheitsliste.view;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Logger;

import de.dpma.abwesenheitsliste.AL;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;

public class addUsersController implements Initializable {
	static Logger log = Logger.getLogger(AL.class.getName());
	AL gen = new AL();
	public static Stage stage;

	public void abortButton(ActionEvent event) {
		try {

			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("manageUsers.fxml"));
			log.info("Scene wird initalisiert");
			Parent root = (Parent) fxmlLoader.load();
			manageUsersController.stage.close();
			stage = new Stage();
			stage.setScene(new Scene(root));
			stage.setResizable(false);
			stage.show();
			stage.setTitle("Benutzer verwalten");

		} catch (Exception e) {
			e.printStackTrace();

		}

	}

	public void okButton(ActionEvent event) {
		try {

			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("manageUsers.fxml"));
			log.info("Scene wird initalisiert");
			Parent root = (Parent) fxmlLoader.load();
			manageUsersController.stage.close();
			stage = new Stage();
			stage.setScene(new Scene(root));
			stage.setResizable(false);
			stage.show();
			stage.setTitle("Benutzer verwalten");

		} catch (Exception e) {
			e.printStackTrace();

		}

	}

	@FXML
	public ComboBox<String> berufsbild;
	ObservableList<String> berufsbildList = FXCollections.observableArrayList("IT 1. AJ", "IT 2. AJ", "IT 3. AJ",
			"KFB 1. AJ", "KFB 2. AJ", "KFB 3. AJ", "VFA 1. AJ", "VFA 2. AJ", "VFA 3. AJ", "FAMI 1. AJ", "FAMI 2. AJ",
			"FAMI 3. AJ", "Schreiner 1. AJ", "Schreiner 2. AJ", "Schreiner 3. AJ", "Elektroniker 1. AJ",
			"Elektroniker 2. AJ", "Elektroniker 3. AJ");

	@FXML
	public ComboBox<String> einstellungsjahr;
	ObservableList<String> einstellungsjahrList = FXCollections.observableArrayList("2017", "2016", "2015", "2014",
			"2013", "2012");

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		berufsbild.setItems(berufsbildList);
		einstellungsjahr.setItems(einstellungsjahrList);
	}

}
