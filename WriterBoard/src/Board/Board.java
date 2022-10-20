package Board;

public class Board {
	private int rowNum;
	private int boardNum;
	private String boardTitle;
	private String boardContent;
	private String writer;
	private String creationDate;
	private int viewCnt;

	public Board() {
		super();
	}

	public Board(int rowNum, int boardNum, String boardTitle, String boardContent, String writer, String creationDate,
			int viewCnt) {
		super();
		this.rowNum = rowNum;
		this.boardNum = boardNum;
		this.boardTitle = boardTitle;
		this.boardContent = boardContent;
		this.writer = writer;
		this.creationDate = creationDate;
		this.viewCnt = viewCnt;
	}

	public Board(int boardNum, String boardTitle, String boardContent, String writer, String creationDate,
			int viewCnt) {
		super();
		this.boardNum = boardNum;
		this.boardTitle = boardTitle;
		this.boardContent = boardContent;
		this.writer = writer;
		this.creationDate = creationDate;
		this.viewCnt = viewCnt;
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

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(String creationDate) {
		this.creationDate = creationDate;
	}

	public int getViewCnt() {
		return viewCnt;
	}

	public void setViewCnt(int viewCnt) {
		this.viewCnt = viewCnt;
	}

	@Override
	public String toString() {
		return "『제목: " + boardTitle + "\n 내용: " + boardContent
				+"\n "+ creationDate + String.format("|조회수: %2d", viewCnt) + "』";
	}

	public String showRank() {
		return String.format("%2d번", boardNum) + String.format("|제목: %-10.10s", boardTitle) + "|작성자: " + writer + "|조회수: " + viewCnt;
	}
	public String showAll() {
		return String.format("|제목: %-8.8s", boardTitle) + String.format("|작성자: %-10.10s", writer) + "|" + creationDate + String.format("|조회수: %-2d", viewCnt) + String.format("|고유번호: %-2d|",boardNum);
	}
	public String myBoards() {
		return boardNum + " | 제목: " + boardTitle + " | "+boardContent
				+" | "+ creationDate + " | 조회수: " + viewCnt;
	}
	public String manageBrd() {
		return "고유번호 " + boardNum + String.format("|제목: %-8.8s", boardTitle) + "|내용: "+boardContent+ "|작성자: " + writer +"|" + creationDate + "|조회수: " + viewCnt;
	}

	public int getRowNum() {
		return rowNum;
	}

	public void setRowNum(int rowNum) {
		this.rowNum = rowNum;
	}
}
