package game;

import java.util.ArrayList;
import java.util.Collections;

public class Drum {
	private ArrayList<Integer> availableNumbers;
	private static final int MAX_NUMBER = 75;

	public Drum() {
		availableNumbers = new ArrayList<>();
		for (int i = 1; i <= MAX_NUMBER; ++i) {
			availableNumbers.add(i);
		}
	}

	public boolean hasNumbers() {
		return !availableNumbers.isEmpty();
	}

	public int drawNumber() {
		if (availableNumbers.isEmpty())
			throw new IllegalStateException("No more numbers to draw");

		Collections.shuffle(availableNumbers);
		return availableNumbers.remove(0);
	}
}
