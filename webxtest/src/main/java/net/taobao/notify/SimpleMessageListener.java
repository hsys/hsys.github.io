package net.taobao.notify;

import com.taobao.hsf.notify.client.MessageListener;
import com.taobao.hsf.notify.client.MessageStatus;
import com.taobao.hsf.notify.client.message.BytesMessage;
import com.taobao.hsf.notify.client.message.Message;
import com.taobao.hsf.notify.client.message.StringMessage;


public class SimpleMessageListener implements MessageListener
{

    public void receiveMessage(Message message, MessageStatus status)
    {
        StringBuilder generalInfo = new StringBuilder();
        
        generalInfo.append("收到");
        generalInfo.append(message.getClass().getSimpleName());
        generalInfo.append("\tTopic:");
        generalInfo.append(message.getTopic());
        generalInfo.append("\tType:");
        generalInfo.append(message.getMessageType());
        /*generalInfo.append("\tcustomHeader:");
        try {
            generalInfo.append(message.getStringProperty("customHeader"));
        }
        catch (Exception e) {
        }*/
        
        /**
         * 只读属性
         */
        generalInfo.append("\tBornTime:").append(message.getBornTime());
        generalInfo.append("\tGmtCreate:").append(message.getGMTCreate());
        generalInfo.append("\tLastDelivery:").append(message.getGMTLastDelivery());
        generalInfo.append("\tDelivery Count:").append(message.getDeliverCount());
        
        if (message instanceof StringMessage) {
            generalInfo.append("\tBody:");
            StringMessage stringMessage = (StringMessage) message;
            generalInfo.append(stringMessage.getBody());
        }
        else if (message instanceof BytesMessage) {
            generalInfo.append("\tBody:");
            BytesMessage bytesMessage = (BytesMessage) message;
            generalInfo.append(new String(bytesMessage.getBody()));
        }
        System.out.println(generalInfo.toString());

    }

}
