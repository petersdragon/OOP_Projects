package POS_UI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;

import POS_Problem_Domain.Cashier;
import POS_Problem_Domain.Store;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;

public class CashierSelectionPanel extends JPanel {

	/**
	 * Create the panel.
	 */
	public CashierSelectionPanel(JFrame currentFrame, Store store) {
		setLayout(null);
		
		JButton editButton = new JButton("Edit");
		JButton deleteButton = new JButton("Delete");
		
		JLabel lblNewLabel = new JLabel("Cashier Selection List");
		lblNewLabel.setBounds(158, 5, 133, 16);
		add(lblNewLabel);
		
		DefaultListModel<Cashier> cashierList = new DefaultListModel<Cashier>();
		
		for (Cashier cashier : store.getCashiers().values())
			cashierList.addElement(cashier);	
		
		JList<Cashier> cashierDisplayList = new JList<Cashier>(cashierList);
		cashierDisplayList.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				if (!cashierDisplayList.isSelectionEmpty()) {
					editButton.setEnabled(true);
					if (cashierDisplayList.getSelectedValue().isOKToDelete())
						deleteButton.setEnabled(true);
				}
				else {
					editButton.setEnabled(false);
					deleteButton.setEnabled(false);
				}
			}
		});
		cashierDisplayList.setBounds(100, 41, 249, 146);
		add(cashierDisplayList);
		
		JButton addButton = new JButton("Add");
		addButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currentFrame.getContentPane().removeAll();
				currentFrame.getContentPane().add(new CashierEditPanel(currentFrame, store, new Cashier(), true));
				currentFrame.getContentPane().revalidate();
			}
		});
		addButton.setBounds(39, 195, 97, 25);
		add(addButton);
		
		editButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Cashier cashier = cashierDisplayList.getSelectedValue();
				currentFrame.getContentPane().removeAll();
				currentFrame.getContentPane().add(new CashierEditPanel(currentFrame, store, cashier, false));
				currentFrame.getContentPane().revalidate();
			}
		});
		editButton.setBounds(175, 195, 97, 25);
		editButton.setEnabled(false);
		add(editButton);
		
		deleteButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Cashier cashier = cashierDisplayList.getSelectedValue();
				if(cashier.isOKToDelete()) {
					store.removeCashier(cashier);
					cashierList.removeElement(cashier);
				}
			}
		});
		deleteButton.setBounds(311, 195, 97, 25);
		deleteButton.setEnabled(false);
		add(deleteButton);


	}
}
