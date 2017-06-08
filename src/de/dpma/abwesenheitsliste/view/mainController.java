package de.dpma.abwesenheitsliste.view;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Logger;

import de.dpma.abwesenheitsliste.AL;
import javafx.application.Platform;
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

public class mainController implements Initializable {
	static Logger log = Logger.getLogger(AL.class.getName());
	AL gen = new AL();
	public static Stage stage;
	String berufsbild;
	String kategorie;
	String datefield1;
	String datefield2;

	@FXML
	public void searchButton(ActionEvent event) {
		try {

			FXMLLoader fxmlLoader = new FXMLLoader(this.getClass().getResource("search.fxml"));
			log.info("Scene wird initalisiert.");
			Parent root = (Parent) fxmlLoader.load();

			AL.stage.close();
			stage = new Stage();
			stage.setScene(new Scene(root));
			stage.setResizable(false);
			stage.show();

			stage.setTitle("Einsatzplan");

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@FXML
	public void closeButton(ActionEvent event) {
		Platform.exit();
	}

	/**
	 * @author Kinan Saeb
	 *         <p>
	 *         This method closes the whole application.
	 *         <p>
	 *         This method creates a new event handler for closing the whole
	 *         application within a button-click
	 * 
	 */

	@FXML
	public void manageUsersButton(ActionEvent event) {
		try {
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("manageUsers.fxml"));
			log.info("Scene wird initalisiert");
			Parent root = (Parent) fxmlLoader.load();
			AL.stage.close();
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
	public void deploymentPlanButton(ActionEvent event) {
		try {
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("search.fxml"));
			log.info("Scene wird initalisiert");
			Parent root = (Parent) fxmlLoader.load();
			AL.stage.close();
			stage = new Stage();
			stage.setScene(new Scene(root));
			stage.setResizable(false);
			stage.show();
			stage.setTitle("Einsatzplan");

		} catch (Exception e) {
			e.printStackTrace();

		}

	}

	@FXML
	public ComboBox<String> combobox;
	ObservableList<String> list = FXCollections.observableArrayList("IT 1. AJ", "IT 2. AJ", "IT 3. AJ", "KFB 1. AJ",
			"KFB 2. AJ", "KFB 3. AJ", "VFA 1. AJ", "VFA 2. AJ", "VFA 3. AJ", "FAMI 1. AJ", "FAMI 2. AJ", "FAMI 3. AJ",
			"Schreiner 1. AJ", "Schreiner 2. AJ", "Schreiner 3. AJ", "Elektroniker 1. AJ", "Elektroniker 2. AJ",
			"Elektroniker 3. AJ");

	@FXML
	public ComboBox<String> combobox2;
	ObservableList<String> list2 = FXCollections.observableArrayList("Berufschule", "Fachbereich", "Urlaub", "Krank",
			"Arbeit");

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		combobox.setItems(list);
		combobox2.setItems(list2);

	}

}
