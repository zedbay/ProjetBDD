package bdd;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import manager.DiskManager;
import manager.BufferManager;

public class HeapFile {

	private RelDef rd;
	
	public HeapFile(RelDef rd) {
		this.setRD(rd);
	}
	
	public HeapFile() {
		
	}
	public void setRD(RelDef rd) {
		this.rd = rd;
	}
	
	public RelDef getRD() {
		return(this.rd);
	}
	
	public void createHeader() throws FileNotFoundException, IOException {
		manager.DiskManager.addPage(rd.getFileId());
		//ByteBuffer bbuf1 = ByteBuffer.allocate(bdd.Constante.PAGESIZE);
	}
	
	public void readHeaderPage(ByteBuffer buff, HeaderPage hp) {
		buff.position(0);
		hp.setNbPageDeDonnees(buff.getInt());
		for(int i=0;i<hp.getNbPageDeDonnees();i++) {
			Infos infTmp = new Infos(buff.getInt(),buff.getInt());
			hp.addInfos(infTmp);
		}
	}
	
	public void writeHeaderPage(ByteBuffer buff, HeaderPage hp) {
		buff.position(0);
		buff.putInt(hp.getNbPageDeDonnees());
		ArrayList<Infos> infos = hp.getInfos();
		for(int i=0;i<hp.getNbPageDeDonnees();i++) {
			buff.putInt(infos.get(i).getIdxPage());
			buff.putInt(infos.get(i).getNbSlotsRestantsDisponibles());
		}
	}
	
	public void getHeaderPage(HeaderPage hp) throws FileNotFoundException, IOException {
		PageId pid = new PageId(this.rd.getFileId(),0);
		ByteBuffer buff = ByteBuffer.allocate(bdd.Constante.PAGESIZE);
		buff = manager.BufferManager.getPage(pid);
		this.readHeaderPage(buff,hp);
		manager.BufferManager.freePage(pid,false);
	}
	
	public void updateHeaderNewDataPage(PageId pid) throws IOException {
		PageId pid1 = new PageId(this.rd.getFileId(),0);
		ByteBuffer buff = ByteBuffer.allocate(bdd.Constante.PAGESIZE);
		buff = manager.BufferManager.getPage(pid1);
		HeaderPage hp = new HeaderPage();
		readHeaderPage(buff,hp);
		Infos i1 = new Infos(pid.getIdx(),this.rd.getSlotCount());
		hp.addInfos(i1);
		writeHeaderPage(buff,hp);
		manager.DiskManager.writePage(pid1,buff);
		manager.BufferManager.freePage(pid1,true);
	}
	
	public void updateHeaderTakenSlot (PageId pid) throws IOException {
		//HeaderPage hp = this.getObjetHeaderPage();
	}
	
	public HeaderPage getObjetHeaderPage() throws IOException {
		PageId pid1 = new PageId(this.rd.getFileId(),0);
		ByteBuffer buff = ByteBuffer.allocate(bdd.Constante.PAGESIZE);
		buff = manager.BufferManager.getPage(pid1);
		HeaderPage hp = new HeaderPage();
		readHeaderPage(buff,hp);
		return(hp);
	}
	
	public void readPageBitMapInfo(ByteBuffer buff, PageBitMapInfo pbmi) {
		for(int i=0;i<this.rd.getSlotCount();i++) {
			pbmi.setSlotStatus(i,buff.get(i));
		}	
	}

	public void writePageBitMap(ByteBuffer buff, PageBitMapInfo pbmi) {
		byte[] slotStatus = pbmi.getSlotStatus();
		for(int i=0;i<this.rd.getSlotCount();i++) {
			buff.put(i,slotStatus[i]);
		}
	}

	public void writeRecordInBuffer(ByteBuffer buff, Record rec, int offset) {
		ArrayList<String> typeCol = this.rd.getRelShema().getTypeCol();
		buff.position(offset);
		for(int i=0;i<typeCol.size();i++) {
			String value = rec.getValeursAttributs(i);
			if(typeCol.get(i).equals("int")) {
				buff.putInt(Integer.parseInt(value));
			}
			if(typeCol.get(i).equals("float")) {
				buff.putFloat(Float.parseFloat(value));
			}
			if(typeCol.get(i).equals("string")) {
				for(int j=0;j<value.length();j++) {
					buff.putChar(value.charAt(j));
				}
			}
		}
	}

	public PageId addDataPage() throws FileNotFoundException, IOException {
		PageId pid = DiskManager.addPage(rd.getFileId());
		updateHeaderNewDataPage(pid);	
		return(pid);
	}

	public PageId getFreePageId() throws FileNotFoundException, IOException {  
		HeaderPage hp = new HeaderPage();
		getHeaderPage(hp);
		for(int i=0;i<hp.getNbPageDeDonnees();i++) {
			if(hp.getInfos().get(i).getNbSlotsRestantsDisponibles()>0) {
				int j = hp.getInfos().get(i).getIdxPage();    
				PageId pid = new PageId(rd.getFileId(),j);
				return(pid);
			}
		}
		return(addDataPage());
	}

	public void insertRecordInPage(Record rec, PageId pid) throws IOException {
		ByteBuffer buff = ByteBuffer.allocate(bdd.Constante.PAGESIZE);
		buff = BufferManager.getPage(pid);
		PageBitMapInfo pbmi = new PageBitMapInfo();
		readPageBitMapInfo(buff,pbmi);
		int idx = pbmi.getPremierSlotDispo();
		int offset = this.rd.getSlotCount()+idx*rd.getRecordSize();
		writeRecordInBuffer(buff,rec,offset);
		pbmi.setSlotStatus(idx,(byte)1);
		writePageBitMap(buff,pbmi);
		BufferManager.freePage(pid,true);
	}

	public void insertRecord(Record rec) throws FileNotFoundException, IOException {
		//PageId pid = getFreePageId();
		//insertRecordInPage(rec, pid);
		//updateHeaderTakenSlot(pid);
	}
}
