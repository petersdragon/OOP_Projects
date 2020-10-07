package POS_UI;

import javax.swing.JPanel;

import POS_Problem_Domain.Store;

import javax.swing.JLabel;

public class POSHomePanel extends JPanel {

	/**
	 * Create the panel.
	 * @param store 
	 */
	public POSHomePanel(Store store) {
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Welcome to the Store");
		lblNewLabel.setBounds(156, 13, 137, 16);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel(store.getName());
		lblNewLabel_1.setBounds(138, 42, 173, 53);
		add(lblNewLabel_1);

	}
}
