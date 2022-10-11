package co.edu.io;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

class Emp implements Serializable {
	int id;
	String name;
	String dept;
	
	public Emp(int id, String name, String dept) {
		super();
		this.id = id;
		this.name = name;
		this.dept = dept;
	}
	
	
}

public class EmpObjectExam {
	public static void main(String[] args) throws Exception {
		FileInputStream fis = new FileInputStream("C:/temp/emp.dat");
		ObjectInputStream ois = new ObjectInputStream(fis);
		ArrayList<Emp> empList = (ArrayList<Emp>) ois.readObject();
		Scanner scn = new Scanner(System.in);

		while (true) {
			System.out.println("1.사원등록 2.목록출력 3.종료");
			System.out.println("선택>>  ");

			int menu = scn.nextInt();
			scn.nextLine();
			String[] empAry = null; 
			if (menu == 1) {
//				add
				System.out.print(">> ");
				String empVal = scn.nextLine();
				//split 이용할 경우
				empAry = empVal.split(" ");
				Emp emp = new Emp(Integer.parseInt(empAry[0]), empAry[1], empAry[2]);
				empList.add(emp);
				System.out.println("입력완료");
				
//				System.out.print("사원 Id: ");
//				int id = scn.nextInt();
//				System.out.print("사원 이름: ");
//				String name = scn.nextLine();
//				System.out.print("사원 부서: ");
//				String dept = scn.nextLine();
//				empList.add(id, name, dept);

			} else if (menu == 2) {
				for (Emp emp : empList) {
					System.out.println(emp);
				}
//				empList 출력
			} else if (menu == 3) {
				System.out.println("프로그램을 종료합니다.");
				// 컬렉션에 있던 ObjectOutputStream 을 활용.
				break;
			} else {
				System.out.println("잘못된 메뉴를 선택했습니다.");
			}

		} // end of while
	}// end of main
}// end of class
