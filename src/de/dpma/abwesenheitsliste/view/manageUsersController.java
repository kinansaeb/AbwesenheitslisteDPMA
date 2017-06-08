package de.dpma.abwesenheitsliste.view;

import java.util.logging.Logger;

import de.dpma.abwesenheitsliste.AL;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class manageUsersController {
	static Logger log = Logger.getLogger(AL.class.getName());
	AL gen = new AL();
	public static Stage stage;

	public void backButton(ActionEvent event) {
		try {
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("main.fxml"));
			log.info("Scene wird initalisiert");
			Parent root = (Parent) fxmlLoader.load();

			stage = new Stage();
			stage.setScene(new Scene(root));
			stage.setResizable(false);
			stage.show();
			stage.setTitle("Abwesenheitsliste");
			manageUsersController.stage.close();

		} catch (Exception e) {
			e.printStackTrace();

		}
	}

	public void addUserButton(ActionEvent event) {
		try {
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("addUsers.fxml"));
			log.info("Scene wird initalisiert");
			Parent root = (Parent) fxmlLoader.load();

			stage = new Stage();
			stage.setScene(new Scene(root));
			stage.setResizable(false);
			stage.show();
			stage.setTitle("Benutzer hinzufügen");

		} catch (Exception e) {
			e.printStackTrace();

		}
	}

}
