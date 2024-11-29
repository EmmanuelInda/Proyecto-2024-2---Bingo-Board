package ui;

import game.Game;

import ui.mycolors.MyColor;
import ui.panels.PatternPanel;
import ui.panels.PatternGrid;

import javax.swing.*;
import java.awt.*;

public class SetupFrame extends JFrame {
	JPanel pnl_header;
	JPanel pnl_options;
	JPanel pnl_patterns;

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
		pnl_header = new JPanel();
		pnl_header.setBackground(MyColor.BLUE);

		JLabel lbl_header = new JLabel("Bingo");
		lbl_header.setForeground(Color.WHITE);
		lbl_header.setFont(new Font("Arial", Font.BOLD, 36));
		pnl_header.add(lbl_header);

		add(pnl_header, BorderLayout.NORTH);
	}

	private void setOptions() {
		pnl_options = new JPanel();
		pnl_options.setPreferredSize(new Dimension(200, 768));
		pnl_options.setLayout(new BoxLayout(pnl_options, BoxLayout.Y_AXIS));
		pnl_options.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

		JLabel lbl_side = new JLabel("Menu");
		lbl_side.setFont(new Font("Arial", Font.BOLD, 18));
		lbl_side.setAlignmentX(Component.CENTER_ALIGNMENT);
		pnl_options.add(lbl_side);

		JButton button1 = new JButton("Start");
		button1.setAlignmentX(Component.CENTER_ALIGNMENT);

		button1.addActionListener(e -> {	
			if (currentPattern == null || currentPattern.length == 0) {
				JOptionPane.showMessageDialog(this, "Please select a valid pattern before starting the game.", "Error", JOptionPane.ERROR_MESSAGE);
			} else {
				new BingoBoard(new Game(currentPattern), new History());
				this.dispose();
			}
		});
	
		pnl_options.add(button1);

		JPanel pnl_placeholder = new JPanel();
		pnl_placeholder.setPreferredSize(new Dimension(180, 300));
		pnl_placeholder.setAlignmentX(Component.CENTER_ALIGNMENT);
		pnl_options.add(pnl_placeholder);
		
		JLabel newLabel = new JLabel("Selected grid");
		newLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		pnl_options.add(newLabel);

		JPanel pnl_preview = PatternGrid.createPatternGrid(null);
		pnl_preview.setPreferredSize(new Dimension(180, 80));
		pnl_preview.setAlignmentX(Component.CENTER_ALIGNMENT);
		pnl_options.add(pnl_preview);

		add(pnl_options, BorderLayout.WEST);
	}

	public void updatePreview(int[][] pattern) {
		JPanel pnl_preview = PatternGrid.createPatternGrid(pattern);
		pnl_preview.setPreferredSize(new Dimension(180, 80));
		pnl_preview.setAlignmentX(Component.CENTER_ALIGNMENT);
		pnl_options.remove(4);
		pnl_options.add(pnl_preview, 4);
		pnl_options.revalidate();
		pnl_options.repaint();
	}

	public void setCurrentPattern(int[][] currentPattern) {
		this.currentPattern = currentPattern;
	}

	private void setPatterns() {
		currentPattern = null;
		pnl_patterns = new PatternPanel(this);
		add(pnl_patterns, BorderLayout.CENTER);
	}
}
