package ui.panels;

import game.patterns.Pattern;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import ui.SetupFrame;

public class PatternPanel extends JPanel {
	private SetupFrame parentFrame;
	private JTabbedPane tab_grids;

	public PatternPanel(SetupFrame parentFrame) {
		this.parentFrame = parentFrame;

		this.setLayout(new BorderLayout());

		this.tab_grids = new JTabbedPane();

		this.tab_grids.addTab("5-in-a-Row", createPatternPanel(Pattern.getFiveInARowPatterns()));
		this.tab_grids.addTab("6-Pack", createPatternPanel(Pattern.getSixPackPatterns()));
		this.tab_grids.addTab("8 Patterns", createPatternPanel(Pattern.getEightPatterns()));

		this.add(tab_grids, BorderLayout.CENTER);
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

			JPanel wrapper = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 20));
			wrapper.setMaximumSize(new Dimension(120, 120));
			wrapper.setPreferredSize(new Dimension(120, 120));

			wrapper.add(patternGrid);
			panel.add(wrapper);
		}

		JPanel outerPanel = new JPanel(new BorderLayout());
		outerPanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
		outerPanel.add(panel, BorderLayout.CENTER);

		return outerPanel;
	}
}
