
public class test {
	public static double triangleArea(double a, double b) {
		if(b == 0) {
			return -1.0;
		}else {
			double z = a / b;
			//小数第2位から四捨五入する
			double truth = (double) Math.round(z * 10) / 10;
			return truth;
		}

	}
	public static void main(String[] args) {
	double a = 5.0;
	double b = 0.0;
	double c = triangleArea(a,b);
	System.out.println(c);


	}
}
