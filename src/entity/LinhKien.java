package entity;

import java.sql.Date;

public class LinhKien {
	private String maLK;
	private String tenLk;
	private String loaiLK;
	private String moTa;
	private double donGia;
	private String thuongHieu;
	private int soLuongTon;
	private Date ngayNhap;
	private int baoHanh;

	public LinhKien() {
		super();
	}

	public LinhKien(String maLK, String tenLk, String loaiLK, String moTa, double donGia, String thuongHieu,
			int soLuongTon, Date ngayNhap, int baoHanh) {
		super();
		this.maLK = maLK;
		this.tenLk = tenLk;
		this.loaiLK = loaiLK;
		this.moTa = moTa;
		this.donGia = donGia;
		this.thuongHieu = thuongHieu;
		this.soLuongTon = soLuongTon;
		this.ngayNhap = ngayNhap;
		this.baoHanh = baoHanh;
	}

	public String getMaLK() {
		return maLK;
	}

	public void setMaLK(String maLK) {
		this.maLK = maLK;
	}

	public String getTenLk() {
		return tenLk;
	}

	public void setTenLk(String tenLk) {
		this.tenLk = tenLk;
	}

	public String getLoaiLK() {
		return loaiLK;
	}

	public void setLoaiLK(String loaiLK) {
		this.loaiLK = loaiLK;
	}

	public String getMoTa() {
		return moTa;
	}

	public void setMoTa(String moTa) {
		this.moTa = moTa;
	}

	public double getDonGia() {
		return donGia;
	}

	public void setDonGia(double donGia) {
		this.donGia = donGia;
	}

	public String getThuongHieu() {
		return thuongHieu;
	}

	public void setThuongHieu(String thuongHieu) {
		this.thuongHieu = thuongHieu;
	}

	public int getSoLuongTon() {
		return soLuongTon;
	}

	public void setSoLuongTon(int soLuongTon) {
		this.soLuongTon = soLuongTon;
	}

	public Date getNgayNhap() {
		return ngayNhap;
	}

	public void setNgayNhap(Date ngayNhap) {
		this.ngayNhap = ngayNhap;
	}

	public int getBaoHanh() {
		return baoHanh;
	}

	public void setBaoHanh(int baoHanh) {
		this.baoHanh = baoHanh;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((maLK == null) ? 0 : maLK.hashCode());
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
		LinhKien other = (LinhKien) obj;
		if (maLK == null) {
			if (other.maLK != null)
				return false;
		} else if (!maLK.equals(other.maLK))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "LinhKien [maLK=" + maLK + ", tenLk=" + tenLk + ", loaiLK=" + loaiLK + ", moTa=" + moTa + ", donGia="
				+ donGia + ", thuongHieu=" + thuongHieu + ", soLuongTon=" + soLuongTon + ", ngayNhap=" + ngayNhap
				+ ", baoHanh=" + baoHanh + "]";
	}

}