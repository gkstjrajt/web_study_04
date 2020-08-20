package unit02;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request,response);
	}

	private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String userID = request.getParameter("userID");
		String userPwd = request.getParameter("userPwd");
		String loginCheck = request.getParameter("loginCheck");
		System.out.printf("%s%n %s%n %s%n", userID, userPwd, loginCheck);
		
		
		request.setAttribute("userID", userID);
//		request.setAttribute("userPwd", userPwd);
//		request.setAttribute("loginCheck", loginCheck);
		
		RequestDispatcher dispatcher;
		if (loginCheck.contentEquals("user")) {
			request.setAttribute("userName", "전고객");
			dispatcher = request.getRequestDispatcher("09_userMain.jsp");
		} else {
			request.setAttribute("userName", "성관리");
			dispatcher = request.getRequestDispatcher("09_managerMain.jsp");
		}
		dispatcher.forward(request, response);
	}

}
