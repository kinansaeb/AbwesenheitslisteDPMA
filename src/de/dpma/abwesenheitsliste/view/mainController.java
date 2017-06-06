package de.dpma.abwesenheitsliste.view;

import java.util.logging.Logger;

import de.dpma.abwesenheitsliste.AL;
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

	@FXML
	public void searchButton(ActionEvent event) {
		try {
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("suche.fxml"));
			log.info("Suche wird intialisiert.");
			Parent root = (Parent) fxmlLoader.load();
			stage = new Stage();
			stage.setScene(new Scene(root));
			stage.setResizable(false);
			stage.show();
			stage.setTitle("Mitarbeiter suche");

			gen.stage.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@FXML
	private ComboBox<String> selection = new ComboBox<String>(options);

}
