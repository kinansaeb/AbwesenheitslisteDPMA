package de.dpma.abwesenheitsliste.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Logger;

public class DatabaseConnection {

	public Connection con = null;

	Logger log = Logger.getLogger(DatabaseConnection.class.getName());

	public DatabaseConnection() throws ClassNotFoundException, SQLException {
		log.info("Die Verbindung zur Datenbank wird gestartet");
		Class.forName("org.apache.derby.jdbc.ClientDriver");
		con = DriverManager.getConnection("jdbc:mysql://localhost:1578"
				+ "user=root&password=&characterEncoding=UTF-8&autoReconnect=true&failOverReadOnly=false&maxReconnects=10");
		log.info("Verbindung erfolgreich");
	}

	public Connection getConnection() {

		log.info("Die Datenbankverbindung wird hergestellt");
		return con;
	}

	public void closeConnection() throws SQLException {

		log.info("Die Datenbankverbindung wird geschlossen");
		con.close();
	}
}
