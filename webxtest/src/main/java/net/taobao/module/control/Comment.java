package net.taobao.module.control;

import com.alibaba.service.template.TemplateContext;
import com.alibaba.turbine.module.control.TemplateControl;
import com.alibaba.turbine.service.rundata.RunData;
import com.alibaba.webx.WebxException;

public class Comment extends TemplateControl{

	@Override
	protected void execute(RunData rundata, TemplateContext context)
			throws WebxException {
		// TODO Auto-generated method stub
		super.execute(rundata, context);
		System.out.println("Commnet Control Execute!!!!");
	}

}
