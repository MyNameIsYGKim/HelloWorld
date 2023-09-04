package co.micol.example.todolist.web;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import co.micol.example.todolist.service.TodolistService;
import co.micol.example.todolist.service.TodolistVO;
import co.micol.example.todolist.serviceImpl.TodolistServiceImpl;

@WebServlet("/AjaxTodolistUpdate.do")
public class AjaxTodolistUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public AjaxTodolistUpdate() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String todolistContent = request.getParameter("todolistContent");
		String todolistDate = request.getParameter("todolistDate");
		
		TodolistVO vo = new TodolistVO();
		vo.setTodolistContent(todolistContent);
		vo.setTodolistDate(todolistDate);
		
		TodolistService svc = new TodolistServiceImpl();
		
		Map<String, Object> map = new HashMap<>();
		if(svc.insert(vo) == 1) {
			map.put("retCOde", "성공");
			map.put("data", vo);
		} else {
			map.put("retCode", "실패");
			map.put("data", "실패");
		}
		
		Gson gson = new GsonBuilder().create();
		
		response.setContentType("text/json;charset=utf-8");
		response.getWriter().print(gson.toJson(map));
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
