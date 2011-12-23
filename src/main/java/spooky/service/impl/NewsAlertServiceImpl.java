package spooky.service.impl;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import spooky.service.NewsAlertService;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import javax.jms.TextMessage;
import java.util.Date;

@Service
public class NewsAlertServiceImpl implements NewsAlertService{
    
    private static Logger log = Logger.getLogger(NewsAlertServiceImpl.class);
    
    @Autowired
    private JmsTemplate jmsTemplate;

    @Scheduled(fixedRate = 10000)
    @Override
    public void sendNewsAlert() {
        jmsTemplate.send(new MessageCreator() {
            @Override
            public Message createMessage(Session session) throws JMSException {
                TextMessage message = session.createTextMessage("Groovy rocks! @ " + new Date());
                log.debug("sending message " + message);

                return message;
            }
        });
    }

    @Scheduled(fixedRate = 1000)
    @Override
    public void ping() {
        System.out.println("alive");
    }
}
