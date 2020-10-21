package POS_UI;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class ItemEditPanel extends JPanel {
	private JTextField numberField;
	private JTextField descriptionField;

	/**
	 * Create the panel.
	 */
	public ItemEditPanel() {
		setLayout(null);
		
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
		
		JLabel lblNewLabel_3 = new JLabel("Tax Category:");
		lblNewLabel_3.setBounds(10, 126, 66, 13);
		add(lblNewLabel_3);
		
		JComboBox comboBox = new JComboBox();
		comboBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
			}
		});
		comboBox.setBounds(86, 125, 96, 21);
		add(comboBox);
		
		JList upcList = new JList();
		upcList.setBounds(10, 165, 210, 69);
		add(upcList);
		
		JButton upcAddButton = new JButton("Add");
		upcAddButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		upcAddButton.setBounds(10, 244, 66, 21);
		add(upcAddButton);
		
		JButton upcEditButton = new JButton("Edit");
		upcEditButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		upcEditButton.setBounds(83, 244, 66, 21);
		add(upcEditButton);
		
		JButton upcDeleteButton = new JButton("Delete");
		upcDeleteButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		upcDeleteButton.setBounds(154, 244, 66, 21);
		add(upcDeleteButton);
		
		JButton priceDeleteButton = new JButton("Delete");
		priceDeleteButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		priceDeleteButton.setBounds(374, 244, 66, 21);
		add(priceDeleteButton);
		
		JButton priceAddButton_1 = new JButton("Add");
		priceAddButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		priceAddButton_1.setBounds(230, 244, 66, 21);
		add(priceAddButton_1);
		
		JButton priceEditButton = new JButton("Edit");
		priceEditButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		priceEditButton.setBounds(303, 244, 66, 21);
		add(priceEditButton);
		
		JList priceList = new JList();
		priceList.setBounds(230, 165, 210, 69);
		add(priceList);
		
		JButton saveButton = new JButton("Save");
		saveButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		saveButton.setBounds(355, 91, 85, 21);
		add(saveButton);
		
		JButton cancelButton = new JButton("Cancel");
		cancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		cancelButton.setBounds(355, 125, 85, 21);
		add(cancelButton);

	}
}
