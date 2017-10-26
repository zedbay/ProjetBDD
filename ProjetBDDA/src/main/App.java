package main;

import java.util.ArrayList;
import java.util.StringTokenizer;

public class App {

	public static void main(String[] args) {
		init();
		//Fenetre fenetre = new Fenetre();
		
		//Creation du menu et début
		//Menu menu=new Menu();
		//menu.start();
	}
	
	public static void init() {
		DbDef instanceUniqueDbDef = new DbDef(); 
	}
	
	/******
	 * 
	 * @param commande reçu de l'UI
	 * @return une relation 
	 */
	public static RelSchema creationRelation(String commande) {
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
			return(r1);
		} else {
			System.out.println("Erreur commande non reconnue");
			return(null);
		}
	}
	
}
