package vector.raster;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Demo {

	private final static List<VectorRectangle> vectorObjects = new ArrayList<>(
			Arrays.asList(new VectorRectangle(1, 1, 10, 10), new VectorRectangle(3, 3, 6, 6)));

	public static void drawPoint(Point p) {
		System.out.println(".");
	}

	private static void draw() {
		for (VectorRectangle vr : vectorObjects) {
			for (Line line : vr) {
				LineToPointAdapter adapter = new LineToPointAdapter(line);
				adapter.forEach(Demo::drawPoint);
			}
		}
	}

	public static void main(String[] args) {
		draw();
	}

}
