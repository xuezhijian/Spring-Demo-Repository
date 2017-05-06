package cn.xuezhijian2.demo.rabbitmq.direct.hello;


import cn.xuezhijian2.core.rabbitmq.RabbitMQConfig;
import cn.xuezhijian2.core.util.SpringContextBeanUtil;
import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.AcknowledgeMode;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.ChannelAwareMessageListener;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * Created with IntelliJ IDEA.
 * packageName  : cn.xuezhijian2.demo.rabbitmq.hello
 * User         : zj
 * Date         : 17/4/22
 * Time         : 上午11:58
 * Description  :
 */

public class HelloReceiver implements ChannelAwareMessageListener{

    @Override
    public void onMessage(Message message, Channel channel) throws Exception {

        byte[] body = message.getBody();
        System.out.println("Receiver(helloQueue)  : " + new String(body));
        channel.basicAck(message.getMessageProperties().getDeliveryTag(), false); //确认消息成功消费
    }
}
