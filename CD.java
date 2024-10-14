package ex10;

import java.text.NumberFormat;
import java.util.Locale;

import javax.swing.text.NumberFormatter;

public class CD {
	private int maCD;
	private String cdName;
	private int sobaiHat;
	private double gia;

	public CD() throws Exception {
		this(0, "unk", 0, 0);
	}

	public CD(int maCD, String cdName, int sobaiHat, double gia) throws Exception {
		setCdName(cdName);
		setGia(gia);
		setMaCD(maCD);
		setSoBaiHat(sobaiHat);
	}

	public int getMaCD() {
		return maCD;
	}

	public void setMaCD(int maCD) throws Exception {
		if (maCD < 0 || maCD > 999999)
			throw new Exception("lỗi nhập mã cd");
		else
			this.maCD = maCD;
	}

	public String getCdName() {
		return cdName;
	}

	public void setCdName(String cdName) throws Exception {
		if (cdName == null || cdName.trim().isEmpty())
			throw new Exception("lỗi nhập tên cd");
		else
			this.cdName = cdName;
	}

	public int getSoBaiHat() {
		return sobaiHat;
	}

	public void setSoBaiHat(int sobaiHat) throws Exception {
		if (sobaiHat <= 0)
			throw new Exception("nhập sai số bài hát");
		else
			this.sobaiHat = sobaiHat;
	}

	public double getGia() {
		return gia;
	}

	public void setGia(double gia) throws Exception {
		if (gia < 0)
			throw new Exception("nhập sai giá");
		else
			this.gia = gia;
	}

	public String toString() {
		NumberFormat nft = NumberFormat.getInstance(new Locale("vi", "VN"));
		return String.format("%-20d | %-20s | %-20d | %-20s", maCD, cdName, sobaiHat, nft.format(gia));
	}

}
