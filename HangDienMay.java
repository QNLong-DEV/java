package bai8self;

public class HangDienMay extends HangHoa {

	private int ThoiGianBaoHanh;
	private int CongSuat;

	public HangDienMay(String maHang, String tenHang, double donGia, int soLuongTon, int thoiGianBaoHanh, int congSuat)
			throws Exception {
		super(maHang, tenHang, donGia, soLuongTon);
		setCongSuat(congSuat);
		setThoiGianBaoHanh(thoiGianBaoHanh);
	}

	public int getThoiGianBaoHanh() {
		return ThoiGianBaoHanh;
	}

	public void setThoiGianBaoHanh(int thoiGianBaoHanh) {
		if (thoiGianBaoHanh < 0)
			ThoiGianBaoHanh = 0;
		else
			ThoiGianBaoHanh = thoiGianBaoHanh;
	}

	public int getCongSuat() {
		return CongSuat;
	}

	public void setCongSuat(int congSuat) {
		if (congSuat < 0)
			CongSuat = 0;
		else
			CongSuat = congSuat;
	}

	@Override
	public String toString() {
		String bh = ThoiGianBaoHanh + " tháng";
		String cs = CongSuat + "kw";
		return super.toString() + String.format("%-20s %-20s", bh, cs);
	}

	public static String getTieuDe() {
		return String.format("%s%-20s %-20s", HangHoa.getTieuDe(),"Thời gian bảo hành", "Công Suất");
	}

	@Override
	public double tinhThueVAT() {
		return super.DonGia * 0.1;
	}

	@Override
	public String danhGia() {
		if (SoLuongTon < 3)
			return "Bán được";
		else
			return "Không đánh giá";
	}

}
