package edu.java.swing03;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;

public class AppMain03 {

	private JFrame frame;
	private JTextField textNum1;
	private JTextField textNum2;
	private JTextArea textResult;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AppMain03 window = new AppMain03();
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
	public AppMain03() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 669, 502);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		// label
		JLabel lblNum1 = new JLabel("num1");
		lblNum1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNum1.setFont(new Font("맑은 고딕", Font.BOLD, 22));
		lblNum1.setBounds(12, 10, 109, 54);
		frame.getContentPane().add(lblNum1);
		
		JLabel lblNum2 = new JLabel("num2");
		lblNum2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNum2.setFont(new Font("맑은 고딕", Font.BOLD, 22));
		lblNum2.setBounds(12, 74, 109, 54);
		frame.getContentPane().add(lblNum2);
		
		// num 입력창
		textNum1 = new JTextField();
		textNum1.setBackground(new Color(240, 248, 255));
		textNum1.setFont(new Font("맑은 고딕", Font.PLAIN, 22));
		textNum1.setBounds(133, 10, 508, 54);
		frame.getContentPane().add(textNum1);
		textNum1.setColumns(10);
		
		textNum2 = new JTextField();
		textNum2.setBackground(new Color(255, 239, 213));
		textNum2.setFont(new Font("맑은 고딕", Font.PLAIN, 22));
		textNum2.setColumns(10);
		textNum2.setBounds(133, 74, 508, 54);
		frame.getContentPane().add(textNum2);
		
		// button
		JButton btnPlus = new JButton("+");
		btnPlus.setFont(new Font("맑은 고딕", Font.BOLD, 55));
		btnPlus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				handleButtonClick("plus");
			}
		});
		btnPlus.setBounds(12, 174, 147, 75);
		frame.getContentPane().add(btnPlus);
		
		JButton btnMinus = new JButton("-");
		btnMinus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				handleButtonClick("minus");
			}
		});
		btnMinus.setFont(new Font("맑은 고딕", Font.BOLD, 55));
		btnMinus.setBounds(176, 174, 147, 75);
		frame.getContentPane().add(btnMinus);
		
		JButton btnMulti = new JButton("*");
		btnMulti.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				handleButtonClick("multi");
			}
		});
		btnMulti.setFont(new Font("맑은 고딕", Font.BOLD, 55));
		btnMulti.setBounds(335, 174, 147, 75);
		frame.getContentPane().add(btnMulti);
		
		JButton btnDivision = new JButton("/");
		btnDivision.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				handleButtonClick("division");
			}
		});
		btnDivision.setFont(new Font("맑은 고딕", Font.BOLD, 45));
		btnDivision.setBounds(494, 174, 147, 75);
		frame.getContentPane().add(btnDivision);
		
		// 결과값
		textResult = new JTextArea();
		textResult.setFont(new Font("맑은 고딕", Font.PLAIN, 25));
		textResult.setBounds(12, 271, 629, 182);
		frame.getContentPane().add(textResult);
	}

	private void handleButtonClick(String string) {
		if(!check()) {
			return;
		}
		
		int num1 = Integer.parseInt(textNum1.getText());
		int num2 = Integer.parseInt(textNum2.getText());
		
		switch(string) {
		case "plus":
			textResult.setText(Integer.toString(num1 + num2));
			break;
		case "minus":
			textResult.setText(Integer.toString(num1 - num2));
			break;
		case "multi":
			textResult.setText(Integer.toString(num1 * num2));
			break;
		case "division":
			if(num2 != 0) {
				textResult.setText(Double.toString((double)num1 / (double)num2));
			} else {
				textNum2.setText("");
				textResult.setText("num2가 0이면 나눗셈을 할 수 없습니다.");
			}
			
			break;
		}
		
	}

	private boolean check() {
		try {
			Integer.parseInt(textNum1.getText());
			Integer.parseInt(textNum2.getText());
			return true;
		} catch (Exception e) {
			textNum1.setText("");
			textNum2.setText("");
			textResult.setText("정수를 입력해주세요.");
			
			return false; 
		}
		
	}
}
