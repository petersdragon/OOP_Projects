package POS_UI;

import javax.swing.JPanel;
import javax.swing.JTextField;

import POS_Problem_Domain.Item;
import POS_Problem_Domain.UPC;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class UPCEditPanel extends JPanel {
	private JTextField upcField;

	/**
	 * Create the panel.
	 */
	public UPCEditPanel(JFrame currentFrame, JPanel currentPanel, Item item, UPC upc, Boolean isAdd) {
		setLayout(null);
		
		JLabel UPCEditLabel = new JLabel("UPC Edit");
		UPCEditLabel.setBounds(197, 13, 56, 16);
		add(UPCEditLabel);
		
		JLabel upcLabel = new JLabel("UPC:");
		upcLabel.setBounds(85, 74, 56, 16);
		add(upcLabel);
		
		upcField = new JTextField(upc.getUpc());
		upcField.setBounds(141, 71, 116, 22);
		add(upcField);
		upcField.setColumns(10);
		
		JButton saveButton = new JButton("Save");
		saveButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				upc.setUpc(upcField.getText());
				if(isAdd) item.addUPC(upc); // If a duplicate with the same key exists, the old category will be lost, even if it was tied to Sessions. Need additional error checking here.
				currentFrame.getContentPane().removeAll();
				currentFrame.getContentPane().add(currentPanel);
				currentFrame.getContentPane().revalidate();
				currentFrame.getContentPane().repaint();
				
			}
		});
		saveButton.setBounds(85, 136, 97, 25);
		add(saveButton);
		
		JButton cancelButton = new JButton("Cancel");
		cancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currentFrame.getContentPane().removeAll();
				currentFrame.getContentPane().add(currentPanel);
				currentFrame.getContentPane().revalidate();
				currentFrame.getContentPane().repaint();
			}
		});
		cancelButton.setBounds(267, 136, 97, 25);
		add(cancelButton);

	}
}
