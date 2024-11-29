package ui.panels;

import ui.mycolors.MyColor;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

public class PatternGrid extends JPanel {
	public static JPanel createPatternGrid(int[][] pattern) {
		if (pattern == null) {
			JPanel pnlNull = new JPanel();
			
			pnlNull.setBorder(new LineBorder(Color.BLACK, 1));
			pnlNull.add(new JLabel("null"));

			return pnlNull;
		}

		JPanel pnlGrids = new JPanel();
		pnlGrids.setLayout(new GridLayout(pattern.length, pattern[0].length));

		for (int[] row : pattern) {
			for (int cell : row) {
				JLabel lblCell = new JLabel();

				lblCell.setOpaque(true);
				lblCell.setBackground(cell == 1 ? MyColor.BLUE : Color.WHITE);
				lblCell.setBorder(BorderFactory.createLineBorder(Color.BLACK));
				pnlGrids.add(lblCell);
			}
		}

		return pnlGrids;
	}
}
