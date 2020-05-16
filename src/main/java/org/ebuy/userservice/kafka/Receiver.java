package org.ebuy.userservice.kafka;

import org.ebuy.userservice.dto.UserDto;
import org.ebuy.userservice.mapper.UserMapper;
import org.ebuy.userservice.model.KafkaMessage;
import org.ebuy.userservice.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import java.util.concurrent.CountDownLatch;

/**
 * Created by Ozgur Ustun on May, 2020
 */

@Service
public class Receiver {

    private static final Logger LOGGER = LoggerFactory.getLogger(Receiver.class);

    private CountDownLatch latch = new CountDownLatch(1);

    private final UserMapper userMapper;
    private UserService userService;

    @Autowired
    public Receiver(UserMapper userMapper, UserService userService) {
        this.userMapper = userMapper;
        this.userService = userService;
    }

    @KafkaListener(topics = "${spring.kafka.topic.userRegistered}", autoStartup = "true")
    public void receiveRegisterMail(@Payload KafkaMessage kafkaMessage) {
        LOGGER.debug("received paylod" + kafkaMessage.toString());
        userService.createUser(userMapper.KafkaMsgToUserReq(kafkaMessage));
        latch.countDown();
    }


}
