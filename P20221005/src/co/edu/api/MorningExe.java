package co.edu.api;

public class MorningExe {
	public static void main(String[] args) {
		int n = 1;
		for (int i = 0; i < 4; i++) {
			for (int k = 0; k <= i; k++) {
				System.out.printf("%2d", n++);
			}
			for (int j = 3; j > i; j--) {
				System.out.print("  ");
			}
			System.out.println();
		}
		System.out.println();
		int n2 = 1;
		for (int i = 0; i < 4; i++) {
			for (int k = 3; k > i; k--) {
				System.out.print("  ");
			}
			for (int j = 0; j <= i; j++) {
				System.out.printf("%2d", n2++);
			}
			System.out.println();
		}
	}
}
