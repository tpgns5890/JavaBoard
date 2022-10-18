package Board;

public class Writer {
	private String userId; 
	private String userPw;
	private String userName;
	private int postCnt;
	
	
	public Writer() {
		super();
	}
	
	public Writer(String userId, String userPw, String userName, int postCnt) {
		super();
		this.userId = userId;
		this.userPw = userPw;
		this.userName = userName;
		this.postCnt = postCnt;
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
		return  "아이디: " + userId + "|이름: " + userName + "|게시글 수: " + postCnt;
	}
	
	
}
