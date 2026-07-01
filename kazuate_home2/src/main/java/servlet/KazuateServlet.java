package servlet;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import model.Kazu;
import model.KazuLogic;

@WebServlet("/Kazuate")
public class KazuateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = "WEB-INF/jsp/kazuate.jsp";
		request.getRequestDispatcher(url).forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		Kazu kazu = (Kazu) session.getAttribute("kazu");
		if (kazu == null) {
			response.sendRedirect("start");
			return;
		}
		String you = request.getParameter("kazu");
		String msg = "";
		int user = Integer.parseInt(you);
		kazu.setUser(user);
		
		KazuLogic kazuLogic = new KazuLogic();
		kazuLogic.execute(kazu);
		
		String url = "WEB-INF/jsp/kazuate.jsp";
		request.getRequestDispatcher(url).forward(request, response);
	}

}
