package com.lee9213.gmall.sso.message.producer;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

/**
 * @author lee9213@163.com
 * @version 1.0
 * @date 2018-09-08 9:55
 */
public interface MessageProducerSource {

    String OUTPUT = "LUCKY_DRAW_CHANCE_TOPIC_OUTPUT";

    @Output(OUTPUT)
    MessageChannel luckyDrawChanceTopicOutput();
}