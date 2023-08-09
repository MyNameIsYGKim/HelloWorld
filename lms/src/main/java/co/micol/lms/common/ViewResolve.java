package co.micol.lms.common;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ViewResolve {
	public static void forward(HttpServletRequest request, HttpServletResponse response, String viewName) throws ServletException, IOException {
		String prefix = "WEB-INF/views/";
		String subfix = ".jsp";
		viewName = prefix + viewName + subfix;
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewName);
		dispatcher.forward(request, response);
	}
}
