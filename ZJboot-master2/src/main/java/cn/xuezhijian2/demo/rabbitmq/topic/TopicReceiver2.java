package cn.xuezhijian2.demo.rabbitmq.topic;

import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.core.ChannelAwareMessageListener;

/**
 * Created with IntelliJ IDEA.
 * packageName  : cn.xuezhijian2.demo.rabbitmq.topic
 * User         : zj
 * Date         : 17/4/22
 * Time         : 下午12:04
 * Description  :
 */

public class TopicReceiver2 implements ChannelAwareMessageListener {

    @Override
    public void onMessage(Message message, Channel channel) throws Exception {
        byte[] body = message.getBody();
        System.out.println("Topic Receiver(topic.messages)  : " +  new String(body));
        channel.basicAck(message.getMessageProperties().getDeliveryTag(), false); //确认消息成功消费
    }

}