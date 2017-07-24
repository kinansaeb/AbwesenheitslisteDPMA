package de.dpma.abwesenheitsliste.view;

import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Logger;

import de.dpma.abwesenheitsliste.AL;
import de.dpma.abwesenheitsliste.model.Benutzer;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class addUsersController implements Initializable {

	@FXML
	private TextField vorname = new TextField();
	@FXML
	private TextField nachname = new TextField();
	@FXML
	private ComboBox<String> newBerufsbild = new ComboBox();
	@FXML
	private ComboBox<Integer> ausbildungsjahr = new ComboBox();

	static Logger log = Logger.getLogger(AL.class.getName());
	AL gen = new AL();
	public static Stage stage;

	public void abortButton(ActionEvent event) {
		try {

			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("manageUsers.fxml"));
			log.info("Scene 'Benutzer verwalten' wird initalisiert");
			Parent root = (Parent) fxmlLoader.load();
			manageUsersController.stage.close();
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
	 *         stage and sets various properties for the newly opened stage.
	 * @since JDK 1.0
	 */

	public void okButton() {
		try {
			Benutzer user = new Benutzer();
			user.setName(vorname.getText() + " " + nachname.getText());
			user.setAusbildungsjahr(Integer.parseInt(einstellungsjahr.getValue()));
			user.setBerufsbild(berufsbild.getValue());
			List<Benutzer> lastUser = mainController.manageUsersDAO.allUsers();
			user.setId(lastUser.size());

			mainController.manageUsersDAO.addUser(user);

			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("manageUsers.fxml"));
			log.info("Scene 'Benutzer verwalten' wird initalisiert");
			Parent root = (Parent) fxmlLoader.load();
			manageUsersController.stage.close();
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
	 *         stage and sets various properties for the newly opened stage. It
	 *         also initializes the saving into the database
	 * @since JDK 1.0
	 */

	@FXML
	public ComboBox<String> berufsbild;
	ObservableList<String> berufsbildList = FXCollections.observableArrayList("IT", "KFB", "VFA", "FAMI", "Schreiner",
			"Elektroniker");

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
	public ComboBox<String> einstellungsjahr;
	ObservableList<String> einstellungsjahrList = FXCollections.observableArrayList("1", "2", "3", "4");

	/**
	 * @author Kinan Saeb
	 *         <p>
	 *         This creates a new ComboBox and an observable list
	 *         <p>
	 *         This creates a new ComboBox and an observable List, adding a
	 *         variety of Strings into it.
	 * @since JDK 1.0
	 */

	public void initialize(URL location, ResourceBundle resources) {
		vorname.setPromptText("vorname");
		nachname.setPromptText("nachname");
		berufsbild.setItems(berufsbildList);
		einstellungsjahr.setItems(einstellungsjahrList);
	}

	/**
	 * 
	 * <p>
	 * This method initializes the observable list into the ComboBoxes
	 * <p>
	 * This method puts the String given in the observable lists into the
	 * ComboBoxes
	 * 
	 * @author Kinan Saeb
	 * 
	 * @since JDK 1.0
	 * 
	 */

	public void addUser() throws SQLException {

		vorname.getText();
		nachname.getText();
		ausbildungsjahr.getValue();
		einstellungsjahr.getValue();
	}
}