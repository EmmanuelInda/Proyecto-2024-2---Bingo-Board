package ui;

import game.Game;
import ui.mycolors.MyColor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;

public class BingoBoard extends JFrame {
	private static final int BOARD_SIZE = 5;
	private static final int MAX_NUMBER = 75;
	private int[][] board;
	private int[][] filledPattern;
	private ArrayList<Integer> availableNumbers;

	private Game game;
	private History history;
	private JLabel[][] boardCells;

	public BingoBoard(Game game, History history) {
		this.game = game;
		this.history = history;

		this.board = new int[BOARD_SIZE][BOARD_SIZE];
		this.filledPattern = new int[BOARD_SIZE][BOARD_SIZE];
		this.boardCells = new JLabel[BOARD_SIZE][BOARD_SIZE];
		this.availableNumbers = new ArrayList<>();

		for (int i = 1; i <= MAX_NUMBER; i++) {
			availableNumbers.add(i);
		}

		this.generateBoard();

		this.setTitle("Bingo Board");
		this.setSize(500, 550);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setLayout(new BorderLayout());

		JPanel boardPanel = new JPanel(new GridLayout(BOARD_SIZE + 1, BOARD_SIZE));
		this.initializeBoardGUI(boardPanel);
		this.add(boardPanel, BorderLayout.CENTER);

		this.initializeButtonGUI();

		this.setVisible(true);
	}

	private void generateBoard() {
		ArrayList<Integer> numbers = new ArrayList<>();
		int range = MAX_NUMBER / BOARD_SIZE;

		for (int col = 0; col < BOARD_SIZE; ++col) {
			numbers.clear();

			for (int i = col * range + 1; i <= (col + 1) * range; ++i) {
				numbers.add(i);
			}

			Collections.shuffle(numbers);

			for (int row = 0; row < BOARD_SIZE; ++row) {
				if (row == 2 && col == 2)
					board[row][col] = 0;
				else
					board[row][col] = numbers.remove(0);
				
				filledPattern[row][col] = 0;
			}
			filledPattern[2][2] = 1; // Free
		}
	}

	private void initializeBoardGUI(JPanel boardPanel) {
		String[] headers = {"B", "I", "N", "G", "O"};
		for (String header : headers) {
			JLabel lblHeader = new JLabel(header, SwingConstants.CENTER);

			lblHeader.setFont(new Font("Arial", Font.BOLD, 24));
			lblHeader.setForeground(Color.WHITE);
			lblHeader.setOpaque(true);
			lblHeader.setBackground(MyColor.BLUE);

			boardPanel.add(lblHeader);
		}

		for (int row = 0; row < BOARD_SIZE; ++row) {
			for (int col = 0; col < BOARD_SIZE; ++col) {
				JLabel cell = new JLabel();

				cell.setHorizontalAlignment(SwingConstants.CENTER);
				cell.setFont(new Font("Arial", Font.BOLD, 20));
				cell.setBorder(BorderFactory.createLineBorder(Color.BLACK));

				if (board[row][col] == 0) {
					cell.setText("FREE");
					cell.setForeground(Color.WHITE);
					cell.setBackground(MyColor.BLUE);
					cell.setOpaque(true);
				} else {
					cell.setText(String.valueOf(board[row][col]));
					cell.setOpaque(true);
					cell.setBackground(Color.WHITE);
				}

				boardCells[row][col] = cell;
				boardPanel.add(cell);
			}
		}
	}

	private void initializeButtonGUI() {
		JButton drawButton = new JButton("Draw Ball");

		drawButton.setFont(new Font("Arial", Font.BOLD, 16));
		drawButton.setBackground(MyColor.BLUE);
		drawButton.setForeground(Color.WHITE);

		drawButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (availableNumbers.isEmpty()) {
					JOptionPane.showMessageDialog(BingoBoard.this, "No more numbers to draw!", "Info", JOptionPane.INFORMATION_MESSAGE);
					return;
				}

				Collections.shuffle(availableNumbers);
				int drawnNumber = availableNumbers.remove(0);

				history.markNumber(drawnNumber);
				updateBoard(drawnNumber);

				if (game.isWinGame(filledPattern)) {
					JOptionPane.showMessageDialog(BingoBoard.this, "Congratulations! You've won the game!", "Winner", JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});

		this.add(drawButton, BorderLayout.SOUTH);
	}

	private void updateBoard(int number) {
		for (int row = 0; row < BOARD_SIZE; row++) {
			for (int col = 0; col < BOARD_SIZE; col++) {
				if (board[row][col] == number) {
					JLabel cell = boardCells[row][col];

					cell.setBackground(Color.YELLOW);
					cell.setOpaque(true);
					cell.repaint();

					filledPattern[row][col] = 1;
				}
			}
		}
	}
}
