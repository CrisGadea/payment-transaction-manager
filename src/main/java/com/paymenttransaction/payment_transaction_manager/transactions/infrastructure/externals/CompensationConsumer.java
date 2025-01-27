package com.paymenttransaction.payment_transaction_manager.transactions.infrastructure.externals;

import com.paymenttransaction.payment_transaction_manager.config.rabbitmq.RabbitMQConfig;
import com.paymenttransaction.payment_transaction_manager.transactions.application.ports.out.TransactionPort;
import com.paymenttransaction.payment_transaction_manager.transactions.domain.enums.TransactionStatus;
import com.paymenttransaction.payment_transaction_manager.transactions.domain.models.CompensationEvent;
import com.paymenttransaction.payment_transaction_manager.transactions.domain.models.Transaction;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class CompensationConsumer {

    @Qualifier("transactionPort")
    @Autowired
    private TransactionPort transactionRepository;

    @RabbitListener(queues = RabbitMQConfig.COMPENSATION_QUEUE)
    public void handleCompensationEvent(CompensationEvent event) {
        Transaction transaction = transactionRepository.findById(Long.getLong(event.getTransactionId()));
        if (transaction != null && event.getAction().equals(TransactionStatus.REFUNDED)) {
            transaction.setStatus(TransactionStatus.REFUNDED);
            transactionRepository.createTransaction(transaction);
        }
    }
}
