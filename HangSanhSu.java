package bai8self;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class HangSanhSu extends HangHoa {
	private String NhaSanXuat;
	private LocalDate NgayNhapKho;

	public HangSanhSu(String maHang, String tenHang, double donGia, int soLuongTon, String nhaSanXuat,
			LocalDate ngayNhapKho) throws Exception {
		super(maHang, tenHang, donGia, soLuongTon);
		setNgayNhapKho(ngayNhapKho);
		setNhaSanXuat(nhaSanXuat);
	}

	public String getNhaSanXuat() {
		return NhaSanXuat;
	}

	public void setNhaSanXuat(String nhaSanXuat) {
		NhaSanXuat = nhaSanXuat;
	}

	public LocalDate getNgayNhapKho() {
		return NgayNhapKho;
	}

	public void setNgayNhapKho(LocalDate ngayNhapKho) {
		LocalDate NgayHienTai = LocalDate.now();
		if (ngayNhapKho == null || ngayNhapKho.isAfter(NgayHienTai))
			NgayNhapKho = NgayHienTai;
		else
			NgayNhapKho = ngayNhapKho;
	}

	@Override
	public String toString() {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		return super.toString() + String.format("%-20s %-20s", NhaSanXuat, dtf.format(NgayNhapKho));
	}
	
	public static String getTieuDe() {
		return String.format("%s%-20s %-20s", HangHoa.getTieuDe(),"Nhà sản xuất", "Ngày nhập kho");
	}
	

	@Override
	public double tinhThueVAT() {
		return super.DonGia * 0.1;
	}

	public int ThoiGianLuuKho() {
		LocalDate homNay = LocalDate.now();
		Period intervalPeriod = Period.between(NgayNhapKho, homNay);
		int soNgay = intervalPeriod.getDays();
		return soNgay;
	}

	@Override
	public String danhGia() {
		if (ThoiGianLuuKho() > 10 && SoLuongTon > 50)
			return "Bán chậm";
		else
			return "Không đánh giá";
	}

}
