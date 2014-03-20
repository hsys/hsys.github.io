package net.taobao.module.screen;

import java.util.List;

import net.taobao.service.UserService;

import com.alibaba.service.template.TemplateContext;
import com.alibaba.turbine.module.screen.TemplateScreen;
import com.alibaba.turbine.service.rundata.RunData;
import com.alibaba.webx.WebxException;

public class User extends TemplateScreen{
	
	private UserService userService;

	protected void execute(RunData rundata, TemplateContext context)
			throws WebxException {
		super.execute(rundata, context);
		List<net.taobao.model.User> userList = userService.getUserList();
		int userCount = userService.getUserCount();
		context.put("userList", userList);
		context.put("userCount", userCount);
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	
}
