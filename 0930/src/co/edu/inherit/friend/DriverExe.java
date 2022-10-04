package co.edu.inherit.friend;

public class DriverExe {
	public static void main(String[] args) {
		Car car = new Car();
		Bus bus = new Bus();
		Driver driver = new Driver();
		driver.drive(car); // 동일한 기능을 실행하는데 다른 결과가 나타나는것.
		driver.drive(bus); // Vehicle 인스턴스
	}
}
