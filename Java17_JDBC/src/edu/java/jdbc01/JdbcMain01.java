package edu.java.jdbc01;


// JDK 클래스, 인터페이스
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Iterator;

import edu.java.jdbc.model.Blog;
// Oracle JDBC 라이브러리 클래스
import oracle.jdbc.OracleDriver;

// OracleConneect 인터페이스에서 public static final로 선언된 모든 상수 이름들을 임포트.
import static edu.java.jdbc.oracle.OracleConnect.*;
// Blog 안에 있는 인터페이스 Entity에 있는 상수들을 모두 가져온다.
import static edu.java.jdbc.model.Blog.Entity.*;


/*
	JDBC(Java Database Connectivity):
	자바 프로그램에서 데이터베이스를 연결하고, SQL 문장들을 실행하는 방법.
	
	1. Oracle JDBC 라이브러리를 다운로드 하고 자바 프로젝트에 라이브러리를 포함.
		(1) 라이브러리 다운로드.
		(2) 이클립스 프로젝트 폴더에 lib 폴더 생성.
		(3) 다운로드한 라이브러리 jar 파일을 lib 폴더에 복사.
		(4) jar 파일을 프로젝트의 빌드 패스(build path)에 추가.(Add to build path)
		
	2. 오라클 데이터베이스 서버에 접속하기 위한 정보들(URL, USER, PASSWORD)을 상수로 정의.
	3. 프로그램에서 오라클 JDBC 라이브러리를 사용할 수 있도록 드라이버 등록(라이브러리를 메모리 로딩).
	4. 데이터베이스 서버 접속(Connection).
	5. Statement 타입 객체 생성.
		- DB 서버에서 실행할 SQL 문장을 작성, 실행하는 객체.
	6. Statement 객체의 메서드를 사용해서 SQL 문장을 DB 서버로 전송하고, 그 결과를 처리.
		- executeQuery(): DQL. SELECT 문장.
		- executeUpdate(): DML. INSERT, UPDATE, DELETE 문장.
	7. 결과 처리 - 화면 출력.
	8. 사용했던 모든 리소스(Connection, Statement, ResultSet(select에서만 있음))들을 해제(close).
*/

public class JdbcMain01 {

	public static void main(String[] args) {
		
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			// 3. Oracle JDBC driver(라이브러리) 등록.
			DriverManager.registerDriver(new OracleDriver());
			System.out.println("오라클 드라이버 등록 성공");
			
			// 4. DB 서버에 접속
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			System.out.println("conn = " + conn);
			
			// 5. statement 타입 객체 생성.			
			String sql = "SELECT * FROM BLOGS";	// JDBC에서 SQL 문장은 세미콜론(;)을 사용하지 않음!
			stmt = conn.prepareStatement(sql);
			System.out.println("stmt = " + stmt);
			
			// 6. Statement 실행
			rs = stmt.executeQuery();	// select 문장 실행.
			System.out.println("rs = " + rs);
			
			// 7. 결과 처리
			while(rs.next()) {	// ResultSet에 행(row) 데이터가 있는 경우
				Integer id = rs.getInt(COL_ID);	// ID 컬럼의 값을 읽고 int 타입으로 리턴.
				String title = rs.getString(COL_TITLE);	// TITLE 컬럼의 값을 String 타입으로 리턴.
				String content = rs.getString(COL_CONTENT);
				String author = rs.getString(COL_AUTHOR);
				// CREATED_TIME 컬럼의 값을 Timestamp 타입으로 읽고, LocalDateTime 타입으로 변환해서 리턴.
				LocalDateTime createdTime = rs.getTimestamp(COL_CREATED_TIME).toLocalDateTime();
				LocalDateTime modifiedTime = rs.getTimestamp(COL_MODIFIED_TIME).toLocalDateTime();
				
				Blog blog = new Blog(id, title, content, author, createdTime, modifiedTime);
				
				System.out.println(blog);
			}			
			
		} catch (SQLException e) {
			// debug를 위해
			e.printStackTrace();
			
		} finally {
			// 리소스 해제 - 리소스가 생성된 순서의 반대로 close를 호출. 
			try {
				rs.close();
				stmt.close();
				conn.close();
				System.out.println("오라클 DB 접속 해제 성공");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

}
