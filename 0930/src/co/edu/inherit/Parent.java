package co.edu.inherit;

public class Parent extends Object{ // 기본적으로 Object를 상속 받고 있음 (최상위 존재)
	String field;
	Parent(){
		System.out.println("Parent() call");
	}
	Parent(String args){
		System.out.println("Parent(String args) call");
	}
	
	void method() {
		System.out.println("parent method() call");
	}
	@Override
	public String toString() {
		return "Parent [field=" + field + "]";
	}
	
}
