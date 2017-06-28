package de.dpma.abwesenheitsliste.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import de.dpma.abwesenheitsliste.model.Benutzer;

public class manageUsersDAO {
	// public SimpleIntegerProperty userName = new SimpleIntegerProperty();
	final String SELECT_ALL_USERS = "SELECT * FROM ROOT.BENUTZER";
	private final Connection con;

	public List<Benutzer> allUsers() throws SQLException {
		PreparedStatement stat = con.prepareStatement(SELECT_ALL_USERS);
		ResultSet result = stat.executeQuery();

		ArrayList<Benutzer> User = new ArrayList<>();
		while (result.next()) {
			User Users = new User();
			Users.setBerufsbild(result.getString("berufsbild"));
			Users.setAusbildungsjahr(result.getInt("ausbildungsjahr"));
			Users.setCategory(result.getString("kategorie"));
			Users.setId(result.getInt("id"));
			Users.setName(result.getString("name"));

			User.add(Users);
		}
		return User;
	}
}
