package co.edu.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import co.edu.common.Command;
import co.edu.common.HttpUtil;
import co.edu.service.MemberService;
import co.edu.service.MemberServiceImpl;
import co.edu.vo.MemberVO;

public class Login implements Command {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		String id = req.getParameter("id");
		String pass = req.getParameter("passwd");

		MemberService service = new MemberServiceImpl();
		MemberVO result = service.login(id, pass);
		
		//회원아이디와 비밀번호 => main.jsp 이동.
		if (result != null) {
			req.setAttribute("logInfo", result);
			
			session.setAttribute("id", result.getId());
			session.setAttribute("auth", result.getResponsibility()); //admin/ user 권한.

			HttpUtil.forward(req, resp, "memberView/main.jsp");

		} else {
			HttpUtil.forward(req, resp, "memberLog/loginForm.jsp");

		}

	}

}
