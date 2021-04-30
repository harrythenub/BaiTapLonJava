package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import connectDatabase.ConnectDatabase;
import entity.NhanVien;

public class NhanVienDAO {
	
	private Connection con;

	public NhanVienDAO() {
		try {
			con = ConnectDatabase.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public ArrayList<NhanVien> getEmployees() throws SQLException {
		ArrayList<NhanVien> emps = new ArrayList<>();

		Statement state = con.createStatement();

		ResultSet res = state.executeQuery("select * from NhanVien");

		while (res.next())
			emps.add(new NhanVien(res.getString(1), res.getString(2), res.getString(3), res.getDate(4),
					res.getString(5), res.getString(6), res.getString(7), res.getString(8)));

		return emps;
	}

	public NhanVien getEmployeeByID(String maNhanVien) throws SQLException {
		String query = "select * from NhanVien where maNhanVien = ?";

		NhanVien nv = null;

		PreparedStatement pState = con.prepareStatement(query);

		pState.setString(1, maNhanVien);

		ResultSet res = pState.executeQuery();

		while (res.next())
			nv = new NhanVien(res.getString(1), res.getString(2), res.getString(3), res.getDate(4), res.getString(5),
					res.getString(6), res.getString(7), res.getString(8));

		return nv;
	}

	public boolean addEmployee(NhanVien nv) throws SQLException {
		String query = "insert NhanVien values(?, ?, ?, ?, ?, ?, ?, ?)";
		
		PreparedStatement pState = con.prepareStatement(query);
		
		pState.setString(1, nv.getMaNhanVien());
		pState.setString(2, nv.getHoTen());
		pState.setString(3, nv.getGioiTinh());
		pState.setDate(4, nv.getNgaySinh());
		pState.setString(5, nv.getSoDT());
		pState.setString(6, nv.getDiaChi());
		pState.setString(7, nv.getMatKhau());
		pState.setString(8, nv.getQuyenTryCap());
		
		
		return pState.executeUpdate() > 0;
	}

	public boolean removeEmployeeByID(String maNhanVien) throws SQLException {
		String query = "delete NhanVien where maNhanVien = ?";
		
		PreparedStatement pState = con.prepareStatement(query);
		pState.setString(1, maNhanVien);
		
		return pState.executeUpdate() > 0;
	}
	
	public boolean updateEmployeeInfoByID(String maNhanVien, NhanVien nv) throws SQLException {
		
		String query = "update NhanVien " +
						"set hoTenNV = ?, gioiTinhNV = ?, ngaySinhNV = ?, soDienThoaiNV = ?," + 
						"diaChiNV = ?, matKhau = ?, quyenTruyCap = ? where maNhanVien = ?";
		
		PreparedStatement pState = con.prepareStatement(query);
		
		pState.setString(1, nv.getHoTen());
		pState.setString(2, nv.getGioiTinh());
		pState.setDate(3, nv.getNgaySinh());
		pState.setString(4, nv.getSoDT());
		pState.setString(5, nv.getDiaChi());
		pState.setString(6, nv.getMatKhau());
		pState.setString(7, nv.getQuyenTryCap());
		
		pState.setString(8, maNhanVien);
		
		return pState.executeUpdate() > 0;
	}
}