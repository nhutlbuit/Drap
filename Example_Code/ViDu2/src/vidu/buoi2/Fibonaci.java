package vidu.buoi2;

public class Fibonaci {

	public static int getNumofIndexN(int n) {
		int counter = 2;
		int pre=1;
		int pos=1;
		int x = 0;
		if (n == 1 || n == 2) {
			x = 1;
		} else {
			if (n > 2) {
				while(counter!=n)
				{
					int tem=pos;
					pos=pre+pos;
					pre=tem;
					counter++;
					x=pos;
				}
			}
		}

		return x;
	}
	//xuoi
	public static int getNumofIndexN_DQ(int n, int prevl,int posvl, int index) {
		if (n >= 1) {
			if (index == n+1) {
				return posvl;
			}
			if (index == 1 || index == 2) {
				index++;
				return getNumofIndexN_DQ(n,1,1,index);
			} else {
				 int newposvl = prevl+posvl;
				prevl =posvl;
				index++;
				return getNumofIndexN_DQ(n, prevl,newposvl,index);
			}
		}
		return 0;
	}
	//nguoc
	public static int getNumofIndexN_DQ2(int n) {
		if (n >= 1) {
			
			if (n == 1 || n == 2) {
			return 1;
			} else {
				return getNumofIndexN_DQ2(n-1)+getNumofIndexN_DQ2(n-2);
			}
		}
		return 0;
	}
	
	public static void main(String[] args) {
		System.out.println(getNumofIndexN_DQ2(3));
		System.out.println(getNumofIndexN(3));
	}
}
