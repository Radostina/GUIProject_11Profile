package edu.smg;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

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
		leftPanel.add(journalArea);
		File myObj = new File("filename.txt");
		String text = "";
		try {
			Scanner myReader = new Scanner(myObj);
			while (myReader.hasNextLine()) {
				text += myReader.nextLine() + "\n";
			}
			myReader.close();
		} catch (FileNotFoundException e) {
			try {
				myObj.createNewFile();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		journalArea.setText(text);

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

		JButton thanksButton = new JButton("Thanks");
		thanksButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				String gratitude1 = gratitudeText_1.getText();
				String gratitude2 = gratitudeText_2.getText();
				String gratitude3 = gratitudeText_3.getText();
				if (gratitude1.isEmpty() && gratitude2.isEmpty() && gratitude3.isEmpty()) {
					return;
				}
				String text = 
						currentDateLabel.getText() + "\n"
				+ gratitude1 + "\n"
				+ gratitude2 + "\n" 
				+ gratitude3 + "\n";
				try {
					FileWriter myWriter = new FileWriter("filename.txt",true);
					myWriter.write(text);
					myWriter.close();

				} catch (IOException e) {
					System.out.println("An error occurred.");
					e.printStackTrace();
				}
				
				File myObj = new File("filename.txt");
				text = "";
				try {
					Scanner myReader = new Scanner(myObj);
					while (myReader.hasNextLine()) {
						text += myReader.nextLine() + "\n";
					}
					myReader.close();
				} catch (FileNotFoundException e) {
					try {
						myObj.createNewFile();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				journalArea.setText(text);

			}
		});
		rightPanel.add(thanksButton);

		JLabel inspirationLabel = new JLabel("How we spend our days is of course " + "how we spend our lives.");
		rightPanel.add(inspirationLabel);

		frame.pack();
		// Setting the frame visibility to true
		frame.setVisible(true);

	}
}
