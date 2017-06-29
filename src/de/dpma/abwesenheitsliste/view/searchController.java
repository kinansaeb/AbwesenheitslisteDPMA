package de.dpma.abwesenheitsliste.view;

import java.sql.SQLException;
import java.util.List;
import java.util.logging.Logger;

import de.dpma.abwesenheitsliste.AL;
import de.dpma.abwesenheitsliste.model.Termin;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

public class searchController {
	static Logger log = Logger.getLogger(AL.class.getName());
	AL gen = new AL();
	public static Stage stage;
	@FXML
	private TableView<Terminliste> userTbl = new TableView<>();
	@FXML
	private TableColumn<Terminliste, String> id = new TableColumn<Terminliste, String>();
	@FXML
	private TableColumn<Terminliste, String> userName = new TableColumn<Terminliste, String>();
	@FXML
	private TableColumn<Terminliste, String> vonDate = new TableColumn<Terminliste, String>();
	@FXML
	private TableColumn<Terminliste, String> bisDate = new TableColumn<Terminliste, String>();
	@FXML
	private TableColumn<Terminliste, String> kategorie = new TableColumn<Terminliste, String>();
	@FXML
	private TableColumn<Terminliste, String> kommentar = new TableColumn<Terminliste, String>();

	@FXML
	private void initialize() throws SQLException {
		List<Termin> termin = mainController.searchUsersDAO.allTermine();
		ObservableList<Termin> terminList = FXCollections.observableArrayList();
		terminList = FXCollections.observableArrayList(termin);
		userTbl.setItems(terminList);
		userName.setCellValueFactory(cellData -> cellData.getValue().getName());
		id.setCellValueFactory(cellData -> cellData.getValue().convertId());
	}

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

	public void backButton(ActionEvent event) {
		try {
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("main.fxml"));
			log.info("Scene 'main.fxml' wird initalisiert");
			Parent root = (Parent) fxmlLoader.load();
			mainController.stage.close();
			stage = new Stage();
			stage.setScene(new Scene(root));
			stage.setResizable(false);
			stage.show();
			stage.setTitle("Abwesenheitsliste");

		} catch (Exception e) {
			e.printStackTrace();

		}
	}

	/**
	 * @author Kinan Saeb
	 *         <p>
	 *         This method goes back to the main stage
	 *         <p>
	 *         This method goes back to the main stage, closes the opened stage
	 *         and sets various properties
	 * @since JDK 1.0
	 */

	public void createScheduleButton(ActionEvent event) {
		try {
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("createSchedule.fxml"));
			log.info("Scene 'createSchedule.fxml' wird initalisiert");
			Parent root = (Parent) fxmlLoader.load();

			stage = new Stage();
			stage.setScene(new Scene(root));
			stage.setResizable(false);
			stage.show();
			stage.setTitle("Termin anlegen");

		} catch (Exception e) {
			e.printStackTrace();

		}
	}
	/**
	 * @author Kinan Saeb
	 *         <p>
	 *         This method goes to the create schedule stage
	 *         <p>
	 *         This method goes back to the create schedule, closes the opened
	 *         stage and sets various properties
	 * @since JDK 1.0
	 */

}
