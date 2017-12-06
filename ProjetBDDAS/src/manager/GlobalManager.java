package manager;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import bdd.HeapFile;
import bdd.Record;
import bdd.RelDef;
import exception.NombreArgumentInvalide;
import exception.argumentInvalide;
import exception.RelationErreur;

public class GlobalManager {

	private static bdd.DbDef dbDef;
	private static ArrayList<HeapFile> listHeapFile = new ArrayList<HeapFile>();

	public static void init() throws IOException, ClassNotFoundException {
		File newFile = new File("DB" + File.separator + "Catalog.def");
		if (newFile.exists()) {
			FileInputStream fis = new FileInputStream(newFile);
			ObjectInputStream ois = new ObjectInputStream(fis);
			dbDef = (bdd.DbDef) ois.readObject();
			ois.close();
			fis.close();
		} else {
			dbDef = new bdd.DbDef();
		}
		refreshHeapFiles();
		BufferManager.bufferManager();
	}

	public static void createRelation(String[] rep) throws IOException {
		try {
			int nbArgumentAttendu = rep.length - 3;
			if (Integer.parseInt(rep[2]) != nbArgumentAttendu) {
				throw new NombreArgumentInvalide();
			}
			try {
				bdd.RelSchema rs1 = new bdd.RelSchema(rep);
				bdd.RelDef rd1 = new bdd.RelDef(dbDef.getCompteurRelation(), rs1);
				DiskManager.createFile(dbDef.getCompteurRelation());
				dbDef.ajoutRelDef(rd1);
				HeapFile hp1 = new bdd.HeapFile(rd1);
				listHeapFile.add(hp1);
				hp1.createHeader();
			} catch (argumentInvalide e) {
			}
		} catch (NombreArgumentInvalide e) {
		}
	}

	public static void finish() throws IOException {
		File newFile = new File("DB" + File.separator + "Catalog.def");
		if (!newFile.exists()) {
			newFile.createNewFile();
		}
		try (FileOutputStream fos = new FileOutputStream(newFile);
				ObjectOutputStream oos = new ObjectOutputStream(fos);) {
			oos.writeObject(dbDef);
		}
		BufferManager.flushAll();
	}

	public static void refreshHeapFiles() {
		ArrayList<RelDef> ar1 = dbDef.getAr1();
		for (RelDef rd : ar1) {
			HeapFile tmp = new HeapFile(rd);
			listHeapFile.add(tmp);
		}
	}

	public static bdd.DbDef getDbDef() {
		return (dbDef);
	}

	public static void insert(String[] rep) throws FileNotFoundException, IOException {
		String nomRelation = rep[1];
		ArrayList<String> valAtt = new ArrayList<String>();
		for (int i = 2; i < rep.length; i++) {
			valAtt.add(rep[i].toString());
		}
		bdd.Record r1 = new bdd.Record(valAtt);
		try {
			HeapFile hp = null;
			for (int j = 0; j < listHeapFile.size(); j++) {
				if (listHeapFile.get(j).getRd().getRelShema().getNom().equals(nomRelation)) {
					hp = listHeapFile.get(j);
				}
			}
			if (hp == null) {
				throw new RelationErreur();
			}
			hp.insertRecord(r1);
		} catch (RelationErreur e) {
		}
		System.out.println(r1);
	}

	public static void selectAll(String name) throws FileNotFoundException, IOException {
		HeapFile hp = null;
		try {
			for (int i = 0; i < listHeapFile.size(); i++) {
				if (listHeapFile.get(i).getRd().getRelShema().getNom().equals(name)) {
					hp = listHeapFile.get(i);
				} else {
					throw new RelationErreur();
				}
			}
			hp.printAllRecord();
		} catch (RelationErreur e) {
		}

	}

	public static void clean() {
		File path = new File("DB");
		if (path.exists()) {
			File[] files = path.listFiles();
			for (File f : files) {
				f.delete();
			}
		}
	}

	public static void fill(String[] rep) throws IOException {
		String nomRelation = rep[1];
		String nomFichier = rep[2];
		BufferedReader br = new BufferedReader(new FileReader(nomFichier));
		// FileInputStream fis=new FileInputStream(new File(nomFichier));
		while (br.readLine() != null) {
			String line = br.readLine();
			ArrayList<String> array = new ArrayList<>();
			for (String str : line.split(",")) {
				array.add(str);
			}
			Record record=new Record(array);
			HeapFile hp=new HeapFile();
			hp.insertRecord(record);
		}
		br.close();
	}
}
