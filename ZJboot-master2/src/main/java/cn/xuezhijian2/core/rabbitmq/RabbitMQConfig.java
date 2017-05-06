package cn.xuezhijian2.core.rabbitmq;

import cn.xuezhijian2.demo.rabbitmq.direct.hello.HelloReceiver;
import cn.xuezhijian2.demo.rabbitmq.direct.neo.NeoReceiver1;
import cn.xuezhijian2.demo.rabbitmq.direct.neo.NeoReceiver2;
import cn.xuezhijian2.demo.rabbitmq.direct.object.ObjectReceiver;
import cn.xuezhijian2.demo.rabbitmq.fanout.FanoutReceiverA;
import cn.xuezhijian2.demo.rabbitmq.fanout.FanoutReceiverB;
import cn.xuezhijian2.demo.rabbitmq.fanout.FanoutReceiverC;
import cn.xuezhijian2.demo.rabbitmq.topic.TopicReceiver;
import cn.xuezhijian2.demo.rabbitmq.topic.TopicReceiver2;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

/**
 * Created with IntelliJ IDEA.
 * packageName  : cn.xuezhijian2.core.rabbitmq
 * User         : zj
 * Date         : 17/4/19
 * Time         : 上午2:21
 * Description  :
 */

@Configuration
public class RabbitMQConfig {

    /**
     * 配置链接信息
     */
    @Bean
    public ConnectionFactory connectionFactory() {
        CachingConnectionFactory connectionFactory = new CachingConnectionFactory("127.0.0.1",5672);
        connectionFactory.setUsername("guest");
        connectionFactory.setPassword("guest");
        connectionFactory.setVirtualHost("/");
        /** 如果要进行消息回调，则这里必须要设置为true */
        connectionFactory.setPublisherConfirms(true);
        return connectionFactory;
    }


    @Bean
    /** 因为要设置回调类，所以应是prototype类型，如果是singleton类型，则回调类为最后一次设置 */
    @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public RabbitTemplate rabbitTemplate() {
        RabbitTemplate template = new RabbitTemplate(connectionFactory());
        return template;
    }



    /**
     * DirectExchange:按照routingkey分发到指定队列
     * TopicExchange:多关键字匹配
     * FanoutExchange: 将消息分发到所有的绑定队列，无routingkey的概念
     * HeadersExchange ：通过添加属性key-value匹配
     */

    //##########################################DirectExchange############################################

    /** 消息交换机的名字*/
    public static final String DIRECT_EXCHANGE   = "callback.exchange.foo";

    @Bean
    public Queue helloQueue() {
        return new Queue("hello",true);//队列持久
    }

    @Bean
    public Queue objectQueue() {
        return new Queue("object",true);
    }

    @Bean
    public Queue neoQueue() {
        return new Queue("neo",true);
    }

    /** 设置交换机类型  */
    @Bean
    public DirectExchange defaultExchange() {
        return new DirectExchange(DIRECT_EXCHANGE,true, false);
    }

    /** 将队列绑定到交换机 */
    @Bean
    public Binding binding1() {
        return BindingBuilder.bind(helloQueue()).to(defaultExchange()).with("hello_queue_key");
    }

    @Bean
    public Binding binding2() {
        return BindingBuilder.bind(objectQueue()).to(defaultExchange()).with("object_queue_key");
    }

    @Bean
    public Binding binding3() {
        return BindingBuilder.bind(neoQueue()).to(defaultExchange()).with("neo_queue_key");
    }


    /**
     * 接受消息的监听，这个监听会接受消息队列helloQueue的消息
     */
    @Bean
    public SimpleMessageListenerContainer helloQueueListenerContainer() {
        SimpleMessageListenerContainer container = new SimpleMessageListenerContainer(connectionFactory());
        container.setQueues(helloQueue());
        container.setExposeListenerChannel(true);
        container.setMaxConcurrentConsumers(1);
        container.setConcurrentConsumers(1);
        container.setAcknowledgeMode(AcknowledgeMode.MANUAL); //设置确认模式手工确认
        container.setMessageListener(new HelloReceiver());
        return container;
    }

    /**
     * 接受消息的监听，这个监听会接受消息队列objectQueue的消息
     * 针对消费者配置
     * @return
     */
    @Bean
    public SimpleMessageListenerContainer objectQueueListenerContainer() {
        SimpleMessageListenerContainer container = new SimpleMessageListenerContainer(connectionFactory());
        container.setQueues(objectQueue());
        container.setExposeListenerChannel(true);
        container.setMaxConcurrentConsumers(1);
        container.setConcurrentConsumers(1);
        container.setAcknowledgeMode(AcknowledgeMode.MANUAL); //设置确认模式手工确认
        container.setMessageListener(new ObjectReceiver());
        return container;
    }

    //neoQueue监听器1
    @Bean
    public SimpleMessageListenerContainer neoQueueListenerContainer1() {
        SimpleMessageListenerContainer container = new SimpleMessageListenerContainer(connectionFactory());
        container.setQueues(neoQueue());
        container.setExposeListenerChannel(true);
        container.setMaxConcurrentConsumers(1);
        container.setConcurrentConsumers(1);
        container.setAcknowledgeMode(AcknowledgeMode.MANUAL); //设置确认模式手工确认
        container.setMessageListener(new NeoReceiver1());
        return container;
    }


    //neoQueue监听器2
    @Bean
    public SimpleMessageListenerContainer neoQueueListenerContainer2() {
        SimpleMessageListenerContainer container = new SimpleMessageListenerContainer(connectionFactory());
        container.setQueues(neoQueue());
        container.setExposeListenerChannel(true);
        container.setMaxConcurrentConsumers(1);
        container.setConcurrentConsumers(1);
        container.setAcknowledgeMode(AcknowledgeMode.MANUAL); //设置确认模式手工确认
        container.setMessageListener(new NeoReceiver2());
        return container;
    }


    //##########################################DirectExchange############################################




    //##########################################FanoutExchange#############################################

    @Bean
    public Queue AMessage() {
        return new Queue("fanout.A",true);
    }

    @Bean
    public Queue BMessage() {
        return new Queue("fanout.B",true);
    }

    @Bean
    public Queue CMessage() {
        return new Queue("fanout.C",true);
    }

    @Bean
    public FanoutExchange fanoutExchange() {
        return new FanoutExchange("fanoutExchange");
    }

    @Bean
    public Binding bindingExchangeA(Queue AMessage,FanoutExchange fanoutExchange) {
        return BindingBuilder.bind(AMessage).to(fanoutExchange);
    }

    @Bean
    public Binding bindingExchangeB(Queue BMessage, FanoutExchange fanoutExchange) {
        return BindingBuilder.bind(BMessage).to(fanoutExchange);
    }

    @Bean
    public Binding bindingExchangeC(Queue CMessage, FanoutExchange fanoutExchange) {
        return BindingBuilder.bind(CMessage).to(fanoutExchange);
    }

    //AMessageQueue监听器
    @Bean
    public SimpleMessageListenerContainer AMessageQueueListenerContainer() {
        SimpleMessageListenerContainer container = new SimpleMessageListenerContainer(connectionFactory());
        container.setQueues(AMessage());
        container.setExposeListenerChannel(true);
        container.setMaxConcurrentConsumers(1);
        container.setConcurrentConsumers(1);
        container.setAcknowledgeMode(AcknowledgeMode.MANUAL); //设置确认模式手工确认
        container.setMessageListener(new FanoutReceiverA());
        return container;
    }

    //BMessageQueue监听器
    @Bean
    public SimpleMessageListenerContainer BMessageQueueListenerContainer() {
        SimpleMessageListenerContainer container = new SimpleMessageListenerContainer(connectionFactory());
        container.setQueues(BMessage());
        container.setExposeListenerChannel(true);
        container.setMaxConcurrentConsumers(1);
        container.setConcurrentConsumers(1);
        container.setAcknowledgeMode(AcknowledgeMode.MANUAL); //设置确认模式手工确认
        container.setMessageListener(new FanoutReceiverB());
        return container;
    }

    //CMessageQueue监听器
    @Bean
    public SimpleMessageListenerContainer CMessageQueueListenerContainer() {
        SimpleMessageListenerContainer container = new SimpleMessageListenerContainer(connectionFactory());
        container.setQueues(CMessage());
        container.setExposeListenerChannel(true);
        container.setMaxConcurrentConsumers(1);
        container.setConcurrentConsumers(1);
        container.setAcknowledgeMode(AcknowledgeMode.MANUAL); //设置确认模式手工确认
        container.setMessageListener(new FanoutReceiverC());
        return container;
    }


    //##########################################FanoutExchange#############################################




    //##########################################TopicExchange#############################################

    public final static String message = "topic.message";

    public final static String messages = "topic.messages";

    @Bean
    public Queue queueMessage() {
        return new Queue(RabbitMQConfig.message);
    }

    @Bean
    public Queue queueMessages() {
        return new Queue(RabbitMQConfig.messages);
    }

    @Bean
    TopicExchange exchange() {
        return new TopicExchange("topicExchange");
    }

    @Bean
    Binding bindingExchangeMessage(Queue queueMessage, TopicExchange exchange) {
        return BindingBuilder.bind(queueMessage).to(exchange).with("topic.message");
    }

    @Bean
    Binding bindingExchangeMessages(Queue queueMessages, TopicExchange exchange) {
        return BindingBuilder.bind(queueMessages).to(exchange).with("topic.#");
    }

    //BMessageQueue监听器
    @Bean
    public SimpleMessageListenerContainer queueMessageListenerContainer() {
        SimpleMessageListenerContainer container = new SimpleMessageListenerContainer(connectionFactory());
        container.setQueues(queueMessage());
        container.setExposeListenerChannel(true);
        container.setMaxConcurrentConsumers(1);
        container.setConcurrentConsumers(1);
        container.setAcknowledgeMode(AcknowledgeMode.MANUAL); //设置确认模式手工确认
        container.setMessageListener(new TopicReceiver());
        return container;
    }

    //CMessageQueue监听器
    @Bean
    public SimpleMessageListenerContainer queueMessagesListenerContainer() {
        SimpleMessageListenerContainer container = new SimpleMessageListenerContainer(connectionFactory());
        container.setQueues(queueMessages());
        container.setExposeListenerChannel(true);
        container.setMaxConcurrentConsumers(1);
        container.setConcurrentConsumers(1);
        container.setAcknowledgeMode(AcknowledgeMode.MANUAL); //设置确认模式手工确认
        container.setMessageListener(new TopicReceiver2());
        return container;
    }


    //##########################################TopicExchange#############################################


}
