package co.micol.testtemplete.home.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.micol.testtemplete.common.ViewResolve;

@WebServlet("/about.do")
public class AboutController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public AboutController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String viewName = "home/about";
		ViewResolve.forward(request, response, viewName);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
