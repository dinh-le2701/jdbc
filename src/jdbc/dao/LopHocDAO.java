package jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import jdbc.dbconnect.DatabaseConnection;
import jdbc.entity.GiaoVien;
import jdbc.entity.LopHoc;

public class LopHocDAO {
	ArrayList<LopHoc> dslh;
	LopHoc lh;

	public LopHocDAO() {
		dslh = new ArrayList<LopHoc>();
	}

	public List<LopHoc> loadtable() {
		try {
			Connection con = DatabaseConnection.getConnection();
			String sql = "SELECT * FROM LOPHOC";
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			while (rs.next()) {
				String ma = rs.getString(1);
				String ten = rs.getString(2);
				String gv = rs.getString(3);
				int siso = rs.getInt(4);

				LopHoc lh = new LopHoc(ma, ten, new GiaoVien(gv), siso);
				dslh.add(lh);
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		return dslh;
	}
	
	
	public ArrayList<LopHoc> getLopHocTheoMa(String maLop){
		Connection con = DatabaseConnection.getInstance().getConnection();
		PreparedStatement ps = null;
		
		try {
			String sql = "SELECT * FROM LOPHOC";
			ps =con.prepareStatement(sql);
			ps.setString(1, maLop);
			
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				String ma = rs.getString(1);
				String ten = rs.getString(2);
				String gv = rs.getString(3);
				int siso = rs.getInt(4);

				LopHoc lh = new LopHoc(ma, ten, new GiaoVien(gv), siso);
				dslh.add(lh);
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return dslh;
	}
	
	
	public boolean create(LopHoc lh) {
		Connection con = DatabaseConnection.getInstance().getConnection();
		PreparedStatement ps = null;
		
		int n = 0;
		try {
			ps = con.prepareStatement("insert into LOPHOC values (?, ?, ?, ?)");
			ps.setString(1, lh.getMaLop());
			ps.setString(2, lh.getTenLop());
			ps.setString(3, lh.getGiaoVien().getMaGV());
			ps.setInt(4, lh.getSiso());
			
			n = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return n > 0;
	}
	
	public boolean update(LopHoc lh) {
		Connection con = DatabaseConnection.getInstance().getConnection();
		PreparedStatement ps = null;
		
		int n = 0;
		try {
			ps = con.prepareStatement("update LOPHOC set tenLop = ?, maGV = ?, siSo = ? where maLop = ?");
			ps.setString(1, lh.getTenLop());
			ps.setString(2, lh.getGiaoVien().getMaGV());
			ps.setInt(3, lh.getSiso());
			ps.setString(4,  lh.getMaLop());
			
			n = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return n > 0;
	}
	
	public boolean delete(String maLop) {
		Connection con = DatabaseConnection.getInstance().getConnection();
		PreparedStatement ps = null;
		
		int n = 0;
		try {
			ps = con.prepareStatement("delete from LOPHOC where maLop = ?");
			ps.setString(1, lh.getMaLop());
			
			n = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return n > 0;
	}
	
	
	
	
	
	
	
	
	
}
