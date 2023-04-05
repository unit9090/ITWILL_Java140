package edu.java.swing04;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class AppMain04 {
	// 이미지 파일의 경로들을 저장하는 배열.
	private static final String[] IMAGES = {
			"images/image1.jpg",
			"images/image2.jpg",
			"images/image3.jpg",
			"images/image4.jpg",
			"images/image5.jpg"
	};
	
	private JFrame frame;
	private JButton btnPrevious;
	private JButton btnNext;
	private JLabel lblImage;
	
	private int count = 0;	// 현재 화면에 보여지는 이미지 파일의 인덱스
	private static final int MAX = IMAGES.length - 1;
	private static final int MIN = 0;
	
	private List<String> list = Arrays.asList(
			"images/image1.jpg",
			"images/image2.jpg",
			"images/image3.jpg",
			"images/image4.jpg",
			"images/image5.jpg");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AppMain04 window = new AppMain04();
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
	public AppMain04() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 487, 563);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		// image
		lblImage = new JLabel(new ImageIcon(IMAGES[count]));
//		lblImage.setIcon(new ImageIcon("D:\\git\\itwill_java140_individual\\Java16_Swing\\images\\image1.jpg"));
		lblImage.setBounds(12, 10, 450, 450);
		frame.getContentPane().add(lblImage);
		
		// button
		// 이전 버튼
		btnPrevious = new JButton("<");
		btnPrevious.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				handleButtonClick(e);
//				showPerformedImage();
			}
		});
		btnPrevious.setFont(new Font("MS PGothic", Font.BOLD, 15));
		btnPrevious.setBackground(SystemColor.activeCaption);
		btnPrevious.setBounds(12, 470, 87, 47);
		frame.getContentPane().add(btnPrevious);
		
		// 다음 버튼
		btnNext = new JButton(">");
		btnNext.addActionListener((e) -> {
			handleButtonClick(e);
//			showNextImage();
		});
//		btnNext.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				handleButtonClick(e);
//			}
//		});
		btnNext.setFont(new Font("MS PGothic", Font.BOLD, 15));
		btnNext.setBackground(SystemColor.activeCaption);
		btnNext.setBounds(375, 470, 87, 47);
		frame.getContentPane().add(btnNext);
	}

//	private void showNextImage() {
//		if(count < IMAGES.length - 1) {
//			count++;
//		}		
//		lblImage.setIcon(new ImageIcon(IMAGES[count]));
//	}
//
//	protected void showPerformedImage() {
//		if(count > 0) {
//			count--;
//		} else {
//			count = IMAGES.length - 1;
//		}
//		lblImage.setIcon(new ImageIcon(IMAGES[count]));
//	}

	private void handleButtonClick(ActionEvent e) {
//		if(e.getSource() == btnNext) {
//			if(count < MAX) {
//				count++;
//			}
//		} else {
//			if(count > MIN) {
//				count--;
//			}
//		}
//		
//		ImageIcon mario = new ImageIcon("images/image" + (count + 1) + ".jpg");
//		lblImage.setIcon(mario);
		
		
		if(e.getSource() == btnNext) {
			if(count < MAX) {
				count++;
				ImageIcon icon = new ImageIcon(list.get(count));
				lblImage.setIcon(icon);
			} else {
				count = MIN;
				ImageIcon icon = new ImageIcon(list.get(count));
				lblImage.setIcon(icon);
			}
		} else {
			if(count > MIN) {
				count--;
				ImageIcon icon = new ImageIcon(list.get(count));
				lblImage.setIcon(icon);
			} else {
				count = MAX;
				ImageIcon icon = new ImageIcon(list.get(count));
				lblImage.setIcon(icon);
			}
		}
	}

}
