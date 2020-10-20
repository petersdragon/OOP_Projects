package POS_UI;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JButton;

public class ItemSelectionPanel extends JPanel {

	/**
	 * Create the panel.
	 */
	public ItemSelectionPanel() {
		setLayout(null);
		
		JLabel itemPanelLabel = new JLabel("Items");
		itemPanelLabel.setBounds(206, 5, 37, 13);
		add(itemPanelLabel);
		
		JList itemsList = new JList();
		itemsList.setBounds(66, 33, 317, 155);
		add(itemsList);
		
		JButton addButton = new JButton("Add");
		addButton.setBounds(66, 212, 85, 21);
		add(addButton);
		
		JButton editButton = new JButton("Edit");
		editButton.setBounds(180, 212, 85, 21);
		add(editButton);
		
		JButton deleteButton = new JButton("Delete");
		deleteButton.setBounds(298, 212, 85, 21);
		add(deleteButton);

	}
}
