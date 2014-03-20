package net.taobao.service;

import java.util.List;

import net.taobao.model.User;

public interface UserService {
	
	void registerUser(User user);
	
	int getUserCount();
	
	List<User> getUserList();
}
