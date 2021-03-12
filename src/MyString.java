//Kasper Rosenberg karo5568
import java.util.Arrays;

public class MyString {

	private char[] data;

	public MyString(String title) {
		data = title.toCharArray();
	}

	public Object length() {
		return data.length;
	}

	public char[] getData() {
		return data;
	}

	public boolean equals(Object other) {
		if (other instanceof MyString) {
			MyString ms = (MyString) other;
			return Arrays.equals(data, ms.getData());
		}
		return false;
	}

	@Override
	public String toString() {
		return new String(data);
	}

}
