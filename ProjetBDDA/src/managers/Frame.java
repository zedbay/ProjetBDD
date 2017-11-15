package managers;

import java.nio.ByteBuffer;

import constantes.Constante;

public class Frame {

	private ByteBuffer buffer;
	private PageId pageId;
	private int pincount;
	private boolean isDirty, refBit;

	public Frame() {
		buffer.allocate(Constante.PAGESIZE);
		pageId = null;
		pincount = 0;
		isDirty = false;
		refBit = false;
	}

	public ByteBuffer getBuffer() {
		return buffer;
	}

	public void setBuffer(ByteBuffer buffer) {
		this.buffer = buffer;
	}

	public PageId getPageId() {
		return pageId;
	}

	public void setPageId(PageId pageId) {
		this.pageId = pageId;
	}

	public int getPincount() {
		return pincount;
	}

	public void setPincount(int pincount) {
		this.pincount = pincount;
	}

	public boolean getRefBit() {
		return refBit;
	}

	public void setRefBit(boolean refBit) {
		this.refBit = refBit;
	}

	public boolean isDirty() {
		return isDirty;
	}

	public void setDirty(boolean isDirty) {
		this.isDirty = isDirty;
	}

}
