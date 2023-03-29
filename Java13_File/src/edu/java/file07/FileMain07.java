package edu.java.file07;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class FileMain07 {

	public static void main(String[] args) {
		// TODO 
		// 1. ArrayList<Student> 객체 생성
		ArrayList<Student> students = new ArrayList<>();
		
		// 2. 1,000,000개의 Student 객체를 리스트에 저장 - Random
		for(int i = 0; i < 1_000_000; i++) {
			Score score = new Score((int)(Math.random() * 101),
									(int)(Math.random() * 101),
									(int)(Math.random() * 101));
			Student student = new Student(i, "student_" + i, score);
			students.add(student);
		}
		
		System.out.println("객체 생성 후 사이즈: " + students.size());
		System.out.println("객체 생성 후 index 77번 결과값: " + students.get(77));
		
		// 3. 리스트를 students.dat 파일에 (직렬화해서) 씀.
		String file = "data/students.dat";
		
		try(FileOutputStream out = new FileOutputStream(file);
			BufferedOutputStream bout = new BufferedOutputStream(out);
			ObjectOutputStream oout = new ObjectOutputStream(bout);) {
			
			long start = System.currentTimeMillis();	// 시작시간
			oout.writeObject(students);
			long end = System.currentTimeMillis();		// 종료시간
			
			System.out.println("write 경과 시간: " + (end - start) + "ms");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		// 4. 파일에서 데이터를 읽어서 역직렬화.
		try(FileInputStream in = new FileInputStream(file);
			BufferedInputStream bin = new BufferedInputStream(in);
			ObjectInputStream oin = new ObjectInputStream(bin);) {
			
			long start = System.currentTimeMillis();	// 시작 시간
			ArrayList<Student> result = (ArrayList<Student>) oin.readObject();
			long end = System.currentTimeMillis();		// 종료 시간
			
			System.out.println("read 경과 시간: " + (end - start) + "ms");
			System.out.println("read 후 결과 사이즈: " + result.size());
			System.out.println("read 후 index 77번 결과값: " + result.get(77));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
