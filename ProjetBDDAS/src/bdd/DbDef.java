package bdd;

import java.io.Serializable;
import java.util.ArrayList;

public class DbDef implements Serializable {

	private static final long serialVersionUID = 1L;
	public int compteurRelation;
	public ArrayList<RelDef> ar1;

	public DbDef() {
		this.compteurRelation = 0;
		this.ar1 = new ArrayList<RelDef>();
	}

	public void ajoutRelDef(RelDef r1) {
		ar1.add(r1);
		this.compteurRelation++;
	}
	
	public ArrayList<RelDef> getAr1() {
		return(this.ar1);
	}

	public int getCompteurRelation() {
		return (this.compteurRelation);
	}

	public String toString() {
		String rep = new String("La bdd a " + this.compteurRelation + " relations : ");
		for(int i=0;i<this.ar1.size();i++) {
			rep = rep + "\n" + ar1.get(i);
		}
		return (rep);
	}
}
