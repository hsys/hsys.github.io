package net.taobao.notify;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.taobao.hsf.notify.client.NotifyManager;
import com.taobao.hsf.notify.client.SendResult;
import com.taobao.hsf.notify.client.message.StringMessage;

public class PublishNotifyManager {

	private static final String TOPIC = "FEEDCENTER";
	private static final String MESSAGE_TYPE = "feed-create";
	
	public static void main(String[] args){
		ApplicationContext ctx = new ClassPathXmlApplicationContext("biz-notify-publish.xml");

        NotifyManager publisher = (NotifyManager) ctx.getBean("publishNotifyManager");

        // 因为连接是异步的。第一次发送需要等待连接建立成功。
        try {
            Thread.sleep(10000);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        sendNoTransactionMessage(publisher);
	}
	
	private static void sendNoTransactionMessage(NotifyManager notifyManager) {
        StringMessage stringMessage = new StringMessage();
        stringMessage.setBody("NoTranscationTestStringMessage");
        /**
         * 必填属性
         */
        stringMessage.setTopic(TOPIC);
        stringMessage.setMessageType(MESSAGE_TYPE);
        /**
         * 可选属性，使用前，请务必仔细看Notify的User guide的Message章节
         */
        stringMessage.setSendOnceMessage(true);// 默认值为false
        stringMessage.setPostTimeout(10000);// 默认值10*1000毫秒
        stringMessage.setClientPostTimeout(3000);// 默认值3*1000毫秒
        stringMessage.setTimeToLive(7 * 24 * 3600);// 默认值，为-1
        stringMessage.setDLQTime(7 * 24 * 3600);// 默认值，NotifyServer配置文件决定

        stringMessage.setStringProperty("customHeader", "customValue"); // 该可选属性是一个系列

        SendResult result = notifyManager.sendMessage(stringMessage);

        if (result.isSuccess()) {
            // 发送成功后处理
            System.out.println("消息发送成功");
        }
        else {
            System.out.println("消息发送失败，原因：" + result.getErrorMessage());
        }
    }
	
}
