package Sayhello;

public class AdapterCompany {
	String message;
	String tennhanvien;
	String phongban;
	double manv;
	
	
	public double getManv() {
		return manv;
	}
	public void setManv(double manv) {
		this.manv = manv;
	}
	public String getTennhanvien() {
		return tennhanvien;
	}
	public void setTennhanvien(String tennhanvien) {
		this.tennhanvien = tennhanvien;
	}
	public String getPhongban() {
		return phongban;
	}
	public void setPhongban(String phongban) {
		this.phongban = phongban;
	}
	public AdapterCompany(){
		message = "say hello";
		
	};
	public void printmessage(){
		System.out.println(message);
		
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	};
	

}
