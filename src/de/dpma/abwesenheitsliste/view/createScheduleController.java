package de.dpma.abwesenheitsliste.view;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Logger;

import de.dpma.abwesenheitsliste.AL;
import de.dpma.abwesenheitsliste.model.Termin;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class createScheduleController implements Initializable {
	@FXML
	private ComboBox<String> namensListe = new ComboBox();
	@FXML
	private ComboBox<String> kategorie = new ComboBox();
	@FXML
	private TextField kommentarFeld = new TextField();
	@FXML
	private DatePicker vonPicker = new DatePicker();
	@FXML
	private DatePicker bisPicker = new DatePicker();

	static Logger log = Logger.getLogger(AL.class.getName());
	AL gen = new AL();
	public static Stage stage;
	String comment;

	public void okButton(ActionEvent event) {
		try {
			Termin schedule = new Termin();
			schedule.setName(namensListe.getValue());
			schedule.setVon(vonPicker.getValue());
			schedule.setBis(bisPicker.getValue());
			schedule.setKategorie(kategorie.getValue());
			// schedule.setKommentar(kommentar.getText());
			// List<Termin> lastSchedule =
			// mainController.createScheduleDAO.allTermine();
			// schedule.setId(lastSchedule.size());
			mainController.createScheduleDAO.addSchedule(schedule);

			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("saving.fxml"));
			log.info("Scene wird initalisiert");
			Parent root = (Parent) fxmlLoader.load();
			searchController.stage.close();
			stage = new Stage();
			stage.setScene(new Scene(root));
			stage.setResizable(false);
			stage.show();
			stage.setTitle("Speichern...");

		} catch (Exception e) {
			e.printStackTrace();

		}
	}

	/**
	 * @author Kinan Saeb
	 *         <p>
	 *         This method goes to the saving stage
	 *         <p>
	 *         This method goes to the saving stage, closes the opened stage and
	 *         sets various properties. It also initializes the saving of given
	 *         files
	 * @since JDK 1.0
	 * 
	 */

	public void abortButton(ActionEvent event) {
		searchController.stage.close();

	}

	/**
	 * @author Kinan Saeb
	 *         <p>
	 *         This method closes the actual stage
	 *         <p>
	 *         This method closes the actual stage It will close the stage by
	 *         clicking abortButton
	 * @since JDK 1.0
	 * 
	 *
	 */

	@FXML
	private TextField kommentar;

	@FXML
	private DatePicker von;

	@FXML
	private DatePicker bis;

	@FXML
	public ComboBox<String> names;
	ObservableList<String> nameList = FXCollections.observableArrayList("IT 1. AJ", "IT 2. AJ", "IT 3. AJ", "KFB 1. AJ",
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
	public ComboBox<String> categories;
	ObservableList<String> categorieList = FXCollections.observableArrayList("Berufschule", "Fachbereich", "Urlaub",
			"Krank", "Arbeit");

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
		names.setItems(nameList);
		categories.setItems(categorieList);

	}

	public void addSchedule() throws SQLException {
		vorname.getText();
		nachname.getText();
		ausbildungsjahr.getValue();
		kategorie.getValue();
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