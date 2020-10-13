import javax.swing.JFrame;
import javax.swing.JPanel;

import POS_Problem_Domain.Register;
import POS_Problem_Domain.Store;
import POS_UI.CashierSelectionPanel;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RegisterEditPanel extends JPanel {
	private JTextField textField;

	/**
	 * Create the panel.
	 */
	public RegisterEditPanel(JFrame currentFrame, Store store, Register register, Boolean isAdd) {
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Register Edit");
		lblNewLabel.setBounds(185, 10, 45, 13);
		add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(148, 73, 96, 19);
		add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Number");
		lblNewLabel_1.setBounds(74, 76, 45, 13);
		add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("Save");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				register.setNumber(textField.getText());
				if (isAdd) { store.addRegister(register); }
				currentFrame.getContentPane().removeAll();
				currentFrame.getContentPane().add(new RegisterSelectionPanel(currentFrame, store));
				currentFrame.getContentPane().revalidate();
			}
		});
		btnNewButton.setBounds(63, 194, 85, 21);
		add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Cancel");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currentFrame.getContentPane().removeAll();
				currentFrame.getContentPane().add(new RegisterSelectionPanel(currentFrame, store));
				currentFrame.getContentPane().revalidate();
			}
		});
		btnNewButton_1.setBounds(238, 194, 85, 21);
		add(btnNewButton_1);

		
	}
}
