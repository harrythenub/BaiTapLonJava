package entity;

public class KhachHang {
	private String maKH;
	private String hoTen;
	private String soDT;
	private String diaChi;

	public KhachHang() {
	}

	public KhachHang(String maKH, String hoTen, String soDT, String diaChi) {
		this.maKH = maKH;
		this.hoTen = hoTen;
		this.soDT = soDT;
		this.diaChi = diaChi;
	}

	public KhachHang(String maKH) {
		super();
		this.maKH = maKH;
	}

	public String getMaKH() {
		return maKH;
	}

	public void setMaKH(String maKH) {
		this.maKH = maKH;
	}

	public String getHoTen() {
		return hoTen;
	}

	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}

	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}

	public String getSoDT() {
		return soDT;
	}

	public void setSoDT(String soDT) {
		this.soDT = soDT;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((maKH == null) ? 0 : maKH.hashCode());
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
		KhachHang other = (KhachHang) obj;
		if (maKH == null) {
			if (other.maKH != null)
				return false;
		} else if (!maKH.equals(other.maKH))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "KhachHang [maKH=" + maKH + ", hoTen=" + hoTen + ", soDT=" + soDT + ", diaChi=" + diaChi + "]";
	}

}