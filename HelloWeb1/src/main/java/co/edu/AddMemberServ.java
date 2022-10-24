package co.edu;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.edu.emp.EmpDAO;
import co.edu.emp.EmployeeVO;

@WebServlet({ "/addMemberServlet", "/addMember" })
public class AddMemberServ extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AddMemberServ() {
		super();
	}
// get 방식의 요청
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// content 타입 지정.
		response.setContentType("text/html;charset=UTF-8");

		System.out.println("/addMemberSer 페이지입니다.");
		String empId = request.getParameter("employee_id");
		String fName = request.getParameter("first_name");
		String lName = request.getParameter("last_name");
		String email = request.getParameter("email");
		String hireDate = request.getParameter("hire_date");
		String jobId = request.getParameter("job_id");
//		System.out.println(empId);

		// db입력
		EmpDAO dao = new EmpDAO();
		EmployeeVO empVO = new EmployeeVO(0, fName, lName, email, hireDate, jobId);
		dao.insertEmp(empVO);

		System.out.println("입력완료.");
		
		int empSeq = dao.getEmpId(fName, lName, email);
				
		PrintWriter out = response.getWriter(); // 출력 스트림.
		out.print("<h1>입력결과</h1>");
		out.print("<h3>사원번호: " + empSeq + "</h3>");
		out.print("<h3>firstName: " + fName + "</h3>");
		out.print("<h3>lastName: " + lName + "</h3>");
		out.print("<h3>email: " + email + "</h3>");
		out.print("<h3>hiredate: " + hireDate + "</h3>");
		out.print("<h3>jobid: " + jobId + "</h3>");
		out.print("<h1>입력완료</h1>");
		out.print("<a href=\"member/memberAdd.html\"><h2>첫화면으로</h2></a>");

	}
	//post 방식의 요청 시 실행
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("test/html;charset=UTF-8");
//		doGet(request, response);
		PrintWriter out = response.getWriter(); // 사용자의 브라우저(출력스트림 생성)
		out.print("<h3>Post 방식의 요청</h3>");
	}

}
