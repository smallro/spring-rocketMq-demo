package cn.wang.rocketmq.producer;

import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by Intellij IDEA
 * User: wr
 * Date: 2018/5/31
 */
public class RocketMqProducer {

    private final Logger logger = LoggerFactory.getLogger(RocketMqProducer.class);

    private DefaultMQProducer defaultMQProducer;

    private String producerGroup;

    private String host;

    /**
     * Spring bean init-method
     */
    public void init() throws MQClientException {
        // 参数信息
        logger.info("DefaultMQProducer initialize!");
        logger.info(producerGroup);
        logger.info(host);
        // 初始化
        defaultMQProducer = new DefaultMQProducer(producerGroup);
        defaultMQProducer.setNamesrvAddr(host);
        defaultMQProducer.setInstanceName(String.valueOf(System.currentTimeMillis()));
        defaultMQProducer.start();
        logger.info("DefaultMQProudcer start success!");
    }

    /**
     * Spring bean destroy-method
     */
    public void destroy() {
        defaultMQProducer.shutdown();
    }

    public DefaultMQProducer getDefaultMQProducer() {
        return defaultMQProducer;
    }

    // ---------------setter -----------------

    public void setProducerGroup(String producerGroup) {
        this.producerGroup = producerGroup;
    }

    public void setHost(String host) {
        this.host = host;
    }
}
