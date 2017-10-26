package main;

import java.util.ArrayList;
import java.util.StringTokenizer;

public class App {
	
	static DbDef instanceUniqueDbDef;

	public static void main(String[] args) {
		//Fenetre fenetre = new Fenetre();
		//Creation du menu et début
		//Menu menu=new Menu();
		//menu.start();
		init();
		System.out.println(instanceUniqueDbDef);
		finish();
	}
	
	public static void init() {
		instanceUniqueDbDef = new DbDef(); 
	}
	
	/******
	 * @param commande reçu de l'UI
	 * @return une relation 
	 */
	public void creationRelation(String commande) {
		StringTokenizer commande1 = new StringTokenizer(commande);
		//test si le premier mot est "create"
		if(commande1.nextElement().equals(new StringTokenizer("create").nextElement())) {
			String nameRelation = (String) commande1.nextElement();
			int nbrColRelation = Integer.parseInt(commande1.nextElement().toString());
			ArrayList<String> typeColRelation = new ArrayList();
			while(commande1.hasMoreTokens()) {
				typeColRelation.add(commande1.nextToken().toString());
			}
			RelSchema r1 =  new RelSchema(nameRelation, nbrColRelation, typeColRelation);
			RelDef rd1 = new RelDef(this.instanceUniqueDbDef.getCompteurRelation(), r1);
			this.instanceUniqueDbDef.ajoutRelDef(rd1);
			DiskManager.createFile(rd1.getFileId());
		} else {
			System.out.println("Erreur commande non reconnue");
		}
	}
	
	public static void finish() {
		System.out.println(DiskManager.createCatalog());
	}
	
}
