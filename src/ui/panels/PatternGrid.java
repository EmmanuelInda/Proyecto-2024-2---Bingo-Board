package ui.panels;

import ui.mycolors.MyColor;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

public class PatternGrid extends JPanel {
	public static JPanel createPatternGrid(int[][] pattern) {
		if (pattern == null) {
			JPanel nullPanel = new JPanel();
			nullPanel.setBorder(new LineBorder(Color.BLACK, 1));
			nullPanel.add(new JLabel("null"));

			return nullPanel;
		}

		JPanel gridPanel = new JPanel();
		gridPanel.setLayout(new GridLayout(pattern.length, pattern[0].length));

		for (int[] row : pattern) {
			for (int cell : row) {
				JLabel cellLabel = new JLabel();
				cellLabel.setOpaque(true);
				cellLabel.setBackground(cell == 1 ? MyColor.BLUE : Color.WHITE);
				cellLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
				gridPanel.add(cellLabel);
			}
		}

		return gridPanel;
	}
}
