package POS_UI;
import javax.swing.JPanel;

import POS_Problem_Domain.Register;
import POS_Problem_Domain.Store;
import POS_Problem_Domain.TaxCategory;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;

public class TaxCategorySelectionPanel extends JPanel {

	/**
	 * Create the panel.
	 */
	private JButton addButton;
	private JButton editButton;
	private JButton deleteButton;
	public TaxCategorySelectionPanel(JFrame currentFrame, Store store) {
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Tax Category List");
		lblNewLabel.setBounds(174, 10, 101, 13);
		add(lblNewLabel);
		
		DefaultListModel<TaxCategory> categoryList = new DefaultListModel<TaxCategory>();
		
		for (TaxCategory category : store.getTaxCategories().values())
			categoryList.addElement(category);	
		
		JList<TaxCategory> list = new JList<TaxCategory>(categoryList);
		list.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				if (!list.isSelectionEmpty()) {
					editButton.setEnabled(true);
					if (list.getSelectedValue().isOKToDelete())
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
		list.setBounds(126, 43, 197, 127);
		add(list);
		
		addButton = new JButton("Add");
		addButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currentFrame.getContentPane().removeAll();
				currentFrame.getContentPane().add(new TaxCategoryEditPanel(currentFrame, store, new TaxCategory(), true));
				currentFrame.getContentPane().revalidate();
			}
		});
		addButton.setBounds(48, 180, 85, 21);
		add(addButton);
		
		editButton = new JButton("Edit");
		editButton.setEnabled(false);
		editButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currentFrame.getContentPane().removeAll();
				currentFrame.getContentPane().add(new TaxCategoryEditPanel(currentFrame, store, list.getSelectedValue(), true));
				currentFrame.getContentPane().revalidate();
			}
		});
		editButton.setBounds(181, 180, 85, 21);
		add(editButton);
		
		deleteButton = new JButton("Delete");
		deleteButton.setEnabled(false);
		deleteButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TaxCategory category = list.getSelectedValue();
				if(category.isOKToDelete()) {
					store.removeTaxCategory(category);
					categoryList.removeElement(category);
				}
			}
		});
		deleteButton.setBounds(314, 180, 85, 21);
		add(deleteButton);

	}
}
