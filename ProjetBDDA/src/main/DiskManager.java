package main;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class DiskManager {
	
	public static void createFile(int fileId) {
		File newFile = new File("DB" + File.separator + "Data_" + fileId + ".rf");
		try {
			FileWriter fw = new FileWriter(newFile);
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void addPage() {
		
	}
	
	public static void  readPage() {
		
	}
	
	public static void writePage() {
		
	}
}
