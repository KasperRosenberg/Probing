//Kasper Rosenberg karo5568
public class LinearProbingHashTable<T> extends ProbingHashTable<T> {

	/*
	 * Denna metod ska skrivas klart. Den ska använda linjär sondering och hela tiden öka med ett.
	 */
	@Override
	protected int findPos(T x) {
		int offset = 1;
		int currentPos = myhash(x);
		while (continueProbing(currentPos, x)) {
			currentPos += offset;
			if (currentPos >= capacity())
				currentPos -= capacity();
		}

		return currentPos;
	}
}
