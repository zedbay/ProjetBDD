package test;

import manager.GlobalManager;

public class Debug {

	public static void debug(String rep[]) {
		try {
			switch (rep[1]) {
				case "bdd":
					System.out.println(GlobalManager.getDbDef());
					break;
				default:
					System.out.println("debug non reconnue");
					break;	
			}
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("debug nécessite un argument");
		}
	}
}
