package classes;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.Servlet;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

//url:http://localhost:8080/01_Servlet_Interface/MyFirstServlet
@WebServlet("/MyFirstServlet")
public class MyFirstServlet implements Servlet {

	private ServletConfig config;

	@Override
	public void init(ServletConfig config) throws ServletException {
		this.config = config;
		System.out.println("Servlet initialized.");
	}

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {

		// Get form data from index.jsp (if available)
		String name = req.getParameter("username");
		if (name == null || name.isEmpty()) {
			name = "Guest";
		}

		// Business logic or data preparation
		String message = "Hello," + name + "Welcome to JSP Integration Example!";
		req.setAttribute("message", message);

		// Forward the request to JSP page
		RequestDispatcher rd = req.getRequestDispatcher("/message.jsp");
		rd.forward(req, res);

	}

	@Override
	public void destroy() {
		System.out.println("Servlet destroyed.");

	}

	@Override
	public ServletConfig getServletConfig() {
		return config;
	}

	@Override
	public String getServletInfo() {
		return "MyFirstServlet - JSP Enabled v1.1";
	}

}
