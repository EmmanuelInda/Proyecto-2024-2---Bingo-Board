package game.patterns;

import java.util.ArrayList;

public class Pattern {
	public static ArrayList<int[][]> getFiveInARowPatterns() {
		ArrayList<int[][]> patterns = new ArrayList<>();

		patterns.add(pattern1);
		patterns.add(pattern2);
		patterns.add(pattern3);
		patterns.add(pattern4);
		patterns.add(pattern5);
		patterns.add(pattern6);
		patterns.add(pattern7);
		patterns.add(pattern8);
		patterns.add(pattern9);
		patterns.add(pattern10);
		patterns.add(pattern11);
		patterns.add(pattern12);

		return patterns;
	}

	public static ArrayList<int[][]> getSixPackPatterns() {
		ArrayList<int[][]> patterns = new ArrayList<>();

		patterns.add(pattern13);
		patterns.add(pattern14);
		patterns.add(pattern15);
		patterns.add(pattern16);
		patterns.add(pattern17);
		patterns.add(pattern18);
		patterns.add(pattern19);
		patterns.add(pattern20);
		patterns.add(pattern21);
		patterns.add(pattern22);
		patterns.add(pattern23);
		patterns.add(pattern24);
		patterns.add(pattern25);
		patterns.add(pattern26);
		patterns.add(pattern27);
		patterns.add(pattern28);
		patterns.add(pattern29);
		patterns.add(pattern30);
		patterns.add(pattern31);
		patterns.add(pattern32);
		patterns.add(pattern33);
		patterns.add(pattern34);
		patterns.add(pattern35);
		patterns.add(pattern36);

		return patterns;
	}

	public static ArrayList<int[][]> getEightPatterns() {
		ArrayList<int[][]> patterns = new ArrayList<>();

		patterns.add(pattern37);
		patterns.add(pattern38);

		return patterns;
	}

	/*
	 *	5-in-a-Row Patterns
	 */
	private static int[][] pattern1 = {
		{1, 0, 0, 0, 0},
		{1, 0, 0, 0, 0},
		{1, 0, 0, 0, 0},
		{1, 0, 0, 0, 0},
		{1, 0, 0, 0, 0}
	};

	private static int[][] pattern2 = {
		{0, 1, 0, 0, 0},
		{0, 1, 0, 0, 0},
		{0, 1, 0, 0, 0},
		{0, 1, 0, 0, 0},
		{0, 1, 0, 0, 0}
	};

	private static int[][] pattern3 = {
		{0, 0, 1, 0, 0},
		{0, 0, 1, 0, 0},
		{0, 0, 1, 0, 0},
		{0, 0, 1, 0, 0},
		{0, 0, 1, 0, 0}
	};

	private static int[][] pattern4 = {
		{0, 0, 0, 1, 0},
		{0, 0, 0, 1, 0},
		{0, 0, 0, 1, 0},
		{0, 0, 0, 1, 0},
		{0, 0, 0, 1, 0}
	};

	private static int[][] pattern5 = {
		{0, 0, 0, 0, 1},
		{0, 0, 0, 0, 1},
		{0, 0, 0, 0, 1},
		{0, 0, 0, 0, 1},
		{0, 0, 0, 0, 1}
	};

	private static int[][] pattern6 = {
		{1, 0, 0, 0, 0},
		{0, 1, 0, 0, 0},
		{0, 0, 1, 0, 0},
		{0, 0, 0, 1, 0},
		{0, 0, 0, 0, 1}
	};

	private static int[][] pattern7 = {
		{1, 1, 1, 1, 1},
		{0, 0, 0, 0, 0},
		{0, 0, 0, 0, 0},
		{0, 0, 0, 0, 0},
		{0, 0, 0, 0, 0}
	};

	private static int[][] pattern8 = {
		{0, 0, 0, 0, 0},
		{1, 1, 1, 1, 1},
		{0, 0, 0, 0, 0},
		{0, 0, 0, 0, 0},
		{0, 0, 0, 0, 0}
	};

	private static int[][] pattern9 = {
		{0, 0, 0, 0, 0},
		{0, 0, 0, 0, 0},
		{1, 1, 1, 1, 1},
		{0, 0, 0, 0, 0},
		{0, 0, 0, 0, 0}
	};

	private static int[][] pattern10 = {
		{0, 0, 0, 0, 0},
		{0, 0, 0, 0, 0},
		{0, 0, 0, 0, 0},
		{1, 1, 1, 1, 1},
		{0, 0, 0, 0, 0}
	};

	private static int[][] pattern11 = {
		{0, 0, 0, 0, 0},
		{0, 0, 0, 0, 0},
		{0, 0, 0, 0, 0},
		{0, 0, 0, 0, 0},
		{1, 1, 1, 1, 1}
	};

	private static int[][] pattern12 = {
		{0, 0, 0, 0, 1},
		{0, 0, 0, 1, 0},
		{0, 0, 1, 0, 0},
		{0, 1, 0, 0, 0},
		{1, 0, 0, 0, 0}
	};

	/*
	 *	6-Pack Patterns
	 */
	private static int[][] pattern13 = {
		{1, 1, 0, 0, 0},
		{1, 1, 0, 0, 0},
		{1, 1, 0, 0, 0},
		{0, 0, 0, 0, 0},
		{0, 0, 0, 0, 0}
	};

	private static int[][] pattern14 = {
		{0, 0, 0, 0, 0},
		{1, 1, 0, 0, 0},
		{1, 1, 0, 0, 0},
		{1, 1, 0, 0, 0},
		{0, 0, 0, 0, 0}
	};

	private static int[][] pattern15 = {
		{0, 0, 0, 0, 0},
		{0, 0, 0, 0, 0},
		{1, 1, 0, 0, 0},
		{1, 1, 0, 0, 0},
		{1, 1, 0, 0, 0}
	};

	private static int[][] pattern16 = {
		{0, 1, 1, 0, 0},
		{0, 1, 1, 0, 0},
		{0, 1, 1, 0, 0},
		{0, 0, 0, 0, 0},
		{0, 0, 0, 0, 0}
	};

	private static int[][] pattern17 = {
		{0, 0, 0, 0, 0},
		{0, 1, 1, 0, 0},
		{0, 1, 1, 0, 0},
		{0, 1, 1, 0, 0},
		{0, 0, 0, 0, 0}
	};

	private static int[][] pattern18 = {
		{0, 0, 0, 0, 0},
		{0, 0, 0, 0, 0},
		{0, 1, 1, 0, 0},
		{0, 1, 1, 0, 0},
		{0, 1, 1, 0, 0}
	};

	private static int[][] pattern19 = {
		{0, 0, 1, 1, 0},
		{0, 0, 1, 1, 0},
		{0, 0, 1, 1, 0},
		{0, 0, 0, 0, 0},
		{0, 0, 0, 0, 0}
	};

	private static int[][] pattern20 = {
		{0, 0, 0, 0, 0},
		{0, 0, 1, 1, 0},
		{0, 0, 1, 1, 0},
		{0, 0, 1, 1, 0},
		{0, 0, 0, 0, 0}
	};

	private static int[][] pattern21 = {
		{0, 0, 0, 0, 0},
		{0, 0, 0, 0, 0},
		{0, 0, 1, 1, 0},
		{0, 0, 1, 1, 0},
		{0, 0, 1, 1, 0}
	};

	private static int[][] pattern22 = {
		{0, 0, 0, 1, 1},
		{0, 0, 0, 1, 1},
		{0, 0, 0, 1, 1},
		{0, 0, 0, 0, 0},
		{0, 0, 0, 0, 0}
	};

	private static int[][] pattern23 = {
		{0, 0, 0, 0, 0},
		{0, 0, 0, 1, 1},
		{0, 0, 0, 1, 1},
		{0, 0, 0, 1, 1},
		{0, 0, 0, 0, 0}
	};

	private static int[][] pattern24 = {
		{0, 0, 0, 0, 0},
		{0, 0, 0, 0, 0},
		{0, 0, 0, 1, 1},
		{0, 0, 0, 1, 1},
		{0, 0, 0, 1, 1}
	};

	private static int[][] pattern25 = {
		{1, 1, 1, 0, 0},
		{1, 1, 1, 0, 0},
		{0, 0, 0, 0, 0},
		{0, 0, 0, 0, 0},
		{0, 0, 0, 0, 0}
	};

	private static int[][] pattern26 = {
		{0, 1, 1, 1, 0},
		{0, 1, 1, 1, 0},
		{0, 0, 0, 0, 0},
		{0, 0, 0, 0, 0},
		{0, 0, 0, 0, 0}
	};

	private static int[][] pattern27 = {
		{0, 0, 1, 1, 1},
		{0, 0, 1, 1, 1},
		{0, 0, 0, 0, 0},
		{0, 0, 0, 0, 0},
		{0, 0, 0, 0, 0}
	};

	private static int[][] pattern28 = {
		{0, 0, 0, 0, 0},
		{1, 1, 1, 0, 0},
		{1, 1, 1, 0, 0},
		{0, 0, 0, 0, 0},
		{0, 0, 0, 0, 0}
	};

	private static int[][] pattern29 = {
		{0, 0, 0, 0, 0},
		{0, 1, 1, 1, 0},
		{0, 1, 1, 1, 0},
		{0, 0, 0, 0, 0},
		{0, 0, 0, 0, 0}
	};

	private static int[][] pattern30 = {
		{0, 0, 0, 0, 0},
		{0, 0, 1, 1, 1},
		{0, 0, 1, 1, 1},
		{0, 0, 0, 0, 0},
		{0, 0, 0, 0, 0}
	};

	private static int[][] pattern31 = {
		{0, 0, 0, 0, 0},
		{0, 0, 0, 0, 0},
		{1, 1, 1, 0, 0},
		{1, 1, 1, 0, 0},
		{0, 0, 0, 0, 0}
	};

	private static int[][] pattern32 = {
		{0, 0, 0, 0, 0},
		{0, 0, 0, 0, 0},
		{0, 1, 1, 1, 0},
		{0, 1, 1, 1, 0},
		{0, 0, 0, 0, 0}
	};

	private static int[][] pattern33 = {
		{0, 0, 0, 0, 0},
		{0, 0, 0, 0, 0},
		{0, 0, 1, 1, 1},
		{0, 0, 1, 1, 1},
		{0, 0, 0, 0, 0}
	};

	private static int[][] pattern34 = {
		{0, 0, 0, 0, 0},
		{0, 0, 0, 0, 0},
		{0, 0, 0, 0, 0},
		{1, 1, 1, 0, 0},
		{1, 1, 1, 0, 0}
	};

	private static int[][] pattern35 = {
		{0, 0, 0, 0, 0},
		{0, 0, 0, 0, 0},
		{0, 0, 0, 0, 0},
		{0, 1, 1, 1, 0},
		{0, 1, 1, 1, 0}
	};

	private static int[][] pattern36 = {
		{0, 0, 0, 0, 0},
		{0, 0, 0, 0, 0},
		{0, 0, 0, 0, 0},
		{0, 0, 1, 1, 1},
		{0, 0, 1, 1, 1}
	};

	/*
	 *	8 Diamond Pattern
	 */
	private static int[][] pattern37 = {
		{0, 0, 1, 0, 0},
		{0, 1, 0, 1, 0},
		{1, 0, 0, 0, 1},
		{0, 1, 0, 1, 0},
		{0, 0, 1, 0, 0}
	};

	/*
	 *	8 Small Center Box Pattern
	 */
	private static int[][] pattern38 = {
		{0, 0, 0, 0, 0},
		{0, 1, 1, 1, 0},
		{0, 1, 0, 1, 0},
		{0, 1, 1, 1, 0},
		{0, 0, 0, 0, 0}
	};
}
