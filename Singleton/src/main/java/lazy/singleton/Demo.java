package lazy.singleton;

public class Demo {

}

class LazySingleton {

	private static LazySingleton instance;

	private LazySingleton() {
		System.out.println("Initializing a lazy singleton");
	}

	public static synchronized LazySingleton getInstance() {
		if (instance == null) {
			instance = new LazySingleton();
		}
		return instance;
	}

	// double-checked locking
	public static LazySingleton getInstanceDoubleChecked() {
		if (instance == null) {
			synchronized (LazySingleton.class) {
				if (instance == null) {
					instance = new LazySingleton();
				}
			}
		}
		return instance;
	}

}
