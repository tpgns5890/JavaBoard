package co.edu.vo;

import lombok.Data;

@Data
public class MemberVO {
	private String id;
	private String passwd;
	private String email;
	private String name;
	private String responsibility;
	
	public  MemberVO() {
		
	}
	
	public MemberVO(String id, String passwd, String name, String email) {
		this.id = id;
		this.passwd = passwd;
		this.name = name;
		this.email = email;
	}

	public MemberVO(String id, String passwd, String email, String name, String responsibility) {
		this.id = id;
		this.passwd = passwd;
		this.email = email;
		this.name = name;
		this.responsibility = responsibility;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	public String getResponsibility() {
		return responsibility;
	}

	public void setResponsibility(String responsibility) {
		this.responsibility = responsibility;
	}
	
	@Override
	public String toString() {
		return "MemberVO [id=" + id + ", passwd=" + passwd + ", email=" + email + ", name=" + name + ", responsibility="
				+ responsibility + "]";
	}
}
