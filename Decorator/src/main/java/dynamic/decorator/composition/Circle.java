package dynamic.decorator.composition;

import java.util.function.Supplier;

public class Circle implements Shape {

	private float radius;

	public Circle() {
	}

	public Circle(float radius) {
		this.radius = radius;
	}

	void resize(float factor) {
		radius *= factor;
	}

	@Override
	public String info() {
		return "A circle of radius " + radius;
	}

}

class Square implements Shape {

	private float side;

	public Square() {
	}

	public Square(float side) {
		this.side = side;
	}

	@Override
	public String info() {
		return "A square of side " + side;
	}

}

//we are NOT altering the base class of these objects
//cannot make ColoredSquare, ColoredCircle

class ColoredShape<T extends Shape> implements Shape {

	private Shape shape;
	private String color;

	public ColoredShape(Supplier<? extends T> ctor, String color) {
		shape = ctor.get();
		this.color = color;
	}

	@Override
	public String info() {
		return shape.info() + " has the color " + color;
	}

}

class TransparentShape<T extends Shape> implements Shape {

	private Shape shape;
	private int transparency;

	public TransparentShape(Supplier<? extends T> ctor, int transparency) {
		shape = ctor.get();
		this.transparency = transparency;
	}

	@Override
	public String info() {
		return shape.info() + " has " + transparency + "% transparency";
	}

}

interface Shape {
	String info();
}
