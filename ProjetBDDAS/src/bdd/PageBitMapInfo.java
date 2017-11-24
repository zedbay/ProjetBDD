package bdd;

public class PageBitMapInfo {

	private byte[] slotStatus;
	
	public PageBitMapInfo (byte[] slotStatus) {
		this.slotStatus = slotStatus;
	}
	
	public PageBitMapInfo() {
		
	}
	
	public byte[] getSlotStatus() {
		return(this.slotStatus);
	}
	
	public void setSlotStatus(int i, byte b) {
		this.slotStatus[i] = b;
	}
	
	public int getPremierSlotDispo() {
		for(int i=0;i<this.slotStatus.length;i++) {
			if(slotStatus[i]==0) {
				return(i);
			}
		}
		return(-1);
	}
	
}
