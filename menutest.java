package bai8self;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;


public class menutest {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		DanhSachHangHoa list = new DanhSachHangHoa(100);
		try {
			list.them(new HangDienMay("01", "Tủ lạnh 123 lít", 5000000, 10, 12, 2000));
			list.them(new HangDienMay("02", "Bếp điện từ Sunhouse", 600000, 10, 12, 2100));
			list.them(new HangSanhSu("04", "Chén bông Đào", 15000, 100, "Minh Long 1", LocalDate.of(2018, 10, 5)));
			list.them(new HangSanhSu("05", "Tô bông Đào", 18000, 0, "Minh Long 1", LocalDate.of(2018, 01, 24)));
			list.them(new HangDienMay("03", "Bếp hồng ngoại", 550000, 15, 24, 2000));
			list.them(new HangThucPham("06", "Gạo nàng thơm", 17000, 1000, "Safico", LocalDate.of(2018, 01, 01),
					LocalDate.of(2019, 03, 01)));
			int chon;
			boolean flag = true;
			do {
				System.out.println("===Chức năng=== " + "\n1. Thêm hàng hóa" + "\n2. Xuất toàn bộ danh sách hàng hóa"
						+ "\n3. Xuất danh sách từng loại hàng hóa" + "\n4. Tìm kiếm khi biết mã hàng"
						+ "\n5. Sắp tăng dần theo tên hàng" + "\n6. Sắp giảm dần theo số lượng tồn"
						+ "\n7. Xuất các hàng thực phẩm khó bán" + "\n8. Xóa hàng hóa" + "\n9. Sửa đơn giá"
						+ "\n Các trường hợp khác thoát chương trình" + "\n===Mời bạn chọn===");
				chon = sc.nextInt();
				sc.nextLine();
				switch (chon) {
				case 1:
					System.out.println(
							"Chọn loại hàng:" + "\n1. Hàng thực phẩm " + "\n2. Hàng điện máy" + "\n3. Hàng sành sứ");
					int loaiHang = sc.nextInt();

					System.out.println("Nhập mã hàng: ");
					String maHang = sc.nextLine();
					sc.nextLine();
					HangHoa hh = nhapmathang(loaiHang, maHang);
					try {
						list.them(hh); // Thêm vào danh sách
					} catch (Exception e) {
						System.out.println(e.getMessage()); // In thông báo lỗi nếu có ngoại lệ
					}
					break;
				case 2:
					System.out.println("Danh sách hàng hóa là: ");
					System.out.println(list.thongtin());
					break;
				case 3:
					System.out.println("chọn loại mặt hàng để in: " + "\n1.Hàng thực phẩm" + "\n2.Hàng Điện Máy"
							+ "\n3.Hàng Sành Sứ");
					int choice = sc.nextInt();
					if (choice == 1)
						System.out.println(list.thongtinHangThucPham());
					else if (choice == 2)
						System.out.println(list.thongtinHangDienMay());
					else if (choice == 3)
						System.out.println(list.thongtinHangSanhSu());
					else
						System.out.println("nhập sai!");
					break;
				case 4:
					System.out.println("Nhập mã hàng cần tìm: ");
					String maaHang = sc.nextLine();
					if (list.timkiem(maaHang) == null)
						System.out.println("Không tìm thấy hàng");
					else
						System.out.println(list.timkiem(maaHang));
					break;
				case 5:
					list.sapXepTangTheoTenHang();
					System.out.println("hàng hòa sau khi được sắp xếp: ");
					System.out.println(list.thongtin());
					break;
				case 6:
					list.sapXepGiamDantheoSoLuongTon();
					System.out.println("hàng hòa sau khi được sắp xếp: ");
					System.out.println(list.thongtin());
					break;
				case 7:
					System.out.println("thông tin hàng thực phẩm khó bán: ");
					System.out.println(list.thongtinThucPhamKhoBan());
					break;
				case 8:
					System.out.println("nhập thông tin mã hàng cần xóa: ");
					String mh = sc.nextLine();
					System.out.println("mã hàng đã xóa: " + list.xoa(mh));
					break;
				case 9:
					System.out.println("nhập thông tin mã hàng cần sửa: ");
					String mh1 = sc.nextLine();
					System.out.println("nhập thông tin đơn giá cần sửa: ");
					double newdongia = sc.nextDouble();
					System.out.println("đã sửa thành công: " + list.sua(mh1, newdongia));
					break;
				default: // Thoát vòng lặp do while
					flag = false;
					break;
				}
			} while (flag);
			sc.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static HangHoa nhapmathang(int loaiHang, String maHang) {
		HangHoa hh = null;
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		try {
			System.out.println("Nhập tên hàng: ");
			String tenHang = new Scanner(System.in).nextLine();
			System.out.println("Nhập đơn giá: ");
			double donGia = new Scanner(System.in).nextDouble();
			System.out.println("Nhập số lượng tồn: ");
			int soLuongTon = new Scanner(System.in).nextInt();

			switch (loaiHang) {
			case 1:
				System.out.println("Nhập ngày sản xuất(dd/MM/yyyy): ");
				String s1 = new Scanner(System.in).nextLine();
				LocalDate ngsx = LocalDate.parse(s1, dtf);

				System.out.println("Nhập ngày hết hạn(dd/MM/yyyy): ");
				String s2 = new Scanner(System.in).nextLine();
				LocalDate nghh = LocalDate.parse(s2, dtf);

				System.out.println("Nhập tên nhà cung cấp: ");
				String nhacc = new Scanner(System.in).nextLine();

				hh = new HangThucPham(maHang, tenHang, donGia, soLuongTon, nhacc, ngsx, nghh);
				break;
			case 2:
				System.out.println("Nhập thời gian bảo hành: ");
				int thoiGianBH = new Scanner(System.in).nextInt();
				System.out.println("Nhập số công suất: ");
				int congSuat = new Scanner(System.in).nextInt();
				hh = new HangDienMay(maHang, tenHang, donGia, soLuongTon, thoiGianBH, congSuat);
				break;
			case 3:
				System.out.println("Nhập nhà sản xuất: ");
				String nhaSanXuat = new Scanner(System.in).nextLine();
				System.out.println("Nhập ngày nhập kho (dd/MM/yyyy): ");
				String s = new Scanner(System.in).nextLine();
				dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
				LocalDate ngnk = LocalDate.parse(s, dtf);
				hh = new HangSanhSu(maHang, tenHang, donGia, soLuongTon, nhaSanXuat, ngnk);
				break;
			}
		} catch (Exception ex) {
			System.out.println("Bạn nhập không tương thích với định dạng.");
			System.out.println("Mời nhập lại!");
		}
		return hh;
	}
}
