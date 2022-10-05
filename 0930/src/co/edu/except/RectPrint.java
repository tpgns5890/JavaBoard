package co.edu.except;

public class RectPrint {
	public static void main(String[] args) {
		int cnt = 1;
		int width = 5;
		int height = 5;
		for(int i=0;i<height; i++) {
			for(int j = 0; j<width; j++) {
				System.out.printf("%3d", cnt);
				cnt += height;
			}
			cnt -= height*width - 1;
			System.out.println();
			
		}
	}
}
