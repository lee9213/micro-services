package com.lee9213.gmall.user.message.consumer;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

/**
 * @author lee9213@163.com
 * @version 1.0
 * @date 2018-09-08 9:55
 */
public interface MessageConsumerSink {

    String INPUT = "LUCKY_DRAW_CHANCE_TOPIC_INPUT";

    @Input(INPUT)
    SubscribableChannel luckyDrawChanceTopicInput();
}
