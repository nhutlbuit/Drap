package vidu.buoi2;

public class PhuongTrinhBac2 implements Comparable<PhuongTrinhBac2> {
	private double a, b, c;
	private double x1, x2;
	private Status flag;

	public static enum Status {
		ONE_SOLUTION, TWO_SOLUTION, MANY_SOLUTION, NO_SOLUTION
	}

	public PhuongTrinhBac2() {
	}

	public PhuongTrinhBac2(double a, double b, double c) {
		this.a = a;
		this.b = b;
		this.c = c;

	}

	public void bai6() {
		double delta = b * b - 4 * a * c;
		// System.out.println(delta);

		if (a != 0) {
			if (delta < 0) {
				flag= Status.NO_SOLUTION;
			} else {
				if (delta == 0) {
					flag = Status.ONE_SOLUTION;

					x1 = x2 = (-b / (2 * a));
				}
				if (delta > 0) {
					flag = Status.TWO_SOLUTION;

					x1 = (double) (-b + Math.sqrt(delta)) / (2 * a);

					x2 = (double) (-b - Math.sqrt(delta)) / (2 * a);
				}
				// return;
			}

		} else {
			if (b == 0) {
				if (c == 0) {
					flag = Status.MANY_SOLUTION;

				} else {
					flag = Status.NO_SOLUTION;

				}

			} else {
				flag = Status.ONE_SOLUTION;

				x1 = x2 = (-c / b);
			}
		}

	}


	public double getX1() {
		return x1;
	}

	public void setX1(double x1) {
		this.x1 = x1;
	}

	public double getX2() {
		return x2;
	}

	public void setX2(double x2) {
		this.x2 = x2;
	}

	public Status getFlag() {
		return flag;
	}

	public void setFlag(Status flag) {
		this.flag = flag;
	}

	@Override
	public int compareTo(PhuongTrinhBac2 pt2) {
		if(a==pt2.a && b==pt2.b && c==pt2.c)
		{
			return 0;
		}
		if(a>pt2.a)
		{
			return 1;
		}else{
			if(a==pt2.a)
			{
				if(b>pt2.b)
				{
					return 1;
				}
				if(b==pt2.b)
				{
					if(c>pt2.c)
					{
						return 1;
					} else{
						return -1;
						}
				}
				else{
					return -1;
					}
			}else{
				return -1;
				}
		}
	}

	public double getA() {
		return a;
	}

	public void setA(double a) {
		this.a = a;
	}

	public double getB() {
		return b;
	}

	public void setB(double b) {
		this.b = b;
	}

	public double getC() {
		return c;
	}

	public void setC(double c) {
		this.c = c;
	}

	
	
}
