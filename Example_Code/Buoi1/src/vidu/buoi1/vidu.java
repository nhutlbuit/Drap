package vidu.buoi1;

import java.util.Scanner;

public class vidu {

	
	public static void main(String [] args)
	{
		
		Scanner scan=new Scanner(System.in);
		int a=scan.nextInt();
		int b=scan.nextInt();
		int c=scan.nextInt();
		
		System.out.println("bai1:"+ TinhTong(a));
		System.out.println(Bai2(a));
		bai3(a, b, c);
		String str = scan.nextLine();
		System.out.println(Bai4(str));
		bai6(a,b,c);
		
		
	}
	
	public static int TinhTong(int n)
	{
		int tong = 0;
		if(n<500){
			for(int i=1; i<=n;i++) {
				tong= tong +i;
			}
		}
		return tong;
	}
	public static int TinhTong2(int n)
	{
		int tong = 0;
		int i=1;
		if(n<500){
			while(i<=n)
			{
				tong = tong +i;
				i++;
			}
		}
		return tong;
	}
	
	public static int TinhTong3(int n)
	{
		int tong = 0;
		int i=1;
		if(n<500){
			do{
				tong = tong +i;
				++i;
			} while(i<=n);
		}
		return tong;
	}
	
	public static double Bai2(int a)
	{
		double tong=1;
		if(a==0){
			tong = 0;
		}else{
			if(a==1) {
				tong=1;
			}else{
				for(int i=2;i<=a;i++){
					System.out.println(tong);
					tong+=TinhTong12(i);
				}
			}
		}
		return tong;
	}
	public static double TinhTong12(int x)
	{
		double tong=0.0;
		if(x%2==0)
		{
			tong = 1.0/((-x));
		}else{
			tong = 1.0/(x);
		}
		
		return tong;
	}
	public static void bai3(int a, int b, int c)
	{
		int max=0;
		int min=0;
		max = getMax(a, b);
		max = getMax(max, c);
		min = getMin(a, b);
		min =  getMin(min, c);
		System.out.println("min= "+min+" Max= "+max);	
	}
	
	
	public static int getMax(int a, int b)
	{
		if(a<=b)
		{
			return b;
		}
		return a;
	}
	
	public static int getMin(int a, int b)
	{
		if(a<=b)
		{
			return a;
		}
		return b;
	}


	public static int Bai4(String str)
	{
		int numA =0;
		for(int i=0;i<str.length();i++)
		{
			if(String.valueOf(str.charAt(i)).toUpperCase().equals("A"))
			{
				numA++;
			}
		}
		return numA;
	}
	
	//giai phuong trinh
	// ax^2 + bx +c =0
	public static void bai6(int a, int b, int c)
	{
		int delta = b*b -4*a*c;
		System.out.println(delta);
		if(a!=0)
		{
			if (delta < 0) {
				System.out.println("Phuong trinh Vo nghiem");
			} else {
				if (delta == 0) {
					System.out.println("Phuong trinh co 1 nghiem: x= " + (-b / (2 * a)));
				}
				if (delta > 0) {
					System.out.println("Phuong trinh co 2 nghiem:");
					System.out.println("x1= " + (int) (-b + Math.sqrt(delta)) / (2 * a));
					System.out.println("x2= " + (int) (-b - Math.sqrt(delta)) / (2 * a));
				}
				// return;
			}

		}else{
			System.out.println(" he so cua X^2 phai khac khong");
		}
	}

}


