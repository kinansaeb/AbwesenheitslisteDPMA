package de.dpma.abwesenheitsliste.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.logging.Logger;

public class DatabaseConnection {
	/**
	 * @author Alexander Bacher This is the DatabaseConnection Class
	 *         <p>
	 *         This class will be connect the Java with the Apache Derby
	 *         database
	 *         <p>
	 *         The DatabseConnection is one of the important classes It connect
	 *         Java with the Derby Database
	 * @since JDK 1.0
	 */
	public Connection con = null;

	Logger log = Logger.getLogger(DatabaseConnection.class.getName());

	public DatabaseConnection() throws ClassNotFoundException, SQLException {
		log.info("Die Verbindung zur Datenbank wird gestartet");
		Class.forName("org.apache.derby.jdbc.ClientDriver");
		Properties properties = new Properties();
		properties.put("user", "root");
		properties.put("password", "dpmadpma");
		/*
		 * @author Alexander Bacher <p> This method add the password to the user
		 * "root" in the database <p> This method add the password dpmadpma to
		 * the user "root" via Put command After that the User root has the
		 * password dpmadpma
		 * 
		 * @since JDK 1.0
		 */
		con = DriverManager.getConnection("jdbc:derby://localhost:1527/c:/derby/DatenbankDerby;create=false",
				properties);
		/*
		 * @author Alexander Bacher This is the con command it is the
		 * Drivermanager connection <p> The Con will connect to the local
		 * database via getConnection <p> The Con can connect via the
		 * getConnection command to the local hosted database It need the path
		 * of the database to connect there
		 * 
		 * @since JDK
		 */

		Statement statement = con.createStatement();
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
