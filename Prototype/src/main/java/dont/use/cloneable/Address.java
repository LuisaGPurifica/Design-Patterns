package dont.use.cloneable;

import java.util.Arrays;

public class Address implements Cloneable {

	public String streetName;
	public int houseNumber;

	public Address(String streetName, int houseNumber) {
		this.streetName = streetName;
		this.houseNumber = houseNumber;
	}

	// Deep copy
	@Override
	public Object clone() throws CloneNotSupportedException {
		return new Address(streetName, houseNumber);
	}

	@Override
	public String toString() {
		return "Address [streetName=" + streetName + ", houseNumber=" + houseNumber + "]";
	}

}

class Person implements Cloneable {

	public String[] names;
	public Address address;

	public Person(String[] names, Address address) {
		this.names = names;
		this.address = address;
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		return new Person(names.clone(), (Address) address.clone());
	}

	@Override
	public String toString() {
		return "Person [names=" + Arrays.toString(names) + ", address=" + address + "]";
	}

}