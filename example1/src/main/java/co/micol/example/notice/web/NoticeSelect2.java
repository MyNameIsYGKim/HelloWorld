package co.micol.example.notice.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.micol.example.common.ViewResolve;
import co.micol.example.notice.service.NoticeService;
import co.micol.example.notice.service.NoticeVO;
import co.micol.example.notice.serviceImpl.NoticeServiceImpl;


@WebServlet("/noticeselect2.do")
public class NoticeSelect2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
    public NoticeSelect2() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		NoticeService dao = new NoticeServiceImpl();
		NoticeVO vo = new NoticeVO();
		// ----------------------------------------
//		Map<String, Object> map = new HashMap<>();
//		
//		ReplyService svc = new ReplyServiceImpl();
//		List<ReplyVO> list = svc.replyList(6);
//		
//		map.put("data",  list);
//		
//		Gson gson = new GsonBuilder().create();
//		String json = gson.toJson(map);
//		
//		response.setContentType("text/json;charset=utf-8");
//		response.getWriter().print(json);
		// ----------------------------------------
		
		vo.setNoticeId(Integer.valueOf(request.getParameter("noticeId")));
		
		vo = dao.noticeSelect(vo);
		
		request.setAttribute("n", vo);
		String viewName = "notice/noticeselect2";
		
		ViewResolve.forward(request, response, viewName);
		
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
