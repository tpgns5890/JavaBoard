package Board;

public class Writer {
	private String userId; 
	private String userPw;
	private String userName;
	private int postCnt;
	private String email;
	
	public Writer() {
		super();
	}
	
	public Writer(String userId, String userPw, String userName, int postCnt, String email) {
		super();
		this.userId = userId;
		this.userPw = userPw;
		this.userName = userName;
		this.postCnt = postCnt;
		this.email = email;
	}

	public Writer(String userId, String userPw, String userName, int postCnt) {
		super();
		this.userId = userId;
		this.userPw = userPw;
		this.userName = userName;
		this.postCnt = postCnt;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}	
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserPw() {
		return userPw;
	}
	public void setUserPw(String userPw) {
		this.userPw = userPw;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public int getPostCnt() {
		return postCnt;
	}
	public void setPostCnt(int postCnt) {
		this.postCnt = postCnt;
	}
	@Override
	public String toString() {
		return  String.format("%-10.10s", userId) + String.format("|이름: %-4.4s", userName) + String.format("|게시글 수: %2d", postCnt);
	}

	public String showAll() {
		return  String.format("%-10s", userId) +String.format("|비밀번호: %-5s", userPw)+ String.format("|이름: %-4s", userName) +String.format("|이메일: %-20s", email)+ "|게시글 수: " + postCnt;
	}
	
	
}
