package POS_UI;

import javax.swing.JFrame;
import javax.swing.JPanel;

import POS_Problem_Domain.Cashier;
import POS_Problem_Domain.Store;
import POS_Problem_Domain.TaxCategory;
import POS_Problem_Domain.TaxRate;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.AncestorListener;
import javax.swing.event.AncestorEvent;

public class TaxCategoryEditPanel extends JPanel {
	private JTextField categoryField;
	
	/**
	 * Create the panel.
	 */
	public TaxCategoryEditPanel(JFrame currentFrame, Store store, TaxCategory category, Boolean isAdd) {
		
		JPanel currentPanel = this;
		addAncestorListener(new AncestorListener() {
			public void ancestorAdded(AncestorEvent event) {
				DefaultListModel<TaxRate> taxRateList = new DefaultListModel<TaxRate>();
				for (TaxRate rate : category.getTaxRates())
					taxRateList.addElement(rate);	
			}
			public void ancestorMoved(AncestorEvent event) {
			}
			public void ancestorRemoved(AncestorEvent event) {
			}
		});
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Tax Category Edit");
		lblNewLabel.setBounds(165, 10, 45, 13);
		add(lblNewLabel);
		
		JLabel categoryLabel = new JLabel("Category:");
		categoryLabel.setBounds(21, 54, 45, 13);
		add(categoryLabel);
		
		categoryField = new JTextField();
		categoryField.setBounds(76, 51, 96, 19);
		add(categoryField);
		categoryField.setColumns(10);
		
		JLabel taxRatesLabel = new JLabel("Tax Rates");
		taxRatesLabel.setBounds(305, 38, 45, 13);
		add(taxRatesLabel);
		

		DefaultListModel<TaxRate> taxRateList = new DefaultListModel<TaxRate>();
		
		for (TaxRate rate : category.getTaxRates())
			taxRateList.addElement(rate);
		
		JList<TaxRate> taxRatesDisplayList = new JList<TaxRate>(taxRateList);
		taxRatesDisplayList.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
			}
		});
		taxRatesDisplayList.setBounds(240, 53, 189, 119);
		add(taxRatesDisplayList);
		
		JButton saveButton = new JButton("Save");
		saveButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				category.setCategory(categoryField.getText());
				if (isAdd) { store.addTaxCategory(category); }
				currentFrame.getContentPane().removeAll();
				currentFrame.getContentPane().add(new CashierSelectionPanel(currentFrame, store));
				currentFrame.getContentPane().revalidate();
			}
		});
		saveButton.setBounds(47, 214, 85, 21);
		add(saveButton);
		
		JButton cancelButton = new JButton("Cancel");
		cancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currentFrame.getContentPane().removeAll();
				currentFrame.getContentPane().add(new TaxCategorySelectionPanel(currentFrame, store));
				currentFrame.getContentPane().revalidate();
			}
		});
		cancelButton.setBounds(142, 214, 85, 21);
		add(cancelButton);
		
		JButton addButton = new JButton("Add");
		addButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currentFrame.getContentPane().removeAll();
				currentFrame.getContentPane().add(new TaxRateEditPanel(currentFrame, currentPanel, store, category, new TaxRate(), isAdd));
				currentFrame.getContentPane().revalidate();
			}
		});
		addButton.setBounds(240, 182, 56, 21);
		add(addButton);
		
		JButton editButton = new JButton("Edit");
		editButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currentFrame.getContentPane().removeAll();
				currentFrame.getContentPane().add(new TaxRateEditPanel(currentFrame, currentPanel, store, category, taxRatesDisplayList.getSelectedValue(), true));
				currentFrame.getContentPane().revalidate();
			}
		});
		editButton.setBounds(305, 182, 56, 21);
		add(editButton);
		
		JButton deleteButton = new JButton("Delete");
		deleteButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TaxRate rate = taxRatesDisplayList.getSelectedValue();
				if(rate.isOKToDelete()) {
					category.removeTaxRate(rate);
					taxRateList.removeElement(category);
				}
			}
		});
		deleteButton.setBounds(371, 182, 69, 21);
		add(deleteButton);
		
	}
}
