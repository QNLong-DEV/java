package bai8self;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

public class cacdinhdangstringcannho {
	public static void main(String[] args) {
		DecimalFormat fmt = new DecimalFormat("#,##0.00");
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		NumberFormat nft = NumberFormat.getInstance(new Locale("vi", "VN"));
		// hàm equalIgnoreCase => so sanh không pbiet hoa thường
		String s1 = "qnl";
		String s2 = "Qnl";
		String s3 = "qnl";
		// hàm equal => so sánh chuỗi giống nhau, pbiet hoa thường
		System.out.println("s1 equals s2: " + s1.equals(s2));
		System.out.println("s1 equals s3: " + s1.equals(s3));
		// hàm equalIgnoreCase => so sanh không pbiet hoa thường
		System.out.println("s1 equals s2: " + s1.equalsIgnoreCase(s2));
		System.out.println("s1 equals s3: " + s1.equalsIgnoreCase(s3));
		// hàm compareTo = > so sánh lớn bé bằng
		String sv1 = "Nguyễn Văn A";
		String sv2 = "Nguyễn Văn B";
		String sv3 = "Nguyễn Văn";
		String sv4 = "Nguyễn Văn A";
		System.out.println("sv1 compare sv2: " + sv1.compareTo(sv2));
		System.out.println("sv1 compare sv3: " + sv1.compareTo(sv3));
		System.out.println("sv1 compare sv4: " + sv1.compareTo(sv4));
		// hàm compareToIgnoreCase => giống compareTo ko pbiet hoa, thường
		System.out.println("sv1 compare sv2: " + sv1.compareToIgnoreCase(sv2));
		System.out.println("sv1 compare sv3: " + sv1.compareToIgnoreCase(sv3));
		System.out.println("sv1 compare sv4: " + sv1.compareToIgnoreCase(sv4));
		// hàm regionMatches => so sánh một đoạn
		String r1 = "323qnl123";
		String r2 = "qnl";
		boolean check = r1.regionMatches(2, r2, 0, 2);
		System.out.println(check);
		// hàm startWith => kiểm tra chuỗi bắt đầu bằng ...
		String sdt = "0371234556";
		System.out.println(sdt.startsWith("037"));
		System.out.println(sdt.startsWith("034"));
		// hàm endWith => kiểm tra chuỗi kết thúc bằng ...
		String tenfile = "asdasd.JDG";
		if (tenfile.endsWith("JDG")) {
			System.out.println("true");
		} else
			System.out.println("false");
		// hàm indexof: tìm kiếm chuỗi(trả về vị trí bắt đầu)
		System.out.println(r1.indexOf(r2));
		// hàm lastindexof: tìm kiếm chuỗi từ cuối lên
		System.out.println(r1.lastIndexOf(r2));
		// hàm concat()
		// c1
		String a = s1 + s2;
		// c2
		String a1 = s1.concat(s2);
		System.out.println(a);
		System.out.println(a1);
		// hàm replace => thay thế
		String a2 = "QNL.vn";
		String a3 = a2.replaceAll(a2, "kkkkk");
		System.out.println(a3);
		// toLowerCase, toUpperCase
		String a4 = a2.toLowerCase();
		System.out.println(a4);
		String a5 = a2.toUpperCase();
		System.out.println(a5);
		// trim() xóa khoảng trắng dư thừa ở đầu chuỗi
		String b = " a  sd a   ";
		System.out.println(b.trim());
		// subString cắt chuỗi con
		String s0 = "helo helo asd";
		String p = s0.substring(0, s0.length());
		// cộng thêm ngày
		LocalDate today = LocalDate.now();
		LocalDate futureDate = today.plusDays(10);
		System.out.println("Ngày hiện tại: " + today);
		System.out.println("Ngày sau 10 ngày: " + futureDate);
		// trừ đi tháng
		LocalDate pastDate = today.minusMonths(3);
		System.out.println("Ngày hiện tại: " + today);
		System.out.println("Ngày cách đây 3 tháng: " + pastDate);
		// chuyển đổi String thành localDate
		String dateString = "15-10-2023";
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		LocalDate date = LocalDate.parse(dateString, formatter);
		System.out.println("Ngày được chuyển đổi: " + date);
		// kiểm tra món hàng có nằm trong khoảng ngày bắt đầu và kết thúc
		LocalDate startDate = LocalDate.of(2023, 10, 1); // Ngày 1
		LocalDate endDate = LocalDate.of(2023, 10, 10); // Ngày 10
		LocalDate itemDate = LocalDate.of(2023, 10, 5); // Ví dụ: Ngày 5 tháng 10
		if ((itemDate.isAfter(startDate) || itemDate.equals(startDate))
				&& (itemDate.isBefore(endDate) || itemDate.equals(endDate))) {
			System.out.println("Món hàng có ngày " + itemDate + " nằm trong khoảng từ ngày 1 đến ngày 10.");
		} else {
			System.out.println("Món hàng có ngày " + itemDate + " không nằm trong khoảng từ ngày 1 đến ngày 10.");
		}
		//nhập date
		String s = new Scanner(System.in).nextLine();
		LocalDate ss = LocalDate.parse(s, dtf);
	}
}
