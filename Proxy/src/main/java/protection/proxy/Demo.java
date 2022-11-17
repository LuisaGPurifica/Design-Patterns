package protection.proxy;

public class Demo {
	public static void main(String[] args) {
		Car car = new Car(new Driver(12));
		System.out.println("Using car constructor:");
		car.drive();
		Car car2 = new CarProxy(new Driver(12));
		System.out.println("Using car proxy constructor:");
		car2.drive();
	}
}
