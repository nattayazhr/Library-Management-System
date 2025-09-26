package com.dao;

import java.util.ArrayList;

import com.dto.UserDTO;
import com.dto.UserLoginDTO;
import com.dto.UserSessionDTO;
import com.model.User;

public interface UserDAO {
	public boolean addUser(User user);
	
	public ArrayList<UserDTO> getUsers();
	
	public UserSessionDTO login(UserLoginDTO user);
}
