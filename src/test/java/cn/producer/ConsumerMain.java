package cn.producer;

import cn.wang.rocketmq.consumer.RocketMqConsumer;
import cn.wang.rocketmq.producer.RocketMqProducer;
import com.alibaba.fastjson.JSON;
import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.client.producer.SendStatus;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.exception.RemotingException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Intellij IDEA
 * User: wr
 * Date: 2018/5/31
 */
public class ConsumerMain {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath*:META-INF/spring/spring-*.xml");
        DefaultMQPushConsumer rocketMqConsumer = context.getBean(DefaultMQPushConsumer.class);
        try {
            rocketMqConsumer.start();
        } catch (MQClientException e) {
            e.printStackTrace();
        }
    }
}
