package composant;

import java.io.IOException;
import java.util.Scanner;
import java.util.StringTokenizer;



public class MenuConsole {
	
	public static void ligneCommande() throws IOException{
		Scanner sc = new Scanner(System.in);
		String[] rep;
		do {
			StringTokenizer tmp = new StringTokenizer(sc.nextLine());
			rep = new String[tmp.countTokens()];
			int i = 0;
			while(tmp.hasMoreTokens()) {
				rep[i] =tmp.nextToken();
				i++;
			}
			switch(rep[0]) {
				case "create":
					manager.GlobalManager.createRelation(rep);
					break;
				case "exit":
					manager.GlobalManager.finish();
					break;
				case "debug":
					test.Debug.debug(rep);
					break;
				case "insert":
					manager.GlobalManager.insert(rep);
					break;
				case "selectall":
					manager.GlobalManager.selectAll(rep[1]);
					break;
				case"clean":
					manager.GlobalManager.clean();
					break;
				case"fill":
					manager.GlobalManager.fill(rep);
					break;
				default:
					System.out.println("Commande non reconnue, taper help pour de l'aide");
			}
		} while (!rep[0].equals("exit"));
		sc.close();
	}
	
	public void interfaceGraphique () {
		
	}
	
}
