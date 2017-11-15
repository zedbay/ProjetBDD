package main;

public class RelDef {
		
	private int fileId;
	private RelSchema relSchema;
	
	public RelDef (int fileId, RelSchema relSchema){
		this.fileId = fileId;
		this.relSchema = relSchema;
	}

	public int getFileId() { 
		return fileId;
	}
	
	public RelSchema getRelShema() {
		return relSchema;
	}
	
}
