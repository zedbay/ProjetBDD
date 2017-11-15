package main;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

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

	public static void createFile(int fileId) {
		File newFile = new File("DB" + File.separator + "Data_" + fileId + ".rf");
		try {
			if (newFile.createNewFile()) {
				System.out.println("Fichier crée");
			} else {
				System.out.println("Fichier existant");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static PageId addPage(int fileId) {
		File newFile = new File("DB" + File.separator + "Data_" + fileId + ".rf");
		try (RandomAccessFile out = new RandomAccessFile(newFile, "rw")) {
			byte[] buf = new byte[4096];
			long tailleFichier = newFile.length();
			out.seek(tailleFichier);
			out.write(buf);
		} catch (IOException e) {
			e.printStackTrace();
		}
		PageId pi1 = new PageId(1, 1);
		return (pi1);
	}

	public static StringBuffer readPage(PageId pageId) {
		StringBuffer res = new StringBuffer("");
		File newFile = new File("DB" + File.separator + "Data_" + pageId.getFileId() + ".rf");
		try (RandomAccessFile in = new RandomAccessFile(newFile, "r")) {
			in.seek(4096 * pageId.getIdx());
			for (int i = 0; i < 4096; i++) {
				res.append(in.readByte());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return (res);
	}

	public static void writePage(PageId pageId, String buffer) {
		File newFile = new File("DB" + File.separator + "Data_" + pageId.getFileId() + ".rf");
		try (RandomAccessFile out = new RandomAccessFile(newFile, "rw")) {
			out.seek(4096 * pageId.getIdx());
			out.writeBytes(buffer);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
