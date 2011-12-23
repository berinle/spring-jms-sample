package spooky.tests;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.jms.ConnectionFactory;
import javax.jms.Queue;

import static junit.framework.Assert.assertNotNull;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:test.xml"})
public class SampleTest {
    
    @Autowired
    ConnectionFactory connectionFactory;

    @Autowired
    Queue queue;

    @Test
    public void testName() throws Exception {
        assertNotNull(connectionFactory);
        assertNotNull(queue);
    }
}
