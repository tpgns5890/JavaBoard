package co.edu.api;

import java.io.IOException;

public class StringExe2 {
	public static void main(String[] args) {
//		System.out.println("abcDEF".toLowerCase());
		while(true) {
			try {
				int bytes = System.in.read();
				if(bytes == 123)
					break;
				
				System.out.println("입력값: " + bytes);
			}catch(IOException e) {
				e.printStackTrace();
			}
		}
		System.out.println("end of prog");
	}
	public static void changeCapital(String msg) {
		//대문자 -> 소문자, 소문자 -> 대문자
		// aBcD => AbCd 소문자 97~122:uppercase(), 대문자 65~90:lowercase()
	}
}
