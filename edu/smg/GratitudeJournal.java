package edu.smg;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class GratitudeJournal {
	public static void main(String[] args) {

		JFrame frame = new JFrame("Gratitude Journal");
		frame.setSize(350, 200);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// main containers and Layouts
		JPanel mainPanel = new JPanel();
		frame.add(mainPanel);
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.X_AXIS));

		JPanel leftPanel = new JPanel();
		mainPanel.add(leftPanel);
		leftPanel.setLayout(new BoxLayout(leftPanel, BoxLayout.Y_AXIS));

		JPanel rightPanel = new JPanel();
		mainPanel.add(rightPanel);
		rightPanel.setLayout(new BoxLayout(rightPanel, BoxLayout.Y_AXIS));

		// left side
		JLabel gratituteJournalLabel = new JLabel("Gratitutde journal");
		leftPanel.add(gratituteJournalLabel);

		JTextArea journalArea = new JTextArea();
		journalArea.setBounds(100, 20, 165, 25);
		journalArea.setEditable(false);
		journalArea.setText("Here are the journal logs from previous days");
		leftPanel.add(journalArea);

		// right side
		SimpleDateFormat ft = new SimpleDateFormat("dd. M yyyy");
		JLabel currentDateLabel = new JLabel(ft.format(new Date()));
		rightPanel.add(currentDateLabel);

		JTextField gratitudeText_1 = new JTextField();
		rightPanel.add(gratitudeText_1);
		JTextField gratitudeText_2 = new JTextField();
		rightPanel.add(gratitudeText_2);
		JTextField gratitudeText_3 = new JTextField();
		rightPanel.add(gratitudeText_3);

		JButton thankButton = new JButton("Thanks");
		rightPanel.add(thankButton);
		
		JLabel inspirationLabel = new JLabel("How we spend our days is of course "
				+ "how we spend our lives.");
		rightPanel.add(inspirationLabel);

		frame.pack();
		// Setting the frame visibility to true
		frame.setVisible(true);

	}
}
