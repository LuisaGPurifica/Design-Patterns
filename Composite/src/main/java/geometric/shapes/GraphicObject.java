package geometric.shapes;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GraphicObject {

	protected String name = "Group";
	public String color;
	public List<GraphicObject> children = new ArrayList<>();

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		print(sb, 0);
		return sb.toString();
	}

	private void print(StringBuilder stringBuilder, int depth) {
		stringBuilder.append(String.join("", Collections.nCopies(depth, "*"))).append(depth > 0 ? " " : "")
				.append((color == null || color.isEmpty()) ? "" : color + " ").append(getName())
				.append(System.lineSeparator());
		for (GraphicObject child : children)
			child.print(stringBuilder, depth + 1);
	}

	public GraphicObject() {
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}

class Circle extends GraphicObject {

	public Circle(String color) {
		name = "Circle";
		this.color = color;
	}

}

class Square extends GraphicObject {

	public Square(String color) {
		name = "Square";
		this.color = color;
	}

}