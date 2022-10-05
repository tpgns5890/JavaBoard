package co.edu.Emp;

import java.util.Scanner;

//메인 클래스
public class EmployeeApp {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
//		EmployeeService service = new EmployeeArray(); // 배열을 이용할때
		EmployeeService service = new EmployeeArrayList(); // 컬렉션을 이용할때

		// 1. 사원수(초기화) 2.사원정보입력 3.사원검색 4.사원리스트 9.종료
		while (true) {
			System.out.println("1.사원수(초기화) 2.사원정보입력 3.사원검색 4.사원리스트 5.사원급여 9.종료");
			System.out.print("선택>> ");
			try {
				int menu = Integer.parseInt(scn.nextLine()); // "1" -> 1 : Integer.parseInt
				if (menu == 1) {
					service.init();
					System.out.println();
				} else if (menu == 2) {
					service.input();
					System.out.println();
				} else if (menu == 3) {
					System.out.print("검색할 사원 번호를 입력>> ");
					int eId = Integer.parseInt(scn.nextLine()); // "100" Enter
					String name = service.search(eId);
					if (name == null) {
						System.out.println("해당하는 사원번호의 사원정보가 없습니다.");
					} else {
						System.out.println("사원의 이름은 " + name + "입니다.");
					}
					System.out.println();
				} else if (menu == 4) {
					service.print();
					System.out.println();
				} else if (menu == 5) {
					// 사번을 입력하면 급여정보 반환
					System.out.print("검색할 사원 번호를 입력>> ");
					int eId = Integer.parseInt(scn.nextLine());
					int sal = service.searchSal(eId);
					if (sal == -1) {
						System.out.println("해당하는 사원번호의 사원정보가 없습니다.");
					} else {
						System.out.println("사원의 급여는 " + sal + "원 입니다.");
	
					}
					System.out.println();
				} else if (menu == 9) {
					System.out.println("프로그램을 종료합니다.");
					break;
				} else {
					System.out.println("없는 메뉴입니다.");
					System.out.println();
				}
			} catch (NumberFormatException e){
				System.out.println("숫자를 입력해 주세요.");
				System.out.println();
			}
		}
		System.out.println("프로그램 종료");
	} // end of main
} // end of class
