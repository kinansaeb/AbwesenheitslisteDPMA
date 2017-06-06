package de.dpma.abwesenheitsliste;

import java.util.logging.Logger;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Abwesenheitsliste extends Application {
	static Logger log = Logger.getLogger(Abwesenheitsliste.class.getName());

	public static Stage stage;

	public static void main(String[] args) {
		log.info("Applikaton wird gestartet.");
		Application.launch(Abwesenheitsliste.class, args);
		log.info("Applikation wird geschlossen.");
	}

	@Override
	public void start(Stage stage) throws Exception {
		this.stage = stage;
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(this.getClass().getResource("view/‌​main.fxml"));

		log.info("Scene wird initialisiert.");
		AnchorPane content;
		content = (AnchorPane) loader.load();
		Scene scene = new Scene(content);
		stage.setResizable(false);
		stage.setTitle("AbwesenheitslisteDPMA");

		stage.setScene(scene);
		stage.show();
	}
}
