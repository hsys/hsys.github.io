package net.taobao.module.screen;

import com.alibaba.service.template.TemplateContext;
import com.alibaba.turbine.module.screen.TemplateScreen;
import com.alibaba.turbine.service.rundata.RunData;
import com.alibaba.webx.WebxException;
import com.alibaba.webx.request.context.parser.ParameterParser;

public class Success extends TemplateScreen{

	@Override
	protected void execute(RunData rundata, TemplateContext context)
			throws WebxException {
		ParameterParser param = rundata.getParameters();
		
		String username = (String)param.get("username");;
		String password = (String)param.get("password");
		System.out.println(username);
		System.out.println(password);
		context.put("username", username);
		context.put("password", password);
	}

	
	
}
