package jdbc.entity;

public class LopHoc {
	private String maLop;
	private String tenLop;
	private GiaoVien giaoVien;
	private int siso;
	public String getMaLop() {
		return maLop;
	}
	public void setMaLop(String maLop) {
		this.maLop = maLop;
	}
	public String getTenLop() {
		return tenLop;
	}
	public void setTenLop(String tenLop) {
		this.tenLop = tenLop;
	}
	public GiaoVien getGiaoVien() {
		return giaoVien;
	}
	public void setGiaoVien(GiaoVien giaoVien) {
		this.giaoVien = giaoVien;
	}
	public int getSiso() {
		return siso;
	}
	public void setSiso(int siso) {
		this.siso = siso;
	}
	public LopHoc() {
		super();
		// TODO Auto-generated constructor stub
	}
	public LopHoc(String maLop, String tenLop, GiaoVien giaoVien, int siso) {
		super();
		this.maLop = maLop;
		this.tenLop = tenLop;
		this.giaoVien = giaoVien;
		this.siso = siso;
	}
	
	
	
}
