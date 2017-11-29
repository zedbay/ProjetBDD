package bdd;

import java.util.ArrayList;

public class HeaderPage {
	
	private int nbPageDeDonnees;
	private ArrayList<Infos> infos;
	
	public HeaderPage(int npdd, ArrayList<Infos> infos) {
		this.nbPageDeDonnees = npdd;
		this.infos = infos;
	}
	
	public HeaderPage(int npdd) {
		this.nbPageDeDonnees = npdd;
		this.infos = new ArrayList<Infos>();
	}
	
	public HeaderPage() {
		this.infos = new ArrayList<Infos>();
	}
	
	public void setNbPageDeDonnees(int nb) {
		this.nbPageDeDonnees = nb;
	}
	
	public ArrayList<Infos> getInfos() {
		return(this.infos);
	}
	
	public void addInfos (Infos inf) {
		this.infos.add(inf);
	}
	
	public int getNbPageDeDonnees() {
		return(this.nbPageDeDonnees);
	}
	
}
