package Board;

public class Reply {
	private int repSeq;
	private int boardNum;
	private String repContent;
	private String repWriter;
	private String creationDate;

	public Reply() {
		super();
	}

	public Reply(int repSeq, int boardNum, String repContent, String repWriter, String creationDate) {
		super();
		this.repSeq = repSeq;
		this.boardNum = boardNum;
		this.repContent = repContent;
		this.repWriter = repWriter;
		this.creationDate = creationDate;
	}

	public int getRepSeq() {
		return repSeq;
	}

	public void setRepSeq(int repSeq) {
		this.repSeq = repSeq;
	}

	public int getBoardNum() {
		return boardNum;
	}

	public void setBoardNum(int boardNum) {
		this.boardNum = boardNum;
	}

	public String getRepContent() {
		return repContent;
	}

	public void setRepContent(String repContent) {
		this.repContent = repContent;
	}

	public String getRepWriter() {
		return repWriter;
	}

	public void setRepWriter(String repWriter) {
		this.repWriter = repWriter;
	}

	public String getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(String creationDate) {
		this.creationDate = creationDate;
	}

	@Override
	public String toString() {
		return "└───" +repSeq +String.format("·%-15s", repContent)+ String.format(" · 작성자: %-10s", repWriter)+" · "+creationDate;
	}

}
