package servlet;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Com;
import model.JudgeLogic;
import model.SetNumberLogic;

@WebServlet("/Kazuate")
public class KazuateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Com c = new Com();
		SetNumberLogic setNumberLogic = new SetNumberLogic();
		setNumberLogic.execute(c);
		String msg = "";
		c.setMsg(msg);
		HttpSession session = request.getSession();
		session.setAttribute("com", c);
		RequestDispatcher d = request.getRequestDispatcher("WEB-INF/jsp/kazuate.jsp");
		d.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		JudgeLogic judgeLogic = new JudgeLogic();
		String you = request.getParameter("kazu");
		int user = Integer.parseInt(you);
		HttpSession session = request.getSession();
		Com c = (Com) session.getAttribute("com");

		judgeLogic.execute(user, c);

		String url = "WEB-INF/jsp/kazuate.jsp";
		request.getRequestDispatcher(url).forward(request, response);
	}

}
