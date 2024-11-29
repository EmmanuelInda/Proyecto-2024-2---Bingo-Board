package ui;

import game.Game;

import ui.mycolors.MyColor;
import ui.panels.PatternPanel;
import ui.panels.PatternGrid;

import javax.swing.*;
import java.awt.*;

public class SetupFrame extends JFrame {
	JPanel pnlHeader;
	JPanel pnlOptions;
	JPanel pnlPatterns;

	int currentPattern[][];

	public SetupFrame() {
		setTitle("Bingo (setup)");
		setPreferredSize(new Dimension(1366, 768));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setLayout(new BorderLayout());

		setHeader();
		setOptions();
		setPatterns();

		pack();
		setLocationRelativeTo(null);
		setResizable(false);
		setVisible(true);
	}

	private void setHeader() {
		pnlHeader = new JPanel();
		pnlHeader.setBackground(MyColor.BLUE);

		JLabel lblHeader = new JLabel("Bingo");
		lblHeader.setForeground(Color.WHITE);
		lblHeader.setFont(new Font("Arial", Font.BOLD, 36));
		pnlHeader.add(lblHeader);

		add(pnlHeader, BorderLayout.NORTH);
	}

	private void setOptions() {
		pnlOptions = new JPanel();
		pnlOptions.setPreferredSize(new Dimension(200, 768));
		pnlOptions.setLayout(new BoxLayout(pnlOptions, BoxLayout.Y_AXIS));
		pnlOptions.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

		JLabel lblSide = new JLabel("Menu");
		lblSide.setFont(new Font("Arial", Font.BOLD, 18));
		lblSide.setAlignmentX(Component.CENTER_ALIGNMENT);
		pnlOptions.add(lblSide);

		JButton btnStart = new JButton("Start");
		btnStart.setAlignmentX(Component.CENTER_ALIGNMENT);

		btnStart.addActionListener(e -> {	
			if (currentPattern == null || currentPattern.length == 0) {
				JOptionPane.showMessageDialog(this, "Please select a valid pattern before starting the game.", "Error", JOptionPane.ERROR_MESSAGE);
			} else {
				new CardUI(new Game(currentPattern), new HistoryUI());
				this.dispose();
			}
		});
	
		pnlOptions.add(btnStart);

		JPanel pnlPlaceHolder = new JPanel();
		pnlPlaceHolder.setPreferredSize(new Dimension(180, 300));
		pnlPlaceHolder.setAlignmentX(Component.CENTER_ALIGNMENT);
		pnlOptions.add(pnlPlaceHolder);
		
		JLabel lbl_selectGrid = new JLabel("Selected grid");
		lbl_selectGrid.setAlignmentX(Component.CENTER_ALIGNMENT);
		pnlOptions.add(lbl_selectGrid);

		JPanel pnlPreview = PatternGrid.createPatternGrid(null);
		pnlPreview.setPreferredSize(new Dimension(180, 80));
		pnlPreview.setAlignmentX(Component.CENTER_ALIGNMENT);
		pnlOptions.add(pnlPreview);

		add(pnlOptions, BorderLayout.WEST);
	}

	public void updatePreview(int[][] pattern) {
		JPanel pnlPreview = PatternGrid.createPatternGrid(pattern);

		pnlPreview.setPreferredSize(new Dimension(180, 80));
		pnlPreview.setAlignmentX(Component.CENTER_ALIGNMENT);
		pnlOptions.remove(4);
		pnlOptions.add(pnlPreview, 4);
		pnlOptions.revalidate();
		pnlOptions.repaint();
	}

	public void setCurrentPattern(int[][] currentPattern) {
		this.currentPattern = currentPattern;
	}

	private void setPatterns() {
		currentPattern = null;
		pnlPatterns = new PatternPanel(this);
		add(pnlPatterns, BorderLayout.CENTER);
	}
}
