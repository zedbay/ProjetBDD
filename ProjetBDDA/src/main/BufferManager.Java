package main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Queue;

public class BufferManager {
	private final static int F=2;
	private int pincount, flagdirty, pageid;
	private ArrayList<StringBuffer> bufferpool = new ArrayList<StringBuffer>();
	
	public BufferManager(int pincount, int flagdirty, int pageid, ArrayList<StringBuffer> Bufferpool){
		this.pincount= pincount;
		this.flagdirty=flagdirty;
		this.pageid=pageid;
		this.bufferpool=Bufferpool;
	}

	public void AddBuffer(ArrayList<StringBuffer> bufferpool, StringBuffer buffer){
		if (bufferpool.size()<F){
			bufferpool.add(buffer);
		}
		else 
			LRU(bufferpool);
			bufferpool.add(buffer);
	}

	private void LRU(ArrayList<StringBuffer> bufferpool) {
		Queue<Integer> file =new Queue<Integer>();
	}
//			void LecturePages(pageid)
//				if bufferpool.isempty
//					buffer b= readpage(pageid) ;
//					bufferpool.addBuffer(b) ;
//					read(b)
//					return
//				else 
//					for(Buffer b:bufferpool)
//						if b.getPageId==pageid
//							read(b)	
//							return
//					buffer b= readpage(pageid) ;
//					bufferpool.addBuffer(b) ;
}
