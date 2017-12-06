package bdd;

import java.util.ArrayList;

public class Record {
	
	private ArrayList<String> valeursAttributs;
	
	public Record(ArrayList<String> va) {
		setValeursAttributs(va);
	}
	
	public Record() {
		this.valeursAttributs = new ArrayList<String>();
	}
	
	public void setValeursAttributs(ArrayList<String> va) {
		this.valeursAttributs = va;
	}
	
	public String getValeursAttributs(int i) {
		return(this.valeursAttributs.get(i));
	}
	
	public ArrayList<String > getValeurAttributs(){
		return this.valeursAttributs;
	}
	
	public String toString() {
		return("Les valeurs du record sont : " + valeursAttributs);
	}
}
