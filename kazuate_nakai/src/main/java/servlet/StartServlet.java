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
public class StartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
				//comの数字をランダム生成
				int com = new Random().nextInt(9)+1;
				
				//セッションスコープに値を保存
				HttpSession session = request.getSession();
				session.setAttribute("com", com);
				
				//フォワード
				String url = "WEB-INF/jsp/kazuate.jsp";
				request.getRequestDispatcher(url).forward(request, response);
}

}
