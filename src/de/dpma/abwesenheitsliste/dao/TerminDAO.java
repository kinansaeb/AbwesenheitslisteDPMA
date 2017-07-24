package de.dpma.abwesenheitsliste.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import de.dpma.abwesenheitsliste.model.Termin;

public class TerminDAO {

	final String SELECT_ALL = "SELECT * FROM ROOT.TERMINEDB";
	final String ADD_SCHEDULE = "INSERT INTO ROOT.TERMINEDB(NAME, KOMMENTAR, KATEGORIE, VON, BIS(?, ?, ?, ?,?)";
	private final Connection con;

	public TerminDAO(Connection con) {
		this.con = con;
	}

	public List<Termin> allTermine() throws SQLException {
		PreparedStatement stat = con.prepareStatement(SELECT_ALL);
		ResultSet result = stat.executeQuery();
		ArrayList<Termin> Termin = new ArrayList<>();
		while (result.next()) {
			Termin Termin1 = new Termin();

			Termin1.setName(result.getString("name"));
			Termin1.setVon(result.getDate("von"));
			Termin1.setBis(result.getDate("bis"));
			Termin1.setKategorie(result.getString("kategorie"));
			Termin1.setKommentar(result.getString("kommentar"));

			Termin.add(Termin1);
		}
		return Termin;
	}

	public void addSchedule(Termin schedule) {
		try {
			PreparedStatement stat = con.prepareStatement(ADD_SCHEDULE);
			stat.setString(1, schedule.getName().getValue());
			stat.setString(2, schedule.getKommentar().getValue());
			stat.setString(3, schedule.getKategorie().getValue());
			stat.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
