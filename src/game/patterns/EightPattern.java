package game.patterns;

import java.util.ArrayList;

public class EightPattern implements Pattern {
	public static ArrayList<int[][]> getPatterns() {
		ArrayList<int[][]> patterns = new ArrayList<>();

		patterns.add(new int[][] {
			{0, 0, 1, 0, 0},
			{0, 1, 0, 1, 0},
			{1, 0, 0, 0, 1},
			{0, 1, 0, 1, 0},
			{0, 0, 1, 0, 0}
		});

		patterns.add(new int[][] {
			{0, 0, 0, 0, 0},
			{0, 1, 1, 1, 0},
			{0, 1, 0, 1, 0},
			{0, 1, 1, 1, 0},
			{0, 0, 0, 0, 0}
		});

		return patterns;
	}
}
