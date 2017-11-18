package main;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class RelSchema implements Serializable{

	private static final long serialVersionUID = 1L;
	private String nom;
	private int nbrCol;
	private ArrayList<String> typeCol;
	private final int stringT = 30;

	public RelSchema(String nom, int nbrCol, ArrayList<String> typeCol) {
		this.nom = nom;
		this.nbrCol = nbrCol;
		this.typeCol = typeCol;
	}

	public String toString() {
		String rep = new String(
				"La relation " + this.nom + " a " + this.nbrCol + " colonnes qui sont : " + this.typeCol.toString());
		return (rep);
	}

	public void display() {
		System.out.println(this.toString());
	}
	public int getStringT() {
		return(stringT);
	}
	
	public String getName() {
		return nom;
	}

	public void setName(String nom) {
		this.nom = nom;
	}

	public int getNbrCol() {
		return nbrCol;
	}

	public void setNbrCol(int nbrCol) {
		this.nbrCol = nbrCol;
	}

	public List<String> getTypeCol() {
		return typeCol;
	}

	public void setTypeCol(ArrayList<String> typeCol) {
		this.typeCol = typeCol;
	}
}
