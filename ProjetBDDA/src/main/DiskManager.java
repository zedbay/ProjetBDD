package main;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;

public class DiskManager {
	
	public static void createFile(int fileId) {
		File newFile = new File("DB" + File.separator + "Data_" + fileId + ".rf");
		try {
			if(newFile.createNewFile()) {
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
		try {
			RandomAccessFile out = new RandomAccessFile(newFile, "rw");
			byte[] buf = new byte[4096];
			long tailleFichier = newFile.length();
			System.out.println(tailleFichier);
			out.seek(tailleFichier);
			out.write(buf);
		} catch (IOException e) {
			e.printStackTrace();
		}
		PageId pi1 = new PageId(1,1);
		return(pi1);
	}
	
	public static void  readPage(PageId pageId) {
		
	}
	
	public static void writePage() {
		
	}
}
