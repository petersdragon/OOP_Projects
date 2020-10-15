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
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Create the panel.
	 */
	public TaxRateEditPanel(JFrame currentFrame, Store store, TaxCategory taxCategory, TaxRate taxRate, Boolean isAdd, Boolean isRateAdd) {
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Tax Rate Edit");
		lblNewLabel.setBounds(167, 10, 45, 13);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Rate");
		lblNewLabel_1.setBounds(24, 43, 45, 13);
		add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(79, 40, 96, 19);
		add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Start Date");
		lblNewLabel_2.setBounds(24, 76, 45, 13);
		add(lblNewLabel_2);
		
		textField_1 = new JTextField();
		textField_1.setBounds(79, 69, 96, 19);
		add(textField_1);
		textField_1.setColumns(10);
		
		JButton saveButton = new JButton("Save");
		saveButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				taxRate.setTaxRate(new BigDecimal(textField.getText()));
				taxRate.setEffectiveDate(LocalDate.parse(textField.getText(), DateTimeFormatter.ofPattern("M/d/yy")));
				if(isRateAdd) taxCategory.addTaxRate(taxRate);
			}
		});
		saveButton.setBounds(10, 136, 85, 21);
		add(saveButton);
		
		JButton cancelButton = new JButton("Cancel");
		cancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currentFrame.getContentPane().removeAll();
				currentFrame.getContentPane().add(new TaxCategoryEditPanel(currentFrame, store, taxCategory, isAdd));
				currentFrame.getContentPane().revalidate();
			}
		});
		cancelButton.setBounds(127, 136, 85, 21);
		add(cancelButton);

	}

}
