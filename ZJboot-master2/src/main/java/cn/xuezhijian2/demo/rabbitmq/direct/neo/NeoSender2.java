package cn.xuezhijian2.demo.rabbitmq.direct.neo;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
/**
 * Created with IntelliJ IDEA.
 * packageName  : cn.xuezhijian2.demo.rabbitmq.direct.neo
 * User         : zj
 * Date         : 17/4/22
 * Time         : 下午7:54
 * Description  :
 */

@Component
public class NeoSender2 {

    @Autowired
    private AmqpTemplate rabbitTemplate;

    public void send(int i) {
        String context = "spirng boot neo queue"+" ****** "+i;
        System.out.println("Sender2 : " + context);
        this.rabbitTemplate.convertAndSend("neo", context);
    }

}
