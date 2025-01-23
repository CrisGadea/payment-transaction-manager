package com.paymenttransaction.payment_transaction_manager.infrastructure.adapters;


import com.paymenttransaction.payment_transaction_manager.application.ports.out.TransactionPort;
import com.paymenttransaction.payment_transaction_manager.domain.models.Transaction;
import com.paymenttransaction.payment_transaction_manager.infrastructure.entities.TransactionEntity;
import com.paymenttransaction.payment_transaction_manager.infrastructure.mappers.TransactionEntityMapper;
import com.paymenttransaction.payment_transaction_manager.infrastructure.repositories.TransactionRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class TransactionAdapter implements TransactionPort {

    private final TransactionRepository repository;
    private final TransactionEntityMapper mapper = TransactionEntityMapper.INSTANCE;

    public TransactionAdapter(TransactionRepository repository) {
        this.repository = repository;
    }

    @Override
    public Transaction createTransaction(Transaction transaction) {
        TransactionEntity entity = mapper.toEntity(transaction);
        TransactionEntity savedEntity = repository.save(entity);
        return mapper.toModel(savedEntity);
    }

    @Override
    public Optional<Transaction> getTransactionById(Long id) {
        return repository.findById(id).map(mapper::toModel);
    }
}

