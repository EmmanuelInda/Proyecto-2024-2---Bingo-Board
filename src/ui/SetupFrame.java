package ui;

import ui.panels.PatternsPanel;

import javax.swing.*;
import java.awt.*;

public class SetupFrame extends JFrame {
	public SetupFrame() {
		setTitle("Bingo (setup)");
		setPreferredSize(new Dimension(1366, 768));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		add(new PatternsPanel(), BorderLayout.CENTER);

		pack();
		setLocationRelativeTo(null);
		setResizable(false);
		setVisible(true);
	}
}
