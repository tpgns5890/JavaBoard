package co.edu;

public class Singleton {
	// 정적 필드'
	private static Singleton singleton = new Singleton();

	// private 생성자.
	private Singleton() {

	}

//	public getInstance(); 생성자를 만들 수 있음'
	public static Singleton getInstance() {
		return singleton;
	}

}
