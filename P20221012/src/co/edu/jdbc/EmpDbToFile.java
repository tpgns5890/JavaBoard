package co.edu.jdbc;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class EmpDbToFile extends EmployeeDAO{
	public static void main(String[] args) {

		try {
			FileWriter fw = new FileWriter("c:/temp/empFile.txt");
			EmployeeDAO dao = new EmployeeDAO();
			List<Employee> list = dao.search();

			for (Employee emp : list) {
				fw.write(emp.getEmployeeId()+" "+ emp.getLastName()+" "+ emp.getEmail()+" "+ emp.getHireDate()+" "+ emp.getJobId()+"\n");

			}
			fw.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
