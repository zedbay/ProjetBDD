package managers;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;

import constantes.Constante;
import main.SceneBDD;

public class DiskManager {

	public static boolean createCatalog() {
		File newFile = new File("DB" + File.separator + "Catalog.def");
		try {
			if (newFile.createNewFile()) {
				return (true);
			} else {
				return (false);
			}
		} catch (IOException e) {
			e.printStackTrace();
			return (false);
		}
	}

	public static void createFile(int fileId) throws IOException {

		File newFile = new File("DB" + File.separator + "Data_" + fileId + ".rf");
		if (newFile.createNewFile()) {
			SceneBDD.setArea("Fichier créé\n");
		} else {
			SceneBDD.setArea("Fichier existant\n");
		}
	}


	public static PageId addPage(int fileId) throws IOException {

		File newFile = new File("DB" + File.separator + "Data_" + fileId + ".rf");
		try (RandomAccessFile out = new RandomAccessFile(newFile, "rw")) {
			int idx = (int) (newFile.length() / Constante.PAGESIZE);
			out.seek(newFile.length());

			for (int i = 0; i < Constante.PAGESIZE; i++) {
				out.writeByte((byte) 0);
			}

			out.close();
			return (new PageId(fileId, idx));
		}
		
		

	}

	public static void readPage(PageId pageId, ByteBuffer buffer) {
		File newFile = new File("DB" + File.separator + "Data_" + pageId.getFileId() + ".rf");
		try (RandomAccessFile in = new RandomAccessFile(newFile, "r")) {
			in.seek(Constante.PAGESIZE * pageId.getIdx());
			for (int i = 0; i < Constante.PAGESIZE; i++) {
				buffer.put(in.readByte());
			}
			in.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static void writePage(PageId page, ByteBuffer buffer) throws IOException {

		if (page != null) {

			buffer.position(0);
			File newFile = new File("DB" + File.separator + "Data_" + page.getFileId() + ".rf");
			try (RandomAccessFile out = new RandomAccessFile(newFile, "rw")) {
				out.seek(Constante.PAGESIZE * page.getIdx());
				for (int i = 0; i < Constante.PAGESIZE; i++) {
					out.writeByte(buffer.get(i));
				}

				out.close();

			}
		}
	}
}
