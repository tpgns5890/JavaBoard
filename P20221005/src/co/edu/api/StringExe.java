package co.edu.api;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class StringExe {
	public static void main(String[] args) {

		String fileName = "src/co/edu/api/birth.txt";
		File file = new File(fileName);
		String searchKey = "자바";
		searchKey = searchKey.replace("/", "");
		Scanner scn = null;

		try {
			scn = new Scanner(file);
			while (true) {
				String str = scn.nextLine();
				if (str == null)
					break;
//				if(str.charAt(0,2)>22)
				// 남자입니다. 여자입니다.
				if (str.charAt(7) % 2 == 1) {
					System.out.println("남자입니다.");
				} else if (str.charAt(7) % 2 == 0) {
					System.out.println("여자입니다.");
				} else { // 년도, 월, 일 정보가 잘못되면 잘못된 번호로 인식.
					System.out.println("잘못된 번호입니다.");
				}

			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (NoSuchElementException e1) {

		}

		System.out.println("end of prog.");
	}
}
