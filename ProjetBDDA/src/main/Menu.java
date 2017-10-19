package main;

public  class Menu implements Choix,Affichage {

	int choix;
	public Menu(int choix) {
		this.choix=choix;
	}
	
	@Override
	public void choix(Integer arg) {
		// TODO Auto-generated method stub
		Affichage.afficher();
		switch(arg) {
			case 0: 
				System.out.println("sortir()");
				break;
			case 1:
				System.out.println("creationFichier(String nom");
				break;
			case 2:
				System.out.println("creationPage(Strign nom)");
				break;
			case 3:
				System.out.println("creationRelation");
				break;
			default: 
				System.out.println("Choix erron�");
				Affichage.afficher();
		}
	}
}
