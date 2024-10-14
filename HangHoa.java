package bai8self;

import java.text.DecimalFormat;

public abstract class HangHoa {
	private String MaHang;
	protected String TenHang;
	protected double DonGia;
	protected int SoLuongTon;

	public HangHoa(String maHang, String tenHang, double donGia, int soLuongTon) throws Exception {
		setDonGia(donGia);
		setMaHang(maHang);
		setSoLuongTon(soLuongTon);
		setTenHang(tenHang);
	}

	public String getMaHang() {
		return MaHang;
	}

	public void setMaHang(String maHang) throws Exception {
		if (maHang == null || maHang.trim().isEmpty())
			throw new Exception("lỗi");
		else
			MaHang = maHang;
	}

	public String getTenHang() {
		return TenHang;
	}

	public void setTenHang(String tenHang) {
		if (tenHang == null || tenHang.trim().isEmpty())
			TenHang = "xxx";
		else
			TenHang = tenHang;
	}

	public double getDonGia() {
		return DonGia;
	}

	public void setDonGia(double donGia) {
		if (donGia < 0)
			DonGia = 0;
		else
			DonGia = donGia;
	}

	public int getSoLuongTon() {
		return SoLuongTon;
	}

	public void setSoLuongTon(int soLuongTon) {
		if (soLuongTon < 0)
			SoLuongTon = 0;
		else
			SoLuongTon = soLuongTon;
	}

	public String toString() {
		DecimalFormat fmt = new DecimalFormat("#,##0.00");
		return String.format("%-10s %-20s %-20s %-20d", getMaHang(), getTenHang(), fmt.format(getDonGia()),
				getSoLuongTon());
	}

	public static String getTieuDe() {
		return String.format("%-10s %-20s %-20s %-20s", "Mã Hàng", "Tên Hàng", "Đơn giá", "Số lượng tồn");
	}

	public abstract double tinhThueVAT();

	public abstract String danhGia();
}
