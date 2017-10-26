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
}
