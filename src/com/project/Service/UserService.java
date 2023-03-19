package com.project.Service;

import com.project.dao.UserDAO;
import com.project.dto.UserDTO;

public class UserService {

	private UserDAO userDAO;

	public UserService() {
		userDAO = new UserDAO();
	}

	public UserDTO login(String username, String password) {
		boolean isValid = true;
		if (username.equals("")) {
			isValid = false;
		} else if (password.equals("")) {
			isValid = false;
		}
		UserDTO userDTO = null;
		if (isValid) {
			userDTO = userDAO.login(username, password);
		}
		return userDTO;
	}
	
	public String join(UserDTO dto) {
		String msg = "";
		if(dto.getUsername().equals("")) {
			msg = "아이디를 입력해주세요";
			System.out.println(msg);
			return msg;
		}
		int resultRow = userDAO.join(dto);
		return resultRow + "";
	}

	public int delete(String username, String password) {
		int check = userDAO.delete(username, password);
		return check;
	}
	
}
