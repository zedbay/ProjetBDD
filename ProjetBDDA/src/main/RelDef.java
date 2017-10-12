package main;

public class RelDef {
		
	private int fileId;
	private RelSchema relShema;
	public RelDef (int fileId,RelSchema relShema){
		this.fileId = fileId;
		//RelSchema rel = new RelSchema();	
	}

	public int getFileId() { 
		return fileId;
	}
	
	public RelSchema getRelShema() {
		return relShema;
	}
	
	public static void main(String[] args) {
			System.out.println("Stephhawk le BG!");
		}
}
