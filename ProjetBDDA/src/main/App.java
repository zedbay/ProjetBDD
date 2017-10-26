package main;

public class App {

	public static void main(String[] args) {
		init();
		//Fenetre fenetre = new Fenetre();
		
		//Creation du menu et début
		Menu menu=new Menu();
		menu.start();
	}
	
	public static void init() {
		DbDef instanceUniqueDbDef = new DbDef(); 
	}
	
}
