package cn.xuezhijian2.demo.rabbitmq.direct.neo;

import cn.xuezhijian2.core.util.ObjectUtil;
import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.ChannelAwareMessageListener;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * packageName  : cn.xuezhijian2.demo.rabbitmq.direct.neo
 * User         : zj
 * Date         : 17/4/22
 * Time         : 下午7:58
 * Description  :
 */

public class NeoReceiver2 implements ChannelAwareMessageListener {


    @Override
    public void onMessage(Message message, Channel channel) throws Exception {
        byte[] body = message.getBody();
        System.out.println("Receiver2(neoQueue)  : " +  new String(body));
        channel.basicAck(message.getMessageProperties().getDeliveryTag(), false); //确认消息成功消费
    }

}