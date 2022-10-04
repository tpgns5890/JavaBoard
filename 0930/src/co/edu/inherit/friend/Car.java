package co.edu.inherit.friend;

public class Car extends Vehicle{
	@Override
	void drive(Vehicle vehicle) {
		System.out.println("자동차가 달립니다.");
	}

}
