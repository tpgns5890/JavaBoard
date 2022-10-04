package co.edu.Emp;

import java.util.Scanner;

//	배열을 활용해서 정보저장
public class EmployeeArray implements EmployeeService {
	// 저장공간 생성
	Employee[] list; // 배열 필드는 따로 선언안하면 초기값 null
	int idx; // int 필드는 따로 선언안해도 초기값이 0임
	Scanner scn = new Scanner(System.in);

	@Override
	public void init() {
		System.out.println("사원수 입력>> ");
		int cnt = Integer.parseInt(scn.nextLine()); // 엔터키 처리 오류 방지 위해 사용
		list = new Employee[cnt]; // cnt 크기의 인스턴스 저장 공간 생성
		
	}

	@Override
	public void input() {
		
		if(idx >= list.length) {
			System.out.println("더이상 입력불가");
			return; //메소드 실행 종료
		}
		System.out.println("사번>> ");
		int eId = Integer.parseInt(scn.nextLine());
		System.out.println("이름>> ");
		String name = scn.nextLine();
		System.out.println("급여>> ");
		int sal = Integer.parseInt(scn.nextLine());
		System.out.println("부서>> ");
		int deptId = Integer.parseInt(scn.nextLine());
		System.out.println("이메일>> ");
		String email = scn.nextLine();
		
		Employee emp = new Employee(eId, name, sal, deptId, email);
		list[idx++] = emp;
		
	}

	@Override
	public String search(int employeeId) {
		return null;
	}

	@Override
	public void print() {
		for(int i=0; i<idx; i++) {
			System.out.printf("%5s %10s %7d\n", list[i].getEmployeeId(), list[i].getName(), list[i].getSalary());
		}
	}

}
