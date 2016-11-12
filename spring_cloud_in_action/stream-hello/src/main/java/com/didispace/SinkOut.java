package com.didispace;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.MessageChannel;

/**
 * 定义对“input”消息通道的输出绑定
 *
 * @author 翟永超
 * @create 2016/11/12.
 * @blog http://blog.didispace.com
 */
public interface SinkOut {

    @Output(Sink.INPUT)
    MessageChannel output();

}
