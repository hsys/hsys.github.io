package net.taobao.test;

import net.taobao.service.UserService;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.taobao.hsf.hsfunit.HSFEasyStarter;
import com.taobao.uic.common.domain.BaseUserDO;
import com.taobao.uic.common.service.userinfo.UicReadService;

public class HsfUnitTest {

	public static void main(String[] rsg){
		// ����HSF��������һ����������taobao-hsf.sar·�����ڶ�����������HSF�汾
		HSFEasyStarter.start("D:/soft/jboss-4.2.2/server/default/deploy/", "1.4.9.7");
		ApplicationContext context = new ClassPathXmlApplicationContext("biz-hsf-uic.xml");
//		UicReadService uicReadService = (UicReadService)context.getBean("uicReadService");
//		BaseUserDO user = uicReadService.getBaseUserByUserId(10000l, "uicfinal").getModule();
//		System.out.println(user.getNick());
		
		/*UserService userService = (UserService)context.getBean("userServiceRemote");
		int userCount = userService.getUserCount();*/
		
		
	}
}
