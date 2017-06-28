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
	
	public static Stage stage;

	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		log.info("Applikation wird gestartet");
		Class.forName("org.apache.derby.jdbc.ClientDriver");
		Properties properties = new Properties();
		properties.put("user", "root");
		/*
		 * @author Alexander Bacher
		 * <p>
		 * This method add the User  root to the database
		 * <p>
		 * This method add the User root via  put command to the database.
		 * After that the User root is in the database
		 * 
		 * @since JDK 1.0
		 */
		properties.put("password", "dpmadpma");
		/*
		 * @author Alexander Bacher
		 * <p>
		 * This method add the password to the user "root" in the database
		 * <p>
		 * This method add the password dpmadpma to the user  "root" via  Put command
		 * After that the User root has the password dpmadpma
		 * 
		 * @since JDK 1.0
		 */
		log.info("Datenbank Verbindung erfolgreich+ hergestellt");
		Connection connection = DriverManager
				.getConnection("jdbc:derby://localhost:1527/c:/derby/DatenbankDerby;create=false", properties);

		log.info("Datenbank verbindung hergestellt");
		Application.launch(AL.class, args);
		log.info("Applikation wird geschlossen");

	}


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


