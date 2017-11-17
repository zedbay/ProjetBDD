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

	public static ByteBuffer getPage(PageId pageToRead) throws IOException {
		ByteBuffer buffer = ByteBuffer.allocate((int) Constante.PAGESIZE);
		int i = 0;
		boolean chosen = false;

		for (int j = 0; j < frames.length; j++) {
			if (frames[j].getPageId() != null && frames[j].getPageId().equals(pageToRead))
				return frames[j].getBuffer();
		}

		for (int j = 0; j < frames.length; j++) {
			if (frames[j].getPageId() == null) {
				frames[j].setPageId(pageToRead);
				DiskManager.readPage(pageToRead, buffer);
				frames[j].setBuffer(buffer);
				frames[j].setPincount(1);
				return buffer;
			}
		}

		do {
			if (frames[i].getPincount() == 0 && frames[i].getRefBit())
				frames[i].setRefBit(false);
			else if (frames[i].getPincount() == 0 && !frames[i].getRefBit())
				chosen = true;
			i = chosen ? i : i + 1;
			i = i == Constante.F ? 0 : i;
		} while (!chosen);

		frames[i].setPageId(pageToRead);
		DiskManager.readPage(pageToRead, buffer);
		frames[i].setBuffer(buffer);
		frames[i].setPincount(1);

		return buffer;
	}

	public static PageId freePage(PageId pageToFree, boolean isDirty) {

		for (int i = 0; i < frames.length; i++) {
			if (frames[i].getPageId().equals(pageToFree)) {
				frames[i].setDirty(isDirty);
				frames[i].setPincount(0);
				frames[i].setRefBit(true);
				return pageToFree;
			}
		}
		return null;
	}

}
