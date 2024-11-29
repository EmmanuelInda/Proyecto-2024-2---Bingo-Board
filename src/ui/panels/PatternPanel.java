package ui.panels;

import game.patterns.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import ui.SetupFrame;

public class PatternPanel extends JPanel {
	private SetupFrame parentFrame;
	private JTabbedPane tabGrids;

	public PatternPanel(SetupFrame parentFrame) {
		this.parentFrame = parentFrame;

		this.setLayout(new BorderLayout());

		this.tabGrids = new JTabbedPane();

		this.tabGrids.addTab("5-in-a-Row", createPatternPanel(FiveInARowPattern.getPatterns()));
		this.tabGrids.addTab("6-Pack", createPatternPanel(SixPackPattern.getPatterns()));
		this.tabGrids.addTab("8 Patterns", createPatternPanel(EightPattern.getPatterns()));

		this.add(tabGrids, BorderLayout.CENTER);
	}

	private JPanel createPatternPanel(ArrayList<int[][]> patterns) {
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(0, 6, 0, 0));

		for (int[][] pattern : patterns) {
			JPanel patternGrid = PatternGrid.createPatternGrid(pattern);
			
			patternGrid.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					parentFrame.setCurrentPattern(pattern);
					parentFrame.updatePreview(pattern);
				}
			});

			patternGrid.setPreferredSize(new Dimension(120, 120));

			JPanel pnlWrapper = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 20));
			pnlWrapper.setMaximumSize(new Dimension(120, 120));
			pnlWrapper.setPreferredSize(new Dimension(120, 120));

			pnlWrapper.add(patternGrid);
			panel.add(pnlWrapper);
		}

		JPanel pnlOuter = new JPanel(new BorderLayout());
		pnlOuter.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
		pnlOuter.add(panel, BorderLayout.CENTER);

		return pnlOuter;
	}
}
