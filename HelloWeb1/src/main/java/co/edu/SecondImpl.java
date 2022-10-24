package co.edu;

public class SecondImpl implements Command {
	@Override
	public void exec() {
		System.out.println("secondImpl() 실행됨");
	}
}
