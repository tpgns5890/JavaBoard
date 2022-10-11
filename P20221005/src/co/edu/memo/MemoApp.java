package co.edu.memo;

import java.util.Scanner;

public class MemoApp {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		MemoManager menager = MemoManager.getInstance();

		while (true) {
			try {
				System.out.println("1.등록 2.검색 3.삭제 4.종료");
				System.out.print("선택>> ");

				int menu = Integer.parseInt(scn.nextLine());

				if (menu < MENU.INSERT || menu > MENU.EXIT) {
					throw new MenuException(menu);
				}

				switch (menu) {
				case MENU.INSERT:
					menager.inputData();
					// 입력작업.
					break;
				case MENU.SEARCH:
					menager.searchData();
					// 검색작업.
					break;
				case MENU.DELETE:
					menager.deleteData();
					// 삭제작업
					break;
				case MENU.EXIT:
					// 새로운 파일 저장
					menager.storeToFile();
					throw new ExitException();
				}
			} catch (MenuException e) {
				e.showErrMessage();
			} catch (ExitException e) {
				break;
			}
		}// end of while
		System.out.println("프로그램 종료");
		scn.close(); //스캐너 클래스 리소스 반환
	}
}
