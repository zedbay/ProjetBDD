package managers;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import main.DbDef;

public class GlobalManager {

	private static DbDef db;

	public static void init() throws IOException {
		try {
			File newFile = new File("DB"+File.separator+"Catalog.def");
			FileInputStream fis = new FileInputStream(newFile);
			ObjectInputStream ois = new ObjectInputStream(fis);
			db = (DbDef) ois.readObject();
			ois.close();
			fis.close();
		} catch (IOException | ClassNotFoundException e) {
			db = new DbDef();
		}
	}

	public static void finish() throws IOException {
		File newFile = new File("DB"+File.separator+"Catalog.def");
		try (FileOutputStream fos = new FileOutputStream(newFile); ObjectOutputStream oos = new ObjectOutputStream(fos);) {
			oos.writeObject(db);
		}
	}
}
