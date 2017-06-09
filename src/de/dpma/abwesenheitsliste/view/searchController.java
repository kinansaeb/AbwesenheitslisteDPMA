package de.dpma.abwesenheitsliste.view;

import java.util.logging.Logger;

import de.dpma.abwesenheitsliste.AL;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class searchController {
	static Logger log = Logger.getLogger(AL.class.getName());
	AL gen = new AL();
	public static Stage stage;

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

	public void backButton(ActionEvent event) {
		try {
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("main.fxml"));
			log.info("Scene wird initalisiert");
			Parent root = (Parent) fxmlLoader.load();
			mainController.stage.close();
			stage = new Stage();
			stage.setScene(new Scene(root));
			stage.setResizable(false);
			stage.show();
			stage.setTitle("Abwesenheitsliste");

		} catch (Exception e) {
			e.printStackTrace();

		}
	}

	/**
	 * @author Kinan Saeb
	 *         <p>
	 *         This method goes back to the main stage
	 *         <p>
	 *         This method goes back to the main stage, closes the opened stage
	 *         and sets various properties
	 * 
	 * 
	 */

	public void createScheduleButton(ActionEvent event) {
		try {
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("createSchedule.fxml"));
			log.info("Scene wird initalisiert");
			Parent root = (Parent) fxmlLoader.load();

			stage = new Stage();
			stage.setScene(new Scene(root));
			stage.setResizable(false);
			stage.show();
			stage.setTitle("Termin anlegen");

		} catch (Exception e) {
			e.printStackTrace();

		}
	}
	/**
	 * @author Kinan Saeb
	 *         <p>
	 *         This method goes to the create schedule stage
	 *         <p>
	 *         This method goes back to the create schedule, closes the opened
	 *         stage and sets various properties
	 * 
	 * 
	 */

}
