package POS_UI;

import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import POS_Problem_Domain.Store;

public class StoreEditPanel extends JPanel {
	private JTextField textField;

	/**
	 * Create the panel.
	 */
	public StoreEditPanel(JFrame currentFrame, Store store) {
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Store Edit");
		lblNewLabel.setBounds(181, 13, 56, 16);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Name:");
		lblNewLabel_1.setBounds(12, 63, 56, 16);
		add(lblNewLabel_1);
		
		textField = new JTextField(store.getName());
		textField.setBounds(68, 60, 116, 22);
		add(textField);
		textField.setColumns(10);

	}
}
