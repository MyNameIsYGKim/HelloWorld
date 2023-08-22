package co.micol.example.notice.web;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import co.micol.example.common.ViewResolve;
import co.micol.example.notice.service.NoticeService;
import co.micol.example.notice.service.NoticeVO;
import co.micol.example.notice.serviceImpl.NoticeServiceImpl;

@WebServlet("/noticeedit.do")
public class NoticeEdit extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public NoticeEdit() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		NoticeService dao = new NoticeServiceImpl();
		NoticeVO vo = new NoticeVO();
		
		String saveDir = getServletContext().getRealPath("attech/notice/");
		int sizeLimit = 100 * 1024 * 1024;
		
		MultipartRequest multi = new MultipartRequest(
				request,
				saveDir,
				sizeLimit,
				"utf-8",
				new DefaultFileRenamePolicy());
		
		String originalFile = multi.getOriginalFileName("file");
		if(originalFile != null) {
			String fileName = multi.getFilesystemName("file");
			vo.setNoticeAttech(originalFile);
			vo.setNoticeAttechDir(saveDir + fileName);
		}
		
		vo.setNoticeId(Integer.valueOf(multi.getParameter("noticeId")));
		vo.setNoticeWriter(multi.getParameter("noticeWriter"));
		vo.setNoticeDate(LocalDate.parse(multi.getParameter("noticeDate")));
		vo.setNoticeTitle(multi.getParameter("noticeTitle"));
		vo.setNoticeSubject(multi.getParameter("noticeSubject"));
		
		String viewName = "notice/noticeselect";
		int n = dao.noticeUpdate(vo); // 수정
		if(n == 1) {
			vo = dao.noticeSelect(vo); // 수정된 글 다시 불러오기.
			request.setAttribute("n", vo);
			ViewResolve.forward(request, response, viewName);
		}else {
			request.setAttribute("message", "수정 중 오류 발생.");
			viewName = "notice/noticemessage";
			ViewResolve.forward(request, response, viewName);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
