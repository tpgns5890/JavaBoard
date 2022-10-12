package co.edu.board;

public class Board {
	private int boardNum;
	private String boardTitle;
	private String boardContent;
	private String boardWriter;
	private String creationDate;
	private int cno;
	
	public Board(int boardNum, String boardTitle, String boardContent, String boardWriter, String creationDate,
			int cno) {
		super();
		this.boardNum = boardNum;
		this.boardTitle = boardTitle;
		this.boardContent = boardContent;
		this.boardWriter = boardWriter;
		this.creationDate = creationDate;
		this.cno = cno;
	}

	

	public Board(int boardNum, String boardContent) {
		super();
		this.boardNum = boardNum;
		this.boardContent = boardContent;
	}



	public Board(int boardNum, String boardTitle, String boardWriter, String creationDate) {
		super();
		this.boardNum = boardNum;
		this.boardTitle = boardTitle;
		this.boardWriter = boardWriter;
		this.creationDate = creationDate;
	}



	public int getBoardNum() {
		return boardNum;
	}

	public void setBoardNum(int boardNum) {
		this.boardNum = boardNum;
	}

	public String getBoardTitle() {
		return boardTitle;
	}

	public void setBoardTitle(String boardTitle) {
		this.boardTitle = boardTitle;
	}

	public String getBoardContent() {
		return boardContent;
	}

	public void setBoardContent(String boardContent) {
		this.boardContent = boardContent;
	}

	public String getBoardWriter() {
		return boardWriter;
	}

	public void setBoardWriter(String boardWriter) {
		this.boardWriter = boardWriter;
	}

	public String getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(String creationDate) {
		this.creationDate = creationDate;
	}

	public int getCno() {
		return cno;
	}

	public void setCno(int cno) {
		this.cno = cno;
	}

	@Override
	public String toString() {
		return "글번호: " + boardNum + " 글제목: " + boardTitle + "\n내용: " + boardContent
				+ "\n작성자: " + boardWriter + " 작성일시: " + creationDate + " 조회수: " + cno;
	}
	
	
}
