package co.edu.jdbc;

import java.util.List;
import java.util.Scanner;

public class EmpMain {

	public static void main(String[] args) {
		EmployeeDAO dao = new EmployeeDAO();
		Scanner scn = new Scanner(System.in);

		// 메뉴=> 1.사원등록(insert) 2.한건조회(getEmp) 3.수정(update) 4.삭제(delete) 5.목록조회(search)
		// 9.종료
		while (true) {
			System.out.println("1.사원등록 2.한건조회 3.수정 4.삭제 5.목록조회 9.종료");
			System.out.print("메뉴를 선택하세요>> ");
			try {
				int menu = Integer.parseInt(scn.nextLine());

				if (menu == 1) {
					System.out.println("사원등록 메뉴입니다.");
					System.out.print("Employee ID를 입력하세요>> ");
					int id = Integer.parseInt(scn.nextLine());
					System.out.print("LastName을 입력하세요>> ");
					String lastName = scn.nextLine();
					System.out.print("Email을 입력하세요>> ");
					String email = scn.nextLine();
					System.out.print("Hire Date를 입력하세요>> ");
					String hireDate = scn.nextLine();
					System.out.print("Job ID를 입력하세요>> ");
					String jobId = scn.nextLine();

					Employee emp = new Employee(id, lastName, email, hireDate, jobId);
					dao.insert(emp);
					System.out.println();
				} else if (menu == 2) {
					System.out.println("한 건 조회 메뉴입니다.");
					System.out.print("조회할 사원의 Employee ID를 입력하세요>> ");
					int id = Integer.parseInt(scn.nextLine());
					
					if (dao.getEmp(id) != null) {
						System.out.println("<사원번호 "+ id +"의 정보입니다>");
						System.out.println(dao.getEmp(id));
						System.out.println();
					} else {
						System.out.println(id + " 에 해당하는 사원번호가 없습니다.");
						System.out.println();
					}
				} else if (menu == 3) {
					System.out.println("사원정보 수정 메뉴입니다.");
					System.out.print("수정할 사원의 Employee ID를 입력하세요>> ");
					int id = Integer.parseInt(scn.nextLine());
					System.out.print("수정하실 LastName을 입력하세요>> ");
					String lastName = scn.nextLine();
					System.out.print("수정하실 Email을 입력하세요>> ");
					String email = scn.nextLine();
					System.out.print("수정하실 Hire Date를 입력하세요>> ");
					String hireDate = scn.nextLine();
					System.out.print("수정하실 Job ID를 입력하세요>> ");
					String jobId = scn.nextLine();

					Employee emp = new Employee(id, lastName, email, hireDate, jobId);
					dao.update(emp);
					System.out.println();

				} else if (menu == 4) {
					System.out.println("사원정보삭제 메뉴입니다.");
					System.out.print("삭제할 사원의 Employee ID를 입력하세요>> ");
					int id = Integer.parseInt(scn.nextLine());

					dao.delete(id);
					System.out.println();

				} else if (menu == 5) {
					System.out.println("사원목록조회 메뉴입니다.");
					List<Employee> employees = dao.search();

					for (Employee emp : employees) {
						System.out.println(emp);
					}
					System.out.println();

				} else if (menu == 9) {
					System.out.println("프로그램을 종료합니다.");
					break;
				} else {
					System.out.println("없는 메뉴입니다.");
				}
			} catch (NumberFormatException e) {
				System.out.println("숫자를 입력해 주세요.");
				System.out.println();
			}
		}
		scn.close();
	}
}
