package co.edu.friends;

public class Friends {
	private int friendsNo;
	private String name;
	private String phoneNo;
	
	public Friends() {}

	public Friends(int friendsNo, String name, String phoneNo) {
		super();
		this.friendsNo = friendsNo;
		this.name = name;
		this.phoneNo = phoneNo;
	}

	public int getFriendsNo() {
		return friendsNo;
	}

	public void setFriendsNo(int friendsNo) {
		this.friendsNo = friendsNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	@Override
	public String toString() {
		return "Friends [친구번호=" + friendsNo + ", 친구이름=" + name + ", 전화번호=" + phoneNo + "]";
	}
	
	
}
