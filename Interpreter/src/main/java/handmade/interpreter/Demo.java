package handmade.interpreter;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

interface Element {
	int eval();
}

class Integer implements Element {

	private int value;

	public Integer(int value) {
		this.value = value;
	}

	@Override
	public int eval() {
		return value;
	}

}

class BinaryOperation implements Element {

	public enum Type {
		ADDITION, SUBSTRACTION
	}

	public Type type;
	public Element left, right;

	@Override
	public int eval() {
		switch (type) {
		case ADDITION:
			return left.eval() + right.eval();
		case SUBSTRACTION:
			return left.eval() - right.eval();
		default:
			return 0;
		}

	}
}

class Token {
	public enum Type {
		INTEGER, PLUS, MINUS, LPAREN, RPAREN
	}

	public Type type;
	public String text;

	public Token(Type type, String text) {
		this.type = type;
		this.text = text;
	}

	@Override
	public String toString() {
		return "`" + text + "`";
	}

}

public class Demo {

	static List<Token> lex(String input) {
		ArrayList<Token> result = new ArrayList<>();

		for (int i = 0; i < input.length(); ++i) {
			switch (input.charAt(i)) {
			case '+':
				result.add(new Token(Token.Type.PLUS, "+"));
				break;
			case '-':
				result.add(new Token(Token.Type.MINUS, "-"));
				break;
			case '(':
				result.add(new Token(Token.Type.LPAREN, "("));
				break;
			case ')':
				result.add(new Token(Token.Type.RPAREN, ")"));
				break;
			default:
				StringBuilder sb = new StringBuilder("" + input.charAt(i));
				for (int j = i + 1; j < input.length(); ++j) {
					if (Character.isDigit(input.charAt(j))) {
						sb.append(input.charAt(j));
						++i;
					} else {
						result.add(new Token(Token.Type.INTEGER, sb.toString()));
						break;
					}
				}
				break;
			}
		}
		return result;
	}

	static Element parse(List<Token> tokens) {
		BinaryOperation result = new BinaryOperation();

		boolean haveLHS = false;

		for (int i = 0; i < tokens.size(); ++i) {
			Token token = tokens.get(i);
			switch (token.type) {
			case INTEGER:
				Integer integer = new Integer(java.lang.Integer.parseInt(token.text));
				if (!haveLHS) {
					result.left = integer;
					haveLHS = true;
				} else
					result.right = integer;
				break;
			case LPAREN:
				break;
			case MINUS:
				break;
			case PLUS:
				break;
			case RPAREN:
				break;
			default:
				break;
			}
		}
	}

	public static void main(String[] args) {

		String input = "(13+4)-(12+1)";

		List<Token> tokens = lex(input);
		System.out.println(tokens.stream().map(t -> t.toString()).collect(Collectors.joining("\t")));

	}

}
