package com.paymenttransaction.payment_transaction_manager.transactions.infrastructure.adapters;


import com.paymenttransaction.payment_transaction_manager.transactions.application.ports.out.TransactionPort;
import com.paymenttransaction.payment_transaction_manager.transactions.domain.models.Transaction;
import com.paymenttransaction.payment_transaction_manager.transactions.infrastructure.entities.TransactionEntity;
import com.paymenttransaction.payment_transaction_manager.transactions.infrastructure.mappers.TransactionEntityMapper;
import com.paymenttransaction.payment_transaction_manager.transactions.infrastructure.repositories.TransactionRepository;
import com.paymenttransaction.payment_transaction_manager.transactions.application.ports.out.TransactionPort;
import com.paymenttransaction.payment_transaction_manager.transactions.domain.models.Transaction;
import com.paymenttransaction.payment_transaction_manager.transactions.infrastructure.mappers.TransactionEntityMapper;
import com.paymenttransaction.payment_transaction_manager.transactions.infrastructure.repositories.TransactionRepository;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Component
public class TransactionAdapter implements TransactionPort {

    private final TransactionRepository repository;
    private final TransactionEntityMapper mapper;

    public TransactionAdapter(TransactionRepository repository, TransactionEntityMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    @Transactional
    public Transaction createTransaction(Transaction transaction) {
        try {
            TransactionEntity entity = mapper.toEntity(transaction);
            TransactionEntity savedEntity = repository.save(entity);
            return mapper.toModel(savedEntity);
        } catch (DataIntegrityViolationException ex) {
            throw new RuntimeException("Save transaction Fail. Verify the data entered.", ex);
        }
    }

    @Override
    public Transaction findById(Long id) {
        return null;
    }

    @Override
    public Optional<Transaction> getTransactionById(Long id) {
        return repository.findById(id).map(mapper::toModel);
    }
}

