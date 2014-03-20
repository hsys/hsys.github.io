package net.taobao.service.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import net.taobao.dao.UserDao;
import net.taobao.model.User;
import net.taobao.service.UserService;

import com.taobao.tair.DataEntry;
import com.taobao.tair.Result;
import com.taobao.tair.ResultCode;
import com.taobao.tair.TairManager;

public class UserServiceImpl implements UserService{
	
	private TairManager tairManager;
	private UserDao userDao;
	
	private static final int NAMESPACE = 320; 
	private static final String USERKEY = "yangpingzhun-user-key";
	private static final String USERCOUNTKEY = "yangpingzhun-usercount-key";
	
	
	public void registerUser(User user) {
		System.out.println("User Register Success! UserName is " + user.getUsername());
		List<User> userList = getUserList();
		if(userList == null ){
			userList = new ArrayList<User>();
		}
		userList.add(user);
		//存入缓存
		ResultCode resultCode = tairManager.put(NAMESPACE, USERKEY, (Serializable) userList);
		if(ResultCode.SUCCESS.getCode() != resultCode.getCode()){
			System.out.println("Put User To Cache Error!!" + resultCode.getMessage());
		}else{
			int count = getUserCount();
			count ++;
			tairManager.put(NAMESPACE, USERCOUNTKEY, count);
		}
		
		//存入数据库
		userDao.registeUser(user);
	}

	public int getUserCount() {
		//从缓存中获取用户注册数，用户在监控平台上查看数据
		int userCount = 0;
		Result<DataEntry> userCache = tairManager.get(NAMESPACE, USERCOUNTKEY);
		if(userCache != null){
			DataEntry data = userCache.getValue();
			if(data != null){
				userCount = (Integer)data.getValue();
			}
		}
		return userCount;
	}


	public List<User> getUserList() {
		List<User> userList = new ArrayList<User>();
		//从缓存中获取用户列表
		Result<DataEntry> userCache = tairManager.get(NAMESPACE, USERKEY);
		if(userCache != null){
			DataEntry data = userCache.getValue();
			if(data != null){
				userList = (List<User>)data.getValue();
			}
		}
		return userList;
	}

	
	public void setTairManager(TairManager tairManager) {
		this.tairManager = tairManager;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	
}
