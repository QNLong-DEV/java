package bai8self;

import java.text.DateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;

public class HangThucPham extends HangHoa {
	private String NhaCungCap;
	private LocalDate NgaySanXuat;
	private LocalDate NgayHetHan;

	public HangThucPham(String maHang, String tenHang, double donGia, int soLuongTon, String nhaCungCap,
			LocalDate ngaySanXuat, LocalDate ngayHetHan) throws Exception {
		super(maHang, tenHang, donGia, soLuongTon);
		setNhaCungCap(nhaCungCap);
		setNgaySanXuat(ngaySanXuat);
		setNgayHetHan(ngayHetHan);
	}

	public String getNhaCungCap() {
		return NhaCungCap;
	}

	public void setNhaCungCap(String nhaCungCap) {
		if (nhaCungCap == null || nhaCungCap.trim().isEmpty())
			NhaCungCap = "unk";
		else
			NhaCungCap = nhaCungCap;
	}

	public LocalDate getNgaySanXuat() {
		return NgaySanXuat;
	}

	public void setNgaySanXuat(LocalDate ngaySanXuat) {
		if (ngaySanXuat == null || ngaySanXuat.isAfter(LocalDate.now()))
			this.NgaySanXuat = LocalDate.now();
		else
			this.NgaySanXuat = ngaySanXuat;
	}

	public LocalDate getNgayHetHan() {
		return NgayHetHan;
	}

	public void setNgayHetHan(LocalDate ngayHetHan) {
		if (ngayHetHan == null || ngayHetHan.isBefore(NgaySanXuat))
			this.NgayHetHan = this.NgaySanXuat;
		else
			this.NgayHetHan = ngayHetHan;
	}

	@Override
	public String toString() {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");

		// Kiểm tra nếu getNgaySanXuat() và getNgayHetHan() là null trước khi định dạng
		String ngaySanXuat = (getNgaySanXuat() != null) ? dtf.format(getNgaySanXuat()) : "Không có ngày sản xuất";
		String ngayHetHan = (getNgayHetHan() != null) ? dtf.format(getNgayHetHan()) : "Không có ngày hết hạn";

		return super.toString() + String.format("%-20s %-20s %-20s", getNhaCungCap(), ngaySanXuat, ngayHetHan);
	}

	public static String getTieuDe() {
		return String.format("%s%-20s %-20s %-20s", HangHoa.getTieuDe(), "Nhà cung cấp", "Ngày sản xuất",
				"Ngày hết hạn");
	}

	@Override
	public double tinhThueVAT() {
		return super.getDonGia() * 0.05;
	}

	public boolean hetHan() {
		if (NgayHetHan.isBefore(LocalDate.now())) {
			return true;
		}
		return false;
	}

	@Override
	public String danhGia() {
		if (hetHan() == true && SoLuongTon > 0)
			return "Khó Bán";
		return "Bán Hết";

	}

}
