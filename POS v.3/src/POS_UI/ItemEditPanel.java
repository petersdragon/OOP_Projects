package POS_UI;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;

import POS_Problem_Domain.Item;
import POS_Problem_Domain.Price;
import POS_Problem_Domain.Store;
import POS_Problem_Domain.TaxCategory;
import POS_Problem_Domain.TaxRate;
import POS_Problem_Domain.UPC;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.event.AncestorListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.AncestorEvent;

public class ItemEditPanel extends JPanel {
	private JTextField numberField;
	private JTextField descriptionField;
	private JList<UPC> upcList;
	private JButton upcAddButton;
	private JButton upcEditButton;
	private JButton upcDeleteButton;
	private JButton priceAddButton;
	private JButton priceEditButton;
	private JButton priceDeleteButton;
	/**
	 * Create the panel.
	 */
	public ItemEditPanel(JFrame currentFrame, Store store, Item item, Boolean isAdd) {
		addAncestorListener(new AncestorListener() {
			public void ancestorAdded(AncestorEvent event) {
			}
			public void ancestorMoved(AncestorEvent event) {
			}
			public void ancestorRemoved(AncestorEvent event) {
			}
		});
		setLayout(null);
		JPanel currentPanel = this;

		JLabel itemPanelLabel = new JLabel("Item Edit");
		itemPanelLabel.setBounds(202, 10, 45, 13);
		add(itemPanelLabel);
		
		JLabel itemNumberField = new JLabel("Item Number:");
		itemNumberField.setBounds(10, 60, 66, 13);
		add(itemNumberField);
		
		numberField = new JTextField();
		numberField.setBounds(86, 60, 96, 19);
		add(numberField);
		numberField.setColumns(10);
		
		JLabel descriptionLabel = new JLabel("Description:");
		descriptionLabel.setBounds(10, 94, 66, 13);
		add(descriptionLabel);
		
		descriptionField = new JTextField();
		descriptionField.setBounds(86, 94, 161, 19);
		add(descriptionField);
		descriptionField.setColumns(10);
		
		JLabel cetegoryLabel_3 = new JLabel("Tax Category:");
		cetegoryLabel_3.setBounds(10, 126, 66, 13);
		add(cetegoryLabel_3);
		
		DefaultComboBoxModel<TaxCategory> categoryList = new DefaultComboBoxModel<TaxCategory>();
		
		for (TaxCategory category : store.getTaxCategories().values())
			categoryList.addElement(category);	
		JComboBox<TaxCategory> comboBox = new JComboBox<TaxCategory>(categoryList);
		comboBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
			}
		});
		comboBox.setBounds(86, 125, 96, 21);
		add(comboBox);
		
		DefaultListModel<UPC> upcs = new DefaultListModel<UPC>();
		
		for (UPC upc : item.getUpcs().values())
			upcs.addElement(upc);
		
		upcList = new JList<UPC>(upcs);
		upcList.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				if (!upcList.isSelectionEmpty()) {
					upcEditButton.setEnabled(true);
					upcDeleteButton.setEnabled(true);
				}
				else {
					upcEditButton.setEnabled(false);
					upcDeleteButton.setEnabled(false);
				}
			}
		});
		upcList.setBounds(10, 165, 210, 69);
		add(upcList);
		
		upcAddButton = new JButton("Add");
		upcAddButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		upcAddButton.setBounds(10, 244, 66, 21);
		add(upcAddButton);
		
		upcEditButton = new JButton("Edit");
		upcEditButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		upcEditButton.setBounds(83, 244, 66, 21);
		add(upcEditButton);
		
		upcDeleteButton = new JButton("Delete");
		upcDeleteButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		upcDeleteButton.setBounds(154, 244, 66, 21);
		add(upcDeleteButton);
		
		priceDeleteButton = new JButton("Delete");
		priceDeleteButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		priceDeleteButton.setBounds(374, 244, 66, 21);
		add(priceDeleteButton);
		
		priceAddButton = new JButton("Add");
		priceAddButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		priceAddButton.setBounds(230, 244, 66, 21);
		add(priceAddButton);
		
		priceEditButton = new JButton("Edit");
		priceEditButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		priceEditButton.setBounds(303, 244, 66, 21);
		add(priceEditButton);
		
		DefaultListModel<Price> prices = new DefaultListModel<Price>();
		for (Price price : item.getPrices())
			prices.addElement(price);
		
		JList<Price> priceList = new JList<Price>(prices);
		priceList.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				if (!priceList.isSelectionEmpty()) {
					priceEditButton.setEnabled(true);
					priceDeleteButton.setEnabled(true);
				}
				else {
					priceEditButton.setEnabled(false);
					priceDeleteButton.setEnabled(false);
				}
			}
		});
		priceList.setBounds(230, 165, 210, 69);
		add(priceList);
		
		JButton saveButton = new JButton("Save");
		saveButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				item.setNumber(itemNumberField.getText());
				item.setDescription(descriptionField.getText());
				item.setTaxCategory((TaxCategory)comboBox.getSelectedItem());
				if (isAdd) { store.addItem(item); } // If the employee number is already taken, it overrides the old employee, even if it's tied to Sessions. This needs added error checking.

			}
		});
		saveButton.setBounds(355, 91, 85, 21);
		add(saveButton);
		
		JButton cancelButton = new JButton("Cancel");
		cancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currentFrame.getContentPane().removeAll();
				currentFrame.getContentPane().add(new ItemSelectionPanel(currentFrame, store));
				currentFrame.getContentPane().revalidate();
			}
		});
		cancelButton.setBounds(355, 125, 85, 21);
		add(cancelButton);

	}
}
