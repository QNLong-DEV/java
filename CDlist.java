package ex10;

public class CDlist {
	private CD[] cdList;
	private int count = 0;

	public CDlist() {
	}

	public CDlist(int n) {
		cdList = new CD[n];
		this.count = 0;
	}

	public boolean add(CD a) {
		if (a == null) {
			return false;
		}
		if (count == cdList.length) {
			CD[] listnew = new CD[count + 1];
			int j = 0;
			for (int i = 0; i < count; i++) {
				listnew[j++] = cdList[i];
			}
			cdList = listnew;
		}
		cdList[count++] = a;
		return true;
	}

	public int soLuong() {
		return count;
	}

	public double tongGiaThanh() {
		double res = 0;
		for (int i = 0; i < count; i++) {
			res += cdList[i].getGia();
		}
		return res;
	}

	public String thongtin() {
		String s = String.format("%-20s | %-20s | %-20s | %-20s", "mã cd", "tên cd", "số lượng", "giá") + "\n";
		for (int i = 0; i < count; i++) {
			s += cdList[i].toString() + "\n";
		}
		return s;
	}

	public boolean timkiem(int macd) {
		for (int i = 0; i < count; i++) {
			if (cdList[i].getMaCD() == macd) {
				return true;
			}
		}
		return false;
	}

	public boolean sapxepgiamdan() {
		if (cdList == null)
			return false;
		for (int i = 1; i < count; i++) {
			int j = i;
			while (j > 0 && cdList[j].getGia() > cdList[j - 1].getGia()) {
				CD tmp = cdList[j];
				cdList[j] = cdList[j - 1];
				cdList[j - 1] = tmp;
				j--;
			}
		}
		return true;
	}

	public boolean sapxeptangdan() {
		if (cdList == null)
			return false;
		for (int i = 1; i < count; i++) {
			int j = i;
			while (j > 0 && (cdList[j].getCdName().compareToIgnoreCase(cdList[j - 1].getCdName())) < 0) {
				CD tmp = cdList[j];
				cdList[j] = cdList[j - 1];
				cdList[j - 1] = tmp;
				j--;
			}
		}
		return true;
	}

}
