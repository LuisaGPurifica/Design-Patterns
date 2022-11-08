package faceted.builder;

public class Person {

	// address
	public String streetAddress, postcode, city;

	// employment
	public String companyName, position;
	public int annualIncome;

	@Override
	public String toString() {
		return "Person [streetAddress=" + streetAddress + ", postcode=" + postcode + ", city=" + city + ", companyName="
				+ companyName + ", position=" + position + ", annualIncome=" + annualIncome + "]";
	}

}

// Builder Facade
class PersonBuilder {

	protected Person person = new Person();

	public PersonJobBuilder works() {
		return new PersonJobBuilder(person);
	}

	public PersonAddressBuilder lives() {
		return new PersonAddressBuilder(person);
	}

	public Person build() {
		return person;
	}

}

class PersonAddressBuilder extends PersonBuilder {

	public PersonAddressBuilder(Person person) {
		this.person = person;
	}

	public PersonAddressBuilder at(String streetAddress) {
		person.streetAddress = streetAddress;
		return this;
	}

	public PersonAddressBuilder withPostcode(String postcode) {
		person.postcode = postcode;
		return this;
	}

	public PersonAddressBuilder in(String city) {
		person.city = city;
		return this;
	}

}

class PersonJobBuilder extends PersonBuilder {

	public PersonJobBuilder(Person person) {
		this.person = person;
	}

	public PersonJobBuilder at(String companyName) {
		person.companyName = companyName;
		return this;
	}

	public PersonJobBuilder asA(String position) {
		person.position = position;
		return this;
	}

	public PersonJobBuilder earning(int annualIncome) {
		person.annualIncome = annualIncome;
		return this;
	}

}