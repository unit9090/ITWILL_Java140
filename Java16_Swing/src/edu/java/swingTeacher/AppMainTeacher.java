package edu.java.swingTeacher;

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

public class AppMainTeacher {

	private JFrame frame;
	private JTextField textNum1;
	private JTextField textNum2;
	private JTextArea textResult;
	private JButton btnPlus;
	private JButton btnMinus;
	private JButton btnMulti;
	private JButton btnDivision;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AppMainTeacher window = new AppMainTeacher();
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
	public AppMainTeacher() {
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
		// 덧셈
		btnPlus = new JButton("+");
		btnPlus.setFont(new Font("맑은 고딕", Font.BOLD, 55));
		btnPlus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				handleButtonClick(e);
			}
		});
		btnPlus.setBounds(12, 174, 147, 75);
		frame.getContentPane().add(btnPlus);
		
		// 뺄셈
		btnMinus = new JButton("-");
		btnMinus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				handleButtonClick(e);
			}
		});
		btnMinus.setFont(new Font("맑은 고딕", Font.BOLD, 55));
		btnMinus.setBounds(176, 174, 147, 75);
		frame.getContentPane().add(btnMinus);
		
		// 곱셈
		btnMulti = new JButton("*");
		btnMulti.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				handleButtonClick(e);
			}
		});
		btnMulti.setFont(new Font("맑은 고딕", Font.BOLD, 55));
		btnMulti.setBounds(335, 174, 147, 75);
		frame.getContentPane().add(btnMulti);
		
		// 나눗셈
		btnDivision = new JButton("/");
		btnDivision.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				handleButtonClick(e);
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

	private void handleButtonClick(ActionEvent event) {
		// 눌린 객체 주소 값과 btnPlus 주소값을 비교
//		System.out.println(e.getSource() == btnPlus);
//		System.out.println(event.getSource());
		//-> argument로 전달된 ActionEvent 객체에서 이벤트가 발생한 GUI 컴포넌트 정보를 알 수 있다.
		
		// JTextField에 입력된 문자열을 읽어서 double 타입으로 변환.
		double number1 = 0;
		double number2 = 0;
		
		try {
			number1 = Double.parseDouble(textNum1.getText());
			number2 = Double.parseDouble(textNum2.getText());
		} catch (NumberFormatException e) {
			textResult.setText("number1, 2는 숫자로 입력하세요.");
			return;	// 메서드 종료
		}
		
		double result = 0;	// 사칙 연산 결과를 저장할 변수
		String op = "";		// 사칙 연산 연산자 문자열을 저장할 변수(+, -, *, /)
		
		Object source = event.getSource();	// 이벤트가 발생한 컴포넌트
		if(source == btnPlus) {
			result = number1 + number2;
			op = "+";
			
		} else if(source == btnMinus) {
			result = number1 - number2;
			op = "-";
			
		} else if(source == btnMulti) {
			result = number1 * number2;
			op = "x";
			
		} else if(source == btnDivision) {
			result = number1 / number2;
			op = "/";
		}
		
		String msg = String.format("%f %s %f = %f", number1, op, number2, result);
		textResult.setText(msg);
		// 숫자 뒤 문자열을 붙여도 문자열로 리턴
//		textResult.setText(result + "");

	}

}
