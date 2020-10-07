package POS_UI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;

import POS_Problem_Domain.Cashier;
import POS_Problem_Domain.Store;

public class CashierSelectionPanel extends JPanel {

	/**
	 * Create the panel.
	 */
	public CashierSelectionPanel(JFrame currentFrame, Store store) {
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Cashier Selection List");
		lblNewLabel.setBounds(158, 5, 133, 16);
		add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Add");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currentFrame.getContentPane().removeAll();
				currentFrame.getContentPane().add(new CashierEditPanel(currentFrame, store, new Cashier()));
				currentFrame.getContentPane().revalidate();

			}
		});
		btnNewButton.setBounds(12, 195, 97, 25);
		add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Edit");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnNewButton_1.setBounds(131, 195, 97, 25);
		add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Delete");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnNewButton_2.setBounds(247, 195, 97, 25);
		add(btnNewButton_2);
		
		JList list = new JList();
		list.setBounds(88, 168, 256, -111);
		add(list);
		
		JList list_1 = new JList();
		list_1.setBounds(69, 41, 249, 146);
		add(list_1);

	}

}
