package co.micol.example.ajax.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import co.micol.example.ajax.service.MembersService;
import co.micol.example.ajax.service.MembersVO;
import co.micol.example.ajax.serviceImpl.MembersServiceImpl;

@WebServlet("/AjaxMemberList.do")
public class AjaxMemberList extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public AjaxMemberList() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 MembersService service = new MembersServiceImpl();
		 List<MembersVO> list = service.listMember();
		 
		 Gson gson = new GsonBuilder().create();
		 String json = gson.toJson(list);
		 
		 response.setContentType("text/json;charset=utf-8");
		 response.getWriter().print(json);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
