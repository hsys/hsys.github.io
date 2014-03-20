package net.taobao.module.layout;

import com.alibaba.service.template.TemplateContext;
import com.alibaba.turbine.module.layout.TemplateLayout;
import com.alibaba.turbine.service.rundata.RunData;
import com.alibaba.webx.WebxException;

public class Default extends TemplateLayout {

	@Override
	protected void execute(RunData rundata, TemplateContext context)
			throws WebxException {
		// TODO Auto-generated method stub
		super.execute(rundata, context);
		System.out.println("Default Layout Execute!!!!");
	}

	
}
