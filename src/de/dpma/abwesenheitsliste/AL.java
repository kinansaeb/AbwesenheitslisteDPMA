package de.dpma.abwesenheitsliste;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Logger;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class AL extends Application {

	static Logger log = Logger.getLogger(AL.class.getName());
	/**
	 * @author Kinan Saeb
	 *         <p>
	 *         This creates the Logger
	 *         <p>
	 *         This creates a logger for a named subsystem
	 *
	 * @Since JDK1.0
	 */

	public static Stage stage;

	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		log.info("Applikation wird gestartet");
		Class.forName("org.apache.derby.jdbc.ClientDriver");
		Properties properties = new Properties();
		properties.put("user", "root");
		properties.put("password", "dpmadpma");
		log.info("Datenbank Verbindung erfolgreich+ hergestellt");
		Connection connection = DriverManager
				.getConnection("jdbc:derby://localhost:1527/c:/derby/DatenbankDerby;create=false", properties);

		log.info("Datenbank verbindung hergestellt");
		Application.launch(AL.class, args);
		log.info("Applikation wird geschlossen");

	}

	/**
	 * @author Kinan Saeb
	 *         <p>
	 *         This method launches the application.
	 *         <p>
	 *         This method launches the application and logs the start and end
	 *         of it
	 */
	@Override
	public void start(Stage stage) throws Exception {
		this.stage = stage;
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(this.getClass().getResource("view/main.fxml"));
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

/**
 * @author Kinan Saeb
 *         <p>
 *         This method loads the scene into the stage.
 *         <p>
 *         This method loads the scene into the stage, logs the initialization
 *         and sets a few properties for the stage
 */
