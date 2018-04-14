package Test;

import java.security.PublicKey;
import java.util.ArrayList;


import src.Book;
import src.Libarry;

//subject : traning
// Email: ddang4@csc.com.vn// dang duyen
//use annamation import from lb jvm
// use JUnit

public class TestnumberBookinLby extends Libarry {
	protected final String result = "0";//fail

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//library co bao nhieu cuon sach, get so luong sach trong lb
		// defi: add
		// input : lb . out : so luong sach
		Libarry lb = new Book();
		lb.numberbook("sach1");
		lb.numberbook("sach1");
		lb.numberbook("sach1");
	//	lb.numberbook("sach1");
		
		int a = lb.counter();
		
		
		
		System.out.println("book number in Library: "+a);

	}
	
	public void ma(){};
	

}
