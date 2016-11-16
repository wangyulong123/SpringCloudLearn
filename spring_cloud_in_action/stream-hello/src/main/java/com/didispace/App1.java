package com.didispace;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Processor;
import org.springframework.messaging.handler.annotation.SendTo;

/**
 *
 *
 * @author 翟永超
 * @create 2016/11/8.
 * @blog http://blog.didispace.com
 */
//@EnableBinding(value = {Processor.class})
public class App1 {

    private static Logger logger = LoggerFactory.getLogger(HelloApplication.class);

    @StreamListener(Processor.INPUT)
    @SendTo(Processor.OUTPUT)
    public Object receiveFromInput(Object payload) {
        logger.info("Received: " + payload);
        return "From Input Channel Return - " + payload;
    }


//    @ServiceActivator(inputChannel= Processor.INPUT, outputChannel = Processor.OUTPUT)
//    public Object receiveFromInput(Object payload) {
//        logger.info("Received: " + payload);
//        return "From Input Channel Return - " + payload;
//    }

}
