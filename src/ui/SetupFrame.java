package ui;

import ui.mycolors.MyColor;
import ui.panels.PatternsPanel;

import javax.swing.*;
import java.awt.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class SetupFrame extends JFrame {
	JPanel headerPanel;
	JPanel optionsPanel;

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
		headerPanel = new JPanel();
		headerPanel.setBackground(MyColor.BLUE);

		JLabel headerLabel = new JLabel("Bingo");
		headerLabel.setForeground(Color.WHITE);
		headerLabel.setFont(new Font("Arial", Font.BOLD, 36));
		headerPanel.add(headerLabel);

		add(headerPanel, BorderLayout.NORTH);
	}

	private void setOptions() {
		optionsPanel = new JPanel();
		optionsPanel.setPreferredSize(new Dimension(200, 768));
		optionsPanel.setLayout(new BoxLayout(optionsPanel, BoxLayout.Y_AXIS));

		JLabel sideLabel = new JLabel("Options");
		sideLabel.setFont(new Font("Arial", Font.BOLD, 18));
		sideLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		optionsPanel.add(sideLabel);

		JButton button1 = new JButton("Option 1");
		button1.setAlignmentX(Component.CENTER_ALIGNMENT);
		optionsPanel.add(button1);

		JButton button2 = new JButton("Option 2");
		button2.setAlignmentX(Component.CENTER_ALIGNMENT);
		optionsPanel.add(button2);

		JLabel sliderLabel = new JLabel("Range Selector:");
		sliderLabel.setFont(new Font("Arial", Font.PLAIN, 14));
		sliderLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		optionsPanel.add(sliderLabel);

		JLabel sliderValueLabel = new JLabel("Selected Value: 40");
		sliderValueLabel.setFont(new Font("Arial", Font.PLAIN, 14));
		sliderValueLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		optionsPanel.add(sliderValueLabel);

		JSlider slider = new JSlider(5, 75, 40);
		slider.setMajorTickSpacing(10);
		slider.setMinorTickSpacing(5);
		slider.setPaintTicks(true);
		slider.setPaintLabels(true);
		slider.setAlignmentX(Component.CENTER_ALIGNMENT);

		slider.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				int value = slider.getValue();
				sliderValueLabel.setText("Selected Value: " + value);
			}
		});
		optionsPanel.add(slider);

		add(optionsPanel, BorderLayout.WEST);
	}

	private void setPatterns() {
		add(new PatternsPanel(), BorderLayout.CENTER);
	}
}
