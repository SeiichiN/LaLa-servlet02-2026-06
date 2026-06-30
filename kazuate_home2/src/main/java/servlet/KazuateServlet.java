package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/Kazuate")
public class KazuateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String retry = request.getParameter("retry");
		if (retry == null) {
			setCom(request);
		}
		String url = "WEB-INF/jsp/kazuate.jsp";
		request.getRequestDispatcher(url).forward(request, response);
	}
	
	private void setCom(HttpServletRequest request) {
		int com = new Random().nextInt(99) + 1;
		HttpSession session = request.getSession();
		session.setAttribute("com", com);		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		int com = (Integer) session.getAttribute("com");
		String you = request.getParameter("kazu");
		String msg = "";
		int user = Integer.parseInt(you);
		if (user > com) {
			msg = "大きすぎます";
		} else if (user < com) {
			msg = "小さすぎます";
		} else {
			msg = "正解です";
			setCom(request);
		}
		request.setAttribute("msg", msg);
		String url = "WEB-INF/jsp/result.jsp";
		request.getRequestDispatcher(url).forward(request, response);
	}

}
