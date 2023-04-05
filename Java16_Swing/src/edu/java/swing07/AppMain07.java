package edu.java.swing07;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AppMain07 {
	// JTable에서 사용할 컬럼 이름들
	private static final String[] COLUMN_NAMES = {"국어", "영어", "수학", "총점", "평균"};
	
	private DefaultTableModel model;
	private JFrame frame;
	private JLabel lblEnglish;
	private JLabel lblKorean;
	private JLabel lblMath;
	private JTextField textKorean;
	private JTextField textEnglish;
	private JTextField textMath;
	private JButton btnInsert;
	private JScrollPane scrollPane;
	private JTable table;
	private JButton btnDelete;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AppMain07 window = new AppMain07();
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
	public AppMain07() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 461, 641);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		lblKorean = new JLabel("국어");
		lblKorean.setHorizontalAlignment(SwingConstants.CENTER);
		lblKorean.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		lblKorean.setBounds(12, 10, 102, 44);
		frame.getContentPane().add(lblKorean);
		
		lblEnglish = new JLabel("영어");
		lblEnglish.setHorizontalAlignment(SwingConstants.CENTER);
		lblEnglish.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		lblEnglish.setBounds(12, 64, 102, 44);
		frame.getContentPane().add(lblEnglish);
		
		lblMath = new JLabel("수학");
		lblMath.setHorizontalAlignment(SwingConstants.CENTER);
		lblMath.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		lblMath.setBounds(12, 119, 102, 44);
		frame.getContentPane().add(lblMath);
		
		textKorean = new JTextField();
		textKorean.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		textKorean.setBounds(126, 10, 307, 44);
		frame.getContentPane().add(textKorean);
		textKorean.setColumns(10);
		
		textEnglish = new JTextField();
		textEnglish.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		textEnglish.setColumns(10);
		textEnglish.setBounds(126, 64, 307, 44);
		frame.getContentPane().add(textEnglish);
		
		textMath = new JTextField();
		textMath.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		textMath.setColumns(10);
		textMath.setBounds(126, 119, 307, 44);
		frame.getContentPane().add(textMath);
		
		btnInsert = new JButton("입력");
		btnInsert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnInsertData();
			}
		});
		btnInsert.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		btnInsert.setBounds(12, 181, 195, 71);
		frame.getContentPane().add(btnInsert);
		
		btnDelete = new JButton("삭제");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnDeleteData();
			}
		});
		btnDelete.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		btnDelete.setBounds(238, 181, 195, 71);
		frame.getContentPane().add(btnDelete);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 262, 421, 330);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		Object[][] data = {};	// 테이블에 사용할 데이터
		model = new DefaultTableModel(data, COLUMN_NAMES);
		table.setModel(model);
//		table.setModel(new DefaultTableModel(
//			new Object[][] {
//				{null, null, null, null, null},
//			},
//			new String[] {
//				"\uAD6D\uC5B4", "\uC601\uC5B4", "\uC218\uD559", "\uCD1D\uC810", "\uD3C9\uADE0"
//			}
//		));
		table.setFont(new Font("맑은 고딕", Font.PLAIN, 14));
		scrollPane.setViewportView(table);
	}

	private void btnDeleteData() {
		if(model.getRowCount() == 0) {
			JOptionPane.showMessageDialog(frame, "등록되어 있는 점수가 없습니다.");
			return;
		} else {
			model.removeRow(0);
		}
	}

	private void btnInsertData() {
		int korean = 0;
		int english = 0;
		int math = 0;
		
		try {
			if(textKorean.getText().isEmpty()
			|| textEnglish.getText().isEmpty()
			|| textMath.getText().isEmpty()) {
				JOptionPane.showMessageDialog(frame, "점수를 입력해주세요.");
				return;
			}
			
			korean = Integer.parseInt(textKorean.getText());
			english = Integer.parseInt(textEnglish.getText());
			math = Integer.parseInt(textMath.getText());
			
			if(korean > 100 || korean < 0
			|| english > 100 || english < 0
			|| math > 100 || math < 0) {
				JOptionPane.showMessageDialog(frame, "점수는 0 이상 100 이하로 작성해주세요.");
				return;
			}
		} catch (NumberFormatException e) {
			textKorean.setText("");
			textEnglish.setText("");
			textMath.setText("");
			JOptionPane.showMessageDialog(frame, "정수로 입력해주세요.");
			return;
		}
		
		Score score = new Score(korean, english, math);
		
		Object[] row = {korean, english, math, score.getTotal(), score.getMean()};
		model.addRow(row);
		
		textKorean.setText("");
		textEnglish.setText("");
		textMath.setText("");
	}
}
