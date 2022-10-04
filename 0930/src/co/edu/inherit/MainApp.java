package co.edu.inherit;

public class MainApp {
	public static void main(String[] args) {
		Child child = new Child(); // field1, method1()
		child.method(); // Parent의 메소드 호출
		child.method1(); // Child의 메소드 호출

		Child2 child2 = new Child2();
		child2.method();
		child2.method2(); // Child2의 메소드

		Parent c1 = new Parent();
		c1 = new Child(); // 부모클래스의 변수에 자식 클래스 인스턴스 대입 가능
		c1 = new Child2(); // 자동형변환(자식클래스의 인스터스 -> 부모클래스 인스턴스)
//		c1.method2(); // 부모클래스의 멤버들만 호출가능.
		if(c1 instanceof Child2) {
			Child2 c2 = (Child2) c1; // 강제형변환(casting)
			c2.method2(); //값 호출 가능.
		}
		
		Parent c3 = new Parent();
		if(c3 instanceof Child2) {
			Child2 c4 = (Child2) c3; // casting.
			c4.method2(); 
		}
	}
}
