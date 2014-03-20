package net.taobao.test;

import static org.junit.Assert.*;

import net.taobao.dao.UserDao;
import net.taobao.module.screen.User;
import net.taobao.service.UserService;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.taobao.hsf.hsfunit.HSFEasyStarter;

public class UserDaoTest extends BaseTest{
	
	private UserDao userDao;
	
	@Before
	public void setUp() throws Exception {
		context = new ClassPathXmlApplicationContext(locations);
		init();
	}

	public void init(){
		userDao = (UserDao)context.getBean("userDao");
	}

	
	@Test
	public void test() {
		net.taobao.model.User user = new net.taobao.model.User();
		user.setUsername("dd0dd");
		userDao.registeUser(user);
	}

}
