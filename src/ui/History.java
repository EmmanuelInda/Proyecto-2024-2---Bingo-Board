package ui;

import javax.swing.*;
import java.awt.*;

public class History extends JFrame {
	private static final int MAX_NUMBER = 75;
	private static final int ROWS = 5;
	private static final int COLUMNS = 15;

	private JPanel pnl_main;
	private JLabel[][] lbl_cells;

	public History() {
		this.setTitle("Bingo History");
		this.setSize(800, 400);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setLayout(new BorderLayout());

		this.pnl_main = new JPanel(new GridLayout(ROWS, COLUMNS));
		this.getContentPane().setBackground(Color.WHITE);

		initializeGrid(pnl_main);
		this.add(pnl_main, BorderLayout.CENTER);

		initializeBingoHeaders();

		this.setVisible(true);
	}

	private void initializeGrid(JPanel pnl_main) {
		lbl_cells = new JLabel[ROWS][COLUMNS];
		int number = 1;

		for (int row = 0; row < ROWS; ++row) {
			for (int col = 0; col < COLUMNS; ++col) {
				JLabel cell = new JLabel(String.valueOf(number));

				cell.setHorizontalAlignment(SwingConstants.CENTER);
				cell.setFont(new Font("Arial", Font.BOLD, 20));
				cell.setOpaque(true);
				cell.setBackground(Color.WHITE);
				cell.setForeground(Color.BLACK);
				cell.setBorder(BorderFactory.createLineBorder(Color.GRAY));
				lbl_cells[row][col] = cell;

				pnl_main.add(cell);
				number++;
			}
		}
	}

	private void initializeBingoHeaders() {
		JPanel headerPanel = new JPanel(new GridLayout(5, 1));
		String[] headers = {"B", "I", "N", "G", "O"};
		Color[] colors = {Color.BLUE, Color.RED, Color.GREEN, Color.YELLOW, new Color(128, 0, 128)};
	
		for (int i = 0; i < headers.length; ++i) {
			JLabel lblHeader = new JLabel(headers[i], SwingConstants.CENTER);
	
			lblHeader.setFont(new Font("Arial", Font.BOLD, 24));
			lblHeader.setOpaque(true);
			lblHeader.setBackground(colors[i]);
			lblHeader.setForeground(Color.WHITE);
			lblHeader.setBorder(BorderFactory.createLineBorder(Color.GRAY));
	
			headerPanel.add(lblHeader);
		}
		this.add(headerPanel, BorderLayout.WEST);
	}
	

	public void markNumber(int number) {
		if (number < 1 || number > MAX_NUMBER) return;

		int row = (number - 1) / COLUMNS;
		int col = (number - 1) % COLUMNS;

		JLabel cell = lbl_cells[row][col];

		cell.setBackground(Color.YELLOW);
		cell.setOpaque(true);
		cell.repaint();
	}
}
