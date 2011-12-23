package spooky.service.impl;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

@Service
public class AlertReceiverImpl implements MessageListener {
    private static final Logger log = Logger.getLogger(AlertReceiverImpl.class);
    
    @Override
    public void onMessage(Message message) {
        if(message instanceof TextMessage){
            log.debug("Received message " + message);
        } else {
            log.error("Invalid message received");
        }
    }
}
