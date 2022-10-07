package co.edu.collect;

import java.util.Scanner;

public class ExcitingGame {
	public static void main(String[] args) {

		long gameStart = System.currentTimeMillis();

		String target = "Britain faces rolling";

		String[] targetAry = target.split(" ");

		Scanner scn = new Scanner(System.in);
		boolean check = true;
		boolean wordcheck = false;
		System.out.println(target);
		
		while (true) {
			System.out.print("\n단어를 입력하세요>>  ");
			String bullet = scn.nextLine();
			wordcheck = false;
			for (int i = 0; i < targetAry.length; i++) {
				if (bullet.equals(targetAry[i])) {
					targetAry[i] = null;
					wordcheck = true;
				} 
			} // 삭제
			if (!wordcheck) {
				System.out.println("!!!없는 단어입니다!!!\n");
			}
			check = false;
			System.out.print("남은 단어 ");
			for (String str : targetAry) {
				if (str != null) {
					System.out.printf("%s ", str);
					check = true;
				}
			} // 남은 값 출력

			if (check == false) {
				System.out.println("가 없습니다!");
				break;
			}
			if(System.currentTimeMillis()-gameStart>30000) {
				System.out.println("\n!!!시간 초과!!!");
				break;
			}

		}
		long gameEnd = System.currentTimeMillis();
		long during = (gameEnd - gameStart);
		System.out.println("\n경과시간: " + during / (60 * 1000) + "분" + during / (1000) + "초");
		if(during>30000) {
			System.out.println("실패!");
		}else {
			System.out.println("성공!");
		}
	}
}
