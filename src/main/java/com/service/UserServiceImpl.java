package com.service;

import java.util.ArrayList;

import com.dao.UserDAOImpl;
import com.dto.UserDTO;
import com.dto.UserLoginDTO;
import com.dto.UserSessionDTO;
import com.model.User;

public class UserServiceImpl implements UserService {

	@Override
	public boolean addUser(User user) {
		return new UserDAOImpl().addUser(user);
	}

	@Override
	public ArrayList<UserDTO> getUsers() {
		return new UserDAOImpl().getUsers();
	}

	@Override
	public UserSessionDTO login(UserLoginDTO user) {
		return new UserDAOImpl().login(user);
	}

}
