package game;

import java.util.ArrayList;

public class Game {
	private int[][] pattern;
	private boolean winGame;

	public Game(int[][] pattern) {
		this.pattern = pattern;
		this.winGame = false;
	}

	public boolean isWinGame(int[][] currentBoard) {
		if (currentBoard == null || pattern.length != currentBoard.length || pattern[0].length != currentBoard[0].length) {
			return false;
		}

		for (int row = 0; row < pattern.length; ++row) {
			for (int col = 0; col < pattern[row].length; ++col) {
				if (pattern[row][col] != 0 && currentBoard[row][col] != pattern[row][col]) {
					return false;
				}
			}
		}

		return true;
	}
}
