package co.edu.inherit.friend;

import java.util.ArrayList;

public class ArrayExam {
	public static void main(String[] args) {
		// 배열은 크기가 정해지면 변경이 불가
		String[] flowers = new String[3];
		flowers[0] = "장미";
		flowers[1] = "해바라기";
		flowers[2] = "무궁화";
//		flowers[3] = "목련";

		// flowers2 선언.
		String[] flowers2 = new String[6];
		flowers2[0] = "장미";
		flowers2[1] = "해바라기";
		flowers2[2] = "무궁화";
		flowers2[3] = "목련";

		for (String str : flowers2) {
			if (str != null) {
				System.out.println(str);
			}
		}

		// 배열의 크기 고정 => 컬렉션 (ArrayList);
		// ArrayList는 데이터 타입이 object 로 저장(모든형태)
		ArrayList flowers3 = new ArrayList(); // 별도의 지정 없으면 크기 10개 공간생성
		flowers3.add("장미"); // 첫번째 위치 장미 저장.
		flowers3.add("해바라기");
		flowers3.add("무궁화");
		flowers3.add("무궁화");
		flowers3.add("무궁화");
		flowers3.add("무궁화");
		flowers3.add("무궁화");
		flowers3.add("무궁화");
		flowers3.add("무궁화");
		flowers3.add("무궁화");
		flowers3.add("무궁화");
		flowers3.add("무궁화");
		flowers3.add("무궁화");
		flowers3.add("무궁화");
		flowers3.add("무궁화");
		flowers3.add("무궁화");
		for (Object str : flowers3) {
			String result = (String) str;
			System.out.println(result);
		}
		// 컬렉션의 크기 : size().
		for (int i = 0; i < flowers3.size(); i++) {
			String result = (String) flowers3.get(i);
			System.out.println(result);
		}

	}
}
