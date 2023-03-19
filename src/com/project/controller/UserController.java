package com.project.controller;

import com.project.Service.UserService;
import com.project.ViewFrame.UserViewFrame;
import com.project.dao.UserDAO;
import com.project.dto.UserDTO;

public class UserController {
	
	private UserService userService;
		
	public UserController() {
		userService = new UserService();
	}

	public UserDTO login(String username, String password) {
		UserDTO responseUserDto = userService.login(username, password);
		return responseUserDto;
	}
	
	public String join(UserDTO dto, String host) {
		String msg = "외부에서는 회원가입을 할 수 없습니다.";
		if(host.equals("localhost")) {
			msg = userService.join(dto);
		}
		return msg; 
	}
	
	public int delete(String username, String password) {
		int check = userService.delete(username, password);
		
		return check;
	}
	
}
