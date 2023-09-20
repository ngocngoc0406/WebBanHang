package Servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
//servlet "LogoutAccount" được ánh xạ đến mẫu URL "/LogoutAccount" bằng cách sử dụng chú thích @WebServlet.
/**
 * Servlet implementation class LogoutAccount
 */
@WebServlet("/LogoutAccount")
public class LogoutAccount extends HttpServlet {
	private static final long serialVersionUID = 1L;
 // phương thức khởi tạo của lớp LogoutAccount.      
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LogoutAccount() {
        super();
        // TODO Auto-generated constructor stub
    }
//Phương thức doGet() trong lớp LogoutAccount được gọi khi một yêu cầu HTTP GET được nhận từ máy khách.
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session= request.getSession();
		session.removeAttribute("sessionName");
	}
//Phương thức doPost() trong lớp LogoutAccount được gọi khi một yêu cầu HTTP POST được nhận từ máy khách.
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
