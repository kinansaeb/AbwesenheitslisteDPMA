package de.dpma.abwesenheitsliste.model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Benutzer {

	private IntegerProperty id = new SimpleIntegerProperty();
	private IntegerProperty ausbildungsjahr = new SimpleIntegerProperty();
	private StringProperty name = new SimpleStringProperty();
	private StringProperty berufsbild = new SimpleStringProperty();
	private StringProperty kategorie = new SimpleStringProperty();

	public Benutzer(String name, String berufsbild, String kategorie, int id, int ausbildungsjahr) {
		this.name = new SimpleStringProperty(name);
		this.kategorie = new SimpleStringProperty(kategorie);
		this.berufsbild = new SimpleStringProperty(berufsbild);
		this.ausbildungsjahr = new SimpleIntegerProperty(ausbildungsjahr);
		this.id = new SimpleIntegerProperty(id);
	}

	public IntegerProperty getId() {
		return id;
	}

	public void setId(IntegerProperty id) {
		this.id = id;
	}

	public IntegerProperty getAusbildungsjahr() {
		return ausbildungsjahr;
	}

	public void setAusbildungsjahr(IntegerProperty ausbildungsjahr) {
		this.ausbildungsjahr = ausbildungsjahr;
	}

	public StringProperty getName() {
		return name;
	}

	public void setName(StringProperty name) {
		this.name = name;
	}

	public StringProperty getBerufsbild() {
		return berufsbild;
	}

	public void setBerufsbild(StringProperty berufsbild) {
		this.berufsbild = berufsbild;
	}

	public StringProperty getKategorie() {
		return kategorie;
	}

	public void setKategorie(StringProperty kategorie) {
		this.kategorie = kategorie;
	}
}
