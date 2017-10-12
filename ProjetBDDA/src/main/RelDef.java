package main;

public class RelDef {
		
	private int fileId;
	private relSchema relShema;
	public RelDef (int fileId,relSchema relShema){
		this.fileId = fileId;
		relSchema rel = new relSchema();	
	}

	public int getFileId() { 
		return fileId;
	}
	
	public relSchema getRelShema() {
		return relShema;
	}
	
	public static void main(String[] args) {
			System.out.println("Stephhawk le BG!");
		}
}
