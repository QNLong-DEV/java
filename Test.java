package ex10;

import java.util.Scanner;

public class Test {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		CDlist cdList = new CDlist(3);
		try {
			cdList.add(new CD(1,"a",12,5000));
			cdList.add(new CD(3,"q",12,2000));
			cdList.add(new CD(2,"c",12,8000));
			int q = -1;
			while (q != 0) {
				System.out.println("1. thêm một CD vào danh sách");
				System.out.println("2. tính số lượng CD có trong danh sách.");
				System.out.println("3. tính tổng giá thành của các CD");
				System.out.println("4. tìm kiếm theo mã CD");
				System.out.println("5. trả thông tin của toàn bộ CD có trong danh sách");
				System.out.println("6. sắp xếp danh sách giảm dần theo giá thành");
				System.out.println("7. sắp xếp danh sách tăng dần theo tên CD");
				System.out.println("0. thoát");
				System.out.print("chọn lựa chọn: ");
				q = sc.nextInt();
				switch (q) {
				case 1:
					System.out.println("nhập mã CD: ");
					int ma = sc.nextInt();
					sc.nextLine();
					System.out.println("nhập tên CD: ");
					String ten = sc.nextLine();
					System.out.println("nhập số lượng bài hát: ");
					int sl = sc.nextInt();
					System.out.println("nhập giá CD: ");
					double gia = sc.nextDouble();
					if (cdList.add(new CD(ma, ten, sl, gia)))
						System.out.println("thêm thành công");
					else
						System.out.println("thêm thất bại");
					break;
				case 2:
					System.out.println("số lượng CD trong danh sách: " + cdList.soLuong());
					break;
				case 3:
					System.out.println("tổng giá thành trong danh sách là: " + cdList.tongGiaThanh());
					break;
				case 4:
					System.out.println("nhập mã cd cần tìm");
					int macd = sc.nextInt();
					if (cdList.timkiem(macd))
						System.out.println("Đã tìm thấy cd");
					else
						System.out.println("Không tìm thấy cd");
					break;
				case 5:
					System.out.println(cdList.thongtin());
					break;
				case 6:
					if (cdList.sapxepgiamdan())
						System.out.println("sắp xếp thành công");
					else
						System.out.println("sắp xếp thất bại");
					break;
				case 7:
					if (cdList.sapxeptangdan())
						System.out.println("sắp xếp thành công");
					else
						System.out.println("sắp xếp thất bại");
					break;
				}
			}
		} catch (Exception ec) {
			System.out.println(ec.getMessage());
		}
	}

}
