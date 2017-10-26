package main;

import java.util.ArrayList;

public class DbDef {
	
	public int compteurRelation;
	public ArrayList<RelDef> ar1;
	
	public DbDef() {
		this.compteurRelation = 0;
		this.ar1 = new ArrayList<RelDef>();
	}
	
	public void ajoutRelDef (RelDef r1) {
		ar1.add(r1);
		compteurRelation++;
	}
	
	public int getCompteurRelation () {
		return(this.compteurRelation);
	}
}
