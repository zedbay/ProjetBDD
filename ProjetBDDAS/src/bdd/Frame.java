package bdd;

import java.nio.ByteBuffer;

public class Frame {

	private ByteBuffer buffer = ByteBuffer.allocate(Constante.PAGESIZE);
	private PageId pageId;
	private int pincount;
	private boolean isDirty, refBit;

	public Frame() {
		this.pageId = null;
		this.pincount = 0;
		this.isDirty = false;
		this.refBit = false;
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