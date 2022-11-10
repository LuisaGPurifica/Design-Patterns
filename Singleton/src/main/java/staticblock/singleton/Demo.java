package staticblock.singleton;

import java.io.File;
import java.io.IOException;

public class Demo {
	public static void main(String[] args) {
		StaticBlockSingleton singleton = StaticBlockSingleton.getInstance();
	}
}

class StaticBlockSingleton {

	private StaticBlockSingleton() throws IOException {
		System.out.println("Singleton is initialized.");
		File.createTempFile(".", ".");
	}

	private static StaticBlockSingleton instance;

	static {
		try {
			instance = new StaticBlockSingleton();
		} catch (Exception e) {
			System.err.println("Failed to get singleton");
		}
	}

	public static StaticBlockSingleton getInstance() {
		return instance;
	}

}