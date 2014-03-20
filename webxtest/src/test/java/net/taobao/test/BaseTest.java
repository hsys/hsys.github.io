package net.taobao.test;

import org.junit.After;
import org.junit.Before;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BaseTest {
//	String[] locations = new String[] { "biz-hsf-uic.xml","hsf-client-uic.xml" };
	String[] locations = new String[] { "biz-dao.xml","biz-tddl.xml"};
	public ClassPathXmlApplicationContext context;

	@Before
	public void setUp() throws Exception {
		context = new ClassPathXmlApplicationContext(locations);
		init();
	}

	@After
	public void tearDown() throws Exception {
		if (context != null)
			context.destroy();
	}

	public void init() {
	}
}
