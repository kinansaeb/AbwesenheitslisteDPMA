package de.dpma.abwesenheitsliste;

import java.sql.SQLException;
import java.util.logging.Logger;

import de.dpma.abwesenheitsliste.dao.DatabaseConnection;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class AL extends Application {

	static Logger log = Logger.getLogger(AL.class.getName());

	public static Stage stage;
	public static DatabaseConnection con = null;

	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		log.info("Applikation wird gestartet");
		/*
		 * @author Alexander Bacher <p> This method add the User root to the
		 * database <p> This method add the User root via put command to the
		 * database. After that the User root is in the database
		 * 
		 * @since JDK 1.0
		 */

		con = new DatabaseConnection();
		Application.launch(AL.class, args);
		log.info("Applikation wird geschlossen");

	}

	@Override
	public void start(Stage stage) throws Exception {
		this.stage = stage;
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(this.getClass().getResource("view/main.fxml"));
		stage.getIcons().add(new Image("file:img/user.ico"));
		log.info("Scene wird initalisiert");
		AnchorPane content;
		content = (AnchorPane) loader.load();
		Scene scene = new Scene(content);
		stage.setResizable(false);
		stage.setTitle("Abwesenheitsliste");

		stage.setScene(scene);
		stage.show();
	}
}
