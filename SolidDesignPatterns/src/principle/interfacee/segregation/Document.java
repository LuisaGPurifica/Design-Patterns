package principle.interfacee.segregation;

/**
 * the interface of a program should be split in a way that the user/client
 * would only have access to the necessary methods related to their needs
 * 
 */

public class Document {

}

interface Machine {

	void print(Document d);

	void fax(Document d) throws Exception;

	void scan(Document d);

}

class MultiFunctionPrinter implements Machine {

	@Override
	public void print(Document d) {
		// TODO Auto-generated method stub

	}

	@Override
	public void fax(Document d) {
		// TODO Auto-generated method stub

	}

	@Override
	public void scan(Document d) {
		// TODO Auto-generated method stub

	}

}

class OldFashionedPrinter implements Machine {

	@Override
	public void print(Document d) {
		// TODO Auto-generated method stub

	}

	@Override
	public void fax(Document d) throws Exception {
		throw new Exception();
	}

	@Override
	public void scan(Document d) {
		// TODO Auto-generated method stub

	}

}

interface Printer {
	void print(Document d);
}

interface Scanner {
	void scan(Document d);
}

// YAGNI - You Ain't Going to Need It

class JustAPrinter implements Printer {

	@Override
	public void print(Document d) {

	}

}

class Photocopier implements Printer, Scanner {

	@Override
	public void scan(Document d) {
		// TODO Auto-generated method stub
	}

	@Override
	public void print(Document d) {
		// TODO Auto-generated method stub
	}

}

interface MultiFunctionDevice extends Printer, Scanner {
}

class MultiFunctionMachine implements MultiFunctionDevice {

	private Printer printer;
	private Scanner scanner;

	public MultiFunctionMachine(Printer printer, Scanner scanner) {
		this.printer = printer;
		this.scanner = scanner;
	}

	@Override
	public void print(Document d) {
		printer.print(d);
	}

	@Override
	public void scan(Document d) {
		scanner.scan(d);
	}

}
