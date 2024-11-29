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

	private JPanel pnl_board;

	private Game game;
	private History history;
	private JLabel[][] lbl_boardCells;

	public BingoBoard(Game game, History history) {
		this.game = game;
		this.history = history;

		this.board = new int[BOARD_SIZE][BOARD_SIZE];
		this.filledPattern = new int[BOARD_SIZE][BOARD_SIZE];
		this.lbl_boardCells = new JLabel[BOARD_SIZE][BOARD_SIZE];
		this.availableNumbers = new ArrayList<>();

		for (int i = 1; i <= MAX_NUMBER; i++) {
			availableNumbers.add(i);
		}

		this.generateBoard();

		this.setTitle("Bingo Board");
		this.setSize(500, 550);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setLayout(new BorderLayout());

		this.pnl_board = new JPanel(new GridLayout(BOARD_SIZE + 1, BOARD_SIZE));
		this.initializeBoardGUI(pnl_board);
		this.add(pnl_board, BorderLayout.CENTER);

		this.initializeButtonGUI();

		this.setVisible(true);
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
			filledPattern[2][2] = 1; // Free
		}
	}

	private void initializeBoardGUI(JPanel pnl_board) {
		String[] headers = {"B", "I", "N", "G", "O"};

		for (String header : headers) {
			JLabel lbl_header = new JLabel(header, SwingConstants.CENTER);

			lbl_header.setFont(new Font("Arial", Font.BOLD, 24));
			lbl_header.setForeground(Color.WHITE);
			lbl_header.setOpaque(true);
			lbl_header.setBackground(MyColor.BLUE);

			pnl_board.add(lbl_header);
		}

		for (int row = 0; row < BOARD_SIZE; ++row) {
			for (int col = 0; col < BOARD_SIZE; ++col) {
				JLabel lbl_cell = new JLabel();

				lbl_cell.setHorizontalAlignment(SwingConstants.CENTER);
				lbl_cell.setFont(new Font("Arial", Font.BOLD, 20));
				lbl_cell.setBorder(BorderFactory.createLineBorder(Color.BLACK));

				if (board[row][col] == 0) {
					lbl_cell.setText("FREE");
					lbl_cell.setForeground(Color.WHITE);
					lbl_cell.setBackground(MyColor.BLUE);
					lbl_cell.setOpaque(true);
				} else {
					lbl_cell.setText(String.valueOf(board[row][col]));
					lbl_cell.setOpaque(true);
					lbl_cell.setBackground(Color.WHITE);
				}

				lbl_boardCells[row][col] = lbl_cell;
				pnl_board.add(lbl_cell);
			}
		}
	}

	private void initializeButtonGUI() {
		JButton btn_draw = new JButton("Draw Ball");

		btn_draw.setFont(new Font("Arial", Font.BOLD, 16));
		btn_draw.setBackground(MyColor.BLUE);
		btn_draw.setForeground(Color.WHITE);

		btn_draw.addActionListener(new ActionListener() {
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

		this.add(btn_draw, BorderLayout.SOUTH);
	}

	private void updateBoard(int number) {
		for (int row = 0; row < BOARD_SIZE; row++) {
			for (int col = 0; col < BOARD_SIZE; col++) {
				if (board[row][col] == number) {
					JLabel lbl_cell = lbl_boardCells[row][col];

					lbl_cell.setBackground(Color.YELLOW);
					lbl_cell.setOpaque(true);
					lbl_cell.repaint();

					filledPattern[row][col] = 1;
				}
			}
		}
	}
}
