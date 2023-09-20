package Servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//Lớp demoThanhToan là một Servlet  được đăng ký với URL "/demoThanhToan" bằng cách sử dụng annotation @WebServlet("/demoThanhToan").
/**
 * Servlet implementation class demoThanhToan
 */
@WebServlet("/demoThanhToan")
public class demoThanhToan extends HttpServlet {
	private static final long serialVersionUID = 1L;
//Phương thức khởi tạo demoThanhToan() là một phương thức constructor trong lớp demoThanhToan      
    /**
     * @see HttpServlet#HttpServlet()
     */
    public demoThanhToan() {
        super();
        // TODO Auto-generated constructor stub
    }
//Phương thức doGet() trong lớp demoThanhToan được gọi khi một yêu cầu HTTP GET được nhận từ máy khách.
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
//Phương thức doPost() trong lớp demoThanhToan được gọi khi một yêu cầu HTTP POST được nhận từ máy khách. 
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
