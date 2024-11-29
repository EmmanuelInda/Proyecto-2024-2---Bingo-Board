package ui;

import javax.swing.*;
import java.awt.*;

public class HistoryUI extends JFrame {
	private static final int MAX_NUMBER = 75;
	private static final int ROWS = 5;
	private static final int COLUMNS = 15;

	private JPanel pnlMain;
	private JLabel[][] lblCells;

	public HistoryUI() {
		this.setTitle("Bingo History");
		this.setSize(800, 400);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setLayout(new BorderLayout());

		this.pnlMain = new JPanel(new GridLayout(ROWS, COLUMNS));
		this.getContentPane().setBackground(Color.WHITE);

		initializeGrid(pnlMain);
		this.add(pnlMain, BorderLayout.CENTER);

		initializeBingoHeaders();

		this.setVisible(true);
	}

	private void initializeGrid(JPanel pnlMain) {
		lblCells = new JLabel[ROWS][COLUMNS];
		int number = 1;

		for (int row = 0; row < ROWS; ++row) {
			for (int col = 0; col < COLUMNS; ++col) {
				JLabel lblCell = new JLabel(String.valueOf(number));

				lblCell.setHorizontalAlignment(SwingConstants.CENTER);
				lblCell.setFont(new Font("Arial", Font.BOLD, 20));
				lblCell.setOpaque(true);
				lblCell.setBackground(Color.WHITE);
				lblCell.setForeground(Color.BLACK);
				lblCell.setBorder(BorderFactory.createLineBorder(Color.GRAY));
				lblCells[row][col] = lblCell;

				pnlMain.add(lblCell);
				number++;
			}
		}
	}

	private void initializeBingoHeaders() {
		JPanel pnlHeader = new JPanel(new GridLayout(5, 1));
		String[] headers = {"B", "I", "N", "G", "O"};
		Color[] colors = {Color.BLUE, Color.RED, Color.GREEN, Color.YELLOW, new Color(128, 0, 128)};
	
		for (int i = 0; i < headers.length; ++i) {
			JLabel lblHeader = new JLabel(headers[i], SwingConstants.CENTER);
	
			lblHeader.setFont(new Font("Arial", Font.BOLD, 24));
			lblHeader.setOpaque(true);
			lblHeader.setBackground(colors[i]);
			lblHeader.setForeground(Color.WHITE);
			lblHeader.setBorder(BorderFactory.createLineBorder(Color.GRAY));
	
			pnlHeader.add(lblHeader);
		}
		this.add(pnlHeader, BorderLayout.WEST);
	}
	

	public void markNumber(int number) {
		if (number < 1 || number > MAX_NUMBER) return;

		int row = (number - 1) / COLUMNS;
		int col = (number - 1) % COLUMNS;

		JLabel lblCell = lblCells[row][col];

		lblCell.setBackground(Color.YELLOW);
		lblCell.setOpaque(true);
		lblCell.repaint();
	}
}
