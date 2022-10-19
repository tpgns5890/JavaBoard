package Board;

public class Board {
	private int boardNum;
	private String boardTitle;
	private String boardContent;
	private String writer;
	private String creationDate;
	private int viewCnt;

	public Board() {
		super();
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
				+"\n "+ creationDate + "| 조회수" + viewCnt + " 』";
	}

	public String showRank() {
		return "고유번호 " + boardNum + "|제목: " + boardTitle + "|작성자: " + writer + "|조회수: " + viewCnt;
	}
	public String showAll() {
		return boardNum + "|제목: " + boardTitle + "|작성자: " + writer +"|작성일: " + creationDate + "|조회수: " + viewCnt ;
	}
	public String myBoards() {
		return "『 고유번호 " + boardNum + "| 제목: " + boardTitle + "||"+boardContent
				+"||"+ creationDate + "| 조회수" + viewCnt + " 』";
	}
	public String manageBrd() {
		return "고유번호 " + boardNum + "|제목: " + boardTitle + "|내용: "+boardContent+ "|작성자: " + writer +"|작성일: " + creationDate + "|조회수: " + viewCnt;
	}
}
