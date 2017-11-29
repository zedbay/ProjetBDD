package bdd;

import java.io.Serializable;

public class RelDef implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private int fileId;
	private RelSchema relSchema;
	private int recordSize;
	private int slotCount;
	private PageId headerPage;

	public RelDef(int fileId, RelSchema relSchema) {
		this.fileId = fileId;
		this.relSchema = relSchema;
		this.recordSize = relSchema.calculRecordSize();
		this.headerPage = new PageId(fileId,0);
		this.calculSlotCount();
	}

	public int getFileId() {
		return fileId;
	}

	public RelSchema getRelShema() {
		return relSchema;
	}
	
	public String toString() {
		return(this.relSchema.toString() + "\n");
	}
	
	public int getRecordSize() {
		return(this.recordSize);
	}
	
	public int getSlotCount() {
		return(this.slotCount);
	}
	
	public void calculSlotCount() {
		this.slotCount = (int) Constante.PAGESIZE/(this.recordSize+1);
	}
	
	public PageId getHeaderPage() {
		return(this.headerPage);
	}

}