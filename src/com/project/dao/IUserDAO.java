package com.project.dao;

import com.project.dto.UserDTO;

public interface IUserDAO {

	int join(UserDTO dto);
	
	UserDTO login(String username, String password);
	
	int delete(String username, String password);

}
