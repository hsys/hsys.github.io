package net.taobao.module.action;

import java.util.Date;

import net.taobao.diamond.DiamondManager;
import net.taobao.model.User;
import net.taobao.service.UserService;

import com.alibaba.common.lang.StringUtil;
import com.alibaba.service.template.TemplateContext;
import com.alibaba.turbine.module.action.TemplateAction;
import com.alibaba.turbine.service.rundata.RunData;
import com.alibaba.webx.request.context.parser.ParameterParser;

public class RegisterAction extends TemplateAction{

	private UserService userService;
	
	public void doRegister(RunData rundata, TemplateContext context){
		ParameterParser param = rundata.getParameters();
		/*if(!canRegiste()){
			context.put("message", "×¢²áÊ§°ÜÁË£¬»¹Î´µ½×¢²áÊ±¼ä");
			return;
		}*/
		
		if(param != null){
			User user = new User();
			user.setUsername((String)param.getString("username"));
			user.setEmail((String)param.getString("email"));
			user.setPassword((String)param.getString("password"));
			context.put("user", user);
			if(StringUtil.isEmpty(user.getUsername())){
				context.put("message", "×¢²áÊ§°ÜÁË");
				//rundata.setRedirectTarget("/success.vm");
			}else{
				//userService.registerUser(user);
				rundata.setRedirectTarget("/success.vm");
			}
		}
	}
	
	private boolean canRegiste(){
		Date registDate = DiamondManager.getRegisteTime();
		if(System.currentTimeMillis() >= registDate.getTime()){
			return true;
		}
		return false;
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	
}
