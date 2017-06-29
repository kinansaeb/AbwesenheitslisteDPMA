package de.dpma.abwesenheitsliste.view;

import java.sql.SQLException;
import java.util.List;
import java.util.logging.Logger;

import de.dpma.abwesenheitsliste.AL;
import de.dpma.abwesenheitsliste.model.Benutzer;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

public class manageUsersController {
	static Logger log = Logger.getLogger(AL.class.getName());
	AL gen = new AL();
	public static Stage stage;
	@FXML
	private TableView<Benutzer> userTbl = new TableView<>();
	@FXML
	private TableColumn<Benutzer, String> userName = new TableColumn<Benutzer, String>();
	@FXML
	private TableColumn<Benutzer, String> id = new TableColumn<Benutzer, String>();
	@FXML
	private TableColumn<Benutzer, String> ausbildungsjahr = new TableColumn<Benutzer, String>();
	@FXML
	private TableColumn<Benutzer, String> berufsbild = new TableColumn<Benutzer, String>();

	/**
	 * @author Kinan Saeb
	 *         <p>
	 *         This method goes back to the main stage
	 *         <p>
	 *         This method goes to the main stage, closes the opened stage and
	 *         sets various properties for the newly opened stage.
	 * @throws SQLException
	 * @since JDK 1.0
	 */
	@FXML
	private void initialize() throws SQLException {
		List<Benutzer> user = mainController.manageUsersDAO.allUsers();
		ObservableList<Benutzer> userList = FXCollections.observableArrayList();
		userList = FXCollections.observableArrayList(user);
		userTbl.setItems(userList);
		userName.setCellValueFactory(cellData -> cellData.getValue().getName());
		id.setCellValueFactory(cellData -> cellData.getValue().convertId());
		ausbildungsjahr.setCellValueFactory(cellData -> cellData.getValue().convertAj());
		berufsbild.setCellValueFactory(cellData -> cellData.getValue().getBerufsbild());
	}

	public void backButton(ActionEvent event) {
		try {
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("main.fxml"));
			log.info("Scene wird initalisiert");
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

	public void addUserButton(ActionEvent event) {
		try {
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("addUsers.fxml"));
			log.info("Scene wird initalisiert");
			Parent root = (Parent) fxmlLoader.load();

			stage = new Stage();
			stage.setScene(new Scene(root));
			stage.setResizable(false);
			stage.show();
			stage.setTitle("Benutzer hinzufügen");

		} catch (Exception e) {
			e.printStackTrace();

		}
	}

	/**
	 * @author Kinan Saeb
	 *         <p>
	 *         This method goes to the add users stage
	 *         <p>
	 *         This method goes to the add users stage, closes the opened stage
	 *         and sets various properties for the newly opened stage.
	 * @since JDK 1.0
	 */
}
