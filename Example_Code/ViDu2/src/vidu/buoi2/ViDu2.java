package vidu.buoi2;

import java.util.Scanner;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import vidu.buoi2.PhuongTrinhBac2.Status;

public class ViDu2 {

	public static void main(String[] str) {
		//TestIO();
		//testReadData();
	/*	int []ax = new int[2];
		 ax[0] = 0;
		 ax[1] = 0;
		 System.out.println(ax[0]+" "+ax[1]);
		 test(ax);
		 System.out.println(ax[0]+" "+ax[1]);
		Scanner scan = new Scanner(System.in);
		double a = scan.nextInt();
		double b = scan.nextInt();
		double c = scan.nextInt();
		PhuongTrinhBac2 pt = new PhuongTrinhBac2(a, b, c);
		pt.bai6();
		System.out.println("===============================");
		if (pt.getFlag() == Status.MANY_SOLUTION) {
			System.out.println("PT vo so nghiem");
		}
		if (pt.getFlag() == Status.NO_SOLUTION) {
			System.out.println("PT vo nghiem");
		}
		if (pt.getFlag() == Status.ONE_SOLUTION) {
			System.out.println("PT co 1 nghiem: x= " + pt.getX1());
		}
		if (pt.getFlag() == Status.TWO_SOLUTION) {
			System.out.println("Phuong trinh co 2 nghiem:");
			System.out.println("x1= " + pt.getX1());
			System.out.println("x2= " + pt.getX2());
		}

		PhuongTrinhBac2 pt2 = new PhuongTrinhBac2(1, 2, 3);
*/
		List<PhuongTrinhBac2> l = new ArrayList<PhuongTrinhBac2>();
		for(int i=0;i<4;i++)
		{
			l.add(new PhuongTrinhBac2(i,i,i));
		}
		Collections.sort(l);
		for(int i=0;i<4;i++)
		{
			System.out.println(l.get(i).getA());
		}
		/*if (pt.compareTo(pt2) == 1) {
			System.out.println("==================");
			System.out.println("Lon Hon");
		} else if (pt.compareTo(pt2) == 2) {
			System.out.println("==================");
			System.out.println("Bang");
		} else {
			System.out.println("==================");
			System.out.println("Nho Hon");
		}*/
	}

	static void test(int[]c)
	{
		c[0]=2;
		int[]b= new int[2];
		b[0]=3;
		b[1]=3;
		c=b;
	}
	
	static void TestIO() {
		int a = 9;
		float b = 0.9f;
		byte[] arr = new byte[9];
		DataOutputStream ds;
		FileOutputStream fo = null;
		try {
			File file = new File("D:\\data\\test.dat");
			fo = new FileOutputStream(file);
			ds = new DataOutputStream(fo);
			ds.writeInt(a);
			ds.writeFloat(b);
			ds.write(arr, 0, arr.length);
			// cho stream ve het
			ds.flush();
			
		} catch (Exception e) {
		}
		finally{
			try {
				if (fo != null) {
					fo.close();
				}
			} catch (IOException ex) {

			}
		}
	}
	
	static void testReadData()
	{
		FileInputStream in = null;
		DataInputStream ds;
		File file = new File("D:\\data\\test.dat");
		try {
			in = new FileInputStream(file);
			ds = new DataInputStream(in);
			
			byte[] arr = new byte[9];
			
				
				int a = ds.readInt();
				float b = ds.readFloat();
				ds.read(arr,0,9);
				System.out.println(a+" "+b+"; ");
				for(int i=0;i<arr.length;i++)
				{
					System.out.println(arr[i]);
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				try {
					if (in != null) {
						in.close();
					}
				} catch (IOException ex) {

				}
			}
		
		
	}
}
