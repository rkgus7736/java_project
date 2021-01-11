import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Dialog.ModalExclusionType;

public class MainUI {

	private JFrame mainFrame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainUI window = new MainUI();
					window.mainFrame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		mainFrame = new JFrame();
		mainFrame.setModalExclusionType(ModalExclusionType.TOOLKIT_EXCLUDE);
		mainFrame.setForeground(Color.LIGHT_GRAY);
		mainFrame.setTitle("Program name");
		mainFrame.setResizable(false);
		mainFrame.setBounds(100, 100, 722, 468);
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.getContentPane().setLayout(null);
		
		JButton btnLogin = new JButton("로그인");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoginUI loginUI = new LoginUI();
				loginUI.show();
			}
		});
		btnLogin.setBounds(96, 89, 140, 74);
		mainFrame.getContentPane().add(btnLogin);
		
		JButton btnPopup = new JButton("팝업");
		btnPopup.setBounds(422, 89, 174, 74);
		mainFrame.getContentPane().add(btnPopup);
	}
}







