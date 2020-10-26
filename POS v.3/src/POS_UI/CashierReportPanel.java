package POS_UI;

import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import com.github.lgooddatepicker.components.DatePicker;

import POS_Problem_Domain.Store;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CashierReportPanel extends JPanel {

	/**
	 * Create the panel.
	 */
	public CashierReportPanel(JFrame currentFrame, Store store) {
		setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(22, 101, 418, 138);
		add(scrollPane);
		
		JTextArea textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		
		JLabel lblNewLabel = new JLabel("Cashier Report");
		lblNewLabel.setBounds(197, 10, 45, 13);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Date:");
		lblNewLabel_1.setBounds(59, 57, 45, 13);
		add(lblNewLabel_1);
		
		JButton generateButton = new JButton("Generate");
		generateButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// get date
				//generate date
				// Show panel
			}
		});
		generateButton.setBounds(62, 250, 85, 21);
		add(generateButton);
		
		JButton cancelButton = new JButton("Cancel");
		cancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		cancelButton.setBounds(240, 250, 85, 21);
		add(cancelButton);
		
		DatePicker datePicker = new DatePicker();
		datePicker.getComponentToggleCalendarButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		datePicker.setBounds(90, 55, 126, 19);
		add(datePicker);

	}
}
