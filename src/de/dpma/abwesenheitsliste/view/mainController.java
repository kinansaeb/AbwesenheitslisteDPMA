package de.dpma.abwesenheitsliste.view;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Logger;

import de.dpma.abwesenheitsliste.AL;
import de.dpma.abwesenheitsliste.dao.ManageUsersDAO;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;

public class mainController implements Initializable {
	static Logger log = Logger.getLogger(AL.class.getName());
	AL gen = new AL();
	public static Stage stage;
	String berufsbild;
	String kategorie;
	String datefield1;
	String datefield2;
	public static ManageUsersDAO manageUsersDAO = new ManageUsersDAO(AL.con.getConnection());

	@FXML
	public void searchButton(ActionEvent event) {
		try {

			FXMLLoader fxmlLoader = new FXMLLoader(this.getClass().getResource("search.fxml"));
			log.info("Scene 'search.fxml' wird initalisiert.");
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

	/**
	 * @author Kinan Saeb
	 *         <p>
	 *         This method goes to the deployment plan page
	 *         <p>
	 *         This method goes to the deployment plan stage, closes the opened
	 *         stage and sets various properties for the newly opened stage. It
	 *         also searchs for the given properties in the database
	 * @since JDK 1.0
	 */
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
	 * @since JDK 1.0
	 */

	@FXML
	public void manageUsersButton(ActionEvent event) {
		try {
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("manageUsers.fxml"));
			log.info("Scene 'manageUsers.fxml' wird initalisiert");
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

	/**
	 * @author Kinan Saeb
	 *         <p>
	 *         This method goes to the manage users stage
	 *         <p>
	 *         This method goes to the manage users stage, closes the opened
	 *         stage and sets various properties for the newly opened stage
	 * @since JDK 1.0
	 */

	@FXML
	public void deploymentPlanButton(ActionEvent event) {
		try {
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("search.fxml"));
			log.info("Scene 'search.fxml' wird initalisiert");
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

		/**
		 * @author Kinan Saeb
		 *         <p>
		 *         This method opens the deployment plan stage
		 *         <p>
		 *         This method opens the deployment plan stage, closes the
		 *         opened stage and sets various properties for the newly opened
		 *         stage
		 * @since JDK 1.0
		 */

	}

	@FXML
	public ComboBox<String> combobox;
	ObservableList<String> list = FXCollections.observableArrayList("IT 1. AJ", "IT 2. AJ", "IT 3. AJ", "KFB 1. AJ",
			"KFB 2. AJ", "KFB 3. AJ", "VFA 1. AJ", "VFA 2. AJ", "VFA 3. AJ", "FAMI 1. AJ", "FAMI 2. AJ", "FAMI 3. AJ",
			"Schreiner 2. AJ", "Schreiner 3. AJ", "Elektroniker 1. AJ", "Elektroniker 2. AJ", "Elektroniker 3. AJ");

	/**
	 * @author Kinan Saeb
	 *         <p>
	 *         This creates a new ComboBox and an observable list
	 *         <p>
	 *         This creates a new ComboBox and an observable List, adding a
	 *         variety of Strings into it.
	 * @since JDK 1.0
	 */

	@FXML
	public ComboBox<String> combobox2;
	ObservableList<String> list2 = FXCollections.observableArrayList("Berufschule", "Fachbereich", "Urlaub", "Krank",
			"Arbeit");

	/**
	 * @author Kinan Saeb
	 *         <p>
	 *         This creates a new ComboBox and an observable list
	 *         <p>
	 *         This creates a new ComboBox and an observable List, adding a
	 *         variety of Strings into it.
	 * @since JDK 1.0
	 */

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		combobox.setItems(list);
		combobox2.setItems(list2);

	}

	/**
	 * @author Kinan Saeb
	 *         <p>
	 *         This method initializes the observable list into the ComboBoxes
	 *         <p>
	 *         This method puts the String given in the observable lists into
	 *         the ComboBoxes
	 * @since JDK 1.0
	 */

}
