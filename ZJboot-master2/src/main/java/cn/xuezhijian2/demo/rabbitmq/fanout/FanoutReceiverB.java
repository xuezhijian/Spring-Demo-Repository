package cn.xuezhijian2.demo.rabbitmq.fanout;

import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.core.ChannelAwareMessageListener;

/**
 * Created with IntelliJ IDEA.
 * packageName  : cn.xuezhijian2.demo.rabbitmq.fanout
 * User         : zj
 * Date         : 17/4/22
 * Time         : 下午12:06
 * Description  :
 */

public class FanoutReceiverB implements ChannelAwareMessageListener {

    @Override
    public void onMessage(Message message, Channel channel) throws Exception {
        byte[] body = message.getBody();
        System.out.println("Fanout Receiver(fanout.B)  : " +  new String(body));
        channel.basicAck(message.getMessageProperties().getDeliveryTag(), false); //确认消息成功消费
    }

}
