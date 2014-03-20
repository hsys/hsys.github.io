package net.taobao.diamond;

import java.text.ParseException;
import java.util.Date;
import java.util.Properties;

import com.ibm.icu.text.SimpleDateFormat;
import com.taobao.diamond.manager.ManagerListenerAdapter;
import com.taobao.diamond.manager.impl.DefaultDiamondManager;
import com.taobao.diamond.manager.impl.PropertiesListener;

public class DiamondManager {
	
	private static Date registeTime = null;
	
	public void init(){
		new DefaultDiamondManager("test.userRegiste", "net.taobao.test.userRegisteTime", new ManagerListenerAdapter() {
			
			@Override
			public void receiveConfigInfo(String configInfo) {
				try {
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
					registeTime = sdf.parse(configInfo);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		
		/*new DefaultDiamondManager("test.userRegiste", "net.taobao.test.userRegisteTime", new PropertiesListener() {
			
			@Override
			public void innerReceive(Properties properties) {
				// TODO Auto-generated method stub
				
			}
		});*/
	}

	public static Date getRegisteTime() {
		return registeTime;
	}

}
