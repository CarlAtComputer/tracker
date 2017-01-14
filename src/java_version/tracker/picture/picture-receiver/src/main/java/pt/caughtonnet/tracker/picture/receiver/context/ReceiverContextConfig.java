package pt.caughtonnet.tracker.picture.receiver.context;

import java.util.Arrays;

import javax.jms.ConnectionFactory;
import javax.jms.Queue;

import org.apache.activemq.command.ActiveMQQueue;
import org.apache.activemq.spring.ActiveMQConnectionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;

import pt.caughtonnet.tracker.picture.receiver.bean.Receiver;

@Configuration
@EnableJms
@ComponentScan(basePackages = { "pt.caughtonnet.tracker.picture.receiver.bean" })
public class ReceiverContextConfig {

	@Value("${queue}")
	private String queueName;
	
	@Value("${brokerUrl}")
	private String brokerUrl;
	
	@Autowired
	Receiver receiver;
	
	@Bean
	public Queue queue() {
		return new ActiveMQQueue(queueName);
	}

	@Bean
	public ConnectionFactory connectionFactory() {
		ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory();
		connectionFactory.setBrokerURL(brokerUrl);
		connectionFactory.setTrustedPackages(Arrays.asList("pt.caughtonnet.tracker.picture"));
		return connectionFactory;
	}

	@Bean(name="jmsListenerContainerFactory")
	public DefaultJmsListenerContainerFactory containerFactory(ConnectionFactory connectionFactory) {
		DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
		factory.setConnectionFactory(connectionFactory);
		return factory;
	}

}
