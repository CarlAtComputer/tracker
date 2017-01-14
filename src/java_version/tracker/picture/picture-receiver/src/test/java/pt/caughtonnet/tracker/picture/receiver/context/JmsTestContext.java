package pt.caughtonnet.tracker.picture.receiver.context;

import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.Queue;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.support.converter.SimpleMessageConverter;

@Configuration
@EnableJms
@Import(ReceiverContextConfig.class)
@ComponentScan(basePackages = { "pt.caughtonnet.tracker.picture.receiver.bean" })
public class JmsTestContext {
	@Bean
	public JmsTemplate jmsTemplate(ConnectionFactory connectionFactory, Queue destination) throws JMSException {
		JmsTemplate jmsTemplate = new JmsTemplate(connectionFactory);
		jmsTemplate.setDefaultDestination(destination);
		jmsTemplate.setMessageConverter(new SimpleMessageConverter());
		return jmsTemplate;
	}
}
