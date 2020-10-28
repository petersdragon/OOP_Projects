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
	private JTextField itemNumberField;
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
				DefaultListModel<UPC> UPCList = new DefaultListModel<UPC>();
				for (UPC upc : item.getUpcs().values())
					UPCList.addElement(upc);	
				upcList.setModel(UPCList);
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
		
		JLabel itemNumberLabel = new JLabel("Item Number:");
		itemNumberLabel.setBounds(0, 60, 66, 13);
		add(itemNumberLabel);
		
		itemNumberField = new JTextField(item.getNumber());
		itemNumberField.setBounds(75, 60, 96, 19);
		add(itemNumberField);
		itemNumberField.setColumns(10);
		
		JLabel descriptionLabel = new JLabel("Description:");
		descriptionLabel.setBounds(0, 94, 66, 13);
		add(descriptionLabel);
		
		descriptionField = new JTextField(item.getDescription());
		descriptionField.setBounds(75, 94, 161, 19);
		add(descriptionField);
		descriptionField.setColumns(10);
		
		JLabel cetegoryLabel_3 = new JLabel("Tax Category:");
		cetegoryLabel_3.setBounds(0, 126, 66, 13);
		add(cetegoryLabel_3);
		
		DefaultComboBoxModel<TaxCategory> categoryList = new DefaultComboBoxModel<TaxCategory>();
		
		for (TaxCategory category : store.getTaxCategories().values())
			categoryList.addElement(category);	
		JComboBox<TaxCategory> comboBox = new JComboBox<TaxCategory>(categoryList);
		comboBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
			}
		});
		comboBox.setBounds(75, 125, 96, 21);
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
		upcList.setBounds(243, 26, 111, 69);
		add(upcList);
		
		upcAddButton = new JButton("Add");
		upcAddButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currentFrame.getContentPane().removeAll();
				currentFrame.getContentPane().add(new UPCEditPanel(currentFrame, currentPanel, item, new UPC(), true));
				currentFrame.getContentPane().revalidate();
			}
		});
		upcAddButton.setBounds(358, 32, 60, 21);
		add(upcAddButton);
		
		upcEditButton = new JButton("Edit");
		upcEditButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currentFrame.getContentPane().removeAll();
				currentFrame.getContentPane().add(new UPCEditPanel(currentFrame, currentPanel, item, upcList.getSelectedValue(), false));
				currentFrame.getContentPane().revalidate();
			}
		});
		upcEditButton.setBounds(358, 53, 60, 21);
		upcEditButton.setEnabled(false);
		add(upcEditButton);
		
		upcDeleteButton = new JButton("Del");
		upcDeleteButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(upcList.getSelectedValue().isOKToDelete()) { // Needs additional work in isOKToDelete()
					item.removeUPC(upcList.getSelectedValue());
					upcs.removeElement(upcList.getSelectedValue());
					currentFrame.getContentPane().removeAll();
					currentFrame.getContentPane().add(currentPanel);
					currentFrame.getContentPane().revalidate();
				}
			}  
		});
		upcDeleteButton.setBounds(358, 74, 60, 21);
		upcDeleteButton.setEnabled(false);
		add(upcDeleteButton);
		
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
		priceList.setBounds(243, 117, 111, 69);
		add(priceList);
		
		priceAddButton = new JButton("Add");
		priceAddButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currentFrame.getContentPane().removeAll();
				currentFrame.getContentPane().add(new PriceEditPanel(currentFrame, currentPanel, item, new Price(), true));
				currentFrame.getContentPane().revalidate();
			}
		});
		priceAddButton.setBounds(358, 122, 60, 21);
		add(priceAddButton);
		
		priceEditButton = new JButton("Edit");
		priceEditButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currentFrame.getContentPane().removeAll();
				currentFrame.getContentPane().add(new PriceEditPanel(currentFrame, currentPanel, item, priceList.getSelectedValue(), false));
				currentFrame.getContentPane().revalidate();
			}
		});
		priceEditButton.setBounds(358, 144, 60, 21);
		priceEditButton.setEnabled(false);
		add(priceEditButton);
		
		priceDeleteButton = new JButton("Del");
		priceDeleteButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(priceList.getSelectedValue().isOKToDelete()) { // Needs additional work in isOKToDelete()
					item.removePrice(priceList.getSelectedValue());
					upcs.removeElement(priceList.getSelectedValue());
					currentFrame.getContentPane().removeAll();
					currentFrame.getContentPane().add(currentPanel);
					currentFrame.getContentPane().revalidate();
				}
			}
		});
		priceDeleteButton.setBounds(358, 165, 60, 21);
		priceDeleteButton.setEnabled(false);
		add(priceDeleteButton);
		
		JButton saveButton = new JButton("Save");
		saveButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				item.setNumber(itemNumberField.getText());
				item.setDescription(descriptionField.getText());
				item.setTaxCategory((TaxCategory)comboBox.getSelectedItem()); // add TaxCategory to item
				if (isAdd) { store.addItem(item); } // If the item is already taken, it overrides the old one, even if it's tied to things. This needs added error checking.
				currentFrame.getContentPane().removeAll();
				currentFrame.getContentPane().add(new ItemSelectionPanel(currentFrame, store));
				currentFrame.getContentPane().revalidate();
			}
		});
		saveButton.setBounds(53, 165, 85, 21);
		add(saveButton);
		
		JButton cancelButton = new JButton("Cancel");
		cancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currentFrame.getContentPane().removeAll();
				currentFrame.getContentPane().add(new ItemSelectionPanel(currentFrame, store));
				currentFrame.getContentPane().revalidate();
			}
		});
		cancelButton.setBounds(148, 165, 85, 21);
		add(cancelButton);

	}
}
