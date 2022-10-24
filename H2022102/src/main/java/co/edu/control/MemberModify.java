package co.edu.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.edu.common.Command;
import co.edu.common.HttpUtil;
import co.edu.service.MemberService;
import co.edu.service.MemberServiceImpl;
import co.edu.vo.MemberVO;

public class MemberModify implements Command {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//사용자입력정보를 parameter읽어와야함
		
		//parameter 값에 따라서...
		String id = req.getParameter("id");
		String pw = req.getParameter("passwd");
		String nm = req.getParameter("name");
		String ml = req.getParameter("mail");
			
		MemberVO vo = new MemberVO(id, pw, nm, ml);
				
		//DB입력처리
		MemberService service = new MemberServiceImpl();
		service.modifyMember(vo);
		
		HttpUtil.forward(req, resp, "memberResult/memberUpdateOutput.jsp");
	}

}
