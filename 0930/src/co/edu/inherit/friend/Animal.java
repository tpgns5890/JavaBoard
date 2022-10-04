package co.edu.inherit.friend;

public abstract class Animal {
	private String kind;
	public Animal() {

	}

	public Animal(String kind) {
		this.kind = kind;
	}
	public void move() {
		System.out.println("움직입니다.");
	}
	public abstract void eat(); // 추상 메소드 : 자식 클래스에서 반드시 구현.

	public abstract void speak(); //
}
