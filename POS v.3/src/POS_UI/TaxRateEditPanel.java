package POS_UI;

import javax.swing.JFrame;
import javax.swing.JPanel;

import POS_Problem_Domain.Store;
import POS_Problem_Domain.TaxCategory;
import POS_Problem_Domain.TaxRate;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.awt.event.ActionEvent;

public class TaxRateEditPanel extends JPanel {
	private JTextField rateField;
	private JTextField dateTextField;

	/**
	 * Create the panel.
	 */
	public TaxRateEditPanel(JFrame currentFrame, JPanel currentPanel, Store store, TaxCategory taxCategory, TaxRate taxRate, Boolean isAdd) {
		setLayout(null);
		
		JLabel ratePanelLabel = new JLabel("Tax Rate Edit");
		ratePanelLabel.setBounds(185, 10, 79, 13);
		add(ratePanelLabel);
		
		JLabel rateLabel = new JLabel("Rate");
		rateLabel.setBounds(137, 43, 45, 13);
		add(rateLabel);
		
		String rateString = "";
		String dateString = "";
		if (!isAdd) {
			rateString = taxRate.getTaxRate().toString();
			dateString = taxRate.getEffectiveDate().format(DateTimeFormatter.ofPattern("M/d/yy")).toString();
		}
		
		rateField = new JTextField(rateString);
		rateField.setBounds(217, 40, 96, 19);
		add(rateField);
		rateField.setColumns(10);
		
		JLabel dateLabel = new JLabel("Start Date");
		dateLabel.setBounds(137, 72, 68, 13);
		add(dateLabel);
		
		dateTextField = new JTextField(dateString);
		dateTextField.setBounds(217, 69, 96, 19);
		add(dateTextField);
		dateTextField.setColumns(10);
		
		JButton saveButton = new JButton("Save");
		saveButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				taxRate.setTaxRate(new BigDecimal(rateField.getText()));
				taxRate.setEffectiveDate(LocalDate.parse(dateTextField.getText(), DateTimeFormatter.ofPattern("M/d/yy")));
				if(isAdd) taxCategory.addTaxRate(taxRate);// If a duplicate with the same key exists, the old category will be lost, even if it was tied to Sessions. Need additional error checking here.
				currentFrame.getContentPane().removeAll();
				currentFrame.getContentPane().add(currentPanel);
				currentFrame.getContentPane().revalidate();
				currentFrame.getContentPane().repaint();
			}
		});
		saveButton.setBounds(93, 136, 85, 21);
		add(saveButton);
		
		JButton cancelButton = new JButton("Cancel");
		cancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currentFrame.getContentPane().removeAll();
				currentFrame.getContentPane().add(currentPanel);
				currentFrame.getContentPane().revalidate();
				currentFrame.getContentPane().repaint();
			}
		});
		cancelButton.setBounds(271, 136, 85, 21);
		add(cancelButton);
	}
}
