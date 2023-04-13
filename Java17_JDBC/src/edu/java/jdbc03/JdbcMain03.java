package edu.java.jdbc03;

import static edu.java.jdbc.model.Blog.Entity.*;
import static edu.java.jdbc.oracle.OracleConnect.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import oracle.jdbc.driver.OracleDriver;

public class JdbcMain03 {

	public static void main(String[] args) {
		// JDBC update:
		// UPDATE TABLE SET COL = VAL, ...;
		Scanner sc = new Scanner(System.in);
		
		Connection conn = null;
		PreparedStatement stmt = null;
		
		try {
			// Oracle 드라이버 등록
			DriverManager.registerDriver(new OracleDriver());
			
			// DB 접속
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			
			// Statement(SQL 문장)을 준비
			// UPDATE BLOGS SET TITLE = ?, CONTENT = ?, MODIFIED_TIME = SYSDATE WHERE ID = ?
			String sql = String.format("UPDATE %s SET %s = ?, %s = ?, %s = SYSDATE WHERE %s = ?",
					TBL_NAME, COL_TITLE, COL_CONTENT, COL_MODIFIED_TIME, COL_ID);
			System.out.println(sql);
			
			// SQL 문장을 실행할 수 있는 Statement 타입 객체 생성.
			stmt = conn.prepareStatement(sql);
			
			// SQL 문장의 ? 부분을 채우기 위해서 id, 업데이트할 제목/내용을 입력받음.
			System.out.print("수정할 글 번호> ");
			Integer id = Integer.parseInt(sc.nextLine());
			
			System.out.print("제목 업데이트> ");
			String title = sc.nextLine();
			
			System.out.print("내용 업데이트> ");
			String content = sc.nextLine();
			
			// ?를 채워줌
			stmt.setString(1, title);
			stmt.setString(2, content);
			stmt.setInt(3, id);
			
			// SQL 문장을 DB 서버에서 실행.
			int result = stmt.executeUpdate();
			System.out.println(result + "개의 행이 업데이트 됐습니다.");		
			
			
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
