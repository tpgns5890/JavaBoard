package co.edu.memo;

public class Memo {

	private int no;
	private String date;
	private String content;

	public Memo(int no, String date, String content) {
		this.no = no;
		this.date = date;
		this.content = content;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
	@Override
	public String toString() {
		return "번호: " + this.no + ", 날짜: " + this.date + ", 내용: "+ this.content;
	}

}
