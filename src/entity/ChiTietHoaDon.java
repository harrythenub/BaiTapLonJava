package entity;

public class ChiTietHoaDon {
	private HoaDon maHoaDon;
	private LinhKien maLinhKien;
	private int soLuong;

	public ChiTietHoaDon() {
	}

	public ChiTietHoaDon(HoaDon maHoaDon, LinhKien maLinhKien, int soLuong) {
		this.maHoaDon = maHoaDon;
		this.maLinhKien = maLinhKien;
		this.soLuong = soLuong;
	}

	public HoaDon getMaHoaDon() {
		return maHoaDon;
	}

	public void setMaHoaDon(HoaDon maHoaDon) {
		this.maHoaDon = maHoaDon;
	}

	public LinhKien getMaLinhKien() {
		return maLinhKien;
	}

	public void setMaLinhKien(LinhKien maLinhKien) {
		this.maLinhKien = maLinhKien;
	}

	public int getSoLuong() {
		return soLuong;
	}

	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((maHoaDon == null) ? 0 : maHoaDon.hashCode());
		result = prime * result + ((maLinhKien == null) ? 0 : maLinhKien.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ChiTietHoaDon other = (ChiTietHoaDon) obj;
		if (maHoaDon == null) {
			if (other.maHoaDon != null)
				return false;
		} else if (!maHoaDon.equals(other.maHoaDon))
			return false;
		if (maLinhKien == null) {
			if (other.maLinhKien != null)
				return false;
		} else if (!maLinhKien.equals(other.maLinhKien))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ChiTietHoaDon [maHoaDon=" + maHoaDon + ", maLinhKien=" + maLinhKien + ", soLuong=" + soLuong + "]";
	}

}