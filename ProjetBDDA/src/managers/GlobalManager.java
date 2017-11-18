package managers;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.StringTokenizer;

import main.DbDef;
import main.RelDef;
import main.RelSchema;

public class GlobalManager {

	private static DbDef db;
	private ArrayList<main.HeapFile> hps;

	public static void init() throws IOException {
		try {
			File newFile = new File("DB" + File.separator + "Catalog.def");
			FileInputStream fis = new FileInputStream(newFile);
			ObjectInputStream ois = new ObjectInputStream(fis);
			db = (DbDef) ois.readObject();
			ois.close();
			fis.close();
		} catch (IOException | ClassNotFoundException e) {
			db = new DbDef();
		}
	}

	public static RelSchema creationRelation(String commande) throws IOException {
		StringTokenizer commande1 = new StringTokenizer(commande);
		// test si le premier mot est "create"
		if (commande1.nextElement().equals(new StringTokenizer("create").nextElement())) {
			String nameRelation = (String) commande1.nextElement();
			int nbrColRelation = Integer.parseInt(commande1.nextElement().toString());
			ArrayList<String> typeColRelation = new ArrayList();
			while (commande1.hasMoreTokens()) {
				typeColRelation.add(commande1.nextToken().toString());
			}
			RelSchema r1 = new RelSchema(nameRelation, nbrColRelation, typeColRelation);
			RelDef rd1 = new RelDef(db.getCompteurRelation(), r1);
			db.ajoutRelDef(rd1);
			DiskManager.createFile(rd1.getFileId());
			return r1;
		} else {
			System.out.println("Erreur commande non reconnue");
			return null;
		}
		
	}

	public static void finish() throws IOException {
		File newFile = new File("DB" + File.separator + "Catalog.def");
		try (FileOutputStream fos = new FileOutputStream(newFile);
				ObjectOutputStream oos = new ObjectOutputStream(fos);) {
			oos.writeObject(db);
		}
	}

	public void resfreshHeapFiles() {
		ArrayList<main.RelDef> ar1 = db.getAr1();
		for (main.RelDef rd : ar1) {

		}
	}

}
