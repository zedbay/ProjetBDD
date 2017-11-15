package managers;

public class PageId {

	public int fileId;
	public int idx;

	public PageId(int fileId, int idx) {
		this.setFileId(fileId);
		this.setIdx(idx);
	}

	private void setFileId(int fileId) {
		this.fileId = fileId;
	}

	private void setIdx(int idx) {
		this.idx = idx;
	}

	public int getFileId() {
		return (this.fileId);
	}

	public int getIdx() {
		return (this.idx);
	}

}
