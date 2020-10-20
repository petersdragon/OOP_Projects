package POS_UI;

import javax.swing.JPanel;

import POS_Problem_Domain.Store;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;

public class POSHomePanel extends JPanel {

	/**
	 * Create the panel.
	 * @param store 
	 */
	public POSHomePanel(Store store) {
		setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel(store.getName());
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(138, 42, 173, 53);
		add(lblNewLabel_1);

	}
}
