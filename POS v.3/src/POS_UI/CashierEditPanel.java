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
	private JTextField addressField;
	private JTextField cityField;
	private JTextField stateField;
	private JTextField zipField;
	private JTextField phoneField;
	private JTextField ssnField;

	/**
	 * Create the panel.
	 */
	public CashierEditPanel(JFrame currentFrame, Store store, Cashier cashier, Boolean isAdd) {
		setLayout(null);
		
		JButton cancelButton = new JButton("Cancel");
		cancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currentFrame.getContentPane().removeAll();
				currentFrame.getContentPane().add(new CashierSelectionPanel(currentFrame, store));
				currentFrame.getContentPane().revalidate();
			}
		});
		cancelButton.setBounds(210, 177, 94, 25);
		add(cancelButton);
		
		JButton saveButton = new JButton("Save");
		saveButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cashier.setNumber(numberField.getText());
				cashier.getPerson().setName(nameField.getText());
				cashier.getPerson().setAddress(addressField.getText());
				cashier.getPerson().setCity(cityField.getText());
				cashier.getPerson().setState(stateField.getText());
				cashier.getPerson().setZip(zipField.getText());
				cashier.getPerson().setPhone(phoneField.getText());
				cashier.getPerson().setSSN(ssnField.getText());
				if (isAdd) { store.addCashier(cashier); } // If the employee number is already taken, it overrides the old employee, even if it's tied to Sessions. This needs added error checking.
				currentFrame.getContentPane().removeAll();
				currentFrame.getContentPane().add(new CashierSelectionPanel(currentFrame, store));
				currentFrame.getContentPane().revalidate();
			}
		});
		saveButton.setBounds(103, 177, 97, 25);
		add(saveButton);
		
		JLabel panelLabel = new JLabel("Cashier Edit Panel");
		panelLabel.setBounds(154, 13, 103, 16);
		add(panelLabel);
		
		JLabel numberLabel = new JLabel("Number:");
		numberLabel.setBounds(10, 63, 56, 16);
		add(numberLabel);

		numberField = new JTextField(cashier.getNumber());
		numberField.setBounds(57, 63, 116, 22);
		add(numberField);
		numberField.setColumns(10);
		
		JLabel nameLabel = new JLabel("Name:");
		nameLabel.setBounds(10, 89, 56, 16);
		add(nameLabel);
		
		nameField = new JTextField(cashier.getPerson().getName());
		nameField.setBounds(57, 90, 116, 22);
		add(nameField);
		nameField.setColumns(10);
		
		JLabel addressLabel = new JLabel("Address:");
		addressLabel.setBounds(10, 115, 45, 13);
		add(addressLabel);
		
		addressField = new JTextField(cashier.getPerson().getAddress());
		addressField.setBounds(57, 115, 116, 19);
		add(addressField);
		addressField.setColumns(10);
		
		JLabel cityLabel = new JLabel("City:");
		cityLabel.setBounds(251, 63, 45, 13);
		add(cityLabel);
		
		cityField = new JTextField(cashier.getPerson().getCity());
		cityField.setBounds(284, 63, 116, 19);
		add(cityField);
		cityField.setColumns(10);
		
		JLabel stateLabel = new JLabel("State:");
		stateLabel.setBounds(251, 86, 45, 13);
		add(stateLabel);
		
		stateField = new JTextField(cashier.getPerson().getState());
		stateField.setBounds(284, 86, 116, 19);
		add(stateField);
		stateField.setColumns(10);
		
		JLabel zipLabel = new JLabel("Zip:");
		zipLabel.setBounds(251, 114, 45, 13);
		add(zipLabel);
		
		zipField = new JTextField(cashier.getPerson().getZip());
		zipField.setBounds(284, 111, 116, 19);
		add(zipField);
		zipField.setColumns(10);
		
		JLabel phoneLabel = new JLabel("Phone:");
		phoneLabel.setBounds(10, 141, 45, 13);
		add(phoneLabel);
		
		phoneField = new JTextField(cashier.getPerson().getPhone());
		phoneField.setBounds(57, 138, 116, 19);
		add(phoneField);
		phoneField.setColumns(10);
		
		JLabel ssnLabel = new JLabel("SSN:");
		ssnLabel.setBounds(251, 141, 45, 13);
		add(ssnLabel);
		
		ssnField = new JTextField(cashier.getPerson().getSSN());
		ssnField.setBounds(284, 137, 116, 19);
		add(ssnField);
		ssnField.setColumns(10);
		
	}
}
