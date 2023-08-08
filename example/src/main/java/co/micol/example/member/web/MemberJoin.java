package co.micol.example.member.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import co.micol.example.common.ViewResolve;
import co.micol.example.member.service.MemberService;
import co.micol.example.member.service.MemberVO;
import co.micol.example.member.serviceImpl.MemberServiceImpl;

@WebServlet("/memberjoin.do")
public class MemberJoin extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public MemberJoin() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 파일 업로드 및 데이터 관리.
		MemberService dao = new MemberServiceImpl();
		MemberVO vo = new MemberVO();
		
		String saveDir = getServletContext().getRealPath("attech/member"); // 리눅스 유닉스 '/', window '\'
		int sizeLimit = 100*1024*1024;
		
		MultipartRequest multi = new MultipartRequest(
						request, 
						saveDir,  // 저장위치.
						sizeLimit,  // 크기제한.
						"utf-8", 
						new DefaultFileRenamePolicy());
		
		String originalFileName = multi.getOriginalFileName("file");
		if (originalFileName != null) {
			String fileName = multi.getFilesystemName("file"); // 물리적인 위치에 저장.
			vo.setMemberImg(fileName);
		}
		
		vo.setMemberId(multi.getParameter("memberId"));
		vo.setMemberPassword(multi.getParameter("memberPassword"));
		vo.setMemberName(multi.getParameter("memberName"));
		vo.setMemberTel(multi.getParameter("memberTel"));
		vo.setMemberAddress(multi.getParameter("memberAddress"));
		
		int n = dao.memberInsert(vo);
		if(n!=0) {
			request.setAttribute("message", "희원가입 완료!");
		}else {
			request.setAttribute("message", "희원가입 실패!");
		}
		
		String viewName = "member/membermessage";
		ViewResolve.forward(request, response, viewName);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
