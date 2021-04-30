package entity;

import java.sql.Date;

public class NhanVien {
	
	private String maNhanVien;
	private String hoTen;
	private String gioiTinh;
	private Date ngaySinh;
	private String soDT;
	private String diaChi;
	private String matKhau;
	private String quyenTryCap;

	public NhanVien() {
	}

	public NhanVien(String maNhanVien, String hoTen, String gioiTinh, Date ngaySinh, String soDT, String diaChi,
			String matKhau, String quyenTryCap) {
		this.maNhanVien = maNhanVien;
		this.hoTen = hoTen;
		this.gioiTinh = gioiTinh;
		this.ngaySinh = ngaySinh;
		this.soDT = soDT;
		this.diaChi = diaChi;
		this.matKhau = matKhau;
		this.quyenTryCap = quyenTryCap;
	}
	
	

	public NhanVien(String maNhanVien) {
		super();
		this.maNhanVien = maNhanVien;
	}

	public String getMaNhanVien() {
		return maNhanVien;
	}

	public void setMaNhanVien(String maNhanVien) {
		this.maNhanVien = maNhanVien;
	}

	public String getHoTen() {
		return hoTen;
	}

	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}

	public String getGioiTinh() {
		return gioiTinh;
	}

	public void setGioiTinh(String gioiTinh) {
		this.gioiTinh = gioiTinh;
	}

	public Date getNgaySinh() {
		return ngaySinh;
	}

	public void setNgaySinh(Date ngaySinh) {
		this.ngaySinh = ngaySinh;
	}

	public String getSoDT() {
		return soDT;
	}

	public void setSoDT(String soDT) {
		this.soDT = soDT;
	}

	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}

	public String getMatKhau() {
		return matKhau;
	}

	public void setMatKhau(String matKhau) {
		this.matKhau = matKhau;
	}

	public String getQuyenTryCap() {
		return quyenTryCap;
	}

	public void setQuyenTryCap(String quyenTryCap) {
		this.quyenTryCap = quyenTryCap;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((maNhanVien == null) ? 0 : maNhanVien.hashCode());
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
		NhanVien other = (NhanVien) obj;
		if (maNhanVien == null) {
			if (other.maNhanVien != null)
				return false;
		} else if (!maNhanVien.equals(other.maNhanVien))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "NhanVien [maNhanVien=" + maNhanVien + ", hoTen=" + hoTen + ", gioiTinh=" + gioiTinh + ", ngaySinh="
				+ ngaySinh + ", soDT=" + soDT + ", diaChi=" + diaChi + ", matKhau=" + matKhau + ", quyenTryCap="
				+ quyenTryCap + "]";
	}

}