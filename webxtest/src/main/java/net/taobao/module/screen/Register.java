package net.taobao.module.screen;

import net.taobao.diamond.DiamondManager;

import com.alibaba.service.template.TemplateContext;
import com.alibaba.turbine.module.screen.TemplateScreen;
import com.alibaba.turbine.service.rundata.RunData;
import com.alibaba.webx.WebxException;
import com.ibm.icu.text.SimpleDateFormat;

public class Register extends TemplateScreen{

	@Override
	protected void execute(RunData rundata, TemplateContext context)
			throws WebxException {
		super.execute(rundata, context);
		//SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		//String registeDate =  sdf.format(DiamondManager.getRegisteTime());
		//context.put("msg", "用户允许注册的时间为："+registeDate);
	}

}
