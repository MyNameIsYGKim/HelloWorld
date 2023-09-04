package co.micol.example.todolist.web;

import java.io.IOException;
import java.util.List;

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

@WebServlet("/AjaxTodolistList.do")
public class AjaxTodolistList extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public AjaxTodolistList() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		TodolistService svc = new TodolistServiceImpl();
		List<TodolistVO> list = svc.list();
		
		Gson gson = new GsonBuilder().create();
		
		response.setContentType("text/json;charset=utf-8");
		response.getWriter().print(gson.toJson(list));
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
