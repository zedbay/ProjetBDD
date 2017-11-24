package bdd;

public class Infos {
	
	int idxPage;
	int nbSlotsRestantsDisponibles;
	
	public Infos (int idxPage, int NSD) {
		setIdxPage(idxPage);
	}
	
	public void setIdxPage(int idxPage) {
		this.idxPage = idxPage;
	}
	
	public void setNbSlotsRestantsDisponibles(int NSD) {
		this.nbSlotsRestantsDisponibles = NSD;
	}
	
	public int getIdxPage() {
		return(this.idxPage);
	}
	
	public int getNbSlotsRestantsDisponibles() {
		return(this.nbSlotsRestantsDisponibles);
	}
}
