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

import java.util.Optional;

@Component
public class CompensationConsumer {

    @Qualifier("transactionPort")
    @Autowired
    private TransactionPort transactionRepository;

    @RabbitListener(queues = RabbitMQConfig.COMPENSATION_QUEUE)
    public void handleCompensationEvent(CompensationEvent event) {
        Optional<Transaction> transaction = transactionRepository.getTransactionById(Long.getLong(event.getTransactionId()));
        Transaction transactionFounded;
        if (transaction.isPresent() && event.getAction().equals(TransactionStatus.REFUNDED)) {
            transactionFounded = transaction.get();
            transactionFounded.setStatus(TransactionStatus.REFUNDED);
            transactionRepository.createTransaction(transactionFounded);
        }
    }
}
