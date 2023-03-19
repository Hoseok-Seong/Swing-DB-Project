package com.project.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.project.ViewFrame.UserViewFrame;
import com.project.dto.UserDTO;
import com.project.utils.DBHelper;

public class UserDAO implements IUserDAO {

	private DBHelper dbHelper;
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;

	public UserDAO() {
		dbHelper = new DBHelper();
		conn = dbHelper.getConnection();
	}

	// 로그인 체크 아이디 비번 값 확인해서 찾기
	@Override
	public UserDTO login(String username, String password) {
		UserDTO resultUser = null;

		String query = " SELECT * FROM user " + "WHERE username = ? AND password = ? ";

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, username);
			pstmt.setString(2, password);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				UserDTO dto = new UserDTO();
				dto.setName(rs.getString("name"));
				dto.setEmail(rs.getString("email"));
				dto.setPhone(rs.getString("phone"));
				dto.setAddress(rs.getString("address"));
				resultUser = dto;
			}
		} catch (Exception e) {
			System.out.println(">> 회원찾기 시 에러가 발생했습니다 <<");
			e.printStackTrace();
		}
		return resultUser;
	}

	// 회원가입 
	@Override
	public int join(UserDTO dto) {
		String query = " Insert INTO user(username, name, password, email, phone, address) "
				+ " VALUES(?,?,?,?,?,?) ";
		int resultRow = 0;
		
		try {
			pstmt = conn.prepareStatement(query);

			pstmt.setString(1, dto.getUsername());
			pstmt.setString(2, dto.getName());
			pstmt.setString(3, dto.getPassword());
			pstmt.setString(4, dto.getEmail());
			pstmt.setString(5, dto.getPhone());
			pstmt.setString(6, dto.getAddress());
			resultRow = pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("join 함수에서 오류 발생했습니다.");
			e.printStackTrace();
		}
		return resultRow;
	}

	// 회원 탈퇴
	@Override
	public int delete(String username, String password) {
		String query = " DELETE FROM user "
				+ " WHERE username = ? AND password = ? "; 
		int check = 0;
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, username);
			pstmt.setString(2, password);
			check = pstmt.executeUpdate();
		} catch (Exception e) {
			System.out.println(">> 회원탈퇴 시 에러가 발생했습니다 <<");
			e.printStackTrace();
		}
		return check;
	}

	
}
