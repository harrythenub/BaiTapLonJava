package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import connectDatabase.ConnectDatabase;

public class HoaDonDAO {

	private Connection con;
	
	public HoaDonDAO() {
		try {
			con = ConnectDatabase.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public Double getTotalUnitPriceByDay(int day) throws SQLException {
		
		String query = "select h.maHoaDon, sum(ct.soLuong*lk.donGia) from HoaDon as h join ChiTietHoaDon as ct"
				+ "	on h.maHoaDon = ct.maHoaDon join LinhKien as lk on lk.maLinhKien = ct.maLinhKien"
				+ "	where day(h.ngayLapHoaDon) = ?"
				+ "	group by h.maHoaDon";
		
		double totalPrice = 0;
		
		PreparedStatement pState = con.prepareStatement(query);
		
		pState.setInt(1,day);
		
		ResultSet res = pState.executeQuery();
		
		while(res.next())
			totalPrice += res.getDouble(2);
		
		return totalPrice;
	}
	
public Double getTotalUnitPriceByYear(int year) throws SQLException {
		
		String query = "select h.maHoaDon, sum(ct.soLuong*lk.donGia) from HoaDon as h join ChiTietHoaDon as ct"
				+ "	on h.maHoaDon = ct.maHoaDon join LinhKien as lk on lk.maLinhKien = ct.maLinhKien"
				+ "	where year(h.ngayLapHoaDon) = ?"
				+ "	group by h.maHoaDon";
		
		double totalPrice = 0;
		
		PreparedStatement pState = con.prepareStatement(query);
		
		pState.setInt(1, year);
		
		ResultSet res = pState.executeQuery();
		
		while(res.next())
			totalPrice += res.getDouble(2);
		
		return totalPrice;
	}
	
}