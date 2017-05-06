package cn.xuezhijian2.demo.rabbitmq.fanout;

import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.ChannelAwareMessageListener;
import org.springframework.stereotype.Component;
/**
 * Created with IntelliJ IDEA.
 * packageName  : cn.xuezhijian2.demo.rabbitmq.fanout
 * User         : zj
 * Date         : 17/4/22
 * Time         : 下午12:06
 * Description  :
 */

public class FanoutReceiverA implements ChannelAwareMessageListener {

    @Override
    public void onMessage(Message message, Channel channel) throws Exception {
        byte[] body = message.getBody();
        System.out.println("Fanout Receiver(fanout.A)  : " +  new String(body));
        channel.basicAck(message.getMessageProperties().getDeliveryTag(), false); //确认消息成功消费
    }

}
