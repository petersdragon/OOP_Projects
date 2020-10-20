package POS_UI;
import javax.swing.JFrame;
import javax.swing.JPanel;

import POS_Problem_Domain.Register;
import POS_Problem_Domain.Store;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RegisterEditPanel extends JPanel {
	private JTextField numberField;

	/**
	 * Create the panel.
	 */
	public RegisterEditPanel(JFrame currentFrame, Store store, Register register, Boolean isAdd) {
		setLayout(null);
		
		JLabel registerLabel = new JLabel("Register Edit");
		registerLabel.setBounds(184, 10, 82, 13);
		add(registerLabel);
		
		numberField = new JTextField(register.getNumber());
		numberField.setBounds(203, 73, 96, 19);
		add(numberField);
		numberField.setColumns(10);
		
		JLabel numberLabel = new JLabel("Number");
		numberLabel.setBounds(148, 76, 45, 13);
		add(numberLabel);
		
		JButton saveButton = new JButton("Save");
		saveButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				register.setNumber(numberField.getText());
				if (isAdd) { store.addRegister(register); } // If the number is already taken, it overrides the old register, even if it's tied to Sessions. This needs added error checking.
				currentFrame.getContentPane().removeAll();
				currentFrame.getContentPane().add(new RegisterSelectionPanel(currentFrame, store));
				currentFrame.getContentPane().revalidate();
			}
		});
		saveButton.setBounds(93, 194, 85, 21);
		add(saveButton);
		
		JButton cancelButton = new JButton("Cancel");
		cancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currentFrame.getContentPane().removeAll();
				currentFrame.getContentPane().add(new RegisterSelectionPanel(currentFrame, store));
				currentFrame.getContentPane().revalidate();
			}
		});
		cancelButton.setBounds(271, 194, 85, 21);
		add(cancelButton);

		
	}
}
