package co.micol.example.common;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ViewResolve {
	public static void forward(HttpServletRequest request, HttpServletResponse response, String viewName) 
			throws ServletException, IOException {
//		String prefix = "WEB-INF/views/";
		
		String prefix = "WEB-INF/views/";
		String subfix = ".tiles";
		
		if(viewName.startsWith("No:")) {
			viewName = viewName.substring(3);
			viewName = prefix + viewName + ".jsp";
		} else {
			viewName = viewName + subfix;
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewName);
		dispatcher.forward(request, response);
	}
}
