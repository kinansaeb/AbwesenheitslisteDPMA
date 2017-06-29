package de.dpma.abwesenheitsliste.model;

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

	public Termin() {

	}

	public Termin(String name, String kategorie, String kommentar, int id) {
		this.name = new SimpleStringProperty(name);
		this.id = new SimpleIntegerProperty(id);
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

	public void setName(StringProperty name) {
		this.name = name;
	}
}