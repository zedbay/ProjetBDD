package main;

import java.util.ArrayList;

public class RelSchema {
	
	public int nombreCol;
	public String nom;
	public ArrayList<String> typeCol;
	public int stringT;
	
	public RelSchema (int nombreCol, String nom, ArrayList<String> typeCol, int stringT) {
		this.setNom(nom);
		this.setNombreCol(nombreCol);
		this.setStringT(stringT);
		this.setTypeCol(typeCol);		
	}
	
	private void setNombreCol(int nombreCol) {
		this.nombreCol = nombreCol;
	}
	private void setNom(String nom) {
		this.nom = nom;
	}
	private void setTypeCol(ArrayList<String> typeCol) {
		this.typeCol = typeCol;
	}
	private void setStringT(int stringT) {
		this.stringT = stringT;
	}
	
	public int getNombreCol() {
		return(this.nombreCol);
	}
	public String getNom() {
		return(this.nom);
	}
	public ArrayList<String> getTypeCol() {
		return(this.typeCol);
	}
	public int getStringT() {
		return(this.stringT);
	}
	
}
