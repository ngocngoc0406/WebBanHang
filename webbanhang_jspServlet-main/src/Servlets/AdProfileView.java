package Servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Objects.Users;
//định nghĩa Servlet có nhiệm vụ xử lý yêu cầu từ đường dẫn "/admin/pages/profile/view". 
/**
 * Servlet implementation class AdminProfileShow
 */
@WebServlet(description = "AdminProfileShow", urlPatterns = { "/admin/pages/profile/view" })
public class AdProfileView extends HttpServlet {
	private static final long serialVersionUID = 1L;
//định nghĩa constructor cho lớp Servlet AdProfileView được gọi khi một phiên bản mới của Servlet được tạo.
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AdProfileView() {
		super();
		// TODO Auto-generated constructor stub
	}
//triển khai phương thức doGet() của Servlet được gọi khi có yêu cầu HTTP GET gửi đến Servlet.
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		if (session.getAttribute("uslogin") != null) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("profile.jsp");
			dispatcher.forward(request, response);
		} else {
			response.sendRedirect("../../../pages/login.jsp");
		}
		
	}
//triển khai phương thức doPost() của Servlet được gọi khi có yêu cầu HTTP POST gửi đến Servlet.
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
