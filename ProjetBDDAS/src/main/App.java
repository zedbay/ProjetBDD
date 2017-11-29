package main;

import java.io.IOException;

public class App {
	

	public static void main(String[] arg) throws IOException, ClassNotFoundException {
		manager.GlobalManager.init();
		composant.MenuConsole.ligneCommande();	
	}
	
	public static void test () throws IOException {
		//manager.DiskManager.createFile(1);
		//bdd.PageId pidTest = manager.DiskManager.addPage(1);
		//ByteBuffer bbuf = ByteBuffer.allocate(bdd.Constante.PAGESIZE);
		//manager.DiskManager.readPage(pidTest,bbuf);
		//System.out.println(bbuf.get(0));
		
		//manager.DiskManager.createFile(2);
		//bdd.PageId pidTest2 = new bdd.PageId(2,2);
		//manager.DiskManager.writePage(pidTest2,bbuf);
		//ByteBuffer bbuf1 = ByteBuffer.allocate(bdd.Constante.PAGESIZE);
		//manager.DiskManager.readPage(pidTest2,bbuf1);
		//System.out.println(bbuf1.get(4095));
		
		//manager.DiskManager.addPage(0);
		//bdd.PageId pidTest3 = new bdd.PageId(0,0);
		//manager.BufferManager.bufferManager();
		//ByteBuffer bbuf = manager.BufferManager.getPage(pidTest3);
		//System.out.println(bbuf.get(4095));
	}
}
