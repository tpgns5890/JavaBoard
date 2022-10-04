package co.edu.inherit.friend;

public class Bus extends Vehicle{
	@Override
	void drive(Vehicle vehicle) {
		System.out.println("버스가 달립니다.");
	}

}
