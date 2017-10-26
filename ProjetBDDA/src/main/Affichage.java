package main;

public interface Affichage {
	public static void afficher() {
		System.out.println("BONJOUR\n"
				+ "Entrez un entier pour ex�cuter l'une des commandes suivantes :\n\t"
				+"\"0\":Sortir\n\t"
				+ "\"1\": Cr�ation d'un fichier\n\t"
				+ "\"2\":Cr�ation d'une page\n\t"
				+"\"3\":Cr�ation dune relation\n\t");
	}
}
