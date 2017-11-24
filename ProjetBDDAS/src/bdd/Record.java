package bdd;

import java.util.ArrayList;

public class Record {
	
	private ArrayList<String> valeursAttributs;
	
	public Record(ArrayList<String> va) {
		setValeursAttributs(va);
	}
	
	public void setValeursAttributs(ArrayList<String> va) {
		this.valeursAttributs = va;
	}
	
	public String getValeursAttributs(int i) {
		return(this.valeursAttributs.get(i));
	}
	
	public String toString() {
		return("Les valeurs du record sont : " + valeursAttributs);
	}
}
