import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Dialog.ModalExclusionType;

public class LoginUI extends JFrame {

	private JPanel contentPane;
	private JTextField txtId;
	private JPasswordField txtPasswd;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginUI frame = new LoginUI();
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
	public LoginUI() {
		setTitle("로그인");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 356, 214);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("아이디");
		lblNewLabel.setBounds(51, 31, 57, 15);
		contentPane.add(lblNewLabel);
		
		txtId = new JTextField();
		lblNewLabel.setLabelFor(txtId);
		txtId.setBounds(120, 31, 137, 21);
		contentPane.add(txtId);
		txtId.setColumns(5);
		
		JLabel lblNewLabel_1 = new JLabel("암호");
		lblNewLabel_1.setBounds(51, 67, 57, 15);
		contentPane.add(lblNewLabel_1);
		
		txtPasswd = new JPasswordField();
		txtPasswd.setBounds(120, 62, 137, 21);
		contentPane.add(txtPasswd);
		
		JButton btnLogin = new JButton("로그인");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("아이디 : " + txtId.getText());
				System.out.println("암호 : " + txtPasswd.getText());
				txtId.setText("");
				txtPasswd.setText("");
			}
		});
		btnLogin.setBounds(51, 106, 97, 23);
		contentPane.add(btnLogin);
		
		JButton btnCancel = new JButton("취소");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();//현재 창만 종료
			}
		});
		btnCancel.setBounds(160, 106, 97, 23);
		contentPane.add(btnCancel);
	}
}
