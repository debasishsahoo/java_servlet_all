package classes;

import jakarta.servlet.GenericServlet;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/HelloGenericServlet")
public class HelloGenericServlet extends GenericServlet {

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {

		// Fetch user input
		String user = req.getParameter("user");
		if (user == null || user.isEmpty()) {
			user = "Guest";
		}

		// Prepare message
		String message = "Welcome, " + user + "! (from GenericServlet + JSP)";

		// Pass data to JSP
		req.setAttribute("msg", message);

		// Forward to JSP
		RequestDispatcher rd = req.getRequestDispatcher("/hello.jsp");
		rd.forward(req, res);

	}

}
