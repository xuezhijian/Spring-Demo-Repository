package cn.xuezhijian2.demo.rabbitmq.direct.object;

import cn.xuezhijian2.core.util.ObjectUtil;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.ChannelAwareMessageListener;
import org.springframework.stereotype.Component;

import java.io.ByteArrayInputStream;
import java.io.ObjectInputStream;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * packageName  : cn.xuezhijian2.demo.rabbitmq.direct.object
 * User         : zj
 * Date         : 17/4/22
 * Time         : 下午12:01
 * Description  :
 */

public class ObjectReceiver implements ChannelAwareMessageListener {

    // jackson转换工具
    private static final ObjectMapper objectMapper = new ObjectMapper()
            .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);


    @Override
    public void onMessage(Message message, Channel channel) throws Exception {
        byte[] body = message.getBody();
        System.out.println("Receiver(ObjectQueue)  : " + (Date)ObjectUtil.byteToObject(body));
        channel.basicAck(message.getMessageProperties().getDeliveryTag(), false); //确认消息成功消费
    }

}
