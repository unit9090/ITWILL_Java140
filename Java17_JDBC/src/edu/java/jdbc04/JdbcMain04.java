package edu.java.jdbc04;

import static edu.java.jdbc.oracle.OracleConnect.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import oracle.jdbc.driver.OracleDriver;

import static edu.java.jdbc.model.Blog.Entity.*;

public class JdbcMain04 {

	public static void main(String[] args) {
		// 과제 JDBC delete:
		// DELETE FROM BLOGS WHERE ID = ?

		Scanner sc = new Scanner(System.in);
		
		Connection conn = null;
		PreparedStatement stmt = null;
		
		try {
			// Oracle 객체 생성
			DriverManager.deregisterDriver(new OracleDriver());
			
			// DB 서버 연결
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			
			// DB에 보낼 SQL 문장 생성
			String sql = String.format("DELETE FROM %s WHERE %s = ?", 
					TBL_NAME, COL_ID);
			stmt = conn.prepareStatement(sql);
			
			// SQL 문장에 빈 부분 채우기
			System.out.print("삭제할 id 값 > ");
			Integer id = Integer.parseInt(sc.nextLine());
			
			stmt.setInt(1, id);
			
			// SQL 문장을 DB에 전송하여 실행
			int result = stmt.executeUpdate();
			System.out.println(result + "개의 행이 삭제되었습니다.");
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		
	}

}
