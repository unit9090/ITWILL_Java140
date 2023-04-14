package edu.java.contact.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import edu.java.contact.model.Contact;
import edu.java.contact.controller.ContactDaoImpl;

import java.awt.BorderLayout;
import java.awt.Component;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ContactUpdateFrame extends JFrame {
	
	private final ContactDaoImpl dao = ContactDaoImpl.getInstance();
	private Component parent;	// 부모 컴포넌트(JFrame)를 저장하기 위한 필드.
	private ContactMain app;
	private int cid;

	private JPanel contentPane;
	private JPanel panel;
	private JTextField textName;
	private JTextField textPhone;
	private JTextField textEmail;
	private JLabel lblEmail;
	private JLabel lblPhone;
	private JLabel lblName;
	private JButton btnCancel;

	/**
	 * Launch the application.
	 */
	public static void showContactUpdateFrame(Component parent, int cid, ContactMain app) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ContactUpdateFrame frame = new ContactUpdateFrame(parent, cid, app);
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
	public ContactUpdateFrame(Component parent, int cid, ContactMain app) {
		this.parent = parent;
		this.app = app;
		this.cid = cid;
		
		initialize();	// GUI 컴포넌트들을 생성하고 초기화.
		readContact();		
	}
	
	private void readContact() {
		Contact contact = dao.read(cid);
		
		textName.setText(contact.getName());
		textPhone.setText(contact.getPhone());
		textEmail.setText(contact.getEmail());
	}
	
	public void initialize() {
		setTitle("연락처 업데이트");
		
		// 닫기(x) 버튼의 기본 동작을 현재 창만 닫기(dispose)로 설정.
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		// main이 떠있는 위치에 뜨도록
		int x = 100;	// 부모 컴포넌트가 null인 경우에 사용할 x 좌표 기본값.
		int y = 100;	// 부모 컴포넌트가 null인 경우에 사용할 y 좌표 기본값.
		if(parent != null) {
			x = parent.getX() + parent.getWidth();	// 부모 컴포넌트의 x 좌표
			y = parent.getY();	// 부모 컴포넌트의 y 좌표
			
		}		
		setBounds(x, y, 450, 300);	// 다이얼로그 좌표(x, y), 크기(가로, 세로)
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		lblName = new JLabel("이름");
		lblName.setHorizontalAlignment(SwingConstants.CENTER);
		lblName.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		lblName.setBounds(12, 10, 88, 41);
		panel.add(lblName);
		
		textName = new JTextField();
		textName.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		textName.setBounds(112, 10, 300, 41);
		panel.add(textName);
		textName.setColumns(10);
		
		lblPhone = new JLabel("전화번호");
		lblPhone.setHorizontalAlignment(SwingConstants.CENTER);
		lblPhone.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		lblPhone.setBounds(12, 61, 88, 41);
		panel.add(lblPhone);
		
		textPhone = new JTextField();
		textPhone.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		textPhone.setColumns(10);
		textPhone.setBounds(112, 61, 300, 41);
		panel.add(textPhone);
		
		lblEmail = new JLabel("이메일");
		lblEmail.setHorizontalAlignment(SwingConstants.CENTER);
		lblEmail.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		lblEmail.setBounds(12, 112, 88, 41);
		panel.add(lblEmail);
		
		textEmail = new JTextField();
		textEmail.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		textEmail.setColumns(10);
		textEmail.setBounds(112, 112, 300, 41);
		panel.add(textEmail);
		
		JPanel buttonPanel = new JPanel();
		contentPane.add(buttonPanel, BorderLayout.SOUTH);
		
		JButton btnCreate = new JButton("수정 완료");
		btnCreate.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				updateContact();
			}
		});
		btnCreate.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		buttonPanel.add(btnCreate);
		
		btnCancel = new JButton("취소");
		btnCancel.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();	// 현재 창 닫기
			}
		});
		btnCancel.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		buttonPanel.add(btnCancel);
	}

	private void updateContact() {
		// JTextField에서 업데이트 정보들을 읽음.
		String name = textName.getText();
		String phone = textPhone.getText();
		String email = textEmail.getText();
		
		Contact contact = new Contact(cid, name, phone, email);
		
		int confirm = JOptionPane.showConfirmDialog(
//				  ContactUpdateFrame.this
				  this
				, "정말로 업데이트할까요?"
				, "업데이트 확인"
				, JOptionPane.YES_NO_OPTION
		);
		
		if(confirm == JOptionPane.YES_OPTION) {
			dao.update(contact);	// 리스트를 수정하고, 파일에 업데이트
			app.notifyContactUpdated(); // ContactMain 프레임에 있는 테이블을 갱신하기 위해서
			dispose();
		}	
	}

}
