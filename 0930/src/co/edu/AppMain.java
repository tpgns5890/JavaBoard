package co.edu;

public class AppMain {
	public static void main(String[] args) {

		Student stud1 = new Student();
		stud1.setStudNo("123-123");
		stud1.setStudName("홍민기");

		Student stud2 = new Student();
		stud1.setStudNo("123-222");
		stud1.setStudName("김민기");

		Student stud3 = new Student();
		stud1.setStudNo("123-333");
		stud1.setStudName("박민기");

		Student[] students;
		students = new Student[] { stud1, stud2, stud3 };
		for (Student stud : students) {
			System.out.println(stud.getStudNo() + stud.getStudName());
		}

		// 상속
		WorkMan wman = new WorkMan();
		wman.name = "직장인";
		wman.age = 30;

		StudMan sman = new StudMan();
		sman.school = "고등학교";
		sman.height = 173;
	}

}
