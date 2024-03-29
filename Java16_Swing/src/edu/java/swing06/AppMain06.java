package edu.java.swing06;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AppMain06 {

	private JFrame frame;
	private JButton btnMsgDlg;
	private JButton btnComfirmDlg;
	private JButton btnOptionDlg;
	private JButton btnInputDlg;
	private JButton btnCustomDlg;
	private JButton btnCustomFrame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AppMain06 window = new AppMain06();
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
	public AppMain06() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 452, 646);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		btnMsgDlg = new JButton("Message Dialog");
		btnMsgDlg.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// 프레임을 중심으로 창이 띄워짐
//				JOptionPane.showMessageDialog(frame, "안녕하세요.");
				// null로 줄 시 모니터를 중심으로 메시지 창이 띄워짐
//				JOptionPane.showMessageDialog(null, "안녕하세요.");
				
				JOptionPane.showMessageDialog(
						  frame			// 메시지 다이얼로그가 실행될 부모 컴포넌트
						, "안녕하세요?"	// 다이얼로그에 표시될 메시지
						, "메시지"		// 다이얼로그 타이틀(제목)
						, JOptionPane.QUESTION_MESSAGE	// 메시지 타입
				);
			}
		});
		btnMsgDlg.setFont(new Font("맑은 고딕", Font.BOLD, 25));
		btnMsgDlg.setBounds(12, 10, 412, 62);
		frame.getContentPane().add(btnMsgDlg);
		
		btnComfirmDlg = new JButton("Comfirm Dialog");
		btnComfirmDlg.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int result = JOptionPane.showConfirmDialog(
						  frame	// 부모 컴포넌트
						, "정말 삭제할까요?"	// 메시지
						, "삭제 확인"	// 타이틀
						, JOptionPane.YES_NO_CANCEL_OPTION	// 확인 옵션(yes-no, yes-no-cancel)
						, JOptionPane.QUESTION_MESSAGE	// 메시지 타입
				);
				btnComfirmDlg.setText("Confirm = " + result);
			}
		});
		btnComfirmDlg.setFont(new Font("맑은 고딕", Font.BOLD, 25));
		btnComfirmDlg.setBounds(12, 82, 412, 62);
		frame.getContentPane().add(btnComfirmDlg);
		
		btnOptionDlg = new JButton("Option Dialog");
		btnOptionDlg.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String[] options = {"아니오", "어려워요", "재밌어요", "쉬워요", "뭐래"};
				int result = JOptionPane.showOptionDialog(
						  frame	// 부모 컴포넌트
						, "Java Swing 재미있나요?"	// 메시지
						, "옵션 확인"	// 타이틀
						, JOptionPane.YES_NO_CANCEL_OPTION	// 옵션 타입
						, JOptionPane.QUESTION_MESSAGE	// 메시지 타입
						, null	// 아이콘
						, options	// 옵션들의 배열
						, options[options.length - 1]	// 옵션 초기값
				);
				btnOptionDlg.setText("Option result = " + result);
				
			}
		});
		btnOptionDlg.setFont(new Font("맑은 고딕", Font.BOLD, 25));
		btnOptionDlg.setBounds(12, 154, 412, 62);
		frame.getContentPane().add(btnOptionDlg);
		
		btnInputDlg = new JButton("Input Dialog");
		btnInputDlg.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
//				String input = JOptionPane.showInputDialog(frame, "이름?");
				Object[] selectionValues = {"10대", "20대", "30대", "40대"};
				Object input = JOptionPane.showInputDialog(
						  frame		// 부모 컴포넌트
						, "나이?"	// 메시지
						, "나이 확인"	// 타이틀
						, JOptionPane.QUESTION_MESSAGE	// 메시지 타입
						, null	// 아이콘
						, selectionValues	// 입력으로 사용할 수 있는 선택지들의 배열
						, selectionValues[1]	// 선택 초기값
				);

				btnInputDlg.setText("Input = " + input);
			}
		});
		btnInputDlg.setFont(new Font("맑은 고딕", Font.BOLD, 25));
		btnInputDlg.setBounds(12, 226, 412, 62);
		frame.getContentPane().add(btnInputDlg);
		
		btnCustomDlg = new JButton("Custom Dialog");
		btnCustomDlg.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				MyDialog.showMyDialog(frame);				
			}
		});
		btnCustomDlg.setFont(new Font("맑은 고딕", Font.BOLD, 25));
		btnCustomDlg.setBounds(12, 298, 412, 62);
		frame.getContentPane().add(btnCustomDlg);
		
		btnCustomFrame = new JButton("Custom Frame");
		btnCustomFrame.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				MyFrame.showMyFrame(frame);
			}
		});
		btnCustomFrame.setFont(new Font("맑은 고딕", Font.BOLD, 25));
		btnCustomFrame.setBounds(12, 370, 412, 62);
		frame.getContentPane().add(btnCustomFrame);
	}

}
