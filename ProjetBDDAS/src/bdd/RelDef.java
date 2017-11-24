package bdd;

import java.io.Serializable;

public class RelDef implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private int fileId;
	private RelSchema relSchema;
	private int recordSize;
	private int slotCount;

	public RelDef(int fileId, RelSchema relSchema) {
		this.fileId = fileId;
		this.relSchema = relSchema;
		this.recordSize = relSchema.calculRecordSize();
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
	

}