package ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainUI {

	private JFrame frmPersonmanageprogram;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainUI window = new MainUI();
					window.frmPersonmanageprogram.setVisible(true);
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
		frmPersonmanageprogram = new JFrame();
		frmPersonmanageprogram.setTitle("PersonManageProgram");
		frmPersonmanageprogram.setBounds(100, 100, 886, 575);
		frmPersonmanageprogram.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmPersonmanageprogram.getContentPane().setLayout(null);
		
		JButton btnRegister = new JButton("Person 정보 등록");
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegisterUI ui = new RegisterUI();
				ui.setVisible(true);
			}
		});
		btnRegister.setFont(new Font("굴림", Font.PLAIN, 18));
		btnRegister.setBounds(285, 37, 291, 62);
		frmPersonmanageprogram.getContentPane().add(btnRegister);
		
		JButton btnSearch = new JButton("Person 정보 조회");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PersonSearchUI ui = new PersonSearchUI();
				ui.setVisible(true);
			}
		});
		btnSearch.setFont(new Font("굴림", Font.PLAIN, 18));
		btnSearch.setBounds(285, 136, 291, 62);
		frmPersonmanageprogram.getContentPane().add(btnSearch);
		
		JButton btnSelectAll = new JButton("Person 전체 정보 조회");
		btnSelectAll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SelectAllPersonUI ui = new SelectAllPersonUI();
				ui.setVisible(true);
			}
		});
		btnSelectAll.setFont(new Font("굴림", Font.PLAIN, 18));
		btnSelectAll.setBounds(285, 241, 291, 62);
		frmPersonmanageprogram.getContentPane().add(btnSelectAll);
	}
}
