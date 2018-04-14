package Sayhello;

import java.util.Random;

public class HelloWorld {
	public static AdapterCompany company = new AdapterCompany();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Hello World!");
		printSayhello();
		usesetgetter();
		Managerprint();
		usefor();
		useif();
		useString();

	}
	public  static void printSayhello(){
		
		company.printmessage();
	};
	public static void usesetgetter(){
		
		String message = "  Use setter getter";
		company.setMessage(message);
		
		// random manv
		Random rand = new Random();
		int Manv = rand.nextInt(50);
		company.setManv(Manv);
		
		//set phong ban
		String phongban = "  phong1";
		company.setPhongban(phongban);
		
		// set ten nhan vien
		String name = "hoangnam";
		company.setTennhanvien(name);
		
		
	};
	
	public static void Managerprint(){

		
		
		System.out.println("  Manhanvien: "+company.getManv()+ " - "+
		company.getTennhanvien()+" - "+company.getPhongban()+" - "+company.getMessage());
		
		
	};

	
	
	public static void usefor(){
		
		int sovonglap =5;
		for (int i = 0; i < sovonglap; i++) {
			usesetgetter();
			Managerprint();
			
			
		}
	};
	public static void useif(){
		
		
		int a;
		
		String solonhon3 = "This number more than 3";
		String sonhohon3 = "This number less  3";
		Random rd = new Random();
		  a = rd.nextInt(50);
		
		
		String b = a>3? solonhon3  :sonhohon3;
		System.out.println("This number is: "+ a+" compare with 3. " +b);
		
		
	};
	public static void useString(){
		StringBuffer s1 = new StringBuffer("print s1 using String Buffer");
		String s2 = new String("a");
		System.out.println(s1);
		
	};
}
