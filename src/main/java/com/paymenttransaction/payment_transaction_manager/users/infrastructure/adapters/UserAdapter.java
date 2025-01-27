package com.paymenttransaction.payment_transaction_manager.users.infrastructure.adapters;

import com.paymenttransaction.payment_transaction_manager.transactions.domain.models.Transaction;
import com.paymenttransaction.payment_transaction_manager.transactions.infrastructure.entities.TransactionEntity;
import com.paymenttransaction.payment_transaction_manager.users.application.ports.out.UserPort;
import com.paymenttransaction.payment_transaction_manager.users.domain.models.User;
import com.paymenttransaction.payment_transaction_manager.users.infrastructure.entities.UserEntity;
import com.paymenttransaction.payment_transaction_manager.users.infrastructure.mappers.UserEntityMapper;
import com.paymenttransaction.payment_transaction_manager.users.infrastructure.mappers.UserMapper;
import com.paymenttransaction.payment_transaction_manager.users.infrastructure.repositories.UserRepository;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Component
public class UserAdapter implements UserPort {
    private final UserRepository repository;
    private final UserEntityMapper mapper;

    public UserAdapter(UserRepository repository, UserEntityMapper mapper){
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    @Transactional
    public User createUser(User user){
        try {
            UserEntity entity = mapper.toEntity(user);
            UserEntity savedEntity = repository.save(entity);
            return mapper.toModel(savedEntity);
        } catch (DataIntegrityViolationException ex) {
            throw new RuntimeException("Save user Fail. Verify the data entered.", ex);
        }
    }

    @Override
    public Optional<User> getUserById(Long id) {
        return repository.findById(id).map(mapper::toModel);
    }
}
