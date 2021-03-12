//Kasper Rosenberg karo5568

import java.util.Arrays;

public class ISBN10 {

	private char[] isbn;

	public ISBN10(String isbn) {
		if (isbn.length() != 10)
			throw new IllegalArgumentException("Wrong length, must be 10");
		if (!checkDigit(isbn))
			throw new IllegalArgumentException("Not a valid isbn 10");
		this.isbn = isbn.toCharArray();
	}

	private boolean checkDigit(String isbn) {
		int sum = 0;
		for (int i = 0; i < 9; i++) {
			sum += Character.getNumericValue(isbn.charAt(i)) * (10 - i);
		}
		int checkDigit = (11 - (sum % 11)) % 11;

		return isbn.endsWith(checkDigit == 10 ? "X" : "" + checkDigit);
	}

	public char[] getisbn() {
		return isbn;
	}

	public boolean equals(Object other) {
		if (other instanceof ISBN10) {
			ISBN10 i = (ISBN10) other;
			return Arrays.equals(isbn, i.getisbn());
		}
		return false;
	}

	@Override
	public String toString() {
		return new String(isbn);
	}
}
