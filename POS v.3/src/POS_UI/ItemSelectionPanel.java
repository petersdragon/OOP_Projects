package POS_UI;
import javax.swing.JPanel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import POS_Problem_Domain.Item;
import POS_Problem_Domain.Store;
import POS_Problem_Domain.TaxCategory;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ItemSelectionPanel extends JPanel {

	private JButton addButton;
	private JButton editButton;
	private JButton deleteButton;

	/**
	 * Create the panel.
	 */
	public ItemSelectionPanel(JFrame currentFrame, Store store) {
		setLayout(null);
		
		JLabel itemPanelLabel = new JLabel("Items");
		itemPanelLabel.setBounds(206, 5, 37, 13);
		add(itemPanelLabel);
		
		DefaultListModel<Item> itemList = new DefaultListModel<Item>();
		
		for (Item item : store.getItems().values())
			itemList.addElement(item);	
		
		JList<Item> list = new JList<Item>(itemList);
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
		list.setBounds(66, 33, 317, 155);
		add(list);
		
		addButton = new JButton("Add");
		addButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currentFrame.getContentPane().removeAll();
				currentFrame.getContentPane().add(new ItemEditPanel(currentFrame, store, new Item(), true));
				currentFrame.getContentPane().revalidate();
			}
		});
		addButton.setBounds(66, 212, 85, 21);
		add(addButton);
		
		editButton = new JButton("Edit");
		editButton.setEnabled(false);
		editButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currentFrame.getContentPane().removeAll();
				currentFrame.getContentPane().add(new ItemEditPanel(currentFrame, store, list.getSelectedValue(), true));
				currentFrame.getContentPane().revalidate();
			}
		});
		editButton.setBounds(180, 212, 85, 21);
		add(editButton);
		
		deleteButton = new JButton("Delete");
		deleteButton.setEnabled(false);
		deleteButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Item item = list.getSelectedValue();
				if(item.isOKToDelete()) {
					store.removeItem(item);
					itemList.removeElement(item);
				}
			}
		});
		deleteButton.setBounds(298, 212, 85, 21);
		add(deleteButton);

	}
}
