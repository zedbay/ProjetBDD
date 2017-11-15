package managers;

import java.io.IOException;
import java.nio.ByteBuffer;

import constantes.Constante;

public class BufferManager {
	private static Frame[] frames;

	public static void bufferManager() {
		frames = new Frame[Constante.F];
		for (Frame f : frames)
			f = new Frame();
	}
	
	
	public static ByteBuffer getPage(PageId pageId) throws IOException {
		ByteBuffer buffer = ByteBuffer.allocate(Constante.PAGESIZE);
		int i = 0;
		boolean select = false;
		
		for (Frame f : frames) {
			if (f.getPageId().equals(pageId))
				return f.getBuffer();
		}
		
		for (Frame f : frames) {
			if(f.getPageId() == null) {
				f.setPageId(pageId);
				DiskManager.readPage(pageId, buffer);
			}
		}
	}
}