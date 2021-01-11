package ui;

import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import service.PersonService;
import vo.PersonVO;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class UpdatePersonUI extends JFrame {

	private JPanel contentPane;
	private JLabel lblSearchName;
	private JTextField txtName;
	private JTextField txtAge;

	/**
	 * Create the frame.
	 */
	public UpdatePersonUI(String name) {

		
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 294, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblSearchName = new JLabel("New label");
		lblSearchName.setBounds(43, 10, 167, 22);
		lblSearchName.setText(name);
		contentPane.add(lblSearchName);
		
		JLabel lblNewLabel = new JLabel("수정할 이름");
		lblNewLabel.setBounds(43, 70, 74, 15);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("수정할 나이");
		lblNewLabel_1.setBounds(43, 107, 74, 15);
		contentPane.add(lblNewLabel_1);
		
		txtName = new JTextField();
		txtName.setBounds(129, 67, 116, 21);
		contentPane.add(txtName);
		txtName.setColumns(10);
		
		txtAge = new JTextField();
		txtAge.setColumns(10);
		txtAge.setBounds(129, 104, 116, 21);
		contentPane.add(txtAge);
		
		JButton btnUpdate = new JButton("수정");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = lblSearchName.getText();
				PersonVO p = new PersonVO(txtName.getText(),
						Integer.parseInt(txtAge.getText()));
				try {
					PersonService.getInstance().updatePerson(name, p);
					//SelectAllPersonUI model을 다시 최신화
					SelectAllPersonUI.setDefaultModel();
					//최신화 시킨후 종료
					dispose();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		btnUpdate.setBounds(39, 161, 97, 23);
		contentPane.add(btnUpdate);
		
		JButton btnCancel = new JButton("취소");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCancel.setBounds(148, 161, 97, 23);
		contentPane.add(btnCancel);
	}

}



