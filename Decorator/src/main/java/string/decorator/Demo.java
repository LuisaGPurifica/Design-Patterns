package string.decorator;

import java.util.Scanner;

public class Demo {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		System.out.println("Type in the word:");
		String string = scan.next() + scan.nextLine();

		MagicString s = new MagicString(string);

		System.out.println(s + " has " + s.getNumberOfVowels() + " vowels");

		scan.close();
	}

}
