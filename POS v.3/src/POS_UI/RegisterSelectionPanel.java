package POS_UI;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.event.ListSelectionListener;

import POS_Problem_Domain.Cashier;
import POS_Problem_Domain.Register;
import POS_Problem_Domain.Store;

import javax.swing.event.ListSelectionEvent;

public class RegisterSelectionPanel extends JPanel {

	/**
	 * Create the panel.
	 */
	private JButton addButton; //= new 
	private JButton editButton; //= new JButton("Edit");
	private JButton deleteButton; //= new JButton("Delete");
	
	public RegisterSelectionPanel(JFrame currentFrame, Store store) {
		setLayout(null);

		
		JLabel lblNewLabel = new JLabel("Register List");
		lblNewLabel.setBounds(139, 10, 85, 13);
		add(lblNewLabel);
		
		DefaultListModel<Register> registerList = new DefaultListModel<Register>();
		
		for (Register register : store.getRegisters().values())
			registerList.addElement(register);	
		
		JList<Register> registerDisplayList = new JList<Register>(registerList);
		registerDisplayList.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				if (!registerDisplayList.isSelectionEmpty()) {
					editButton.setEnabled(true);
					if (registerDisplayList.getSelectedValue().isOKToDelete())
						deleteButton.setEnabled(true);
					else
						deleteButton.setEnabled(false);
				}
				else {
					editButton.setEnabled(false);
					deleteButton.setEnabled(false);
				}
			}
		});
		registerDisplayList.setBounds(116, 33, 182, 149);
		add(registerDisplayList);
		
		addButton = new JButton("Add");
		addButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currentFrame.getContentPane().removeAll();
				currentFrame.getContentPane().add(new RegisterEditPanel(currentFrame, store, new Register(), true));
				currentFrame.getContentPane().revalidate();
			}
		});
		addButton.setBounds(58, 192, 85, 21);
		add(addButton);
		
		editButton = new JButton("Edit");
		editButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currentFrame.getContentPane().removeAll();
				currentFrame.getContentPane().add(new RegisterEditPanel(currentFrame, store, registerDisplayList.getSelectedValue(), true));
				currentFrame.getContentPane().revalidate();
			}
		});
		editButton.setBounds(168, 192, 85, 21);
		editButton.setEnabled(false);
		add(editButton);
		
		deleteButton = new JButton("Delete");
		deleteButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Register register = registerDisplayList.getSelectedValue();
				if(register.isOKToDelete()) {
					store.removeRegister(register);
					registerList.removeElement(register);
				}
			}
		});
		deleteButton.setBounds(281, 192, 85, 21);
		deleteButton.setEnabled(false);
		add(deleteButton);

	}
}
