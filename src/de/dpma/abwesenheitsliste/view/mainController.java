package de.dpma.abwesenheitsliste.view;

import java.util.logging.Logger;

import de.dpma.abwesenheitsliste.AL;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;

public class mainController {
	static Logger log = Logger.getLogger(AL.class.getName());
	AL gen = new AL();
	public static Stage stage;
	private ComboBox<String> selection;

	public void initialize() {
		ObservableList<String> options = FXCollections.observableArrayList("Fachinformatiker",
				"Fachangestellte für Medien- und Informationsdienste", "Elektroniker", "Schreiner",
				"Kaufmann/frau für Büromanagement", "Verwaltungsfachangestellte");
		selection = new ComboBox<String>(options);
	}

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

}
