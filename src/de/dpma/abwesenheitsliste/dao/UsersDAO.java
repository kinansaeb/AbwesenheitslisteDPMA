package de.dpma.abwesenheitsliste.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import de.dpma.abwesenheitsliste.model.Benutzer;

public class UsersDAO {
	// public SimpleIntegerProperty userName = new SimpleIntegerProperty();
	final String SELECT_ALL_USERS = "SELECT * FROM ROOT.BENUTZER";
	final String DELETE_USER = "DELETE FROM BENUTZER WHERE ID = ? ";
	final String ADD_USER = "INSERT INTO ROOT.BENUTZER (ID, NAME, BERUFSBILD, AUSBILDUNGSJAHR) VALUES(?, ?, ?, ?)";

	private final Connection con;

	public UsersDAO(Connection con) {
		this.con = con;
	}

	public List<Benutzer> allUsers() throws SQLException {
		PreparedStatement stat = con.prepareStatement(SELECT_ALL_USERS);
		ResultSet result = stat.executeQuery();

		ArrayList<Benutzer> User = new ArrayList<>();
		while (result.next()) {
			Benutzer Users = new Benutzer();
			Users.setBerufsbild(result.getString("berufsbild"));
			Users.setAusbildungsjahr(result.getInt("ausbildungsjahr"));
			// Users.setKategorie(result.getString("kategorie"));
			Users.setId(result.getInt("id"));
			Users.setName(result.getString("name"));

			User.add(Users);
			/*
			 * @author Alexander Bacher <p> This is the select Method <p> This
			 * method will select all Berufsbild,Ausbildungsjahr,Category,Id,
			 * Name. So all columns will be selected
			 * 
			 * @since JDK 1.0
			 */
		}
		return User;

		/*
		 * @author Alexander Bacher <p> This is the retunr Methode. <p> This is
		 * the return method. It will be retunr all selected Columns It use the
		 * data get from User.add(Users) Method
		 * 
		 * @return data from User.add(Users)
		 */

	}

	public void deleteUser(Benutzer user) {
		try {
			PreparedStatement stat = con.prepareStatement(DELETE_USER);
			stat.setInt(1, user.getId().getValue());
			stat.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void addUser(Benutzer user) {
		try {
			PreparedStatement stat = con.prepareStatement(ADD_USER);
			stat.setInt(1, user.getId().getValue());
			stat.setString(2, user.getName().getValue());
			stat.setString(3, user.getBerufsbild().getValue());
			stat.setInt(4, user.getAusbildungsjahr().getValue());
			stat.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
