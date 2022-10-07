package co.edu.collect;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Student {
	String name;
	int score;
	
	public Student(String name, int score) {
		super();
		this.name = name;
		this.score = score;
	}
	
	
}

public class MapExample3 {
	
	public static void main(String[] args) {
		// 1. 저장 2. 조회 3.종료
		//학생, 점수 저장 컬렉션
		Map<String, Integer> students = new HashMap<>();
		
		Scanner scn = new Scanner(System.in);
		
		while(true) {
			System.out.println("1.저장 2.조회 3.종료");
			System.out.print("선택>> ");
			int menu = scn.nextInt();
			
			if(menu==1) {
				System.out.print("학생이름입력>> ");
				scn.nextLine();
				String name = scn.nextLine();//키
				
				System.out.print("학생점수입력>> ");
				int score = scn.nextInt();	//값
				
				students.put(name, score);
				
				
			}else if(menu == 2) {
				System.out.println("조회할 학생이름입력>> ");
				scn.nextLine();
				String searchName = scn.nextLine();
				
				
				System.out.println("점수: " + students.get(searchName));
//				for(int i=0; i<students.size();i++) {
//					if(Map<String> students.name == searchName) {
//						Map<String, Integer> std = students[i].get();
//						students.get(students.name);
//				}
				
			}else if(menu ==3) {
				System.out.println("프로그램을 종료합니다.");
				break;
			}
		} //end of while
		System.out.println("프로그램 종료. ");
	}
}
