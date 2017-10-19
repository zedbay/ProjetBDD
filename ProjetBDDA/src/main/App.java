package main;

public class App {

	public static void main(String[] args) {
		
		Fenetre fenetre = new Fenetre();
		fenetre.setVisible(true);
		Choix choice =new Menu(2);
		choice.choix(2);
	}
	
}
