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

public class createScheduleController implements Initializable {
	static Logger log = Logger.getLogger(AL.class.getName());
	AL gen = new AL();
	public static Stage stage;
	String comment;

	public void okButton(ActionEvent event) {
		try {
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("saving.fxml"));
			log.info("Scene wird initalisiert");
			Parent root = (Parent) fxmlLoader.load();

			stage = new Stage();
			stage.setScene(new Scene(root));
			stage.setResizable(false);
			stage.show();
			stage.setTitle("Speichern...");

		} catch (Exception e) {
			e.printStackTrace();

		}
	}

	public void abortButton(ActionEvent event) {
		searchController.stage.close();
	}

	@FXML
	private Textfield kommentar;
	@FXML
	public ComboBox<String> names;
	ObservableList<String> nameList = FXCollections.observableArrayList("IT 1. AJ", "IT 2. AJ", "IT 3. AJ", "KFB 1. AJ",
			"KFB 2. AJ", "KFB 3. AJ", "VFA 1. AJ", "VFA 2. AJ", "VFA 3. AJ", "FAMI 1. AJ", "FAMI 2. AJ", "FAMI 3. AJ",
			"Schreiner 1. AJ", "Schreiner 2. AJ", "Schreiner 3. AJ", "Elektroniker 1. AJ", "Elektroniker 2. AJ",
			"Elektroniker 3. AJ");

	@FXML
	public ComboBox<String> categories;
	ObservableList<String> categorieList = FXCollections.observableArrayList("Berufschule", "Fachbereich", "Urlaub",
			"Krank", "Arbeit");

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		names.setItems(nameList);
		categories.setItems(categorieList);

	}
}