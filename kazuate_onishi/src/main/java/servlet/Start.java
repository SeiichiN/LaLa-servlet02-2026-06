package servlet;

import java.io.IOException;
import java.util.Random;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/Start")
public class Start extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	int com = new Random().nextInt(99) + 1;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

		HttpSession session = request.getSession();
		session.setAttribute("com", com);
				
		String url = "WEB-INF/jsp/kazuate.jsp";
		request.getRequestDispatcher(url).forward(request, response);
	}
}
