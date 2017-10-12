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
	
	public static PageId addPage(int fildeIdx) {
		PageId pi1 = new PageId(1,1);
		return(pi1);
	}
	
	public static void  readPage(PageId pageId) {
		
	}
	
	public static void writePage() {
		
	}
}
