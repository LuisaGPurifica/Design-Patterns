package principle.liskov.substitution;

/**
 * Let Φ(x) be a property provable about objects x of type T. Then Φ(y) should
 * be true for objects y of type S where S is a subtype of T.
 * 
 * When an instance of a class is passed/extended to another class, the
 * inheriting class should have a use case for all the properties and behavior
 * of the inherited class.
 */
public class Rectangle {

	protected int width, height;

	public Rectangle() {
	}

	public Rectangle(int width, int height) {
		this.width = width;
		this.height = height;
	}

	public int getArea() {
		return width * height;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	@Override
	public String toString() {
		return "Rectangle [width=" + width + ", height=" + height + "]";
	}

	public boolean isSquare() {
		return width == height;
	}

}

class Square extends Rectangle {

	public Square() {
	}

	public Square(int size) {
		width = height = size;
	}

	@Override
	public void setWidth(int width) {
		super.setWidth(width);
		super.setHeight(width);
	}

	@Override
	public void setHeight(int height) {
		super.setWidth(height);
		super.setHeight(height);
	}

}

class RectangleFactory {
	public static Rectangle newRectangle(int width, int height) {
		return new Rectangle(width, height);
	}

	public static Rectangle newSquare(int side) {
		return new Rectangle(side, side);
	}
}

class Demo {
	/**
	 * You have to make sure the method that receives the parent class works for the
	 * child classes too
	 * 
	 * @param r
	 */
	public static void useIt(Rectangle r) {

		int width = r.getWidth();
		r.setHeight(10);

		System.out.println("Expected area of " + (width * 10) + ", got " + r.getArea());

	}

	public static void main(String[] args) {

		Rectangle rc = new Rectangle(2, 3);
		useIt(rc);

		Rectangle sq = new Square();
		sq.setWidth(5);
		useIt(sq);

	}
}
