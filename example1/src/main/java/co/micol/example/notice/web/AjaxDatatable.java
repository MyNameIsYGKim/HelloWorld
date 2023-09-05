package co.micol.example.notice.web;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import co.micol.example.notice.service.ReplyService;
import co.micol.example.notice.service.ReplyVO;
import co.micol.example.notice.serviceImpl.ReplyServiceImpl;

@WebServlet("/jquery/AjaxDatatable.do")
public class AjaxDatatable extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public AjaxDatatable() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Map<String, Object> map = new HashMap<>();
		
		ReplyService svc = new ReplyServiceImpl();
		List<ReplyVO> list = svc.replyList(6);
		
		map.put("data",  list);
		
		Gson gson = new GsonBuilder().create();
		String json = gson.toJson(map);
		
		response.setContentType("text/json;charset=utf-8");
		response.getWriter().print(json);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ReplyService src = new ReplyServiceImpl();
		List<ReplyVO> list = src.replyList(6);
		String json = "{\"data\":[";
		//for(int i=0; i <=75; i++) {
		int cnt = list.size();
		for(int i=0; i<list.size(); i++) {
			json += "[\"" + list.get(i).getReplyId() + "\",\""
					+ list.get(i).getReply() + "" + i + "\",\""
					+ list.get(i).getReplyer() + "\",\"" 
					+ list.get(i).getReplyDate() + "\"]";
			if(i != (cnt - 1)) {
				json += ",";
			}
		}
		json += "]}";
		response.setContentType("text/json;charset=utf-8");
		response.getWriter().print(json);
	}

}
