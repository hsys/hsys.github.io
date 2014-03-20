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

        // ��Ϊ�������첽�ġ���һ�η�����Ҫ�ȴ����ӽ����ɹ���
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
         * ��������
         */
        stringMessage.setTopic(TOPIC);
        stringMessage.setMessageType(MESSAGE_TYPE);
        /**
         * ��ѡ���ԣ�ʹ��ǰ���������ϸ��Notify��User guide��Message�½�
         */
        stringMessage.setSendOnceMessage(true);// Ĭ��ֵΪfalse
        stringMessage.setPostTimeout(10000);// Ĭ��ֵ10*1000����
        stringMessage.setClientPostTimeout(3000);// Ĭ��ֵ3*1000����
        stringMessage.setTimeToLive(7 * 24 * 3600);// Ĭ��ֵ��Ϊ-1
        stringMessage.setDLQTime(7 * 24 * 3600);// Ĭ��ֵ��NotifyServer�����ļ�����

        stringMessage.setStringProperty("customHeader", "customValue"); // �ÿ�ѡ������һ��ϵ��

        SendResult result = notifyManager.sendMessage(stringMessage);

        if (result.isSuccess()) {
            // ���ͳɹ�����
            System.out.println("��Ϣ���ͳɹ�");
        }
        else {
            System.out.println("��Ϣ����ʧ�ܣ�ԭ��" + result.getErrorMessage());
        }
    }
	
}
