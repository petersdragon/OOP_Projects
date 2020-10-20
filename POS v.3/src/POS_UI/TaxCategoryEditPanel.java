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
	private JList<TaxRate> taxRatesDisplayList;
	private JButton editButton;
	private JButton deleteButton;
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
				taxRatesDisplayList.setModel(taxRateList);
			}
			public void ancestorMoved(AncestorEvent event) {
			}
			public void ancestorRemoved(AncestorEvent event) {
			}
		});
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Tax Category Edit");
		lblNewLabel.setBounds(171, 10, 108, 13);
		add(lblNewLabel);
		
		JLabel categoryLabel = new JLabel("Category:");
		categoryLabel.setBounds(21, 54, 63, 13);
		add(categoryLabel);
		
		categoryField = new JTextField(category.getCategory());
		categoryField.setBounds(91, 51, 96, 19);
		add(categoryField);
		categoryField.setColumns(10);
		
		JLabel taxRatesLabel = new JLabel("Tax Rates");
		taxRatesLabel.setBounds(290, 38, 60, 13);
		add(taxRatesLabel);
		

		DefaultListModel<TaxRate> taxRateList = new DefaultListModel<TaxRate>();
		
		for (TaxRate rate : category.getTaxRates())
			taxRateList.addElement(rate);
		
		taxRatesDisplayList = new JList<TaxRate>(taxRateList);
		taxRatesDisplayList.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				if (!taxRatesDisplayList.isSelectionEmpty()) {
					editButton.setEnabled(true);
					if (taxRatesDisplayList.getSelectedValue().isOKToDelete())
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
		taxRatesDisplayList.setBounds(217, 53, 212, 119);
		add(taxRatesDisplayList);
		
		JButton saveButton = new JButton("Save");
		saveButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				category.setCategory(categoryField.getText());
				if (isAdd) { store.addTaxCategory(category); } // If a duplicate with the same key exists, the old category will be lost, even if it was tied to Sessions. Need additional error checking here.
				currentFrame.getContentPane().removeAll();
				currentFrame.getContentPane().add(new TaxCategorySelectionPanel(currentFrame, store));
				currentFrame.getContentPane().revalidate();
			}
		});
		saveButton.setBounds(21, 182, 85, 21);
		add(saveButton);
		
		JButton cancelButton = new JButton("Cancel");
		cancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currentFrame.getContentPane().removeAll();
				currentFrame.getContentPane().add(new TaxCategorySelectionPanel(currentFrame, store));
				currentFrame.getContentPane().revalidate();
			}
		});
		cancelButton.setBounds(116, 182, 85, 21);
		add(cancelButton);
		
		JButton addButton = new JButton("Add");
		addButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currentFrame.getContentPane().removeAll();
				currentFrame.getContentPane().add(new TaxRateEditPanel(currentFrame, currentPanel, store, category, new TaxRate(), true));
				currentFrame.getContentPane().revalidate();
			}
		});
		addButton.setBounds(217, 182, 56, 21);
		add(addButton);
		
		editButton = new JButton("Edit");
		editButton.setEnabled(false);
		editButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currentFrame.getContentPane().removeAll();
				currentFrame.getContentPane().add(new TaxRateEditPanel(currentFrame, currentPanel, store, category, taxRatesDisplayList.getSelectedValue(), false));
				currentFrame.getContentPane().revalidate();
			}
		});
		editButton.setBounds(290, 182, 56, 21);
		add(editButton);
		
		deleteButton = new JButton("Delete");
		deleteButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TaxRate selectedRate = taxRatesDisplayList.getSelectedValue();
				if(selectedRate.isOKToDelete()) {
					category.removeTaxRate(selectedRate);
					taxRateList.removeElement(selectedRate);
					currentFrame.getContentPane().removeAll();
					currentFrame.getContentPane().add(new TaxCategoryEditPanel(currentFrame, store, category, isAdd));
					currentFrame.getContentPane().revalidate();
				}
			}
		});
		deleteButton.setBounds(360, 182, 69, 21);
		deleteButton.setEnabled(false);
		add(deleteButton);
		
	}
}
