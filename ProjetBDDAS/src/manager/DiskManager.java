package manager;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;

public class DiskManager {
	
	public static void createFile(int fileId) throws IOException {
		File newFile = new File("DB" + File.separator + "Data_" + fileId + ".rf");
		if (newFile.createNewFile()) {
			//System.out.println("Fichier cree");
		} else {
			//System.out.println("Fichier existant");
		}
	}
	
	public static bdd.PageId addPage(int fileId) throws FileNotFoundException, IOException {
		File newFile = new File("DB" + File.separator + "Data_" + fileId + ".rf");
		try (RandomAccessFile out = new RandomAccessFile(newFile, "rw")) {
			int idx = (int) (newFile.length() / bdd.Constante.PAGESIZE);
			out.seek(newFile.length());
			for (int i = 0; i < bdd.Constante.PAGESIZE; i++) {
				out.writeByte((byte) 0);
			}
			out.close();
			return (new bdd.PageId(fileId, idx));
		}
	}
	
	public static void readPage(bdd.PageId pid, ByteBuffer buffer) throws FileNotFoundException, IOException {
		File newFile = new File("DB" + File.separator + "Data_" + pid.getFileId() + ".rf");
		buffer.position(0);
		try (RandomAccessFile in = new RandomAccessFile(newFile, "r")) {
			in.seek(bdd.Constante.PAGESIZE * pid.getIdx());
			for (int i = 0; i < bdd.Constante.PAGESIZE; i++) {
				buffer.put(in.readByte());
			}
			in.close();
		}
	}
	
	public static void writePage(bdd.PageId pid, ByteBuffer buffer) throws FileNotFoundException, IOException {
		File newFile = new File("DB" + File.separator + "Data_" + pid.getFileId() + ".rf");
		buffer.position(0);
		try (RandomAccessFile in = new RandomAccessFile(newFile, "rw")) {
			in.seek(bdd.Constante.PAGESIZE * pid.getIdx());
			for (int i = 0; i < bdd.Constante.PAGESIZE; i++) {
				in.writeByte(buffer.get(i));
			}
		}
	}
	
}
