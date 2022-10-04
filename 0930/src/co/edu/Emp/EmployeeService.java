package co.edu.Emp;


//추가, 수정, 조회, 삭제 . CRUD처리
public interface EmployeeService {
	public void init();//초기화(init)
	public void input();//추가
	public String search(int employeeId); //사원 id에 해당되는 이름을 반환해주는 메소드.
	public void print(); //전체사원정보 출력
}
