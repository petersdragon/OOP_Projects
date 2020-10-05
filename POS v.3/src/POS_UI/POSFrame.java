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
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("Maintenance");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Store");
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getContentPane().removeAll();
				getContentPane().add(new StoreEditPanel(currentFrame,store));
				getContentPane().revalidate();
			}
		});
		mnNewMenu.add(mntmNewMenuItem_2);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Cashier");
		mnNewMenu.add(mntmNewMenuItem);
		
		JMenu mnNewMenu_2 = new JMenu("POS");
		menuBar.add(mnNewMenu_2);
		
		JMenu mnNewMenu_3 = new JMenu("Reports");
		menuBar.add(mnNewMenu_3);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		getContentPane().removeAll();
		getContentPane().add(new POSHomePanel());
		getContentPane().revalidate();
		
	}
}
