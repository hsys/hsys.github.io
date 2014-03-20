package net.taobao.test;

import static org.junit.Assert.*;

import net.taobao.service.UserService;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.taobao.hsf.hsfunit.HSFEasyStarter;
import com.taobao.uic.common.domain.BaseUserDO;
import com.taobao.uic.common.domain.ResultDO;
import com.taobao.uic.common.service.userinfo.UicReadService;
import com.taobao.uic.common.service.userinfo.client.UicReadServiceClient;

public class UserServiceTest extends BaseTest{
	
	private UserService userService;
	
	@Before
	public void setUp() throws Exception {
		// 启动HSF容器，第一个参数设置taobao-hsf.sar路径，第二个参数设置HSF版本
		HSFEasyStarter.start("D:/soft/jboss-4.2.2/server/default/deploy/", "1.4.8.7");
		context = new ClassPathXmlApplicationContext(locations);
		init();
	}
	
	public void init(){
		userService = (UserService)context.getBean("userServiceRemote");
	}

	//@Test
	public void test() {
		int userCount = userService.getUserCount();
		assertTrue(userCount == 3);
	}

	@Test
	public void testUic(){
		
		/*UicReadService uicReadService = (UicReadService)context.getBean("uicReadService");
		ResultDO<BaseUserDO> baseDo = uicReadService.getBaseUserByUserId(10000l, "uicfinal");
		System.out.println(baseDo.getModule().getNick());
		System.out.println(baseDo.getModule());*/
		
		UicReadServiceClient client = (UicReadServiceClient)context.getBean("uicReadServiceClient");
		ResultDO<BaseUserDO> baseDo = client.getBaseUserByUserId(10002l);
				System.out.println(baseDo.getModule().getNick());
	}
}
