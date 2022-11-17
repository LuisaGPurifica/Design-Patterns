package property.proxy;

class Property<T> {
	private T value;

	public Property(T value) {
		this.setValue(value);
	}

	public T getValue() {
		return value;
	}

	public void setValue(T value) {
		this.value = value;
	}

	@Override
	public int hashCode() {
		return value != null ? value.hashCode() : 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null | getClass() != obj.getClass())
			return false;
		Property<?> property = (Property<?>) obj;

		return value != null ? value.equals(property.value) : property.value == null;
	}

}

class Creature {

	private Property<Integer> agility = new Property<>(10);

	public Creature() {
	}

	public int getAgility() {
		return agility.getValue();
	}

	public void setAgility(int value) {
		agility.setValue(value);
	}

}

public class Demo {

	public static void main(String[] args) {

		Creature creature = new Creature();
		System.out.println(creature.getAgility());

		creature.setAgility(20);

		System.out.println(creature.getAgility());

	}

}
