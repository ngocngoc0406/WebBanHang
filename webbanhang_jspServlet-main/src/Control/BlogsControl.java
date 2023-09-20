package Control;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Map;

import Model.dao_Blogs;
import Objects.Blogs;
//Lớp BlogsControl định nghĩa một lớp điều khiển (controller) cho việc quản lý các bài viết. 
public class BlogsControl {
	dao_Blogs dao = new dao_Blogs();
//Phương thức được sử dụng để lấy danh sách các bài viết từ cơ sở dữ liệu. 
	public ArrayList<Blogs> getListBlogs() {

		String sql = "Select * From baiviet ORDER BY id DESC";
		return dao.SelectDB(sql);
	}
//Phương thức getFindWithId trong lớp BlogsControl được sử dụng để tìm kiếm một bài viết dựa trên một id được truyền vào.
	public Blogs getFindWithId(long id) {
		String sql = "SELECT * FROM baiviet WHERE id = " + id;
		return dao.FindWithId(sql);
	}
//Phương thức getBlog_TaiKhoanWithId trong lớp BlogsControl được sử dụng để lấy thông tin liên quan đến bài viết và tài khoản dựa trên một id được truyền vào.
	public Map<String, String> getBlog_TaiKhoanWithId(long id) {
		String sql = "SELECT baiviet.id, tieude, mota, noidung, baiviet.hinhanh, ngaydang, ngaysua, id_taikhoan, tentaikhoan, tenhienthi, taikhoan.hinhanh as hinhdaidien FROM baiviet, taikhoan WHERE baiviet.id_taikhoan = taikhoan.id and baiviet.id = "
				+ id;
		return dao.Blog_TaiKhoanWithId(sql);
	}
//Phương thức getAddData trong lớp BlogsControl được sử dụng để thêm một bài viết mới vào cơ sở dữ liệu. 
	public boolean getAddData(Blogs blog) {
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();
		String sql = "INSERT INTO baiviet (tieude, mota, noidung, hinhanh, id_taikhoan, ngaydang) " + "VALUES (\""
				+ blog.getTieude() + "\", \"" + blog.getMota() + "\", '" + blog.getNoidung() + "', \""
				+ blog.getHinhanh() + "\", " + blog.getId_taikhoan() + ", DATE(\"" + dateFormat.format(date) + "\"))";
//		System.out.println(sql);
		return dao.AddData(blog, sql);
	}
//Phương thức getEditData trong lớp BlogsControl được sử dụng để chỉnh sửa thông tin của một bài viết trong cơ sở dữ liệu.
	public boolean getEditData(Blogs blog) {
		String sql = "UPDATE baiviet SET tieude = ?, mota = ?, noidung = ?, hinhanh = ? WHERE id = ?";
		return dao.EditData(blog, sql);
	}
//Phương thức getDelData trong lớp BlogsControl được sử dụng để xóa một bài viết từ cơ sở dữ liệu dựa trên một id được truyền vào
	public boolean getDelData(int id) {
		String sql = "DELETE FROM baiviet WHERE id = ?";
		return dao.DelData(id, sql);
	}
	
	public static void main(String[] args) {
		dao_Blogs dao = new dao_Blogs();
		// for (Blogs ls : dao.SelectDB("Select * From baiviet")) {
		// System.out.println(ls.getId());
		// }
		BlogsControl blogControl = new BlogsControl();
		Map<String, String> blog_TaiKhoan_ID = blogControl.getBlog_TaiKhoanWithId(1);
//		System.out.println(blog_TaiKhoan_ID.get("tentaikhoan"));
//		System.out.println(blog_TaiKhoan_ID.get("id"));
//		System.out.println(blog_TaiKhoan_ID.get("tieude"));
//		System.out.println(blog_TaiKhoan_ID.get("hinhdaidien"));
//		System.out.println(blog_TaiKhoan_ID.get("hinhanh"));

		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();
		System.out.println(dateFormat.format(date));
	}

}
