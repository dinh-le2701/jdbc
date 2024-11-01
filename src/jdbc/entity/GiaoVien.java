package jdbc.entity;

public class GiaoVien {
	private String maGV;
	private String tenGV;
	public String getMaGV() {
		return maGV;
	}
	public void setMaGV(String maGV) {
		this.maGV = maGV;
	}
	public String getTenGV() {
		return tenGV;
	}
	public void setTenGV(String tenGV) {
		this.tenGV = tenGV;
	}
	public GiaoVien() {
		super();
		// TODO Auto-generated constructor stub
	}
	public GiaoVien(String maGV, String tenGV) {
		super();
		this.maGV = maGV;
		this.tenGV = tenGV;
	}
	
	
}
