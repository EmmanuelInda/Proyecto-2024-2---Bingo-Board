package ui;

import game.Game;
import game.PlayerCard;
import ui.mycolors.MyColor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CardUI extends JFrame {
	private static final int BOARD_SIZE = 5;

	private JPanel pnlBoard;

	private Game game;
	private PlayerCard playerCard;
	private HistoryUI history;
	private JLabel[][] lblBoardCells;

	public CardUI(Game game, HistoryUI history) {
		this.game = game;
		this.history = history;
		this.playerCard = game.getPlayerCard();

		this.lblBoardCells = new JLabel[BOARD_SIZE][BOARD_SIZE];

		this.setTitle("Bingo Board");
		this.setSize(500, 550);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setLayout(new BorderLayout());

		this.pnlBoard = new JPanel(new GridLayout(BOARD_SIZE + 1, BOARD_SIZE));
		this.initializeBoardGUI(pnlBoard);
		this.add(pnlBoard, BorderLayout.CENTER);

		this.initializeButtonGUI();

		this.setVisible(true);
	}

	private void initializeBoardGUI(JPanel pnlBoard) {
		String[] headers = {"B", "I", "N", "G", "O"};

		for (String header : headers) {
			JLabel lblHeader = new JLabel(header, SwingConstants.CENTER);

			lblHeader.setFont(new Font("Arial", Font.BOLD, 24));
			lblHeader.setForeground(Color.WHITE);
			lblHeader.setOpaque(true);
			lblHeader.setBackground(MyColor.BLUE);

			pnlBoard.add(lblHeader);
		}

		int[][] board = playerCard.getBoard();

		for (int row = 0; row < BOARD_SIZE; ++row) {
			for (int col = 0; col < BOARD_SIZE; ++col) {
				JLabel lblCell = new JLabel();

				lblCell.setHorizontalAlignment(SwingConstants.CENTER);
				lblCell.setFont(new Font("Arial", Font.BOLD, 20));
				lblCell.setBorder(BorderFactory.createLineBorder(Color.BLACK));

				if (board[row][col] == 0) {
					lblCell.setText("FREE");
					lblCell.setForeground(Color.WHITE);
					lblCell.setBackground(MyColor.BLUE);
					lblCell.setOpaque(true);
				} else {
					lblCell.setText(String.valueOf(board[row][col]));
					lblCell.setOpaque(true);
					lblCell.setBackground(Color.WHITE);
				}

				lblBoardCells[row][col] = lblCell;
				pnlBoard.add(lblCell);
			}
		}
	}

	private void initializeButtonGUI() {
		JButton btnDraw = new JButton("Draw Ball");

		btnDraw.setFont(new Font("Arial", Font.BOLD, 16));
		btnDraw.setBackground(MyColor.BLUE);
		btnDraw.setForeground(Color.WHITE);

		btnDraw.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (!game.getDrum().hasNumbers()) {
					JOptionPane.showMessageDialog(CardUI.this, "No more numbers to draw!", "Info", JOptionPane.INFORMATION_MESSAGE);
					return;
				}

				int drawnNumber = game.getDrum().drawNumber();

				history.markNumber(drawnNumber);
				playerCard.markNumber(drawnNumber);
				updateBoard(drawnNumber);

				if (game.isWinGame()) {
					JOptionPane.showMessageDialog(CardUI.this, "Congratulations! You've won the game!", "Winner", JOptionPane.INFORMATION_MESSAGE);
					btnDraw.setEnabled(false);
				}
			}
		});

		this.add(btnDraw, BorderLayout.SOUTH);
	}

	private void updateBoard(int number) {
		int[][] board = playerCard.getBoard();

		for (int row = 0; row < BOARD_SIZE; row++) {
			for (int col = 0; col < BOARD_SIZE; col++) {
				if (board[row][col] == number) {
					JLabel lblCell = lblBoardCells[row][col];

					lblCell.setBackground(Color.YELLOW);
					lblCell.setOpaque(true);
					lblCell.repaint();
				}
			}
		}
	}
}
