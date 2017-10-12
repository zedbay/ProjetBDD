package bdd;

public interface Affichage {
	public static void afficher() {
		System.out.println("BONJOUR\n"
				+ "Entrez un entier pour exécuter l'une des commandes suivantes :\n\t"
				+"\"0\":Sortir\n\t"
				+ "\"1\": Création d'un fichier\n\t"
				+ "\"2\":Création d'une page\n\t"
				+"\"3\":Création dune relation\n\t");
	}
}
