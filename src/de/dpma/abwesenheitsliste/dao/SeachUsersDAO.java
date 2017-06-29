package de.dpma.abwesenheitsliste.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import de.dpma.abwesenheitsliste.model.Termin;

public class SeachUsersDAO {

	final String SELECT_ALL = "SELECT * FROM ROOT.TERMINEDB";
	private final Connection con;

	public SearchUsersDAO(Connection con) {
		this.con = con;
	}

	public List<Terminliste> allTermine() throws SQLException {
		PreparedStatement stat = con.prepareStatement(SELECT_ALL);
		ResultSet result = stat.executeQuery();
		ArrayList<Terminliste> Termin = new Arraylist<>();
		while (result.next()) {
			Terminliste Termin = new Termin();
			Termin.setName(result.getString("name"));
			Termin.setVon(result.getDate("von"));
			Termin.setBis(result.getDate("bis"));
			Termin.setKategorie(result.getString("kategorie"));
			Termin.setKommentar(result.getString("kommentar"));

			Termin.add(Termin);
		}
		return Termin;
	}
}
