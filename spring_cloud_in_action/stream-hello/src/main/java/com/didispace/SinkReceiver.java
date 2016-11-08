package com.didispace;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Processor;
import org.springframework.cloud.stream.messaging.Sink;

/**
 * @author 翟永超
 * @create 2016/11/8.
 * @blog http://blog.didispace.com
 */
@EnableBinding(Sink.class)
public class SinkReceiver {

    private static Logger logger = LoggerFactory.getLogger(HelloApplication.class);

    @StreamListener(Processor.INPUT)
    public void receive(Object payload) {
        logger.info("Received: " + payload);
    }

}
