package Servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Control.CategoryControl;
import Control.ProductsControl;
import Objects.Category;
import Objects.Products;

/**
 * Servlet implementation class ProductList
 */
//Servlet được định nghĩa để xử lý các yêu cầu đến đường dẫn "/admin/pages/product/list".
@WebServlet(description = "List Product", urlPatterns = { "/admin/pages/product/list" })
public class ProductList extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
//Phương thức constructor ProductList() được gọi khi một đối tượng của lớp ProductList được tạo ra. 
	public ProductList() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
//Phương thức doGet() được gọi khi một yêu cầu HTTP GET được gửi đến servlet ProductList.
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		CategoryControl category = new CategoryControl();
		ArrayList<Category> listCategory = category.getListCategory();
		request.setAttribute("listCategory", listCategory);
		
		ProductsControl productControl = new ProductsControl();
		ArrayList<Products> list = productControl.getListProducts();
		request.setAttribute("list", list);
		
		HttpSession session = request.getSession();
		if (session.getAttribute("uslogin") != null) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("list.jsp");
			dispatcher.forward(request, response);
		}else {
			response.sendRedirect("../../../pages/login.jsp");
		}
	}
}
