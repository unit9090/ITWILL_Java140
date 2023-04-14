package edu.java.contact.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import edu.java.contact.model.Contact;
import oracle.jdbc.OracleDriver;

// Contact의 상수
import static edu.java.contact.model.Contact.Entity.*;
// DB 연결을 위한 URL, USER, PASSWORD
import static edu.java.contact_ojdbc.OracleConnect.*;

public class ContactDaoImpl implements ContactDao {

	private static ContactDaoImpl instance = null;
	private ContactDaoImpl() {}	
	public static ContactDaoImpl getInstance() {
		if(instance == null) {
			instance = new ContactDaoImpl();
		}
		
		return instance;
	}
	
	// 오라클 DB에 접속한 Connection 객체를 리턴.
	private Connection getConnection() throws SQLException {
		// 오라클 JDBC 드라이버(라이브러리)를 등록.
		DriverManager.registerDriver(new OracleDriver());
		
		// 오라클 DB에 접속.
		Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
		
		return conn;
	}
	
	// Resources close(overloading)
	private void closeResources(Connection conn, Statement stmt) throws SQLException {
		stmt.close();
		conn.close();		
	}
	
	private void closeResource(Connection conn, Statement stmt, ResultSet rs) throws SQLException {
		rs.close();
		closeResources(conn, stmt);
	}
	
	private static final String SQL_SELECT_ALL = 
			"SELECT * FROM " + TBL_NAME + " ORDER BY " + COL_CID;
	
	@Override
	public List<Contact> read() {
		ArrayList<Contact> list = new ArrayList<>();
		
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			conn = getConnection();
			System.out.println(SQL_SELECT_ALL);
			stmt = conn.prepareStatement(SQL_SELECT_ALL);			
			rs = stmt.executeQuery();
			
			while(rs.next()) {	// select 결과에서 행(row) 데이터가 있으면
				// 각 컬럼의 값들을 읽음.
				Integer cid = rs.getInt(COL_CID);
				String name = rs.getString(COL_NAME);
				String phone = rs.getString(COL_PHONE);
				String email = rs.getString(COL_EMAIL);
				
				list.add(new Contact(cid, name, phone, email));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				closeResource(conn, stmt, rs);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return list;
	}

	private static final String SQL_SELECT_BY_ID = 
			"SELECT * FROM " + TBL_NAME + " WHERE " + COL_CID + " = ?";
	@Override
	public Contact read(int cid) {
		
		Contact contact = null;
		
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			conn = getConnection();
			
			stmt = conn.prepareStatement(SQL_SELECT_BY_ID);
			stmt.setInt(1, cid);
			
			rs = stmt.executeQuery();
			
			if(rs.next()) {	// 검색된 행(row) 데이터가 있다면
				contact = new Contact(rs.getInt(COL_CID), rs.getString(COL_NAME)
						, rs.getString(COL_PHONE), rs.getString(COL_EMAIL));
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
			
		} finally {
			try {
				closeResource(conn, stmt, rs);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
				
		return contact;
	}
	
	private static final String SQL_SELECT_BY_KEYWORD = 
			"SELECT * FROM " + TBL_NAME + " WHERE "
			+ "LOWER(" + COL_NAME + ") LIKE LOWER(?)"
			+ " OR LOWER(" + COL_PHONE + ") LIKE LOWER(?)"
			+ " OR LOWER(" + COL_EMAIL + ") LIKE LOWER(?)"
			+ " ORDER BY " + COL_CID;
	
	@Override
	public List<Contact> read(String keyword) {
		ArrayList<Contact> list = new ArrayList<>();
		
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			conn = getConnection();
			
			System.out.println(SQL_SELECT_BY_KEYWORD);			
			stmt = conn.prepareStatement(SQL_SELECT_BY_KEYWORD);
			
			System.out.print("keyword = " + keyword);
			keyword = "%" + keyword + "%";
			System.out.println(", key = " + keyword);
			
			stmt.setString(1, keyword);
			stmt.setString(2, keyword);
			stmt.setString(3, keyword);
			
			rs = stmt.executeQuery();			
			while(rs.next()) {
				int cid = rs.getInt(COL_CID);
				String name = rs.getString(COL_NAME);
				String phone = rs.getString(COL_PHONE);
				String email = rs.getString(COL_EMAIL);
				
				Contact c = new Contact(cid, name, phone, email);
				
				list.add(c);		
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
			
		} finally {
			try {
				closeResource(conn, stmt, rs);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		
		return list;
	}
	

	private static final String SQL_INSERT = 
			"INSERT INTO " + TBL_NAME
			+ " (" + COL_NAME + ", " + COL_PHONE + ", " + COL_EMAIL + ") VALUES"
			+ " (?, ?, ?)";
	
	@Override
	public int create(Contact contact) {
		
		int result = 0;	// insert 결과를 저장하고 리턴할 변수.
		
		Connection conn = null;
		PreparedStatement stmt = null;
		
		try {
			conn = getConnection();
			
			stmt = conn.prepareStatement(SQL_INSERT);			
			stmt.setString(1, contact.getName());
			stmt.setString(2, contact.getPhone());
			stmt.setString(3, contact.getEmail());		
			
			result = stmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
			
		} finally {
			try {
				closeResources(conn, stmt);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		
		return result;
	}

	private static final String SQL_UPDATE = 
			"UPDATE " + TBL_NAME + " SET "
			+ COL_NAME + " = ?, " + COL_PHONE + " = ?, " + COL_EMAIL + " = ? WHERE "
			+ COL_CID + " = ?";
	
	@Override
	public int update(Contact contact) {
		int result = 0;
		
		Connection conn = null;
		PreparedStatement stmt = null;
		
		try {
			conn = getConnection();
			
			stmt = conn.prepareStatement(SQL_UPDATE);
			stmt.setString(1, contact.getName());
			stmt.setString(2, contact.getPhone());
			stmt.setString(3, contact.getEmail());
			stmt.setInt(4, contact.getCid());
			
			result = stmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
			
		} finally {
			try {
				closeResources(conn, stmt);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		
		return result;
	}

	
	private static final String SQL_DELETE =
			"DELETE FROM " + TBL_NAME + " WHERE " + COL_CID + " = ?";
	
	@Override
	public int delete(Integer cid) {
		int result = 0;
		
		Connection conn = null;
		PreparedStatement stmt = null;
		
		try {
			conn = getConnection();
			
			stmt = conn.prepareStatement(SQL_DELETE);
			stmt.setInt(1, cid);
			
			result = stmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
			
		} finally {
			try {
				closeResources(conn, stmt);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return result;
	}

}
