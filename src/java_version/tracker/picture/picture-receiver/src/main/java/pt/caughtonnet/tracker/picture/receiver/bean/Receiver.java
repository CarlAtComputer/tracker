package pt.caughtonnet.tracker.picture.receiver.bean;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import pt.caughtonnet.tracker.picture.common.message.Message;

@Component
public class Receiver {

	@JmsListener(destination = "${queue}")
	public void receiveMessage(Message message) {
		System.out.println("Received <" + message.getBody() + ">");
	}

}