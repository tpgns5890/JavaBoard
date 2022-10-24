package co.test;

import java.util.Scanner;


public class StudentApp {
	public static void main(String[] args) {

		StudentManage app = StudentManage.getInstance();
		Scanner scn = new Scanner(System.in);

		while (true) {
			System.out.println("------------------------------------");
			System.out.println("1.등록 2.삭제 3.목록(총점) 4.순위 9.종료");
			System.out.println("------------------------------------");
			System.out.print("선택> ");
			int menu = scn.nextInt();
			if (menu == 1) { // 등록.
				System.out.println("------------------------------------");
				System.out.print("학생번호>> ");
				int studentNum = scn.nextInt();
				scn.nextLine();
				System.out.print("학생이름>> ");
				String studentName = scn.nextLine();
				System.out.print("학생나이>> ");
				int studentAge = scn.nextInt();
				System.out.print("영어점수>> ");
				int engScore = scn.nextInt();
				System.out.print("국어점수>> ");
				int korScore = scn.nextInt();
				
				Student student = new Student(studentNum, studentName, studentAge, engScore, korScore, (engScore+korScore));
				app.add(student);
				System.out.println("<<입력되었습니다!>>");
				
			} else if (menu == 2) { // 삭제.
				System.out.println("------------------------------------");
				System.out.print("삭제할 학생번호> ");
				int studentNum = scn.nextInt();
				app.del(studentNum);
//				System.out.println("<<삭제되었습니다!>>");
				
			} else if (menu == 3) { // 목록.
				System.out.println("------------------------------------");
				System.out.println("학번   이름  나이 영어 국어  총점");
				System.out.println("------------------------------------");
				app.list();
				
			} else if (menu == 4) { // 순위.
				app.ord();
			} else if (menu == 9) { // 종료.
				app.storeToFile();
				System.out.println("<<저장되었습니다!!>>");
				
				break;
			}

		}

		scn.close();
		System.out.println("프로그램 종료.");
	}
}
