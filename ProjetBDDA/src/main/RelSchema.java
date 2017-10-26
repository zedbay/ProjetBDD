package main;

import java.util.ArrayList;

public class RelSchema {
	
	private String nom;
	private int nbrCol;
	private ArrayList<String> typeCol;
	private final int stringT = 30;
	
	public RelSchema (String nom, int nbrCol, ArrayList<String> typeCol) {
		this.nom = nom;
		this.nbrCol = nbrCol;
		this.typeCol = typeCol;
	}
	
	public String toString() {
		String rep = new String("La relation " + this.nom + " a " + this.nbrCol + " colonnes qui sont : " +  this.typeCol.toString());
		return(rep);
	}
}
