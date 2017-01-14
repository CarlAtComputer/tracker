package pt.caughtonnet.tracker.picture.receiver.context;

import java.io.File;
import java.io.IOException;

import javax.jms.Queue;

import org.apache.activemq.broker.BrokerService;
import org.apache.activemq.command.ActiveMQDestination;
import org.apache.activemq.store.PersistenceAdapter;
import org.apache.activemq.store.kahadb.KahaDBPersistenceAdapter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@Import(ReceiverContextConfig.class)
@EnableJms
@EnableWebMvc
@ComponentScan(basePackages = { "pt.caughtonnet.tracker.picture.receiver.bean" })
public class BrokerContextConfig {

	@Value("${dataDirectory}")
	private String dataDirectory;
	
	@Value("${brokerUrl}")
	private String brokerUrl;
	
	@Bean
	public BrokerService getMultipartResolver(Queue queue) {
		BrokerService broker = new BrokerService();

		try {
			broker.addConnector(brokerUrl);
		} catch (Exception e) {
			e.printStackTrace();
		}

		ActiveMQDestination[] destinations = new ActiveMQDestination[1];
		destinations[0] = (ActiveMQDestination) queue;
		broker.setDestinations(destinations);
		PersistenceAdapter pa = new KahaDBPersistenceAdapter();
		pa.setDirectory(new File(dataDirectory));
		try {
			broker.setPersistenceAdapter(pa);
		} catch (IOException e) {
			e.printStackTrace();
		}

		try {
			broker.start();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return broker;
	}
	
}
