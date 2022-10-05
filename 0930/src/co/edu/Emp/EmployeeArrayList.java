package co.edu.Emp;

import java.util.ArrayList;
import java.util.Scanner;

//컬렉션을 활용하여 정보 저장(add, get등등 넣기)
public class EmployeeArrayList implements EmployeeService {
	// 저장공간 생성.
	ArrayList<Employee> list;
	int idx = 0;
	Scanner scn = new Scanner(System.in);

	@Override
	public void init() {
		list = new ArrayList<Employee>();
		System.out.println("초기화 완료");
	}

	@Override
	public void input() {
		System.out.print("사번>> ");
		int eId = -1;
		while (true) {
			try {
				eId = Integer.parseInt(scn.nextLine());
				break;
			} catch (NumberFormatException e) {
				System.out.println("숫자를 입력하세요.");
			}
		}
		System.out.print("이름>> ");
		String name = scn.nextLine();
		System.out.print("급여>> ");
		int sal = -1;
		while (true) {
			try {
				sal = Integer.parseInt(scn.nextLine());
				break;
			} catch (NumberFormatException e) {
				System.out.println("숫자를 입력하세요.");
			}
		}
		System.out.print("부서>> ");
		int deptId = -1;
		while (true) {
			try {
				deptId = Integer.parseInt(scn.nextLine());
				break;
			} catch (NumberFormatException e) {
				System.out.println("숫자를 입력하세요.");
			}
		}
		System.out.print("이메일>> ");
		String email = scn.nextLine();

		list.add(new Employee(eId, name, sal, deptId, email));
		System.out.println("사원이 정상적으로 입력되었습니다.");
	}

	@Override
	public String search(int employeeId) {
		String result = null;
//		for (int i = 0; i < list.size(); i++) {
//			if (list.get(i).getEmployeeId() == employeeId) {
//				result = list.get(i).getName();
//				break;
//			}
//		}
		for (Employee emp : list) {
			if (emp.getEmployeeId() == employeeId) {
				result = emp.getName();
				break;
			}
		}
		return result;
	}

	public int searchSal(int employeeId) {
		int salary = 0;
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getEmployeeId() == employeeId) {
				salary = list.get(i).getSalary();
				break;
			}
		}
		return salary;
	}

	@Override
	public void print() {
		System.out.println("==========사원 리스트=========");
		System.out.println("사번\t부서명\t이름\t급여");
		System.out.println("============================");
		for (int i = 0; i < list.size(); i++) {
			System.out.printf("%3s %6s %6s %7d\n", list.get(i).getEmployeeId(), list.get(i).getDeptName(),
					list.get(i).getName(), list.get(i).getSalary());
		}
		System.out.println("============================");
	}
}
