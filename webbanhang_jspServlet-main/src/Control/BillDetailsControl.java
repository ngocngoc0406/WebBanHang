package Control;

import java.util.ArrayList;

import Model.dao_BillDetail;
import Objects.BillDetailsFull;
import Objects.BillsDetail;

public class BillDetailsControl {
	dao_BillDetail dao = new dao_BillDetail();
//Phương thức được sử dụng để lấy thông tin chi tiết hóa đơn từ cơ sở dữ liệu dựa trên một idHoaDon được truyền vào. 
	public ArrayList<BillDetailsFull> getFindByIdHoaDon(long idHoaDon) {
		String sql = "SELECT `chitiethoadon`.`id`,`soluong`,`id_hoadon`,`id_sanpham`,`tensanpham`, `giagoc`,`khuyenmai`,`anhchinh` FROM `sanpham`, `chitiethoadon` WHERE `sanpham`.`id` = `chitiethoadon`.`id_sanpham` AND `id_hoadon` = "
				+ idHoaDon;
		return dao.FindByIdHoaDon(sql);
	}
//Phương thức được sử dụng để chỉnh sửa thông tin chi tiết hóa đơn trong cơ sở dữ liệu. 
	public boolean getEditData(BillsDetail billDetail) {
		String sql = " UPDATE `chitiethoadon` SET `soluong`= ?,`id_hoadon`= ?,`id_sanpham`= ? WHERE `id`= ?";
		return dao.EditData(billDetail, sql);
	}
//Phương thức được sử dụng để thêm thông tin chi tiết hóa đơn vào cơ sở dữ liệu.
	public boolean getAddData(BillsDetail billDetail) {
		String sql = "INSERT INTO chitiethoadon (`soluong`, `id_hoadon`, `id_sanpham`) VALUES ("
				+ billDetail.getSoluong() + ", " + billDetail.getId_hoadon() + ", " + billDetail.getId_sanpham() + ")";
		return dao.AddData(billDetail, sql);
	}
//Phương thức được sử dụng để xóa thông tin chi tiết hóa đơn từ cơ sở dữ liệu dựa trên một id được truyền vào. 
	public boolean getDelData(long id) {
		String sql = "DELETE FROM chitiethoadon WHERE id = ?";
		return dao.DelData(id, sql);
	}
//Phương thức được sử dụng để tìm kiếm thông tin chi tiết hóa đơn từ cơ sở dữ liệu dựa trên một id được truyền vào.	
	public BillDetailsFull getFindById(long id) {
		String sql = "SELECT `chitiethoadon`.`id`,`soluong`,`id_hoadon`,`id_sanpham`,`tensanpham`, `giagoc`,`khuyenmai`,`anhchinh` FROM `sanpham`, `chitiethoadon` WHERE `sanpham`.`id` = `chitiethoadon`.`id_sanpham` AND `chitiethoadon`.`id` = "
				+ id;
		return dao.FindById(sql);
	}
}
