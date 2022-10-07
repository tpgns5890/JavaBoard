package co.edu.collect;

import java.util.ArrayList;
import java.util.Scanner;

class Employ {
	int empId;
	String empName;
	int salary;

	public Employ(int empId, String empName, int salary) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Employ [empId=" + empId + ", empName=" + empName + ", salary=" + salary + "]";
	}
	
}

//첫번째 값 => empId, 두번째 값=> empName, 세번째 값=> salary
// Employee 클래스의 인스턴스 생성.
// ArrayList에 저장.
// 종료를 하고 싶으면 quit 종료

// for(반복문) 출력
public class MorningCode {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		ArrayList<Employ> list = new ArrayList<>();
		
		System.out.println("입력>> ex)100 홍길동 2500");
		while(true) {
			System.out.print(">> ");
			String inputVal = scanner.nextLine();
			String[] input = inputVal.split(" ");
			
			//종료
			if(input[0].equals("quit")) {
				break;
			}
			
			if(input.length != 3) {
				System.out.println("다시 입력..");
				continue;
			}
			list.add(new Employ(Integer.parseInt(input[0]), input[1], Integer.parseInt(input[2])));
			
		}
		for(Employ emp : list) {
			System.out.println(emp);
		}
		System.out.println("end of prog");
	}
}
//		String tok = "Hello World Good Friend";
//		Scanner scn = new Scanner(tok);
//		Scanner scanner = new Scanner(System.in);
//
////		while(scn.hasNext())
////			System.out.println(scn.next());  // next 공백을 구분자
//
////		String[] toks = tok.split(" ");
////		for(String str : toks) {
////			System.out.println(str);
////		}
//		while (true) {
//			System.out.println("입력>> ex)100 홍길동 2500");
//			ArrayList<Employee1> list = new ArrayList<Employee1>();
//			String inputVal = scanner.nextLine();
//			String[] input = inputVal.split(" ");
//
//			if (inputVal == "quit") {
//				for (Employee1 str : list) {
//					System.out.println("번호: "+str.empId+ ", 이름: "+str.empName+ ", 급여: "+ str.salary);
//				}
//				break;
//			}
//			int id = 0;
//			String name = "";
//			int sal = 0;
//
//			for (int i = 0; i < input.length; i++) {
//				if (i == 0) {
//					id = Integer.parseInt(input[i]);
//				} else if (i == 1) {
//					name = input[i];
//				} else if (i == 2) {
//					sal = Integer.parseInt(input[i]);
//				} 
//			}
//			list.add(new Employee1(id, name, sal));
//			
//			for (Employee1 str : list) {
//				System.out.println("번호: "+str.empId+ ", 이름: "+str.empName+ ", 급여: "+ str.salary);
//			}
//		}
//		
//
//	}

