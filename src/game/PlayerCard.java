package game;

import java.util.ArrayList;
import java.util.Collections;

public class PlayerCard {
	private static final int BOARD_SIZE = 5;
	private static final int MAX_NUMBER = 75;

	private int[][] board;
	private int[][] filledPattern;

	public PlayerCard() {
		board = new int[BOARD_SIZE][BOARD_SIZE];
		filledPattern = new int[BOARD_SIZE][BOARD_SIZE];
		generateBoard();
	}

	private void generateBoard() {
		ArrayList<Integer> numbers = new ArrayList<>();
		int range = MAX_NUMBER / BOARD_SIZE;

		for (int col = 0; col < BOARD_SIZE; ++col) {
			numbers.clear();
			for (int i = col * range + 1; i <= (col + 1) * range; ++i)
				numbers.add(i);

			Collections.shuffle(numbers);

			for (int row = 0; row < BOARD_SIZE; ++row) {
				if (row == 2 && col == 2)
					board[row][col] = 0;
				else
					board[row][col] = numbers.remove(0);

				filledPattern[row][col] = 0;
			}
			filledPattern[2][2] = 1; // Free space
		}
	}

	public int[][] getBoard() {
		return board;
	}

	public int[][] getFilledPattern() {
		return filledPattern;
	}

	public void markNumber(int number) {
		for (int row = 0; row < BOARD_SIZE; ++row) {
			for (int col = 0; col < BOARD_SIZE; ++col) {
				if (board[row][col] == number) {
					filledPattern[row][col] = 1;
				}
			}
		}
	}
}
