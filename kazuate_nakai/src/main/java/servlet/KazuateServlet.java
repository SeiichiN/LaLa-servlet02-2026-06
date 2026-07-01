package servlet;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/kazuate")
public class KazuateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response)
			throws ServletException, IOException {
		//フォワード
		String url ="Start";
		request.getRequestDispatcher(url).forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response)
			throws ServletException, IOException {
		
		//セッションスコープから値を取得
		HttpSession session = request.getSession();
		int com = (int) session.getAttribute("com");
		
		//フォーム入力の値を取得
		request.setCharacterEncoding("UTF-8");
		int user = Integer.parseInt(request.getParameter("user"));
		
		//結果の判定
		String result = "";
		
		if(user < com) {
			result = "小さすぎます";
		} else if(user > com) {
			result = "大きすぎます";
		} else if(user == com) {
			result = "正解です";
		}
		
		//リクエストスコープに保存
		request.setAttribute("result", result);
		
		//フォワード
		String url ="WEB-INF/jsp/kazuate.jsp"; 
		request.getRequestDispatcher(url).forward(request, response);
		
	}
	
}
