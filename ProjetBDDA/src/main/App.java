package main;

public class App {

	public static void main(String[] args) {
		PageId pi1 = new PageId(3,3);
		StringBuffer buff = DiskManager.readPage(pi1);
		System.out.println(buff);
		//Fenetre fenetre = new Fenetre();
		//fenetre.setVisible(true);
		//Choix choice =new Menu(2);
		//choice.choix(2);
	}
	
}
