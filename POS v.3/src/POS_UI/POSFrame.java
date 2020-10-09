package POS_UI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import POS_Problem_Domain.Store;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class POSFrame extends JFrame {

	private JPanel contentPane;
	JFrame currentFrame = this;

	/**
	 * Launch the application.
	 */
	public static void open(Store store) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					POSFrame frame = new POSFrame(store);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public POSFrame(Store store) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		currentFrame = this;
		
		// Add the Menu bar to navigate to the different panels
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		// Add and define behavior for menu option "Maintenance"
		JMenu mnNewMenu = new JMenu("Maintenance");
		menuBar.add(mnNewMenu);
		
		// Add and define behavior for menu option "Cashier"
		JMenuItem mntmNewMenuItem = new JMenuItem("Cashier");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getContentPane().removeAll();
				getContentPane().add(new CashierSelectionPanel(currentFrame,store));
				getContentPane().revalidate();				
			}
		});
		mnNewMenu.add(mntmNewMenuItem);
		
		// Add and define behavior for menu option "Item"
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("Item");
		mntmNewMenuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getContentPane().removeAll();
				getContentPane().add(new ItemSelectionPanel(currentFrame,store));
				getContentPane().revalidate();				
			}
		});
		mnNewMenu.add(mntmNewMenuItem_3);
		
		// Add and define behavior for menu option "Store"
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Store");
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getContentPane().removeAll();
				getContentPane().add(new StoreEditPanel(currentFrame,store));
				getContentPane().revalidate();
			}
		});
		
		// Add and define behavior for menu option "Register"
		JMenuItem mntmNewMenuItem_4 = new JMenuItem("Register");
		mntmNewMenuItem_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getContentPane().removeAll();
				getContentPane().add(new RegisterSelectionPanel(currentFrame,store));
				getContentPane().revalidate();				
			}
		});
		mnNewMenu.add(mntmNewMenuItem_4);
		mnNewMenu.add(mntmNewMenuItem_2);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Tax Category");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getContentPane().removeAll();
				getContentPane().add(new TaxCategorySelectionPanel(currentFrame,store));
				getContentPane().revalidate();				
			}
		});
		mnNewMenu.add(mntmNewMenuItem_1);
		
		JMenu mnNewMenu_2 = new JMenu("POS");
		menuBar.add(mnNewMenu_2);
		
		JMenu mnNewMenu_3 = new JMenu("Reports");
		menuBar.add(mnNewMenu_3);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		getContentPane().removeAll();
		getContentPane().add(new POSHomePanel(store));
		getContentPane().revalidate();
		
	}
}
