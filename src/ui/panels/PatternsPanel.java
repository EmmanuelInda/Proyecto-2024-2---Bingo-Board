package ui.panels;

import game.patterns.Patterns;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class PatternsPanel extends JPanel {
	public PatternsPanel() {
		setLayout(new BorderLayout());

		JTabbedPane tabbedPane = new JTabbedPane();

		tabbedPane.addTab("5-in-a-Row", createPatternPanel(new Patterns().getFiveInARowPatterns()));
		tabbedPane.addTab("6-Pack", createPatternPanel(new Patterns().getSixPackPatterns()));
		tabbedPane.addTab("8 Patterns", createPatternPanel(new Patterns().getEightPatterns()));

		add(tabbedPane, BorderLayout.CENTER);
	}

	private JPanel createPatternPanel(ArrayList<int[][]> patterns) {
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(0, 6, 10, 10)); // 3 columns, adjustable

		for (int[][] pattern : patterns) {
			panel.add(createPatternGrid(pattern));
		}

		return panel;
	}

	private JPanel createPatternGrid(int[][] pattern) {
		JPanel gridPanel = new JPanel();
		gridPanel.setLayout(new GridLayout(pattern.length, pattern[0].length));

		for (int[] row : pattern) {
			for (int cell : row) {
				JLabel cellLabel = new JLabel();
				cellLabel.setOpaque(true);
				cellLabel.setBackground(cell == 1 ? Color.BLUE : Color.WHITE);
				cellLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
				gridPanel.add(cellLabel);
			}
		}

		return gridPanel;
	}

	public static void main(String[] args) {
		// Create and display the frame
		JFrame frame = new JFrame("Patterns Display");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(800, 600);
		frame.add(new PatternsPanel());
		frame.setVisible(true);
	}
}
