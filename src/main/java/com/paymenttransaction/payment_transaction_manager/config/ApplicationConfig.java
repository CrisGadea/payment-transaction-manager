package com.paymenttransaction.payment_transaction_manager.config;

import com.paymenttransaction.payment_transaction_manager.transactions.application.ports.out.TransactionPort;
import com.paymenttransaction.payment_transaction_manager.transactions.domain.useCases.CreateTransactionUseCaseImpl;
import com.paymenttransaction.payment_transaction_manager.transactions.domain.services.TransactionService;
import com.paymenttransaction.payment_transaction_manager.transactions.infrastructure.adapters.TransactionAdapter;
import com.paymenttransaction.payment_transaction_manager.transactions.infrastructure.externals.CompensationProducer;
import com.paymenttransaction.payment_transaction_manager.transactions.infrastructure.mappers.TransactionEntityMapper;
import com.paymenttransaction.payment_transaction_manager.transactions.infrastructure.repositories.TransactionRepository;
import com.paymenttransaction.payment_transaction_manager.users.application.ports.in.CreateUserUseCase;
import com.paymenttransaction.payment_transaction_manager.users.application.ports.out.UserPort;
import com.paymenttransaction.payment_transaction_manager.users.domain.services.UserService;
import com.paymenttransaction.payment_transaction_manager.users.domain.useCases.CreateUserUseCaseImpl;
import com.paymenttransaction.payment_transaction_manager.users.infrastructure.adapters.UserAdapter;
import com.paymenttransaction.payment_transaction_manager.users.infrastructure.mappers.UserEntityMapper;
import com.paymenttransaction.payment_transaction_manager.users.infrastructure.repositories.UserRepository;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import java.time.Duration;

@Configuration
public class ApplicationConfig {

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder
                .setConnectTimeout(Duration.ofMillis(5000))
                .setReadTimeout(Duration.ofMillis(5000))
                .build();
    }

    @Bean
    public CreateTransactionUseCaseImpl createTransactionUseCaseImpl(TransactionPort transactionPort, CompensationProducer compensationProducer) {
        return new CreateTransactionUseCaseImpl(transactionPort, compensationProducer);
    }

    @Bean
    public CreateUserUseCaseImpl createUserUseCaseImpl(UserPort userPort){
        return new CreateUserUseCaseImpl(userPort);
    }

    @Bean
    public TransactionService transactionService(CreateTransactionUseCaseImpl createTransactionUseCase) {
        return new TransactionService(createTransactionUseCase);
    }

    @Bean
    public UserService userService(CreateUserUseCaseImpl createUserUseCaseImpl){
        return new UserService(createUserUseCaseImpl);
    }

    @Bean
    public TransactionPort transactionPort(TransactionAdapter transactionAdapter){
        return transactionAdapter;
    }

    @Bean
    public UserPort userPort(UserAdapter userAdapter) { return userAdapter; }

    @Bean
    public TransactionAdapter transactionAdapter(TransactionRepository repository, TransactionEntityMapper mapper){
        return new TransactionAdapter(repository, mapper);
    }

    @Bean
    public UserAdapter userAdapter(UserRepository repository, UserEntityMapper mapper){
        return new UserAdapter(repository, mapper);
    }

}
