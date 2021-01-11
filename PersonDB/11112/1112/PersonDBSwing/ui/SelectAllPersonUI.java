package ui;

import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import service.PersonService;
import vo.PersonVO;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SelectAllPersonUI extends JFrame {

	private JPanel contentPane;
	private static JTable table;

	private static DefaultTableModel model;
	public static void setDefaultModel() {
		String[] header = {"이름","나이"};
		try {
			ArrayList<PersonVO> list = 
					PersonService.getInstance().selectAllPerson();
			//테이블에 저장될 내용을 생성
			String[][] content = new String[list.size()][];
			for(int i=0;i<list.size();i++) {
				content[i] = new String[] {
						list.get(i).getName(),
						String.valueOf(list.get(i).getAge())
				};
			}
			model = new DefaultTableModel(content,header);
			table.setModel(model);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SelectAllPersonUI frame = new SelectAllPersonUI();
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
	public SelectAllPersonUI() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 569, 518);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 73, 529, 396);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println("마우스 클릭 이벤트");
				System.out.println("클릭한 행번호 : " + table.getSelectedRow());
				System.out.println("클릭한 열번호 : " + table.getSelectedColumn());
				System.out.println(table.getValueAt(table.getSelectedRow(),
						table.getSelectedColumn()));
			}
		});
		scrollPane.setViewportView(table);
		
		JButton btnDelete = new JButton("데이터 삭제");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//데이터 삭제
				int row = table.getSelectedRow();
				if(row == -1) return;
				String name = table.getValueAt(row, 0).toString();
				//System.out.println(name);
				try {
					PersonService.getInstance().deletePerson(name);
					setDefaultModel();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		btnDelete.setBounds(12, 22, 111, 23);
		contentPane.add(btnDelete);
		
		JButton btnUpdate = new JButton("데이터 수정");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int row = table.getSelectedRow();
				if(row == -1) return;
				String name = table.getValueAt(row, 0).toString();
				UpdatePersonUI ui = new UpdatePersonUI(name);
				ui.setVisible(true);
			}
		});
		btnUpdate.setBounds(135, 22, 118, 23);
		contentPane.add(btnUpdate);
		setDefaultModel();
	}

}
