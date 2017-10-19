package main;

import java.util.ArrayList;

public class DbDef {
	
	public int compteurRelation;
	public ArrayList<RelDef> ar1;
	
	public DbDef() {
		this.compteurRelation = 0;
		this.ar1 = new ArrayList<RelDef>();
	}
}
