package nulll.object;

class BankAccount {
	private Log log;
	private int balance;

	public BankAccount(Log log) {
		this.log = log;
	}

	public void deposit(int amount) {
		balance += amount;
		if (log != null)
			log.info("Deposited " + amount);
	}
}

final class NullLog implements Log {

	public void info(String msg) {
	}

	public void warn(String msg) {
	}

}

interface Log {
	void info(String msg);

	void warn(String msg);
}

class ConsoleLog implements Log {

	public void info(String msg) {
		System.out.println(msg);
	}

	public void warn(String msg) {
		System.err.println("WARNING" + msg);
	}

}

public class Demo {

	public static void main(String[] args) {

		Log log = new NullLog();

		BankAccount account = new BankAccount(log);

		account.deposit(100);

	}

}