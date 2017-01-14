package pt.caughtonnet.tracker.picture.receiver;


import java.text.DateFormat;
import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import pt.caughtonnet.tracker.picture.common.message.Message;
import pt.caughtonnet.tracker.picture.receiver.context.JmsTestContext;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { JmsTestContext.class })
public class JmsSenderTest {

	@Autowired
	private JmsTemplate jmsTemplate;
	
	@Test
	public void testSend() {
		Message message = new Message();
		DateFormat df = DateFormat.getDateInstance();
		message.setBody("Sending message at " + df.format(new Date()));
		jmsTemplate.convertAndSend(message);
	}
}
