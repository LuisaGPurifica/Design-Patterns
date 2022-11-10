package factory;
/* THIS IS NOT THE RIGHT WAY
enum CoordinateSystem {
	CARTESIAN, POLAR
}

class Point {

	private double x, y;

	private Point(double a, double b, CoordinateSystem cs) {
		switch (cs) {
		case CARTESIAN:
			this.x = a;
			this.y = b;
			break;

		case POLAR:
			x = a * Math.cos(b);
			y = a * Math.sin(b);
			break;

		default:
			throw new IllegalArgumentException("Unexpected value: " + cs);
		}
	}
*/

// Aplicando o design pattern da factory
class Point {

	private double x, y;

	private Point(double x, double y) {
		this.x = x;
		this.y = y;
	}

	public static class Factory {
		public static Point newCartesianPoint(double x, double y) {
			return new Point(x, y);
		}

		public static Point newPolarPoint(double rho, double theta) {
			return new Point(rho * Math.cos(theta), rho * Math.sin(theta));
		}

	}

}

class Demo {
	public static void main(String[] args) {

		Point point = Point.Factory.newPolarPoint(2, 3);
		
		
	}
}