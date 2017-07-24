package de.dpma.abwesenheitsliste.model;

import java.sql.Date;
import java.time.LocalDate;

import javafx.beans.binding.Bindings;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.util.StringConverter;
import javafx.util.converter.NumberStringConverter;

public class Termin {

	private IntegerProperty id = new SimpleIntegerProperty();
	private StringProperty name = new SimpleStringProperty();
	private StringProperty kategorie = new SimpleStringProperty();
	private StringProperty kommentar = new SimpleStringProperty();

	public Termin() {

	}

	public Termin(String name, String kategorie, String kommentar, int id) {
		this.name = new SimpleStringProperty(name);
		this.id = new SimpleIntegerProperty(id);
		this.kategorie = new SimpleStringProperty(kategorie);
		this.kommentar = new SimpleStringProperty(kommentar);
	}

	public StringProperty getKategorie() {
		return kategorie;
	}

	public void setKategorie(String kategorie) {
		this.kategorie.set(kategorie);
	}

	public StringProperty getKommentar() {
		return kommentar;
	}

	public void setKommentar(String kommentar) {
		this.kommentar.set(kommentar);
	}

	public IntegerProperty getId() {
		return id;
	}

	public StringProperty convertId() {
		StringProperty dump = new SimpleStringProperty();
		StringConverter<Number> converter = new NumberStringConverter();
		Bindings.bindBidirectional(dump, id, converter);
		return dump;
	}

	public void setId(IntegerProperty id) {
		this.id = id;
	}

	public StringProperty getName() {
		return name;
	}

	public void setName(String name) {
		this.name.set(name);
	}

	public void setVon(Date date) {
		// TODO Auto-generated method stub

	}

	public void setBis(Date date) {
		// TODO Auto-generated method stub

	}

	public void setVon(LocalDate value) {
		// TODO Auto-generated method stub

	}

	public void setBis(LocalDate value) {
		// TODO Auto-generated method stub

	}
}