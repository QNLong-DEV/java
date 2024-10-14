package bai8self;

import java.util.Arrays;
import java.util.Comparator;

import bai09.Person;

public class DanhSachHangHoa {
	private HangHoa[] list;
	private int count;

	public DanhSachHangHoa(int n) {
		list = new HangHoa[n];
		this.count = 0;
	}

	public void them(HangHoa a) throws Exception {
		if (a == null) {
			throw new Exception("Hàng hóa không được null.");
		}
		for (int i = 0; i < count; i++) {
			if (list[i].getMaHang().compareToIgnoreCase(a.getMaHang()) == 0) {
				throw new Exception("Trùng mã hàng");
			}
		}
		list[count++] = a;
	}

	public boolean add(HangHoa a) throws Exception {
		if (a == null)
			throw new Exception("không thể thêm");
		if (list.length < count) {
			HangHoa[] newList = new HangHoa[list.length * 2]; // Tạo mảng mới có kích thước lớn gấp đôi
			for (int i = 0; i < list.length; i++) {
				newList[i] = list[i]; // Sao chép các phần tử từ mảng cũ sang mảng mới
			}
			list = newList;
		}
		list[count++] = a;
		return true;
	}

	public String thongtin() {
		String s = String.format("%-10s %-20s %-20s %-20s %-15s\n", "Mã hàng", "Tên hàng", "Đơn giá", "Số lượng tồn",
				"Loại hàng");
		for (int i = 0; i < count; i++) {
			s += String.format("%-10s %-20s %-20.2f %-20d %-15s\n", list[i].getMaHang(), list[i].getTenHang(),
					list[i].getDonGia(), list[i].getSoLuongTon(), list[i].getClass().getSimpleName());
		}
		return s;
	}

	public String thongtinHangThucPham() {
		String s = HangThucPham.getTieuDe() + "\n";
		for (int i = 0; i < count; i++) {
			if (list[i] instanceof HangThucPham) {
				s += list[i] + "\n";
			}
		}
		return s;
	}

	public String thongtinHangDienMay() {
		String s = HangDienMay.getTieuDe() + "\n";
		for (int i = 0; i < count; i++) {
			if (list[i] instanceof HangDienMay) {
				s += list[i] + "\n";
			}
		}
		return s;
	}

	public String thongtinHangSanhSu() {
		String s = HangSanhSu.getTieuDe() + "\n";
		for (int i = 0; i < count; i++) {
			if (list[i] instanceof HangSanhSu) {
				s += list[i] + "\n";
			}
		}
		return s;
	}

	public HangHoa timkiem(String maHang) {
		for (int i = 0; i < count; i++) {
			if (list[i].getMaHang().compareToIgnoreCase(maHang) == 0) {
				return list[i];
			}
		}
		return null;
	}

	public void sapXepTangTheoTenHang() {
		Arrays.sort(list, new Comparator<HangHoa>() {
			public int compare(HangHoa o1, HangHoa o2) {
				if (o1 != null && o2 != null) {
					return o1.getTenHang().compareToIgnoreCase(o2.getTenHang());
				}
				return 0;
			}
		});
	}

	public void sapXepGiamDantheoSoLuongTon() {
		Arrays.sort(list, new Comparator<HangHoa>() {
			public int compare(HangHoa o1, HangHoa o2) {
				if (o1 != null && o2 != null) {
					if (o1.getSoLuongTon() > o2.getSoLuongTon())
						return -1;
					else if (o1.getSoLuongTon() < o2.getSoLuongTon())
						return 1;
					return 0;
				}
				return 0;
			}
		});
	}

	public String thongtinThucPhamKhoBan() {
		String s = HangThucPham.getTieuDe() + "\n";
		for (int i = 0; i < count; i++) {
			if (list[i] instanceof HangThucPham) {
				if (list[i].danhGia().equalsIgnoreCase("Khó bán")) {
					s += list[i].toString() + "\n";
				}
			}
		}
		return s;
	}

	public boolean xoa(String mahang) {
		HangHoa hh = timkiem(mahang);
		if (hh == null)
			return false;
		HangHoa[] tmp = new HangHoa[count - 1];
		int j = 0;
		for (int i = 0; i < count; i++) {
			if (list[i].getMaHang().compareTo(mahang) != 0) {
				tmp[j++] = list[i];
			}
		}
		list = tmp;
		count--;
		return true;
	}

	public boolean sua(String maHang, double new_dongia) {
		for (int i = 0; i < count; i++) {
			if (list[i].getMaHang().compareToIgnoreCase(maHang) == 0) {
				list[i].setDonGia(new_dongia);
				return true;
			}
		}
		return false;
	}

}
