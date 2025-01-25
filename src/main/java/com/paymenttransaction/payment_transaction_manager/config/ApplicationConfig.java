package com.paymenttransaction.payment_transaction_manager.config;

import com.paymenttransaction.payment_transaction_manager.application.ports.out.TransactionPort;
import com.paymenttransaction.payment_transaction_manager.domain.useCases.CreateTransactionUseCaseImpl;
import com.paymenttransaction.payment_transaction_manager.domain.services.TransactionService;
import com.paymenttransaction.payment_transaction_manager.infrastructure.adapters.TransactionAdapter;
import com.paymenttransaction.payment_transaction_manager.infrastructure.mappers.TransactionEntityMapper;
import com.paymenttransaction.payment_transaction_manager.infrastructure.repositories.TransactionRepository;
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
    public CreateTransactionUseCaseImpl createTransactionUseCaseImpl(TransactionPort transactionPort) {
        return new CreateTransactionUseCaseImpl(transactionPort);
    }

    @Bean
    public TransactionService transactionService(CreateTransactionUseCaseImpl createTransactionUseCase) {
        return new TransactionService(createTransactionUseCase);
    }

    @Bean
    public TransactionPort transactionPort(TransactionAdapter transactionAdapter){
        return transactionAdapter;
    }

    @Bean
    public TransactionAdapter transactionAdapter(TransactionRepository repository, TransactionEntityMapper mapper){
        return new TransactionAdapter(repository, mapper);
    }

}
