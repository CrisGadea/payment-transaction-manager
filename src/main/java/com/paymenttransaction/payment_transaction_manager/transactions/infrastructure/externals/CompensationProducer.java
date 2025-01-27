package com.paymenttransaction.payment_transaction_manager.transactions.infrastructure.externals;

import com.paymenttransaction.payment_transaction_manager.config.rabbitmq.RabbitMQConfig;
import com.paymenttransaction.payment_transaction_manager.transactions.domain.models.CompensationEvent;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CompensationProducer {

    @Autowired
    private AmqpTemplate rabbitTemplate;

    public void sendCompensationEvent(CompensationEvent event) {
        rabbitTemplate.convertAndSend(RabbitMQConfig.COMPENSATION_QUEUE, event);
    }
}
