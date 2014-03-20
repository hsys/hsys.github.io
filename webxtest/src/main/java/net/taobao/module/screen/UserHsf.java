package net.taobao.module.screen;

import java.util.List;

import net.taobao.service.UserService;

import com.alibaba.service.template.TemplateContext;
import com.alibaba.turbine.module.screen.TemplateScreen;
import com.alibaba.turbine.service.rundata.RunData;
import com.alibaba.webx.WebxException;

public class UserHsf extends TemplateScreen{
	
	private UserService userServiceRemote;

	@Override
	protected void execute(RunData rundata, TemplateContext context)
			throws WebxException {
		List<net.taobao.model.User> userList = userServiceRemote.getUserList();
		int userCount = userServiceRemote.getUserCount();
		context.put("userList", userList);
		context.put("userCount", userCount);
	}

	public void setUserServiceRemote(UserService userServiceRemote) {
		this.userServiceRemote = userServiceRemote;
	}
	
	

	
}
