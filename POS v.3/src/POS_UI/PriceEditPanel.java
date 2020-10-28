package POS_UI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import POS_Problem_Domain.Item;
import POS_Problem_Domain.Price;
import POS_Problem_Domain.PromoPrice;
import javax.swing.JCheckBox;

public class PriceEditPanel extends JPanel {

	private JTextField priceField;
	private JTextField dateTextField;
	private JLabel endDateLabel;
	private JTextField endDateField;
	private Price price;
	private PromoPrice promoPrice;
	private Boolean isPromo = false;

	/**
	 * Create the panel.
	 */
	public PriceEditPanel(JFrame currentFrame, JPanel currentPanel, Item item, Price priceIn, Boolean isAdd) {
		setLayout(null);

		price = priceIn; // Prepare common functionality for any Price
		
		endDateField = new JTextField();
		endDateField.setBounds(216, 136, 96, 19);
		endDateField.setVisible(false);
		add(endDateField);
		endDateField.setColumns(10);
		
		endDateLabel = new JLabel("End Date");
		endDateLabel.setBounds(136, 139, 45, 13);
		endDateLabel.setVisible(false);
		add(endDateLabel);		
		
		// Check if the price is a promoPrice, if it is set up that functionality too.
		if (priceIn instanceof PromoPrice) {
			isPromo = true;
			promoPrice = (PromoPrice) price;
		}
		if(isPromo) {
			endDateLabel.setVisible(true);
			
			String endDate = "";
			if (promoPrice.getEndDate() != null)
				endDate = promoPrice.getEndDate().format(DateTimeFormatter.ofPattern("M/d/yy")).toString();
			endDateField.setText(endDate);
			endDateField.setVisible(true);
		}
		
		JCheckBox promoPriceCheckBox = new JCheckBox("Promo Price");
		promoPriceCheckBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (isAdd) {
					if(promoPriceCheckBox.isSelected()) {
						isPromo = true;
						price = new PromoPrice();
						endDateLabel.setVisible(true);
						endDateField.setVisible(true);
					}
					else {
						isPromo = false;
						price = new Price();
						endDateLabel.setVisible(false);
						endDateField.setVisible(false);
					}
				}
			}
		});
		promoPriceCheckBox.setBounds(136, 40, 93, 21);
		if (!isAdd)
			promoPriceCheckBox.setEnabled(false);
		add(promoPriceCheckBox);

		JLabel priceEditLabel = new JLabel("Price Edit");
		priceEditLabel.setBounds(185, 10, 79, 13);
		add(priceEditLabel);
		
		JLabel priceLabel = new JLabel("Price");
		priceLabel.setBounds(136, 81, 45, 13);
		add(priceLabel);
		
		if (price.getPrice() != null)
			priceField = new JTextField(price.getPrice().toString());
		else
			priceField = new JTextField();
		priceField.setBounds(216, 78, 96, 19);
		add(priceField);
		priceField.setColumns(10);
		
		JLabel dateLabel = new JLabel("Effective Date");
		dateLabel.setBounds(136, 110, 68, 13);
		add(dateLabel);
		
		String dateString = "";
		if (price.getEffectiveDate() != null)
			dateString = price.getEffectiveDate().format(DateTimeFormatter.ofPattern("M/d/yy")).toString();
		dateTextField = new JTextField(dateString);
		dateTextField.setBounds(216, 107, 96, 19);
		add(dateTextField);
		dateTextField.setColumns(10);
		
		JButton saveButton = new JButton("Save");
		saveButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				price.setPrice(new BigDecimal(priceField.getText()));
				price.setEffectiveDate(LocalDate.parse(dateTextField.getText(), DateTimeFormatter.ofPattern("M/d/yy")));
				if(isAdd) item.addPrice(price);// If a duplicate with the same key exists, the old category will be lost, even if it was tied to Sessions. Need additional error checking here.
				currentFrame.getContentPane().removeAll();
				currentFrame.getContentPane().add(currentPanel);
				currentFrame.getContentPane().revalidate();
				currentFrame.getContentPane().repaint();
			}
		});
		saveButton.setBounds(93, 157, 85, 21);
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
		cancelButton.setBounds(271, 157, 85, 21);
		add(cancelButton);


	}
}
