package edu.java.swing02;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AppMain02 {

	private JFrame frame;
	private JTextField textInput;
	private JLabel lblResult;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AppMain02 window = new AppMain02();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public AppMain02() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 520, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		lblResult = new JLabel("입력하세요.");
		lblResult.setBackground(new Color(240, 240, 240));
		lblResult.setForeground(new Color(0, 0, 0));
		lblResult.setFont(new Font("맑은 고딕", Font.PLAIN, 32));
		lblResult.setBounds(12, 10, 480, 61);
		frame.getContentPane().add(lblResult);
		
		textInput = new JTextField();
		textInput.setFont(new Font("맑은 고딕", Font.PLAIN, 32));
		textInput.setBounds(12, 81, 480, 61);
		frame.getContentPane().add(textInput);
		textInput.setColumns(10);
		
		JButton btnInput = new JButton("입력");
		btnInput.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
//				System.out.println("버튼 클릭!");
				handleButtonClick();	// 내부 클래스에서 외부 클래스의 메서드를 호출할 수 있음.
			}
		});
		btnInput.setFont(new Font("맑은 고딕", Font.PLAIN, 16));
		btnInput.setBounds(374, 152, 118, 37);
		frame.getContentPane().add(btnInput);
	}

	private void handleButtonClick() {
		// JTextField의 입력 내용을 읽음.
		String msg = textInput.getText();
		// 읽은 내용을 JLabel에 씀.
		lblResult.setText(msg);
		// JTextField의 내용을 지움.
		textInput.setText("");
	}
}
