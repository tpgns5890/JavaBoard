package co.edu.friend;

public class CoFriend extends Friend{
	// 친구이름, 연락처 (상속) + 회사명, 부서정보 (추가)
	private String company;
	private String department;

	// 필요한 생성자를 작성.
	public CoFriend() {
	} // 기본 생성자

	public CoFriend(String name, String phoneNumber, String company, String department) {
		super(name, phoneNumber);
		this.company = company;
		this.department = department;
	}
	
	
	// get, set 메소드 작성.
	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	// Friend클래스의 getInfo() 를 overriding 하세요.
	@Override
	public String getInfo() {
		return "친구이름: " + getName() + ", 연락처: " + getPhoneNumber() + ", 회사명: " + company + ", 부서: " + department;
	}
}
