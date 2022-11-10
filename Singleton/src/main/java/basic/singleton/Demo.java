package basic.singleton;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Demo {

	static void saveToFile(BasicSingleton singleton, String filename) throws Exception {
		try (FileOutputStream fileOut = new FileOutputStream(filename);
				ObjectOutputStream out = new ObjectOutputStream(fileOut)) {
			out.writeObject(singleton);
		}
	}

	static BasicSingleton readFromFile(String filename) throws Exception {
		try (FileInputStream fileIn = new FileInputStream(filename);
				ObjectInputStream in = new ObjectInputStream(fileIn)) {
			return (BasicSingleton) in.readObject();
		}
	}

	public static void main(String[] args) throws Exception {

		/*
		 * BasicSingleton singleton = BasicSingleton.getInstance();
		 * singleton.setValue(123); System.out.println(singleton.getValue());
		 * System.out.println(singleton.hashCode());
		 * 
		 * BasicSingleton singleton2 = singleton;
		 * 
		 * System.out.println(singleton2.getValue());
		 * System.out.println(singleton2.hashCode());
		 */
		// PROBLEMS WITH THE BASIC SINGLETON:
		// 1. Reflection- you can get to the private constructor using reflection and
		// make it public effectively
		// 2. Serialization- when you serialize an object the JVM doesn't care that
		// the constructor is private, is going to create an object anyway

		BasicSingleton singleton = BasicSingleton.getInstance();
		singleton.setValue(111);

		String filename = "singleton.bin";
		saveToFile(singleton, filename);

		singleton.setValue(222);

		BasicSingleton singleton2 = readFromFile(filename);

		System.out.println(singleton == singleton2);

		System.out.println(singleton.getValue());
		System.out.println(singleton2.getValue());
	}

}

class BasicSingleton implements Serializable {

	private BasicSingleton() {
	}

	private static final BasicSingleton INSTANCE = new BasicSingleton();

	public static BasicSingleton getInstance() {
		return INSTANCE;
	}

	private int value = 0;

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	protected Object readResolve() {
		return INSTANCE;
	}

}