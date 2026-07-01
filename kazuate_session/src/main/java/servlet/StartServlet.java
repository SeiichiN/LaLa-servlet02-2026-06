package servlet;

import java.io.IOException;

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
		HttpSession session = request.getSession();
		int com = (int) (Math.random() * 99) + 1;
		session.setAttribute("com", com);
		String msg = "新しい数を設定しました";
		request.setAttribute("msg", msg);
		String url = "WEB-INF/jsp/kazuate.jsp";
		request.getRequestDispatcher(url).forward(request, response);

	}

}
