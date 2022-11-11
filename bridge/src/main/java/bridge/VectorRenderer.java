package bridge;

import com.google.inject.AbstractModule;
import com.google.inject.Inject;

public class VectorRenderer implements Renderer {

	public void renderCircle(float radius) {
		System.out.println("Drawing a circle of radius " + radius);
	}

}

class RasterRenderer implements Renderer {

	public void renderCircle(float radius) {
		System.out.println("Drawing pixels of a circle of radius " + radius);
	}

}

abstract class Shape {

	protected Renderer renderer;

	public Shape(Renderer renderer) {
		this.renderer = renderer;
	}

	public abstract void draw();

	public abstract void resize(float factor);

}

class Circle extends Shape {

	public float radius;

	@Inject
	public Circle(Renderer renderer) {
		super(renderer);
	}

	public Circle(Renderer renderer, float radius) {
		super(renderer);
		this.radius = radius;
	}

	@Override
	public void draw() {
		renderer.renderCircle(radius);
	}

	@Override
	public void resize(float factor) {
		radius *= factor;
	}

}

class ShapeModule extends AbstractModule {
	
	@Override
	protected void configure() {
		bind(Renderer.class).to(VectorRenderer.class);
	}
	
}

interface Renderer {
	void renderCircle(float radius);
}
