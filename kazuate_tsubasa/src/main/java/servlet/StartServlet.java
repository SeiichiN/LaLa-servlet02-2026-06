package servlet;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/Start")
public class StartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int com = new java.util.Random().nextInt(9) + 1;
		HttpSession session = request.getSession();
		session.setAttribute("com", com);
		RequestDispatcher d = request.getRequestDispatcher("WEB-INF/jsp/kazuate.jsp");
		d.forward(request, response);
	}
}
