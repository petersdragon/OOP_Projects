package POS_UI;

import javax.swing.JPanel;

import POS_Problem_Domain.Cashier;
import POS_Problem_Domain.Store;

import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class CashierEditPanel extends JPanel {
	private JTextField numberField;
	private JTextField nameField;

	/**
	 * Create the panel.
	 */
	public CashierEditPanel(JFrame currentFrame, Store store, Cashier cashier, Boolean isAdd) {
		setLayout(null);
		
		JButton btnNewButton = new JButton("Cancel");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currentFrame.getContentPane().removeAll();
				currentFrame.getContentPane().add(new CashierSelectionPanel(currentFrame, store));
				currentFrame.getContentPane().revalidate();
			}
		});
		btnNewButton.setBounds(262, 154, 94, 25);
		add(btnNewButton);
		
		JLabel panelLabel = new JLabel("Cashier Edit Panel");
		panelLabel.setBounds(154, 13, 103, 16);
		add(panelLabel);
		
		JLabel numberLabel = new JLabel("Number:");
		numberLabel.setBounds(34, 63, 56, 16);
		add(numberLabel);
		
		JLabel nameLabel = new JLabel("Name:");
		nameLabel.setBounds(34, 120, 56, 16);
		add(nameLabel);
		
		numberField = new JTextField(cashier.getNumber());
		numberField.setBounds(107, 60, 116, 22);
		add(numberField);
		numberField.setColumns(10);
		
		nameField = new JTextField(cashier.getPerson().getName());
		nameField.setBounds(102, 117, 116, 22);
		add(nameField);
		nameField.setColumns(10);
		
		JButton saveButton = new JButton("Save");
		saveButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cashier.setNumber(numberField.getText());
				cashier.getPerson().setName(nameField.getText());
				if (isAdd) { store.addCashier(cashier); }
				currentFrame.getContentPane().removeAll();
				currentFrame.getContentPane().add(new CashierSelectionPanel(currentFrame, store));
				currentFrame.getContentPane().revalidate();
			}
		});
		saveButton.setBounds(70, 154, 97, 25);
		add(saveButton);
		
	}
}
