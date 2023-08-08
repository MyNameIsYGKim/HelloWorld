package co.micol.lms.member.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.micol.lms.common.ViewResolve;
import co.micol.lms.member.service.MemberService;
import co.micol.lms.member.service.MemberVO;
import co.micol.lms.member.serviceImpl.MemberServiceImpl;

@WebServlet("/login.do")
public class MemberLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public MemberLogin() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MemberService dao = new MemberServiceImpl();
		MemberVO vo = new MemberVO();
		
		vo.setMemberId(request.getParameter("memberId"));
		vo.setMemberPassword(request.getParameter("memberPassword"));
		
		vo = dao.memberSelect(vo);
		
		if(vo != null) {
			request.setAttribute("message", vo.getMemberName() + "님 환영합니다.");
		} else {
			request.setAttribute("message", "아이디 또는 패스워드가 일치하지 않습니다.");
		}
		
		String viewName = "member/membermessage";
		ViewResolve.forward(request, response, viewName);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
