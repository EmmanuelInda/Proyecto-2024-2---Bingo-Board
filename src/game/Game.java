package game;

public class Game {
	private int[][] pattern;
	private PlayerCard playerCard;
	private Drum drum;

	public Game(int[][] pattern) {
		this.pattern = pattern;
		this.playerCard = new PlayerCard();
		this.drum = new Drum();
	}

	public PlayerCard getPlayerCard() {
		return playerCard;
	}

	public Drum getDrum() {
		return drum;
	}

	public boolean isWinGame() {
		int[][] currentBoard = playerCard.getFilledPattern();
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
