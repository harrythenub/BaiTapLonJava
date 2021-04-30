package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import connectDatabase.ConnectDatabase;
import entity.LinhKien;

public class LinhKienDAO {

	private Connection con;
	
	public LinhKienDAO() {
		try {
			con = ConnectDatabase.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public ArrayList<LinhKien> getComponents() throws SQLException {
		ArrayList<LinhKien> lks = new ArrayList<>();
		
		String query = "Select * from LinhKien";
		
		ResultSet res = con.createStatement().executeQuery(query);
		
		while(res.next())
			lks.add(new LinhKien(res.getString(1), res.getString(2), res.getString(3), res.getString(4), res.getDouble(5), res.getString(6),
					res.getInt(7), res.getDate(8), res.getInt(9)));
		
		return lks;
	}
	
	public LinhKien getComponentByID(String maLK) throws SQLException {
		LinhKien lk = null;
		
		String query = "Select * from LinhKien where maLinhKien = ?";
		
		PreparedStatement pState = con.prepareStatement(query);
		
		pState.setString(1, maLK);
		
		ResultSet res = pState.executeQuery();
		
		while(res.next())
			lk = new LinhKien(res.getString(1), res.getString(2), res.getString(3), res.getString(4), res.getDouble(5), res.getString(6),
					res.getInt(7), res.getDate(8), res.getInt(9));
		
		return lk;
	}
	
	public boolean addComponent(LinhKien lk) throws SQLException {
		String query = "insert LinhKien values(?, ?, ?, ?, ,? ,? ,? ,? ,?)";
		
		PreparedStatement pState = con.prepareStatement(query);
		
		pState.setString(1, lk.getMaLK());
		pState.setString(2, lk.getTenLk());
		pState.setString(3, lk.getLoaiLK());
		pState.setString(4, lk.getMoTa());
		pState.setDouble(5, lk.getDonGia());
		pState.setString(6, lk.getThuongHieu());
		pState.setInt(7, lk.getSoLuongTon());
		pState.setDate(8, lk.getNgayNhap());
		pState.setInt(9, lk.getBaoHanh());
		
		return pState.executeUpdate() > 0;
	}
	
	public boolean removeComponentByID(String maLK) throws SQLException {
		
		String query = "delete LinhKien where maLinhKien = ?";
		PreparedStatement pState = con.prepareStatement(query);
		
		pState.setString(1, maLK);
		
		return pState.executeUpdate() > 0;
	}

	public boolean updateComponentByID(String maLK, LinhKien lk) throws SQLException{
		String query = "update LinhKien set tenLinhKien = ?, loaiLinhKien = ?, moTa = ?, donGia = ?,"
				+ ", thuongHieu = ?, soLuongTon = ?, ngayNhap = ?, baoHanh = ? where maLinhKien = ?";
		
		PreparedStatement pState = con.prepareStatement(query);
		
		pState.setString(1, lk.getTenLk());
		pState.setString(2, lk.getLoaiLK());
		pState.setString(3, lk.getMoTa());
		pState.setDouble(4, lk.getDonGia());
		pState.setString(5, lk.getThuongHieu());
		pState.setInt(6, lk.getSoLuongTon());
		pState.setDate(7, lk.getNgayNhap());
		pState.setInt(8, lk.getBaoHanh());
		
		pState.setString(9, maLK);
		
		return pState.executeUpdate() > 0;
	}
	
	public static void main(String[] args) {
		
		LinhKienDAO dao = new LinhKienDAO();
		
		try {
//			ArrayList<LinhKien> lks = dao.getComponents();
//			
//			for(LinhKien lk : lks)
//				System.out.println(lk);
			
			System.out.println(dao.getComponentByID("LK000001"));
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}