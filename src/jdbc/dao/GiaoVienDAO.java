package jdbc.dao;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import jdbc.dbconnect.DatabaseConnection;
import jdbc.entity.GiaoVien;

public class GiaoVienDAO {
	List<GiaoVien> dsgv;
	
	public GiaoVienDAO() {
		dsgv = new ArrayList<GiaoVien>();
	}
	
	public List<GiaoVien> loadtable(){
		try {
			Connection con = DatabaseConnection.getConnection();
			String sql =  "SELECT * FROM GIAOVIEN";
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			while (rs.next()) {
				String ma = rs.getString("maGV");
				String ten = rs.getString(2);
				
				GiaoVien gv = new GiaoVien(ma, ten);
				dsgv.add(gv);
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return dsgv;
	}
}
