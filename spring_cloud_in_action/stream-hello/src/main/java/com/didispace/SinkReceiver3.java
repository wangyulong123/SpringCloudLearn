package com.didispace;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Processor;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.context.annotation.Bean;
import org.springframework.integration.annotation.InboundChannelAdapter;
import org.springframework.integration.annotation.Poller;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.integration.core.MessageSource;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.support.GenericMessage;

/**
 *
 *
 * @author 翟永超
 * @create 2016/11/8.
 * @blog http://blog.didispace.com
 */
@EnableBinding(value = {Processor.class, SinkSender.class})
public class SinkReceiver3 {

    private static Logger logger = LoggerFactory.getLogger(HelloApplication.class);

    @StreamListener(Processor.INPUT)
    @SendTo(Processor.OUTPUT)
    public Object receiveFromInput(Object payload) {
        logger.info("Received: " + payload);
        return "From Input Channel Return - " + payload;
    }

    @StreamListener(Processor.OUTPUT)
    public void receiveFromOutput(Object payload) {
        logger.info("Received: " + payload);
    }

}
