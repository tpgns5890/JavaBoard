package co.edu;

public class SingletonMain {
	public static void main(String[] args) {
		Student s1 = new Student();
		Student s2 = new Student();
		
		Singleton sg1 = Singleton.getInstance();
		Singleton sg2 = Singleton.getInstance();
		
		System.out.println(s1 == s2);
		System.out.println(sg1 == sg2);
	}
}
