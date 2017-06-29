package de.dpma.abwesenheitsliste.model;

import javafx.beans.binding.Bindings;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.util.StringConverter;
import javafx.util.converter.NumberStringConverter;

public class Benutzer {

	private IntegerProperty id = new SimpleIntegerProperty();
	private IntegerProperty ausbildungsjahr = new SimpleIntegerProperty();
	private StringProperty name = new SimpleStringProperty();
	private StringProperty berufsbild = new SimpleStringProperty();
	private StringProperty kategorie = new SimpleStringProperty();

	public Benutzer() {

	}

	public Benutzer(String name, String kategorie, String berufsbild, int ausbildungsjahr, int id) {
		this.name = new SimpleStringProperty(name);
		this.kategorie = new SimpleStringProperty(kategorie);
		this.berufsbild = new SimpleStringProperty(berufsbild);
		this.ausbildungsjahr = new SimpleIntegerProperty(ausbildungsjahr);
		this.id = new SimpleIntegerProperty(id);
	}

	public IntegerProperty getId() {
		/*
		 * @author Alexander Bacher <p> This is the getID Method <p> It will get
		 * the ID of the Benutzer
		 * 
		 * @since JDK 1.0
		 */
		return id;
		/*
		 * @author Alexander Bacher <p> This is the returnID Method <p> It will
		 * return the id of the Benutzer The data will be get from the getID
		 * Method
		 * 
		 * @return it will return the ID
		 * 
		 * @since JDK 1.0
		 */
	}

	public StringProperty convertId() {
		StringProperty dump = new SimpleStringProperty();
		StringConverter<Number> converter = new NumberStringConverter();
		Bindings.bindBidirectional(dump, id, converter);
		return dump;
	}

	public StringProperty convertAj() {
		StringProperty dump = new SimpleStringProperty();
		StringConverter<Number> converter = new NumberStringConverter();
		Bindings.bindBidirectional(dump, ausbildungsjahr, converter);
		return dump;
	}

	public void setId(int id) {
		this.id.set(id);
		/*
		 * @author Alexander Bacher <p> This is the setID Method <p> It will set
		 * the id of the Benutzer So the ID can´t be change
		 * 
		 * @since JDK 1.0
		 */
	}

	public IntegerProperty getAusbildungsjahr()
	/*
	 * @author Alexander Bacher <p> This is getAusbildungsjahr methode <p> It
	 * will get the current Ausbildungsjahr The Ausbildungsjahr is used for to
	 * define the year for the Benutzer
	 * 
	 * @since JDK 1.0
	 */ {
		return ausbildungsjahr;
		/*
		 * @author Alexander Bacher <p> This is the return ausbildungsjahr
		 * Method <p> It will return the year of the Ausbildungsjahr The data
		 * will be get from the getAusbildungsjahr
		 * 
		 * @return it will return the Ausbildungsjahr
		 * 
		 * @since JDK 1.0
		 */

	}

	public void setAusbildungsjahr(int ausbildungsjahr) {
		/*
		 * @author Alexander Bacher <p> This is the setAusbildungsjahr <p> It
		 * will set the Ausbildungsjahr of the Benutzer So the year is set and
		 * can´t be changed that easy
		 * 
		 * @since JDK 1.0
		 */
		this.ausbildungsjahr.set(ausbildungsjahr);
	}

	public StringProperty getName() /*
									 * @author Alexander Bacher <p> This is
									 * getName methode <p> It will get the Name
									 * of the Benutzer The Name is manually
									 * typed in the text field
									 * 
									 * @since JDK 1.0
									 */ {
		return name;
		/*
		 * @author Alexander Bacher <p> This is the return Name Method <p> It
		 * will return the Name of the Benutzer The data will be get from the
		 * getName Method
		 * 
		 * @return it will return the Benutzer Name
		 * 
		 * @since JDK 1.0
		 */
	}

	public void setName(String name)
	/*
	 * @author Alexander Bacher <p> This is the setName <p> It will set the Name
	 * of the Benutzer So the Name is set and can´t be changed that easy
	 * 
	 * @since JDK 1.0
	 */ {
		this.name.set(name);
	}

	public StringProperty getBerufsbild
	/*
	 * @author Alexander Bacher <p> This is getBerufsbild methode <p> It will
	 * get the current Berufsbild The Berufsbild is used for to define of the
	 * Berufsbild for the Benutzer
	 * 
	 * @since JDK 1.0
	 */() {
		return berufsbild;
		/*
		 * @author Alexander Bacher <p> This is the return BerufsbildMethod <p>
		 * It will return the Berufsbild of the Benutzer The return Berufsbild
		 * will be get the data from getBerufsbildMethod
		 * 
		 * @return it will return the Berufsbild
		 * 
		 * @since JDK 1.0
		 */
	}

	public void setBerufsbild(String berufsbild)
	/*
	 * @author Alexander Bacher <p> This is the setBerufsbild <p> It will set
	 * the Berufsbild of the Benutzer So the Berufsbild is set and can´t be
	 * changed that easy
	 * 
	 * @since JDK 1.0
	 */ {
		this.berufsbild.set(berufsbild);
	}

	public StringProperty getKategorie()
	/*
	 * @author Alexander Bacher <p> This is getKategorie methode <p> It will get
	 * the current Kategorie The Kategorie is used to define the category of the
	 * Benutzer
	 * 
	 * @since JDK 1.0
	 */ {
		return kategorie;
		/*
		 * @author Alexander Bacher <p> This is the return kategorie <p> It will
		 * return the kategorie of the Benutzer The return kategorie will be get
		 * the data from getKategorie
		 * 
		 * @return it will return the kategorie
		 * 
		 * @since JDK 1.0
		 */
	}

	public void setKategorie(String kategorie)
	/*
	 * @author Alexander Bacher <p> This is the setKategorie <p> It will set the
	 * Kategorie of the Benutzer So the Kategorie is set and can´t be changed
	 * that easy
	 * 
	 * @since JDK 1.0
	 */ {
		this.kategorie.set(kategorie);
	}
}
