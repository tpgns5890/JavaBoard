package co.edu.jdbc;

//import java.util.List;

public class EmpApp {
	public static void main(String[] args) {
		EmployeeDAO empDao = new EmployeeDAO();
//		List<Employee> employees = empDao.search();
		
		int empId = 100;
//		String lastName = "Hong";
//		String email = "hongkil@email";
//		String jobId = "ST_MAN";
//		String hireDate = "2020-05-11";
//		Employee emp1 = new Employee(empId, lastName, email, hireDate, jobId);
		
//		empDao.insert(emp1);
//		empDao.update(emp1);
//		empDao.delete(empId);
		System.out.println(empDao.getEmp(empId));
		
//		for(Employee emp : employees) {
//			System.out.println(emp);
//		}
	}
}
