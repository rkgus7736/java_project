package ui;

import java.awt.Component;
import java.awt.Event;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import service.PersonService;
import vo.PersonVO;
import java.awt.event.KeyAdapter;

public class PersonSearchUI extends JFrame {

	private JPanel contentPane;
	private JTextField txtSearch;
	private JEditorPane resultView;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PersonSearchUI frame = new PersonSearchUI();
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
	public PersonSearchUI() {
		setTitle("Person정보 검색");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 415, 251);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		  
		
		
		JLabel lblNewLabel = new JLabel("이름");
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setBounds(12, 14, 37, 15);
		contentPane.add(lblNewLabel);
		
		txtSearch = new JTextField();
		txtSearch.addKeyListener(new KeyAdapter() {
			boolean flag = true;
			@Override
			public void keyReleased(KeyEvent e) {
				 if(e.getKeyCode() == 10) {
					 flag = !flag;
					 if(flag) return;
					if(txtSearch.getText().isEmpty()) {
						JOptionPane.showMessageDialog(null, "이름을 입력하세요");
						return;
					}
					try {
						ArrayList<PersonVO> list = 
								PersonService.getInstance().selectPerson(txtSearch.getText());
						String result = "";
						for(int i=0;i<list.size();i++) {
							result += list.get(i).toString()+"\n";
						}
						if(list.size() == 0)
							result = "검색 결과가 없습니다.";
						resultView.setText(result);
					} catch (Exception e1) {
						e1.printStackTrace();
					}
				}
					
			}
		});
		txtSearch.setBounds(61, 11, 182, 21);
		contentPane.add(txtSearch);
		txtSearch.setColumns(10);
		
		resultView = new JEditorPane();
		resultView.setEditable(false);
		resultView.setBounds(16, 55, 365, 140);
		contentPane.add(resultView);
		
		JButton btnSearch = new JButton("검색");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(txtSearch.getText().isEmpty()) {
					JOptionPane.showMessageDialog(btnSearch, "이름을 입력하세요");
					return;
				}
				try {
					ArrayList<PersonVO> list = 
							PersonService.getInstance().selectPerson(txtSearch.getText());
					String result = "";
					for(int i=0;i<list.size();i++) {
						result += list.get(i).toString()+"\n";
					}
					if(list.size() == 0)
						result = "검색 결과가 없습니다.";
					resultView.setText(result);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		btnSearch.setBounds(244, 10, 64, 23);
		contentPane.add(btnSearch);
		
		JButton btnClear = new JButton("초기화");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtSearch.setText("");
				resultView.setText("");
			}
		});
		btnClear.setBounds(312, 10, 69, 23);
		contentPane.add(btnClear);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(0, 39, 399, 6);
		contentPane.add(separator);
		
	
	}
}
