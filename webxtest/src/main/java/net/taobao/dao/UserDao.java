package net.taobao.dao;

import net.taobao.model.User;

public interface UserDao {
	public User getUser(long userId);
	
	public void registeUser(User user);
}
