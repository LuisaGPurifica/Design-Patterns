package protection.proxy;

public class Car implements Drivable {

	protected Driver driver;

	public Car(Driver driver) {
		this.driver = driver;
	}

	public void drive() {
		System.out.println("Car being driven");
	}

}

interface Drivable {
	void drive();
}

class Driver {

	public int age;

	public Driver(int age) {
		this.age = age;
	}

}

class CarProxy extends Car {

	public CarProxy(Driver driver) {
		super(driver);
	}

	@Override
	public void drive() {
		if (driver.age >= 16)
			super.drive();
		else
			System.out.println("Driver too young");
	}

}
