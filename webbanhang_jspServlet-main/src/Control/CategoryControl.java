package Control;

import java.util.ArrayList;
import java.util.regex.Pattern;

import Model.dao_Category;
import Objects.Category;

public class CategoryControl {

	dao_Category dao = new dao_Category();
//Phương thức getListCategory trong lớp BlogsControl được sử dụng để lấy danh sách các danh mục sản phẩm từ cơ sở dữ liệu
	public ArrayList<Category> getListCategory() {
		String sql = "Select * From loaisanpham";
		return dao.SelectDB(sql);
	}
//Phương thức getFindWithId trong lớp BlogsControl được sử dụng để tìm kiếm một danh mục sản phẩm dựa trên một id được truyền vào. 
	public Category getFindWithId(int id) {
		String sql = "SELECT * FROM loaisanpham WHERE id = " + id;
		return dao.FindWithId(sql);
	}
//Phương thức getEditData trong lớp BlogsControl được sử dụng để chỉnh sửa thông tin của một danh mục sản phẩm trong cơ sở dữ liệu
	public boolean getEditData(Category category) {
		String sql = "UPDATE loaisanpham SET tenloai = ? WHERE id = ?";
		return dao.EditData(category, sql);
	}
//Phương thức getAddData trong lớp BlogsControl được sử dụng để thêm một danh mục sản phẩm mới vào cơ sở dữ liệu
	public boolean getAddData(Category category) {
		String sql = "INSERT INTO loaisanpham (tenloai) VALUES (\"" + category.getTenloai() + "\")";
		return dao.AddData(category, sql);
	}
//Phương thức getDelData trong lớp BlogsControl được sử dụng để xóa một danh mục sản phẩm từ cơ sở dữ liệu dựa trên một id được truyền vào.
	public boolean getDelData(int id) {
		String sql = "DELETE FROM loaisanpham WHERE id = ?";
		return dao.DelData(id, sql);
	}

}
