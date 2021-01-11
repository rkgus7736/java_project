package ui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import service.PersonService;

public class RegisterUI extends JFrame {

	private JPanel contentPane;
	private JTextField txtName;
	private JTextField txtAge;
	private JButton btnRegister;
	private JButton btnCancel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegisterUI frame = new RegisterUI();
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
	public RegisterUI() {
		setTitle("정보 등록창");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 261, 209);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Person 정보 등록창");
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setFont(new Font("굴림", Font.BOLD, 18));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(29, 10, 188, 51);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("이름");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setBounds(12, 65, 57, 15);
		contentPane.add(lblNewLabel_1);
		
		txtName = new JTextField();
		txtName.setBounds(81, 62, 116, 21);
		contentPane.add(txtName);
		txtName.setColumns(10);
		
		txtAge = new JTextField();
		txtAge.setColumns(10);
		txtAge.setBounds(81, 96, 116, 21);
		contentPane.add(txtAge);
		
		JLabel lblNewLabel_1_1 = new JLabel("나이");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_1.setBounds(12, 99, 57, 15);
		contentPane.add(lblNewLabel_1_1);
		
		btnRegister = new JButton("등록");
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//이름 데이터가 있는지?
				String name = txtName.getText();
				if(name.isEmpty()) {
					JOptionPane.showMessageDialog(
							btnRegister, "이름 데이터가 없습니다.");
					return;
				}
				//나이 데이터가 있는지?
				String age = txtAge.getText();
				if(age.isEmpty()) {
					JOptionPane.showMessageDialog(
							btnRegister, "나이 데이터를 입력하세요");
					return;
				}
				System.out.println(name + " , " + age);
				//PersonService로 전송
				int a = Integer.parseInt(age);
				try {
					PersonService.getInstance().insertPerson(name, a);
					JOptionPane.showMessageDialog(
							btnRegister, "데이터 등록 성공");
					dispose();
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(
							btnRegister, "데이터 등록 실패");
				}
				
			}
		});
		btnRegister.setBounds(45, 127, 72, 23);
		contentPane.add(btnRegister);
		
		btnCancel = new JButton("취소");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCancel.setBounds(127, 127, 71, 23);
		contentPane.add(btnCancel);
	}
}
